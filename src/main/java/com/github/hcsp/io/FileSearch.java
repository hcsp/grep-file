package com.github.hcsp.io;

import java.io.*;

public class FileSearch {
    // 找到第一个包含text的行的行号，行号从1开始计算。若没找到，则返回-1。
    // 如果指定的文件不存在或者无法被读取，抛出一个IllegalArgumentException。
    // 请不要让这个方法抛出checked exception
    public static int grep(File target, String text) {
        int id = 1;
        try {
            BufferedReader fr = new BufferedReader(new FileReader(target));
            String str = null;
            while (true) {
                str = fr.readLine();
                if (str == null) {
                    break;
                } else if (str.contains(text)) {
                    return id;
                } else {
                    id++;
                }

            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println("结果行号：" + grep(new File(projectDir, "log.txt"), "BBB"));
    }
//
//    private static class NoFileReadException extends RuntimeException {
////        public NoFileReadException(String message, Throwable cause) {
//        NoFileReadException(String message, Throwable cause) {
//            super(message, cause);
//        }
//    }
}
