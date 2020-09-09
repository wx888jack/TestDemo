package com.agile.controller;

import com.agile.common.tools.HttpUtils;
import com.agile.common.util.OcrUtils;
import com.agile.web.base.BaseController;
import com.agile.web.enums.StateEnum;
import com.agile.web.result.OrientRestfulResp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ximing huang
 * @Date: 2018/12/4 9:34
 */
@RestController
@CrossOrigin("*")
public class OcrController extends BaseController {

    @ApiOperation("测试orc识别服务")
    @PostMapping("/testOrc")
    public Map testOrc(MultipartFile file) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            String host = "https://cardiddecode.market.alicloudapi.com";//调用路径
            String path = "/api/decode_cardid_aliyun";
            String method = "POST";
            String appcode = "c62c0021f0de4aa1a58dedf5a688f072";//上阿里云开通就会有这个
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE
            headers.put("Authorization", "APPCODE " + appcode);
            //根据API的要求，定义相对应的Content-Type
            headers.put("Content-Type", "application/json; charset=UTF-8");
            Map<String, String> querys = new HashMap<String, String>();
            if (file != null) {
                String img = OcrUtils.base64Img(file);
                String bodys = "{\"imgbase64\":\"" + img + "\"}";//转码位json格式
                HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
                //获取response的body
                String str = EntityUtils.toString(response.getEntity());
                Map<String, Object> map = (Map<String, Object>) JSON.parse(str);
                if (map.get("code").toString().equals("200")) {
                    result.put("code", 0);
                    result.put("data", map.get("data"));
                } else {
                    result.put("code", 400);
                    result.put("msg", map.get("desc"));
                }
            } else {
                result.put("code", 400);
                result.put("msg", "请输入必传参数");
            }
        } catch (Exception e) {
            result.put("code", 400);
            result.put("msg", "服务器繁忙...");
        }
        return result;
    }


    @ApiOperation("测试orc认证服务")
    @PostMapping("/sureOrc")
    public Map  sureOrc(String name,String code) {
        String host = "https://idenauthen.market.alicloudapi.com";
        String path = "/idenAuthentication";
        String method = "POST";
        String appcode = "c62c0021f0de4aa1a58dedf5a688f072";//"你自己的AppCode";
        String result=null;
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("idNo", code);
        bodys.put("name", name);
        Map<String, Object> map=null;
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            //获取response的body
            String str = EntityUtils.toString(response.getEntity());
            map = (Map<String, Object>) JSON.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    @ApiOperation("测试识别结合认证服务")
    @PostMapping("/finalSureOrc")
    public Map  finalSureOrc(MultipartFile file) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            String host = "https://cardiddecode.market.alicloudapi.com";//调用路径
            String path = "/api/decode_cardid_aliyun";
            String method = "POST";
            String appcode = "c62c0021f0de4aa1a58dedf5a688f072";//上阿里云开通就会有这个
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE
            headers.put("Authorization", "APPCODE " + appcode);
            //根据API的要求，定义相对应的Content-Type
            headers.put("Content-Type", "application/json; charset=UTF-8");
            Map<String, String> querys = new HashMap<String, String>();
            if (file != null) {
                String img = OcrUtils.base64Img(file);
                String bodys = "{\"imgbase64\":\"" + img + "\"}";//转码位json格式
                HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
                //获取response的body
                String str = EntityUtils.toString(response.getEntity());
                JSONObject   s=JSONObject.parseObject(str);
                JSONObject   data=(JSONObject)s.get("data");
                JSONObject    front_side=(JSONObject)data.get("front_side");
                String name=front_side.get("name").toString();
                String code=front_side.get("card_no").toString();
                System.out.println("姓名:"+name+",身份证号:"+code);
                Map<String, Object> map = (Map<String, Object>) JSON.parse(str);
                if (map.get("code").toString().equals("200")) {
                    result=sureOrc(name,code);
                } else {
                    result.put("code", 400);
                    result.put("msg", map.get("desc"));
                }
            } else {
                result.put("code", 400);
                result.put("msg", "请输入必传参数");
            }
        } catch (Exception e) {
            result.put("code", 400);
            result.put("msg", "服务器繁忙...");
        }
        return result;
    }

    @ApiOperation("测试识别结合认证服务2")
    @PostMapping("/finalSureOrc2")
    public Map  finalSureOrc2(MultipartFile file) {
        String host = "http://idcardv.market.alicloudapi.com";
        String path = "/clouds/ocrVerify/idcardVerify";
        String method = "POST";
        String appcode = "c62c0021f0de4aa1a58dedf5a688f072";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, Object> map =null;// (Map<String, Object>) JSON.parse(str);
        if(file!=null){
            String img = OcrUtils.base64Img(file);
            Map u=new HashMap();
            u.put("humanImageBase64",img);
            String bodys = JSON.toJSONString(u);
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
            map=(Map<String, Object>) JSONObject.parse(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            map.put("msg","请上传图片") ;
        }
        return map;
    }


    @ApiOperation("将图片转换成base64格式")
    @PostMapping("/changeBase64")
    public OrientRestfulResp changeBase64(MultipartFile file) {
        OrientRestfulResp retVal = restProcessor(() -> {
            String base64Msg=OcrUtils.base64Img(file);
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data(base64Msg).build();
        });
        return retVal;
    }



}
