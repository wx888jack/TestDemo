package com.agile.operator.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    public String upload(MultipartFile file, String path);

    public String ftpUpload(MultipartFile file, String path,String proFolderName);
}
