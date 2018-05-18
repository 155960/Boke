package com.boke.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FTPUtil {
    private static final Logger logger= LoggerFactory.getLogger(FTPUtil.class);
    private static String ftpIp=PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser=PropertiesUtil.getProperty("ftp.user");
    private static String ftpPass=PropertiesUtil.getProperty("ftp.pass");
    private static String rootDir=PropertiesUtil.getProperty("ftp.root.dir");

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
        client=new FTPClient();
    }

   //创建文件夹是遇到一个坑，linux下不能创建多级目录，只能一级一级创建
    private void createDir(String path) throws IOException {
        client.changeWorkingDirectory(rootDir);
        //默认已存在文件路径
        String[] a = rootDir.split("/");
        String[] dirs = path.split("/");
        //忽略已有的根目錄
        int current = a.length;
        for (int i = current; i < dirs.length; i++) {
            //文件存在则返回false
            client.makeDirectory(dirs[i]);
            //cd到当前目录
            client.changeWorkingDirectory(dirs[i]);
        }

    }

    public static boolean uploadFile(List<File> fileList,String remotePath) throws IOException {
       FTPUtil ftpUtil=new FTPUtil(ftpIp,21,ftpUser,ftpPass);
       //logger.info("开始连接服务器");
       PrintUtil.print("开始连接服务器");
       boolean result=ftpUtil.uploadFile(remotePath,fileList);
        PrintUtil.print("上传结束");
       return result;
    }

    public static boolean downloadFile(List<File> fileList){
        return false;
    }

    private boolean downloadFile(String path,String remotePath,List<File> fileList) throws IOException {
        boolean download=true;
        FileOutputStream fos=null;
        if(connectServer(this.ip,this.port,this.user,this.pwd)){
            client.changeWorkingDirectory("/home/ftp/img/");
            client.setControlEncoding("UTF-8");

        }
        return download;
    }

    /**
     *
     * @param remotePath  linux下文件存储路径如 /home/ftp/img
     * @param fileList  要存的文件集合
     * @return
     * @throws IOException
     */
    private  boolean uploadFile(String remotePath,List<File> fileList) throws IOException {
        boolean upload=true;
        FileInputStream fis=null;
        if(connectServer(this.ip,this.port,this.user,this.pwd)){
            try {
                //创建路径
                createDir(remotePath);
                //client.changeWorkingDirectory(remotePath);
                client.setBufferSize(1024);
                client.setDataTimeout(3000);
                client.setConnectTimeout(3000);
                client.setControlEncoding("UTF-8");
                client.setFileType(FTPClient.BINARY_FILE_TYPE);
                //少了这句将无法创建文件
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
        try {
            //默认端口21
            PrintUtil.print("连接中");
            client.connect(ip);
           // PrintUtil.print(client.getReply()+"**");
            isSuccess=client.login(user,pwd);
        } catch (IOException e) {
            e.printStackTrace();
            PrintUtil.print("连接服务器异常");
        }
        return isSuccess;
    }
}
