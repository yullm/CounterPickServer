package counterserver;

public class OPMessage {
    
    private int opcode;
    private String body;

    public OPMessage(){
        opcode = 0;
        body = "";
    }
       
    public OPMessage(int opcode,String body){
        this.opcode = opcode;
        this.body = body;
    }

    public int getOpcode() {
        return opcode;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    
    
}
