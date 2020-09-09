
import ChatService.ChatService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salahazekour
 */
public class GRPCServer {
    
    public static void main(String[] args) throws IOException, InterruptedException  {
            System.setProperty("java.net.preferIPv4Stack", "true");

            System.out.println("Starting GRPC Server!!!");
        Server server = ServerBuilder.forPort(9090).addService( new ChatService()).build();
        
        server.start();
        
        System.out.println("Server started at " + server.getPort());
        
        server.awaitTermination();
        
    }
}
