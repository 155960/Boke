package com.boke.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class FTPUtil {
    private static final Logger logger= LoggerFactory.getLogger(FTPUtil.class);
    private static String ftpIp=PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser=PropertiesUtil.getProperty("ftp.user");
    private static String ftpPass=PropertiesUtil.getProperty("ftp.pass");

    private FTPClient client;
    private String user;
    private String pwd;
    private String ip;
    private int port;

    public FTPUtil(String ip,int port,String user,String pwd){
        this.ip=ip;
        this.port=port;
        this.user=user;
        this.pwd=pwd;
    }

    public static boolean uploadFile(List<File> fileList) throws IOException {
       FTPUtil ftpUtil=new FTPUtil(ftpIp,21,ftpUser,ftpPass);
       //logger.info("开始连接服务器");
       PrintUtil.print("开始连接服务器");
       boolean result=ftpUtil.uploadFile("img",fileList);
        PrintUtil.print("上传结束");
       return result;
    }

    private  boolean uploadFile(String remotePath,List<File> fileList) throws IOException {
        boolean upload=true;
        FileInputStream fis=null;
        if(connectServer(this.ip,this.port,this.user,this.pwd)){
            try {
                client.changeWorkingDirectory("/home/ubuntu/img/");
                client.setBufferSize(1024);
               // client.setDataTimeout(3000);
                //client.setConnectTimeout(3000);
                client.setControlEncoding("UTF-8");
                client.setFileType(FTPClient.BINARY_FILE_TYPE);
                client.enterLocalPassiveMode();
                for(File fileItem:fileList){
                    fis=new FileInputStream(fileItem);
                    client.storeFile(fileItem.getName(),fis);
                }
            } catch (IOException e) {
                e.printStackTrace();
                PrintUtil.print("上传文件异常");
                upload=false;
            }finally {
                fis.close();
                client.disconnect();
            }
        }

        return upload;
    }

    //连接ftp服务器
    private boolean connectServer(String ip,int port ,String user,String pwd){
        boolean isSuccess=false;
        client=new FTPClient();
        try {
            //默认端口21
            PrintUtil.print("连接中");
            client.connect(ip);
            PrintUtil.print("连接中**");
           // PrintUtil.print(client.getReply()+"**");
            isSuccess=client.login(user,pwd);
        } catch (IOException e) {
            e.printStackTrace();
            PrintUtil.print("连接服务器异常");
        }
        return isSuccess;
    }
}
