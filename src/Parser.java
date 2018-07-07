public class Parser {
    private String comp;
    private String dest;
    private String jmp;


    public Parser(String line){
        parse(line);
    }

    public void parse(String line){
        if (line.contains(";")){
            String[] splitOnSemi = line.split(";");
            jmp = splitOnSemi[1];
            String[] splitOnEquals = splitOnSemi[0].split("=");
            dest = splitOnEquals[0];
            comp = splitOnEquals[1];
        } else {
            String[] splitOnEquals = line.split("=");
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
