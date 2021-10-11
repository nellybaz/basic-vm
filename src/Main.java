public class Main {
    public static void main(String[] args) {
        System.out.println("## --- ##");
        int[] byteCode = {
                Opcode.PUSH_1,
                Opcode.PUSH_1,
                Opcode.ADD,
                Opcode.PRINT,
                Opcode.HALT
        };

        int[] byteCode2 = {
                Opcode.ICONST, 10,
                Opcode.PUSH_1,
                Opcode.ADD,
                Opcode.PRINT,
                Opcode.HALT
        };
        VM vm = new VM(byteCode2, 0);
        vm.run();
    }
}
