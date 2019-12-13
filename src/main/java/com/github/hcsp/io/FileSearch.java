package com.github.hcsp.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileSearch {
    // 找到第一个包含text的行的行号，行号从1开始计算。若没找到，则返回-1。
    // 如果指定的文件不存在或者无法被读取，抛出一个IllegalArgumentException。
    // 请不要让这个方法抛出checked exception
    public static int grep(File target, String text) {

        List<String> results = null;
        try {
            results = Files.readAllLines(Paths.get(target.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }

        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).contains(text)) {
                return i + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println("结果行号：" + grep(new File(projectDir, "log.txt"), "BBB"));
    }
}
