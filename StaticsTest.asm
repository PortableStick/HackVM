@256
D=A
@SP
M=D
@Sys.init
0;JMP
//function Class1.set 0
(Class1.set)
//push argument 0
@0
D=A
@ARG
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
//pop static 0
@0
D=A
@Class1.0
D=D+M
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
//push argument 1
@1
D=A
@ARG
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
//pop static 1
@1
D=A
@Class1.1
D=D+M
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
//push constant 0
@0
D=A
@SP
A=M
M=D
@SP
M=M+1
//return
@LCL
D=M
@endFrame
M=D
@5
A=D-A
@returnAddr
M=D
@SP
A=M-1
D=M
@ARG
A=M
M=D
@ARG
D=M+1
@SP
M=D
@endFrame
D=M
@THAT
MD=D-1
@THIS
MD=D-1
@ARG
MD=D-1
@LCL
MD=D-1
@returnAddr
A=M
0;JMP
//function Class1.get 0
(Class1.get)
//push static 0
@0
D=A
@Class1.0
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
//push static 1
@1
D=A
@Class1.1
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
//sub
@SP
AM=M-1
D=M
@SP
AM=M-1
M=M-D
@SP
M=M+1
//return
@LCL
D=M
@endFrame
M=D
@5
A=D-A
@returnAddr
M=D
@SP
A=M-1
D=M
@ARG
A=M
M=D
@ARG
D=M+1
@SP
M=D
@endFrame
D=M
@THAT
MD=D-1
@THIS
MD=D-1
@ARG
MD=D-1
@LCL
MD=D-1
@returnAddr
A=M
0;JMP
//function Class2.set 0
(Class2.set)
//push argument 0
@0
D=A
@ARG
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
//pop static 0
@0
D=A
@Class2.0
D=D+M
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
//push argument 1
@1
D=A
@ARG
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
//pop static 1
@1
D=A
@Class2.1
D=D+M
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
//push constant 0
@0
D=A
@SP
A=M
M=D
@SP
M=M+1
//return
@LCL
D=M
@endFrame
M=D
@5
A=D-A
@returnAddr
M=D
@SP
A=M-1
D=M
@ARG
A=M
M=D
@ARG
D=M+1
@SP
M=D
@endFrame
D=M
@THAT
MD=D-1
@THIS
MD=D-1
@ARG
MD=D-1
@LCL
MD=D-1
@returnAddr
A=M
0;JMP
//function Class2.get 0
(Class2.get)
//push static 0
@0
D=A
@Class2.0
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
//push static 1
@1
D=A
@Class2.1
A=D+M
D=M
@SP
A=M
M=D
@SP
M=M+1
//sub
@SP
AM=M-1
D=M
@SP
AM=M-1
M=M-D
@SP
M=M+1
//return
@LCL
D=M
@endFrame
M=D
@5
A=D-A
@returnAddr
M=D
@SP
A=M-1
D=M
@ARG
A=M
M=D
@ARG
D=M+1
@SP
M=D
@endFrame
D=M
@THAT
MD=D-1
@THIS
MD=D-1
@ARG
MD=D-1
@LCL
MD=D-1
@returnAddr
A=M
0;JMP
//function Sys.init 0
(Sys.init)
//push constant 6
@6
D=A
@SP
A=M
M=D
@SP
M=M+1
//push constant 8
@8
D=A
@SP
A=M
M=D
@SP
M=M+1
//call Class1.set 2
@Class1.set
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@2
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@SP
M=M+1
@SP
D=M
@LCL
M=D
@Sys.init$ret.0
0;JMP
(Class1.set)
//pop temp 0
@SP
AM=M-1
D=M
@5
M=D
//push constant 23
@23
D=A
@SP
A=M
M=D
@SP
M=M+1
//push constant 15
@15
D=A
@SP
A=M
M=D
@SP
M=M+1
//call Class2.set 2
@Class2.set
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@2
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@SP
M=M+1
@SP
D=M
@LCL
M=D
@Sys.init$ret.1
0;JMP
(Class2.set)
//pop temp 0
@SP
AM=M-1
D=M
@5
M=D
//call Class1.get 0
@Class1.get
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@0
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@SP
M=M+1
@SP
D=M
@LCL
M=D
@Sys.init$ret.2
0;JMP
(Class1.get)
//call Class2.get 0
@Class2.get
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@0
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@SP
M=M+1
@SP
D=M
@LCL
M=D
@Sys.init$ret.3
0;JMP
(Class2.get)
//label WHILE
(Sys.init$WHILE)
//goto WHILE
@Sys.init$WHILE
0;JMP
