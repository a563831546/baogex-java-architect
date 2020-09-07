package com.baogex.architect.base.jdk.jdk8.stream.builder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-27
 */
public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws Exception {
        Files.lines(Paths.get(filePath))
                .skip(1) // 略过开头的注释行
                .forEach(line -> {
                    for (String w : line.split("[ .?,]+")) {
                        builder.add(w);
                    }
                });
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws Exception {
        new FileToWordsBuilder("F:\\Project\\Git\\baogex-java-architect\\base\\jdk\\jdk8\\src\\main\\resources\\Cheese.dat")
                .stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
