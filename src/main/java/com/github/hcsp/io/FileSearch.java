package com.github.hcsp.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileSearch {
    // 找到第一个包含text的行的行号，行号从1开始计算。若没找到，则返回-1。
    // 如果指定的文件不存在或者无法被读取，抛出一个IllegalArgumentException。
    // 请不要让这个方法抛出checked exception
    public static int grep(File target, String text) {
        int id = 1;
        try {
            BufferedReader fr = new BufferedReader(new FileReader(target));
            while (true) {
                if (fr.readLine().contains(text)) {
                    return id;
                } else {
                    id++;
                }

            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            throw new NoFileReadException("行号" + id, e);
        }

    }

    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println("结果行号：" + grep(new File(projectDir, "log.txt"), "BBB"));
    }

    private static class NoFileReadException extends RuntimeException {
        public NoFileReadException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
