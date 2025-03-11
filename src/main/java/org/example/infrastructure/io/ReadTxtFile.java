package org.example.infrastructure.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: 根据目录输出该目录下所有txt文件名
 * @Author BAISHUN
 * @Date 2024/8/15 11:34
 */
public class ReadTxtFile {
    public static void main(String[] args) {
        List<String> list1 = listTxtFileByPath("e:/dir");
        for (String s : list1) {
            System.out.println(s);
        }
        System.out.println("=======");
        List<Path> list = listTxtFileByStream("E:\\dir");
        for (Path f : list) {
            System.out.println(f);
        }
    }

    public static List<String> listTxtFileByPath(String path) {
        Path dir = Paths.get(path);
        System.out.println("当前的文件系统：" + dir.getFileSystem());
        ArrayList<String> fileNames = new ArrayList<>();
        if (!Files.exists(dir) || !Files.isDirectory(dir)) {
            System.out.println("input path is invalid");
            return fileNames;
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.txt")) {
            for (Path e : stream) {
//                if (Files.isRegularFile(e) && e.getFileName().toString().endsWith(".txt")) {
//                    String fileName = e.getFileName().toString();
//                    fileNames.add(fileName.substring(0, fileName.length() - 4));
//                }
                fileNames.add(e.getFileName().toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileNames;
    }

    public static List<Path> listTxtFileByStream(String path) {
        Path dir = Paths.get(path);
        if (!Files.exists(dir) || !Files.isDirectory(dir)) {
            System.out.println("input path is invalid");
            return new ArrayList<>();
        }

        try (Stream<Path> stream = Files.list(dir)) {
            return stream
                    .filter(p -> p.toString().endsWith(".txt")) // 过滤出以 .txt 结尾的文件
                    .map(Path::getFileName)         // 只获取文件名
                    .collect(Collectors.toList());  // 收集到 List 中
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
