package com.boke.service.impl;

import com.boke.service.IFileService;
import com.boke.utils.FTPUtil;
import com.boke.utils.PrintUtil;
import com.boke.utils.PropertiesUtil;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

@Service
public class FileService implements IFileService {
    private Logger logger= LoggerFactory.getLogger(FileService.class);

    /**
     *
     * @param file
     * @param path
     * @return 文件路径名
     */
    public String upload(MultipartFile file,String path){
        String fileName=file.getOriginalFilename();
        //原始文件扩展名
        String fileExtensionName=fileName.substring(fileName.lastIndexOf(".")+1);
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        String remotePath="/home/ftp/img/"+month+"/"+day+"/";
        String uploadFileName="file"+System.currentTimeMillis()+"."+fileExtensionName;
        logger.info("开始上传文件，文件名{}，上传路径{}，新文件名{}",fileName,path,uploadFileName);
        File dir=new File(path);
        if(!dir.exists()){
            dir.setWritable(true);
            dir.mkdirs();
        }
        File targetFile=new File(path,uploadFileName);

        try {
            file.transferTo(targetFile);
            FTPUtil.uploadFile(Lists.newArrayList(targetFile),remotePath);
            //targetFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
            PrintUtil.print("上传文件异常");
            return null;
        }
        String httpPath= PropertiesUtil.getProperty("http.path");
        httpPath+=remotePath;
        httpPath+=uploadFileName;
        return uploadFileName;
    }
}
