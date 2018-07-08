import java.util.*;

public class SymbolTable {
    private Map<String,Integer> symbolTable = new HashMap<>();
    private List<String> lines = new ArrayList<>();

    public SymbolTable(List<String> lines){
        initializeTable();
        firstPass(lines);
    }

    public Boolean contains(String key){
        return symbolTable.containsKey(key);
    }

    public Integer getValue(String key){
        return symbolTable.get(key);
    }

    public void firstPass(List<String> lines){


        int lineCount = 0;
        for (String line: lines){
            if(line.length() == 0 || line.startsWith("//")){
                continue;
            }
            if (line.startsWith("(")){
                line = line.replace("(","");
                line = line.replace(")","");
                symbolTable.put(line, lineCount);
            }
            lineCount++;
        }
    }



    void initializeTable(){
        symbolTable.put("SP",0);symbolTable.put("LCL",1);symbolTable.put("ARG",2);symbolTable.put("THIS",3);
        symbolTable.put("THAT",4);symbolTable.put("R0",0);symbolTable.put("R1",1);symbolTable.put("R2",2);
        symbolTable.put("R3",3);symbolTable.put("R4",4);symbolTable.put("R5",5);symbolTable.put("R6",6);
        symbolTable.put("R7",7);symbolTable.put("R8",8);symbolTable.put("R9",9);symbolTable.put("R10",10);
        symbolTable.put("R11",11);symbolTable.put("R12",12);symbolTable.put("R13",13);symbolTable.put("R14",14);
        symbolTable.put("R15",15);symbolTable.put("SCREEN",16384);symbolTable.put("KBD",24576);
    }

    @Override
    public String toString() {
        return "SymbolTable{" +
                "symbolTable=" + symbolTable +
                '}';
    }
}
