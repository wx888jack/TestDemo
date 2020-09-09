/**
 * @Project Name :  SchoolBus_Server
 * @Package Name :  com.agile.common.tools
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-03-27 9:35 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.common.tools;

import com.github.pagehelper.StringUtil;
import org.joda.time.DateTime;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author :  huangximing
 * @Description :  常用工具类
 * @Creation Date:  2018-03-27 9:35 AM
 */
public class CommonTools {

    /**
     * 判断是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    /**
     * 生成格式化UUID字符串
     * @return
     */
    public static String strId(){
        UUID uuid=UUID.randomUUID();
        String strId=uuid.toString().replaceAll("-","");
        return  strId;
    }

    /**
     * MD5加密
     * @param s
     * @return
     */
    public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断是否为空集合
     * @param list
     * @return
     */
    public static boolean isEmptyList(List list) {
        return null == list || list.size() == 0;
    }


    /**
     * 泛型把数组返回集合
     * @param array
     * @param <T>
     * @return
     */
    public static <T> List<T> arrayToList(T[] array) {
        List<T> retVal = new ArrayList<>();
        if (null != array && array.length > 0) {
            retVal = Arrays.stream(array).collect(Collectors.toList());
        }
        return retVal;
    }

    /**
     * List<String>转换成逗号分割的字符串
     * @param collect
     * @return
     */
    public static String list2String(List<String> collect) {
        String str = "";
        for (String substr : collect) {
            if (!StringUtil.isEmpty(substr)) {
                str = str + substr + ",";
            }
        }
        return str.equals("") ? "" : str.substring(0, str.length() - 1);
    }

    /**
     * List<Integer>转换成逗号分割的字符串
     * @param collect
     * @return
     */
    public static String integerList2String(List<Integer> collect) {
        String str = "";
        for (Integer obj : collect) {
            if (null != obj) {
                str = str + obj.toString() + ",";
            }
        }
        return str.equals("") ? "" : str.substring(0, str.length() - 1);
    }

    /**
     * URL编码（utf-8）
     *
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }






}