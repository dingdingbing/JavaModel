package com.banksteel;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 * 连接本地打印机test3
 *
 * @author dingfubing
 * @since 2021/1/13 16:47
 */
public class PrintDemo3 {

    public static final String[] allowPrintType = new String[]{"doc", "docx", "xls", "xlsx", "pdf"};

    public void printPdf(String fileName) {

        if (fileName == null || "".equals(fileName)) {
            throw new RuntimeException("文件信息不能为空");
        }

        //构造一个文件选择器，默认为当前目录
        File file = new File(fileName);//获取选择的文件
        if (!file.isFile()) {
            throw new RuntimeException("该路径非文件格式");
        }
        String name = file.getName();
        if ("".equals(name)) {
            throw new RuntimeException("文件名称不能为空");
        }
        String[] split = name.split("\\.");
        String subStr = split[split.length - 1];
        if (!Arrays.asList(allowPrintType).contains(subStr)) {
            throw new RuntimeException("当前文件格式不支持打印");
        }

        //构建打印请求属性集
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        //设置打印格式，因为未确定文件类型，这里选择AUTOSENSE
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        //查找所有的可用打印服务
        // PrintService[] printService = PrintServiceLookup.lookupPrintServices(flavor, pras);

        // 定位默认的打印服务 使用默认的打印机进行打印，不适用swing进行选择
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        // 显示打印对话框 swing从所有的可用打印服务中选择一个打印服务
        // PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
        if (defaultService == null) {
            throw new RuntimeException("当前主机未设置默认打印机，打印失败");
        }
        try {
            DocPrintJob job = defaultService.createPrintJob(); // 创建打印作业
            FileInputStream fis; // 构造待打印的文件流
            fis = new FileInputStream(file);
            DocAttributeSet das = new HashDocAttributeSet();
            Doc doc = new SimpleDoc(fis, flavor, das);
            job.print(doc, pras);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //
        // PrintDemo3 pic = new PrintDemo3();
        //
        // pic.printPdf("C:\\Users\\dingfubing\\Desktop\\test.docx");

        Double double1 = 123456789.1234;
        DecimalFormat decimalFormat = new DecimalFormat("##0.0000");//格式化设置
        System.out.println(decimalFormat.format(double1));
        System.out.println(double1);
        BigDecimal bigDecimal = new BigDecimal(Long.MAX_VALUE);
        System.out.println(bigDecimal.toString());

    }
}
