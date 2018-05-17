package com.boke.service.impl;

import com.boke.service.IFileService;
import com.boke.utils.FTPUtil;
import com.boke.utils.PrintUtil;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService implements IFileService {
    private Logger logger= LoggerFactory.getLogger(FileService.class);
    public String upload(MultipartFile file,String path){
        String fileName=file.getOriginalFilename();
        //原始文件扩展名
        String fileExtensionName=fileName.substring(fileName.lastIndexOf(".")+1);
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
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //targetFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
            PrintUtil.print("上传文件异常");
            return null;
        }
        return targetFile.getName();
    }
}
