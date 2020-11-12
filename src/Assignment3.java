public class Assignment3 {

    public static void main(String[] args) {

        /*
          l.d   f2,4(r1)                          // Program to be
          l.d   f4,8(r3)                          // simulated;
          mul.d f6,f2,f4                          // No pipelining
          add.d f8,f4,f6
          bne   r5,r5,target
          s.d   f6,8(r3)
          s.d   f8,4(r5)
          bne   r7,r9,target
          l.d   f2,8(r7)
          s.d   f2,8(r7)
        target:
        */


        // Register file
        int[] Reg = new int[10];
        Reg[1] = 105; Reg[3] = 203; Reg[5] = 301; // r-register values
        Reg[7] = 148; Reg[9] = 156;

        // Main memory

        int[] Mem = new int[500];
        char[] XMem = {'l', 'l', 'm', 'a', 'b', 's', 's', 'b', 'l', 's'}; // ten opcodes

        Mem[0] = 124; Mem[1] = 348; Mem[2] = 246; // their ten argument
        Mem[3] = 468; Mem[4] = 550; Mem[5] = 368; // lists; object code
        Mem[6] = 584; Mem[7] = 790; Mem[8] = 728; // for ten instructions
        Mem[9] = 728;

        Mem[109] = 19; Mem[156] = 25;             // assorted data memory values
        Mem[211] = 43;

        boolean branch;                           // for BNE results

        // Loop over instructions

        for(int PC = 0; PC < 10; PC ++){

            // f-box
            char head = XMem[PC];                 // These are the shared variables
            int tail = Mem[PC];                   // that the d-box will use
            System.out.println("f: Fetched instruction: " + head + "|" + tail + ".");

            // d-box
            char opc = head;                       // Decodes instruction into opcode
            int arg3 = tail % 10;                  // and its three arguments
            tail = tail / 10;
            int arg2 = tail % 10;
            tail = tail / 10;
            int arg1 = tail;

            System.out.println("d: Set opc to " + "'"  + opc + "'.");
            // 'opc' is the next datapath "shared variable" to be initialized;
            // 'arg1', 'arg2', 'arg3' are d-box local variables

            int D_Out1, D_Out2, dreg, sval;        // More shared variables
            switch (opc){
                case'a':

                    break;

                case 'l':
                    D_Out1 = Reg[arg1];
                    System.out.println("d: Set D_Out1 to " + D_Out1);
                    D_Out2 = arg3;
                    System.out.println("d: Set D_Out2 to " + D_Out2);

                    break;

                case'm':
                    D_Out1 = Reg[arg1];             // Localize reg. operand and latch
                    System.out.println("d: Set D_Out1 to " + D_Out1 + ".");
                    D_Out2 = Reg[arg2];             // Localize reg. operand and latch
                    System.out.println("d: Set D_Out2 to " + D_Out2 + ".");
                    dreg = arg3;                    // latch dest. register designator
                    System.out.println("d: Set dreg to f" + dreg + ".");
                    break;
            }

            // x-box
            int X_Out;
            switch(opc){

                case'x':


            }

            // m-box
            int M_Out;
            switch(opc){

            }

            // w-box
            switch(opc){

            }



        }
    }

}
