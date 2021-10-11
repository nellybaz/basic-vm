import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class VM {
    private final int[] stack;
    private final int[] code;
    private int IP;
    private int SP = -1;

    public VM(int[] code, int startIP) {
        this.stack = new int[100];
        this.code = code;
        this.IP = startIP;
    }

    public List<Integer> getUsedStack(){
        List<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i <= this.SP; i++){
            output.add(this.stack[i]);
        }
        return output;
    }

    public void run(){

        while(true){
            int opcode = this.code[this.IP++];

            switch (opcode) {
                case Opcode.PUSH_1 ->
                    this.stack[++this.SP] = 1;
                case Opcode.ICONST ->
                        {
                            int operand = this.code[this.IP++];
                            this.stack[++this.SP] = operand;
                        }
                case Opcode.ADD -> {
                    int x = this.stack[this.SP--];
                    int y = this.stack[this.SP--];
                    this.stack[++this.SP] = x + y;
                }
                case Opcode.PRINT ->
                        System.out.println(this.stack[this.SP--]);

                case Opcode.HALT ->
                        System.exit(0);
            }

            System.out.printf("%s %s%n", Opcode.OPCODES.get(opcode), Arrays.toString(getUsedStack().toArray()));

        }

    }
}