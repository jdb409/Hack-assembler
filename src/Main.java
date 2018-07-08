import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException{
        String fileName = "Pong.asm";
        Path input = Paths.get("/Users/jon/Desktop/coding projects/JavaProjects/Hack Assembler/src/files", fileName);
        Path output = Paths.get("/Users/jon/Desktop/nand2tetris/projects/06/assembled",fileName.split("\\.")[0]+".hack");
        List<String> lines = Files.readAllLines(input);
        List<String> assembled = new ArrayList<>();
        SymbolTable symbolTable = new SymbolTable(lines);
        Assemble assembler = new Assemble(symbolTable);


        for (String line: lines){
            line = line.trim();
//            Parse each line. If white space, or begins with / ignore.
            if(line.length() == 0 || line.startsWith("//") || line.startsWith("(")){
                continue;
            }
//            A instruction
            if (line.startsWith("@")){
                if (assembler.assembleAInstruction(line) != null){
                    assembled.add(assembler.assembleAInstruction(line));
                }
                System.out.println(assembler.assembleAInstruction(line));
            }
//            C Instruction.  Need to parseLine
            else {
                Parser parser = new Parser(line);
                String comp = parser.getComp();
                String dest = parser.getDest();
                String jmp = parser.getJmp();
                assembled.add(assembler.assembleCInstruction(comp,dest,jmp));
            }
        }
        Files.write(output,assembled);

    }


}
