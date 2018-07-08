public class Parser {
    private String comp;
    private String dest;
    private String jmp;


    public Parser(String line){
        parse(line);
    }

    public void parse(String line){
//        check for inline comment
        if (line.contains("//")){
            String[] splitOnInlineComment = line.split("//");
            line = splitOnInlineComment[0].trim();

        }
//        check for jump instruction
        if (line.contains(";")){
            String[] splitOnSemi = line.split(";");
            jmp = splitOnSemi[1];
            dest = "null";
            comp = splitOnSemi[0];
        } else if(line.contains("=")) {
            String[] splitOnEquals = line.split("=");
//            System.out.println(splitOnEquals[0]);
            dest = splitOnEquals[0];
            comp = splitOnEquals[1];
        }
    }

    public String getComp() {
        return comp;
    }

    public String getDest() {
        return dest;
    }

    public String getJmp() {
        return jmp;
    }
}
