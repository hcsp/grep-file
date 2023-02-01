package com.github.hcsp.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileSearch {
    // 找到第一个包含text的行的行号，行号从1开始计算。若没找到，则返回-1。
    // 如果指定的文件不存在或者无法被读取，抛出一个IllegalArgumentException。
    // 请不要让这个方法抛出checked exception
    public static int grep(File target, String text) throws IllegalAccessException {
        int i = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(target))) {
            for (String line; (line = br.readLine()) != null; ) {
                // process the line.
                if (text.contains(line) || line.contains(text)) {
                    return i;
                }
                ++i;
            }
            // line is not visible here.
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) throws IllegalAccessException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println("结果行号：" + grep(new File(projectDir, "log.txt"), "BBB"));
    }
}
