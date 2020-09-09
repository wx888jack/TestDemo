package com.agile.common.util;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @Author: ximing huang
 * @Date: 2018/12/4 10:14
 */
public class OcrUtils {

    public static String base64Img(MultipartFile file){
        byte[] data=null;
        try {
            data=file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return   encoder.encode(data);
    }





}
