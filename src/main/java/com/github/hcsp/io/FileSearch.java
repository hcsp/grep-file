package com.github.hcsp.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import java.util.Iterator;
import java.util.List;

public class FileSearch {
    // 找到第一个包含text的行的行号，行号从1开始计算。若没找到，则返回-1。
    // 如果指定的文件不存在或者无法被读取，抛出一个IllegalArgumentException。
    // 请不要让这个方法抛出checked exception
    public static int grep(File target, String text) {
        try {
            List<String> allLines = Files.readAllLines(target.toPath(), Charset.defaultCharset());
            Iterator<String> iterator = allLines.iterator();
            int number = 1;
            while (iterator.hasNext()) {
                if (iterator.next().contains(text)) {
                    return number;
                }
                number++;
            }
            return -1;
        } catch (IOException e){
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println("结果行号：" + grep(new File(projectDir, "log.txt"), "BBB"));
    }
}
