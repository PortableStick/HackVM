package com.gregoftheweb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
    private List<List<String>> commands;
    int numCommands = 0;
    int currentCommand = 0;
    Pattern pattern = Pattern.compile("^.*\\/(\\w*)\\.vm$");
    String filename;
    String currentFunction;
    HashMap functionCallCounts = new HashMap();

    public Parser(Path file) {
        Matcher matcher = pattern.matcher(file.toString());
        if(matcher.find()) {
            this.filename = matcher.group(1);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.toString()));
            commands = reader.lines()
                    .map(s -> s.replaceAll("//[\\w\\W]*", ""))
                    .filter(s -> s.length() > 0)
                    .map(String::trim)
                    .map(this::commandParser)
                    .collect(Collectors.toCollection(ArrayList::new));
            numCommands = commands.size();
        } catch (FileNotFoundException fne) {
            System.out.println(String.format("Could not find file %s", file.toString()));
            fne.printStackTrace();
        }
    }

    private List<String> commandParser(String line) {
        List<String> newCommand = new ArrayList<String>();
        String[] command = line.split("\\s");
        try {
            switch (command[0]) {
                case "call":
                    newCommand.add("C_CALL");
                    newCommand.add(command[1]);
                    newCommand.add(command[2]);
                    newCommand.add(String.format("%s$ret.%s", this.currentFunction, incrementFunctionCount(this.currentFunction)));
                    break;
                case "pop":
                    newCommand.add("C_POP");
                    newCommand.add(formatSegments(command));
                    newCommand.add(command[2]);
                    break;
                case "push":
                    newCommand.add("C_PUSH");
                    newCommand.add(formatSegments(command));
                    newCommand.add(command[2]);
                    break;
                case "label":
                    newCommand.add("C_LABEL");
                    newCommand.add(createLabel(this.currentFunction, command[1]));
                    break;
                case "goto":
                    newCommand.add("C_GOTO");
                    newCommand.add(createLabel(this.currentFunction, command[1]));
                    break;
                case "if-goto":
                    newCommand.add("C_IF");
                    newCommand.add(createLabel(this.currentFunction, command[1]));
                    break;
                case "function":
                    this.currentFunction = command[1];
                    newCommand.add("C_FUNCTION");
                    newCommand.add(command[1]);
                    newCommand.add(command[2]);
                    break;
                case "return":
                    newCommand.add("C_RETURN");
                    break;
                case "not":
                case "or":
                case "and":
                case "add":
                case "sub":
                case "neg":
                case "eq":
                case "gt":
                case "lt":
                    newCommand.add("C_ARITHMETIC");
                    newCommand.add(command[0]);
                    break;
                default:
                    throw new UnrecognizedCommandException(command);
            }
            //for commenting the output file
            newCommand.add(1, line);
        } catch (UnrecognizedCommandException ure) {
            ure.printMessage();
            ure.printStackTrace();
        }
        return newCommand;
    }

    public boolean hasMoreCommands() {
        return currentCommand < numCommands;
    }

    public List<String> getNextCommand() throws IndexOutOfBoundsException {
        if(!hasMoreCommands()) {
            throw new IndexOutOfBoundsException("No more commands");
        }
        return this.commands.get(currentCommand++);
    }

    private String incrementFunctionCount(String fName) {
        if(!this.functionCallCounts.containsKey(fName)) {
            this.functionCallCounts.put(fName, 0);
        } else {
            int current = Integer.parseInt(this.functionCallCounts.get(fName).toString());
            this.functionCallCounts.put(fName, ++current);
        }
        return this.functionCallCounts.get(fName).toString();
    }

    private String createLabel(String functionName, String label) {
        return String.format("%s$%s", functionName, label);
    }

    private String formatSegments(String[] command) throws UnrecognizedCommandException {
        String result = command[1];
        if(command[1].equals("pointer")) {
            switch(command[2]) {
                case "0":
                    result = "POINTER_THIS";
                    break;
                case "1":
                    result = "POINTER_THAT";
                    break;
                default:
                    throw new UnrecognizedCommandException(command);
            }
        }
        if(command[1].equals("static")) {
            result = String.format("STATIC_%s.%s", this.filename, command[2]);
        }
        if(command[1].equals("local")) {
            result = "LCL";
        }
        if(command[1].equals("argument")) {
            result = "ARG";
        }
        if(command[1].equals("this")) {
            result = "THIS";
        }
        if(command[1].equals("that")) {
            result = "THAT";
        }
        return result;
    }
}
