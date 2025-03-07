/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatService;

import com.rpcChat1.grpc.Chat;
import com.rpcChat1.grpc.Chat.Empty;
import com.rpcChat1.grpc.MulticasterGrpc.MulticasterImplBase;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salahazekour
 */
public class ChatService extends MulticasterImplBase {

    @Override
    public void multicast(Chat.Data request, StreamObserver<Chat.Empty> responseObserver) {
        String message = request.getMessage();
        String ip = request.getIp();
        int port = request.getPort();
         
        DatagramSocket socket;
        try {
            socket = new DatagramSocket();
            InetAddress group = InetAddress.getByName(ip);
            byte[] msg = message.getBytes();
            DatagramPacket packet = new DatagramPacket(msg, msg.length, group, port);
            socket.send(packet);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ChatService.class.getName()).log(Level.SEVERE, null, ex);
        }
        Empty.Builder response = Empty.newBuilder();
        responseObserver.onNext(response.build());
    }
    
}
