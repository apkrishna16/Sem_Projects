(START)
  @KBD
  D=M
  @BLACK1     //if KBD > 0 goto BLACK1
  D,JGT
  @BLANK      //if KBD == 0 goto BLANK
  D,JEQ 

(BLACK1)      //rectangle 1
  @i          //i=0
  M=0
(OUTLOOP1)
  @SCREEN     //SCREEN + 32*0 + 0/16
  D=A
  @x          //x=x+i
  M=D
  @i     
  D=M
  @x
  M=M+D
  @8          //if i==8 goto BLACK2
  D=A
  @i 
  D=D-M
  @BLACK2
  D;JEQ
  @i          //i=i+1
  M=M+1
  @j          //j=0
  M=0
 (INLOOP1)
    @64       //if j==64 goto OUTLOOP1
    D=A
    @j
    D=D-M
    @OUTLOOP1
    D;JEQ
    @x        //RAM[x] = -1
    D=M
    A=D 
    M=-1
    @j        //j = j+1
    M=M+1
    @32
    D=A
    @x        //x = x+32
    M=M+D
    @INLOOP1  //goto INLOOP1
    0;JMP

(BLACK2)      //rectangle 2
  @i
  M=0
(OUTLOOP2)
  @16408      //SCREEN + 32*0 + 384/16
  D=A
  @x
  M=D
  @i
  D=M
  @x
  M=M+D
  @8          //if i==8 goto BLACK3
  D=A
  @i
  D=D-M
  @BLACK3
  D;JEQ
  @i
  M=M+1
  @j
  M=0
  (INLOOP2)
    @64
    D=A
    @j
    D=D-M
    @OUTLOOP2
    D;JEQ
    @x
    D=M
    A=D 
    M=-1
    @j
    M=M+1
    @32
    D=A
    @x
    M=M+D
    @INLOOP2
    0;JMP

(BLACK3)      //rectangle 3 
  @i
  M=0
(OUTLOOP3)
  @22528      //SCREEN + 32*192 + 0/16
  D=A
  @x
  M=D
  @i
  D=M
  @x
  M=M+D
  @8          //if i==8 goto BLACK4
  D=A
  @i
  D=D-M
  @BLACK4
  D;JEQ
  @i
  M=M+1
  @j
  M=0
  (INLOOP3)
    @64
    D=A
    @j
    D=D-M
    @OUTLOOP3
    D;JEQ
    @x
    D=M
    A=D 
    M=-1
    @j
    M=M+1
    @32
    D=A
    @x
    M=M+D
    @INLOOP3
    0;JMP

(BLACK4)      //rectangle 4
  @i
  M=0
(OUTLOOP4)
  @22552      //SCREEN + 32*192 + 384/16
  D=A
  @x
  M=D
  @i
  D=M
  @x
  M=M+D
  @8
  D=A
  @i
  D=D-M
  @START      //if i==8 goto START
  D;JEQ
  @i
  M=M+1
  @j
  M=0
  (INLOOP4)
    @64
    D=A
    @j
    D=D-M
    @OUTLOOP4
    D;JEQ
    @x
    D=M
    A=D 
    M=-1
    @j
    M=M+1
    @32
    D=A
    @x
    M=M+D
    @INLOOP4
    0;JMP

(BLANK)       //for entire white screen
  @SCREEN     //x = 16384
  D=A
  @x   
  M=D
  @i          //i = 0   
  M=0
(LOOP)
  @8192       //if i == 8192 goto END
  D=A
  @i
  D=D-M
  @END
  D;JEQ
  @i          //RAM[x+i] = 0
  D=M
  @x
  A=M+D
  M=0
  @i          //i = i+1
  M=M+1 
  @LOOP       //goto LOOP
  0;JMP 

(END)
  @KBD
  D=M
  @START      //if KBD > 0 goto START
  D,JGT
  @END        //if KBD == 0 goto END
  D,JEQ
 




































 
