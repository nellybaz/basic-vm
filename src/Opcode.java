import java.util.Map;

import static java.util.Map.entry;

public class Opcode {
    public static final int ADD = 1;
    public static final int PUSH_1 = 2;
    public static final int PRINT = 3;
    public static final int HALT = 4;
    public static final int ICONST = 5;
    public static final int SUB = 6;
    public static final int GSTORE = 7;
    public static final int GLOAD = 8;

    public static Map<Integer, String> OPCODES = Map.ofEntries(
            entry(1, "ADD"),
            entry(2, "PUSH_1"),
            entry(3, "PRINT"),
            entry(4, "HALT"),
            entry(5, "ICONST"),
            entry(6, "SUB"),
            entry(7, "GSTORE"),
            entry(8, "GLOAD")
    );
}