public class Main {
    public static void main(String[] args) {
        System.out.println("## --- ##");
        int[] printByteCode = {
                Opcode.PUSH_1,
                Opcode.PUSH_1,
                Opcode.ADD,
                Opcode.PRINT,
                Opcode.HALT
        };

        int[] additionByteCode = {
                Opcode.ICONST, 10,
                Opcode.PUSH_1,
                Opcode.ADD,
                Opcode.PRINT,
                Opcode.HALT
        };

        int[] subtractionByteCode = {
                Opcode.ICONST, 10,
                Opcode.PUSH_1,
                Opcode.SUB,
                Opcode.PRINT,
                Opcode.HALT
        };
        VM vm = new VM(subtractionByteCode, 0, 0);
        vm.run();
    }
}
