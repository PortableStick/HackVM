package com.gregoftheweb;

public class HackMacros {
    private final static String Add =
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@SP\n" +
            "AM=M-1\n" +
            "M=D+M\n" +
            "@SP\n" +
            "M=M+1\n";
    private final static String Sub =
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@SP\n" +
            "AM=M-1\n" +
            "M=M-D\n" +
            "@SP\n" +
            "M=M+1\n";
    private final static String Neg =
            "@SP\n" +
            "A=M-1\n" +
            "M=-M\n";
    // %s x 4
    private final static String Eq =
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@SP\n" +
            "AM=M-1\n" +
            "D=D-M\n" +
            "@EQL%s\n" +
            "D;JEQ\n" +
            "@SP\n" +
            "A=M\n" +
            "M=0\n" +
            "@END%s\n" +
            "0;JMP\n" +
            "(EQL%s)\n" +
            "@SP\n" +
            "A=M\n" +
            "M=-1\n" +
            "(END%s)\n" +
            "@SP\n" +
            "M=M+1\n";
    // %s x 4
    private final static String Gt =
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@SP\n" +
            "AM=M-1\n" +
            "D=M-D\n" +
            "@GT%s\n" +
            "D;JGT\n" +
            "@SP\n" +
            "A=M\n" +
            "M=0\n" +
            "@END%s\n" +
            "0;JMP\n" +
            "(GT%s)\n" +
            "@SP\n" +
            "A=M\n" +
            "M=-1\n" +
            "(END%s)\n" +
            "@SP\n" +
            "M=M+1\n";
    // %s x 4
    private final static String Lt =
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@SP\n" +
            "AM=M-1\n" +
            "D=M-D\n" +
            "@LT%s\n" +
            "D;JLT\n" +
            "@SP\n" +
            "A=M\n" +
            "M=0\n" +
            "@END%s\n" +
            "0;JMP\n" +
            "(LT%s)\n" +
            "@SP\n" +
            "A=M\n" +
            "M=-1\n" +
            "(END%s)\n" +
            "@SP\n" +
            "M=M+1\n";
    // %s x 4
    private final static String And =
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@SP\n" +
            "AM=M-1\n" +
            "M=D&M\n" +
            "@SP\n" +
            "M=M+1\n";
    // %s x 4
    private final static String Or =
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@SP\n" +
            "AM=M-1\n" +
            "M=D|M\n" +
            "@SP\n" +
            "M=M+1\n";
    private final static String Not =
            "@SP\n" +
            "A=M-1\n" +
            "M=!M\n";
    // %s1 = offset, %s2 = segment
    private final static String Seg_Push =
            "@%s\n" +
            "D=A\n" +
            "@%s\n" +
            "A=D+M\n" +
            "D=M\n" +
            "@SP\n" +
            "A=M\n" +
            "M=D\n" +
            "@SP\n" +
            "M=M+1\n";
    // %s1 = offset, %s2 = segment
    private final static String Seg_Pop =
            "@%s\n" +
            "D=A\n" +
            "@%s\n" +
            "D=D+M\n" +
            "@R13\n" +
            "M=D\n" +
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@R13\n" +
            "A=M\n" +
            "M=D\n";
    // %s = value
    private final static String Constant =
            "@%s\n" +
            "D=A\n" +
            "@SP\n" +
            "A=M\n" +
            "M=D\n" +
            "@SP\n" +
            "M=M+1\n";
    // %s = TEMP offset
    private final static String Push_Temp =
            "@%s\n" +
            "D=M\n" +
            "@SP\n" +
            "A=M\n" +
            "M=D\n" +
            "@SP\n" +
            "M=M+1\n";
    // %s = TEMP offset
    private final static String Pop_Temp =
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@%s\n" +
            "M=D\n";
    // %s = Pointer reference
    private final static String Pop_Pointer =
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@%s\n" +
            "M=D\n";
    // %s = Pointer reference
    private final static String Push_Pointer =
            "@%s\n" +
            "D=M\n" +
            "@SP\n" +
            "A=M\n" +
            "M=D\n" +
            "@SP\n" +
            "M=M+1\n";
    // hash, nArgs, function, hash
    private final static String Call =
            //return hash
            "//push return address\n" +
            "@%s\n" +
            "D=A\n" +
            "@SP\n" +
            "A=M\n" +
            "M=D\n" +
            "@SP\n" +
            "M=M+1\n" +
            "//push LCL\n"+
            "@LCL\n" +
            "D=M\n" +
            "@SP\n" +
            "A=M\n" +
            "M=D\n" +
            "@SP\n" +
            "M=M+1\n" +
            "//push ARG\n"+
            "@ARG\n" +
            "D=M\n" +
            "@SP\n" +
            "A=M\n" +
            "M=D\n" +
            "@SP\n" +
            "M=M+1\n" +
            "//push THIS\n"+
            "@THIS\n" +
            "D=M\n" +
            "@SP\n" +
            "A=M\n" +
            "M=D\n" +
            "@SP\n" +
            "M=M+1\n" +
            "//push THAT\n"+
            "@THAT\n" +
            "D=M\n" +
            "@SP\n" +
            "A=M\n" +
            "M=D\n" +
            "@SP\n" +
            "M=M+1\n" +
            "//ARG = SP - 5 - nArgs\n"+
            "@SP\n" +
            "D=M\n" +
            "@5\n" +
            "D=D-A\n" +
             //nArgs
            "@%s\n" +
            "D=D-A\n" +
            "@ARG\n" +
            "M=D\n" +
            "//LCL = SP\n"+
            "@SP\n" +
            "D=M\n" +
            "@LCL\n" +
            "M=D\n" +
            //function name
            "//GOTO label\n"+
            "@%s\n" +
            "0;JMP\n" +
            //return hash
            "//return address\n"+
            "(%s)\n";
    private static final String Bootstrap =
            "@256\n" +
            "D=A\n" +
            "@SP\n" +
            "M=D\n";
    private static final String Return =
            "//endframe = LCL\n" +
            "@LCL\n" +
            "D=M\n" +
            "@endFrame\n" +
            "M=D\n" +
            "//returnAddr = *(endframe - 5)\n" +
            "@5\n" +
            "A=D-A\n" +
            "D=M\n" +
            "@returnAddr\n" +
            "M=D\n" +
            "//*ARG = pop()\n" +
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@ARG\n" +
            "A=M\n" +
            "M=D\n" +
            "//SP = ARG + 1\n" +
            "@ARG\n" +
            "D=M+1\n" +
            "@SP\n" +
            "M=D\n" +
            "@endFrame\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@THAT\n" +
            "M=D\n" +
            "@endFrame\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@THIS\n" +
            "M=D\n" +
            "@endFrame\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@ARG\n" +
            "M=D\n" +
            "@endFrame\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@LCL\n" +
            "M=D\n" +
            "@returnAddr\n" +
            "A=M\n" +
            "0;JMP\n";
    // %s = label
    private static final String If =
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            //jump label
            "@%s\n" +
            "D;JNE\n";
    // %s = label
    private static final String Goto =
            //label
            "@%s\n" +
            "0;JMP\n";
    // %s = variable name
    private static final String Push_Static =
            "@%s\n" +
            "D=M\n" +
            "@SP\n" +
            "A=M\n" +
            "M=D\n" +
            "@SP\n" +
            "M=M+1\n";
    // %s = variable name
    private static final String Pop_Static =
            "@SP\n" +
            "AM=M-1\n" +
            "D=M\n" +
            "@%s\n" +
            "M=D\n";

    private static final String Label = "(%s)\n";

    public static String getPop_Static(String label) {
        return String.format(Pop_Static, label);
    }

    public static String getPush_Static(String label) {
        return String.format(Push_Static, label);
    }

    public static String getAdd() {
        return Add;
    }

    public static String getSub() {
        return Sub;
    }

    public static String getNeg() {
        return Neg;
    }

    public static String getEq() {
        return hasherize(Eq);
    }

    public static String getGt() {
        return hasherize(Gt);
    }

    public static String getLt() {
        return hasherize(Lt);
    }

    public static String getAnd() {
        return And;
    }

    public static String getOr() {
        return Or;
    }

    public static String getNot() {
        return Not;
    }

    public static String getSeg_Push(String offset, String segment) {
        return String.format(Seg_Push, offset, segment);
    }

    public static String getSeg_Pop(String offset, String segment) {
        return String.format(Seg_Pop, offset, segment);
    }

    public static String getConstant(String value) {
        return String.format(Constant, value);
    }

    public static String getPush_Temp(String offset) {
        return String.format(Push_Temp, offset);
    }

    public static String getPop_Temp(String offset) {
        return String.format(Pop_Temp, offset);
    }

    public static String getPop_Pointer(String ref) {
        return String.format(Pop_Pointer, ref);
    }

    public static String getPush_Pointer(String ref) {
        return String.format(Push_Pointer, ref);
    }
    public static String getCall(String hash, String label, String nArgs) {
        return String.format(Call, hash, nArgs, label, hash);
    }

    public static String getFunction(String label, String nVars) {
        String result = String.format("(%s)\n", label);
        int nArgs = Integer.parseInt(nVars);
        for(int i = 0; i < nArgs; i++) {
            result += "@SP\n" +
                    "A=M\n" +
                    "M=0\n" +
                    "@SP\n" +
                    "M=M+1\n";
        }
        return result;
    }

    public static String getBootstrap() {
        return Bootstrap + getCall("Program.go", "Sys.init", "0");
    }

    public static String getReturn() {
        return Return;
    }

    public static String getLabel(String label) {
        return String.format(Label, label);
    }

    public static String getIf(String label) {
        return String.format(If, label);
    }

    public static String getGoto(String label) {
        return String.format(Goto, label);
    }

    private static String hasherize(String template) {
        String randomNumber = Double.toString(Math.floor(Math.random() * 1000));
        return String.format(template, randomNumber, randomNumber, randomNumber, randomNumber);
    }
}
