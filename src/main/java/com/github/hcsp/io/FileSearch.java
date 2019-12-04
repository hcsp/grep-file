package com.github.hcsp.io;

import java.io.*;

public class FileSearch {
    // 找到第一个包含text的行的行号，行号从1开始计算。若没找到，则返回-1。
    // 如果指定的文件不存在或者无法被读取，抛出一个IllegalArgumentException。
    // 请不要让这个方法抛出checked exception
    public static int grep(File target, String text) throws IllegalArgumentException {
        FileReader fr=null;
        BufferedReader br=null;
        int i=1;
        try {
             fr =new FileReader(target);
             br=new BufferedReader(fr);
             String string=null;
            while (true) {
                try {
                    if ((string = br.readLine()) == null) {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new IllegalArgumentException();
                }
                if (string.contains(text)) {
                    return i;
                } else {
                    i++;
                }
            }
            return -1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println("结果行号：" + grep(new File(projectDir, "log.txt"), "BBB"));
    }
}
