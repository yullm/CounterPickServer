package counterserver;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class HandleRequest implements Runnable{
    
    private final Socket client;
    
    public HandleRequest(Socket client){
        this.client = client;
    }
    
    @Override
    public void run(){
        try{
            Gson gson = new Gson();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);
            String line;
            line = in.readLine();
            OPMessage op = gson.fromJson(line,OPMessage.class);
            System.out.println(op.getOpcode());
            switch(op.getOpcode()){
                case 0:
                    returnHeroList(out);
                    break;
                case 2:
                    returnHeroComparison(out,op.getBody());
                    break;
            }
            in.close();
            out.close();
            client.close();
        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }
    
    public void returnHeroList(PrintWriter out){
        Gson gson = new Gson();
        out.print("[\r");
        CounterServer.heroes.forEach((h) -> {
            String jStr = gson.toJson(h);
            if(h != CounterServer.heroes.get(CounterServer.heroes.size() - 1))
                out.print(jStr+",\r");
            else{
                out.print(jStr+"\r");
            }
        });
        out.println("]");
    }
    
    public void returnHeroComparison(PrintWriter out,String hero){
        Gson gson = new Gson();
        ArrayList comps = Scrapper.generateComparisonsFromHero(hero);
        out.println(gson.toJson(comps));
    }
}

