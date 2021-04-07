package com.banksteel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 * 连接本地打印机test1
 *
 * @author dingfubing
 * @since 2021/1/13 15:37
 */
public class PrintDemo1 {

    public void printPdf(String fileName) {
        //构造一个文件选择器，默认为当前目录
        File file = new File(fileName);//获取选择的文件
        //构建打印请求属性集
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        //设置打印格式，因为未确定文件类型，这里选择AUTOSENSE
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        //查找所有的可用打印服务
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(flavor, pras);
        //定位默认的打印服务
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        // 显示打印对话框
        PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
        if (service != null) {

            try {
                DocPrintJob job = service.createPrintJob(); // 创建打印作业
                FileInputStream fis; // 构造待打印的文件流
                fis = new FileInputStream(file);
                DocAttributeSet das = new HashDocAttributeSet();
                Doc doc = new SimpleDoc(fis, flavor, das);
                job.print(doc, pras);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        // PrintDemo1 pic = new PrintDemo1();
        // pic.printPdf("C:\\Users\\dingfubing\\Desktop\\test.docx");
        //构建打印请求属性集
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        //设置打印格式，因为未确定文件类型，这里选择AUTOSENSE
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        //查找所有的可用打印服务
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(flavor, pras);
        System.out.println(Arrays.toString(printService));
        System.out.println("-------------");
        //定位默认的打印服务
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        System.out.println(defaultService);
    }
}
