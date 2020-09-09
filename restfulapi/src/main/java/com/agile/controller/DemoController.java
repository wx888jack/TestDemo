package com.agile.controller;

import com.agile.operator.service.*;
import com.agile.persistent.mapper.Test1Mapper;
import com.agile.persistent.po.Test1;
import com.agile.web.base.BaseController;
import com.agile.web.enums.StateEnum;
import com.agile.web.result.OrientRestfulResp;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: ximing huang
 * @Date: 2018/9/6 9:19
 */
@RestController
@CrossOrigin("*")
public class DemoController extends BaseController {

    @ApiOperation("测试上传图片到服务器")
    @PostMapping("/testUploadFtp")
    public OrientRestfulResp testUploadFtp(MultipartFile file,String proFolderName) {
        OrientRestfulResp retVal = restProcessor(() -> {
            String path="D:/ftpServer";
            String fileName=fileService.ftpUpload(file,path,proFolderName);
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data(fileName).build();
        });
        return retVal;
    }


    @ApiOperation("访问权限1")
    @GetMapping("/test1")
    @RequiresAuthentication                     //验证是否登录
    @RequiresPermissions("sys:test1")          //验证是否拥有sys:test1权限
    public OrientRestfulResp test1() {
        OrientRestfulResp retVal = restProcessor(() -> {
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data("访问权限1成功").build();
        });
        return retVal;
    }

    @ApiOperation("访问权限2")
    @GetMapping("/test2")
    @RequiresAuthentication
    @RequiresPermissions("sys:test2")
    public OrientRestfulResp test2() {
        OrientRestfulResp retVal = restProcessor(() -> {
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data("访问权限2成功").build();
        });
        return retVal;
    }

    @ApiOperation("访问权限3")
    @GetMapping("/test3")
    @RequiresAuthentication
    @RequiresPermissions("sys:test3")
    public OrientRestfulResp test3() {
        OrientRestfulResp retVal = restProcessor(() -> {
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data("访问权限3成功").build();
        });
        return retVal;
    }



    @ApiOperation("访问权限3")
    @GetMapping("/findTest")
    public OrientRestfulResp findTest() {
        OrientRestfulResp retVal = restProcessor(() -> {
            List<Test1> list=test1Mapper.selectAll();
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data(list).build();
        });
        return retVal;
    }










    @Autowired
    IFileService fileService;

    @Autowired
    Test1Mapper test1Mapper;





}
