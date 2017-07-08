package com.gregoftheweb;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static String getOutputName(String inputName) {
        String outputName;
        boolean isDirectory = Files.isDirectory(Paths.get(inputName));
        if(!isDirectory) {
            outputName = inputName.replace(".vm", ".asm");
        } else {
            Pattern pattern = Pattern.compile("\\/([\\w]*)$");
            Matcher matcher = pattern.matcher(inputName);
            matcher.find();
            outputName = inputName + "/" + matcher.group(1) + ".asm";
        }
        System.out.println(String.format("Writing to %s", outputName));
        return outputName;
    }
}
