import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VM {
    private final int[] stack;
    private final int[] code;
    private final int[] memory;
    private int IP;
    private int SP = -1;

    public VM(int[] code, int startIP, int memory_size) {
        this.stack = new int[100];
        this.memory = new int[memory_size];
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

                case Opcode.ICONST -> {
                            int operand = this.code[this.IP++];
                            this.stack[++this.SP] = operand;
                }

                case Opcode.GSTORE -> {
                            int operand = this.code[this.IP++];
                            int value = this.stack[this.SP--];
                            this.memory[operand] = value;
                }

                case Opcode.GLOAD -> {
                    int operand = this.code[this.IP++];
                    int value = this.memory[operand];
                    this.stack[++this.SP] = value;
                }

                case Opcode.ADD -> {
                    int x = this.stack[this.SP--];
                    int y = this.stack[this.SP--];
                    this.stack[++this.SP] = x + y;
                }

                case Opcode.SUB -> {
                    int x = this.stack[this.SP--];
                    int y = this.stack[this.SP--];
                    this.stack[++this.SP] = y - x;
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
