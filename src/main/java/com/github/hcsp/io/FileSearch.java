package com.github.hcsp.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileSearch {
    // 找到第一个包含text的行的行号，行号从1开始计算。若没找到，则返回-1。
    // 如果指定的文件不存在或者无法被读取，抛出一个IllegalArgumentException。
    // 请不要让这个方法抛出checked exception
    public static int grep(File target, String text) throws IOException {
        if (!target.exists() || !target.canRead() || target.isDirectory()) {
            throw new IllegalArgumentException();
        }
        FileInputStream inputStream = null;
        Scanner sc = null;
        int num=0;
        try {
            //InputStream
            inputStream = new FileInputStream(target);
            sc = new Scanner(inputStream);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
                if(line.contains(text)) {
                    return num;
                }
                else{
                    num++;
                }
             }
        }catch(IOException e){
            System.err.println("Caught"+e);
        }finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println("结果行号：" + grep(new File(projectDir, "log.txt"), "BBB"));
    }
}
