package com.agile.common.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: ximing huang
 * @Date: 2018/7/18 9:24
 */
public class ExcelUtil {

    /**
     * 获取Excel随机名称
     * @return
     */
    public static String newFileName(){
        String newFileName=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+String.valueOf((int)(Math.random()*100000))+".xls";
        return  newFileName;
    }

    /**
     * 导出格式封装
     * @param title
     * @param params
     * @param dataset
     * @param response
     */
    public static void   exportExcel(String title, String[] params, String[][] dataset, HttpServletResponse response){
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(title);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

        for (int i = 0; i < params.length; i++) {
            row.createCell(i).setCellValue(params[i]);
        }
        for (int i = 0; i < dataset.length; i++) {
            row = sheet.createRow(i + 1);
            for(int j=0;j<dataset[i].length;j++) {
                row.createCell(j).setCellValue(dataset[i][j]);
            }
        }

        response.setContentType("octets/stream");
        OutputStream out=null;
        try {
            response.addHeader("Content-Disposition", "attachment;filename="+new String( title.getBytes("gb2312"),"ISO8859-1" )+".xls");
            try {
                out = response.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            wb.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取Excel数据封装成List<String>对象
     * @param path
     * @return
     */
    public static List<String> readExcelToArrayList(String path) {
        List<String> list=new ArrayList<>();
        // 获取Excel文档的路径
        Workbook wookbook;
        try {
            // 创建对Excel工作簿文件的引用
            if(path.contains(".xlsx")==false){
                wookbook = new HSSFWorkbook(new FileInputStream(
                        new File(path)));
            }else {
                wookbook= new XSSFWorkbook(new FileInputStream(
                        new File(path)));
            }
            // 在Excel文档中，第一张工作表的缺省索引是0
            // 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);?
            Sheet sheet = wookbook.getSheetAt(0);
            // 获取到Excel文件中的所有行数
            int rows = sheet.getPhysicalNumberOfRows();
            int cells=sheet.getRow(0).getPhysicalNumberOfCells();
            // 遍历行
            for (int i = 1; i < rows; i++) {
                // 读取左上端单元格?
                Row row = sheet.getRow(i);
                // 行不为空
                if (row != null) {
                    // 获取到Excel文件中的所有的列?
                    String[] value = new String[cells];
                    // 遍历列
                    String rowString="";
                    for (int j = 0; j < cells; j++) {
                        // 获取到列的值
                        Cell cell = row.getCell((short) j);
                        if(cell!=null){
                            switch (cell.getCellType()) {
                                case HSSFCell.CELL_TYPE_FORMULA:
                                    value[j]=cell.getCellFormula();
                                    break;
                                case HSSFCell.CELL_TYPE_NUMERIC:
                                    if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                        Date date = cell.getDateCellValue();
                                        value[j] = sdf.format(date);
                                    }else{
                                        // 处理数字
                                        Double v = cell.getNumericCellValue();
                                        BigDecimal bd1 = new BigDecimal(Double.toString(v));
                                        // 去掉后面无用的零  如小数点后面全是零则去掉小数点
                                        value[j]=bd1.toPlainString().replaceAll("0+?$", "")
                                                .replaceAll("[.]$", "")+"";
                                    }
                                    break;
                                case HSSFCell.CELL_TYPE_STRING:
                                    value[j] = cell.getRichStringCellValue()
                                            .getString();
                                    break;// getStringCellValue()
                                case HSSFCell.CELL_TYPE_BLANK:
                                    value[j] = " ";
                                    break;
                                default:
                                    value[j] = " ";
                                     break;
                                 }
                        }else {
                            value[j] = " ";
                        }
                        rowString+=value[j]+",";
                    }
                    rowString=rowString.substring(0,rowString.length()-1);
                    list.add(rowString);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }



}
