package com.github.hcsp.io;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.IOException;

import java.io.File;

public class FileSearch {
    // 找到第一个包含text的行的行号，行号从1开始计算。若没找到，则返回-1。
    // 如果指定的文件不存在或者无法被读取，抛出一个IllegalArgumentException。
    // 请不要让这个方法抛出checked exception
    public static int grep(File target, String text) {
            try(LineIterator iterator = FileUtils.lineIterator(target,"UTF-8")) {
                for(int lineNumber  = 0 ; iterator.hasNext(); lineNumber++){
                    String line = iterator.next();
                    if(line.contains(text)){
                        return lineNumber + 1;
                    }
                }
                return -1;
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }

    }

    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println("结果行号：" + grep(new File(projectDir, "log.txt"), "BBB"));
    }
}
