package com.wenky.ds;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileStream {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("sample.txt")).skip(1).limit(1);
    }
}
