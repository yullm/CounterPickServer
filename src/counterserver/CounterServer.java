package counterserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class CounterServer {
    
   public static ArrayList<HeroData> heroes;
   public static boolean listen;
   
    public static void main(String[] args) {
        int port = 1447;
        heroes = WebAPI.GenerateHeroList();
        listen = true;
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started");
            while(listen == true){
                Socket client = serverSocket.accept();
                System.out.println("Client connected");
                new Thread(
                        new HandleRequest(client)
                ).start();
                System.out.println("Handling Client");
            }
        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }

}
