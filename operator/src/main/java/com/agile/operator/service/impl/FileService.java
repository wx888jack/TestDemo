package com.agile.operator.service.impl;

import com.agile.common.util.FTPUtil;
import com.agile.operator.service.IFileService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.UUID;

/*import com.mmall.util.FTPUtil;*/

/**
 * Created by geely
 */
@Service
public class FileService implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileService.class);


    //普通上传到本地
    @Override
    public String upload(MultipartFile file, String path){
        String fileName = file.getOriginalFilename();
        //获取扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString().replaceAll("-","")+"."+fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }
        return targetFile.getName();
    }


    /**
     * 图片上传到远程ftp服务上
     * @param file               上传的文件
     * @param path               本地图片保存路径
     * @param proFolderName    服务项目文件夹名称
     * @return
     */
    @Override
    public String ftpUpload(MultipartFile file, String path,String proFolderName){
        String fileName = file.getOriginalFilename();
        //获取扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString().replaceAll("-","")+"."+fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);
        try {
            file.transferTo(targetFile);
            //上传文件到服务器
            FTPUtil.ftpUploadFile(proFolderName,Lists.newArrayList(targetFile));
            //删除本地文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }
        return targetFile.getName();
    }

}
