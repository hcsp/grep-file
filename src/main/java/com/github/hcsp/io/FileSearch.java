package com.github.hcsp.io;

import java.io.*;

public class FileSearch {
    // 找到第一个包含text的行的行号，行号从1开始计算。若没找到，则返回-1。
    // 如果指定的文件不存在或者无法被读取，抛出一个IllegalArgumentException。
    // 请不要让这个方法抛出checked exception
    public static int grep(File target, String text) {
        FileReader fr = null;
        try {
            fr = new FileReader(target);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        }

        BufferedReader br = new BufferedReader(fr);
        int count = 0;
        //循环读取文件内容
        while (true) {
            String s = "";
            try {
                if ((s = br.readLine()) == null) {
                    return -1;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            count += 1;
            if (s.contains(text)) {
                return count;
            }
        }
    }

    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println("结果行号：" + grep(new File(projectDir, "log.txt"), "BBB"));
    }
}
