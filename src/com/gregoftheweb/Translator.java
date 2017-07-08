package com.gregoftheweb;

import java.util.List;

public class Translator {
    public static String translateCommand(List<String> command) {
        String newCommand = "//" +command.get(1) + "\n";
        try {
            switch (command.get(0)) {
                case "C_CALL":
                    newCommand += HackMacros.getCall(command.get(4), command.get(2), command.get(3));
                    break;
                case "C_FUNCTION":
                    newCommand += HackMacros.getFunction(command.get(2), command.get(3));
                    break;
                case "C_RETURN":
                    newCommand += HackMacros.getReturn();
                    break;
                case "C_LABEL":
                    newCommand += HackMacros.getLabel(command.get(2));
                    break;
                case "C_GOTO":
                    newCommand += HackMacros.getGoto(command.get(2));
                    break;
                case "C_IF":
                    newCommand += HackMacros.getIf(command.get(2));
                    break;
                case "C_PUSH":
                    newCommand += parsePushSection(command.get(2), command.get(3));
                    break;
                case "C_POP":
                    newCommand += parsePopSection(command.get(2), command.get(3));
                    break;
                case "C_ARITHMETIC":
                    newCommand += parseArithmetic(command.get(2));
                    break;
                default:
                    throw new UnrecognizedCommandException(command);

            }
        } catch(UnrecognizedCommandException uce) {
            uce.printMessage();
            uce.printStackTrace();
        }
        return newCommand;
    }

    private static String parsePushSection(String segment, String value) {
        String newCommand = "";
        if (segment.equals("POINTER_THIS")) {
            newCommand += HackMacros.getPush_Pointer("THIS");
        } else if (segment.equals("POINTER_THAT")) {
            newCommand += HackMacros.getPush_Pointer("THAT");
        } else if (segment.equals("constant")) {
            newCommand += HackMacros.getConstant(value);
        } else if (segment.equals("temp")) {
            int tmp = Integer.parseInt(value);
            tmp += 5;
            newCommand += HackMacros.getPush_Temp(Integer.toString(tmp));
        } else if(segment.startsWith("STATIC_")) {
            String label = segment.replace("STATIC_", "");
            newCommand += HackMacros.getPush_Static(label);
        } else {
            newCommand += HackMacros.getSeg_Push(value, segment);
        }
        return newCommand;
    }

    private static String parsePopSection(String segment, String value) {
        String newCommand = "";
        if (segment.equals("POINTER_THIS")) {
            newCommand += HackMacros.getPop_Pointer("THIS");
        } else if (segment.equals("POINTER_THAT")) {
            newCommand += HackMacros.getPop_Pointer("THAT");
        } else if (segment.equals("temp")) {
            int tmp = Integer.parseInt(value);
            tmp += 5;
            newCommand += HackMacros.getPop_Temp(Integer.toString(tmp));
        } else if(segment.startsWith("STATIC_")) {
            String label = segment.replace("STATIC_", "");
            newCommand += HackMacros.getPop_Static(label);
        } else {
            newCommand += HackMacros.getSeg_Pop(value, segment);
        }
        return newCommand;
    }

    private static String parseArithmetic(String instruction) {
        String result = "";
        switch (instruction) {
            case "add":
                result += HackMacros.getAdd();
                break;
            case "sub":
                result += HackMacros.getSub();
                break;
            case "neg":
                result += HackMacros.getNeg();
                break;
            case "not":
                result += HackMacros.getNot();
                break;
            case "eq":
                result += HackMacros.getEq();
                break;
            case "gt":
                result += HackMacros.getGt();
                break;
            case "lt":
                result += HackMacros.getLt();
                break;
            case "and":
                result += HackMacros.getAnd();
                break;
            case "or":
                result += HackMacros.getOr();
                break;

        }
        return result;
    }

}
