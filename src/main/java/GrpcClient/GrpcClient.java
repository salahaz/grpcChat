/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrpcClient;

import com.rpcChat1.grpc.Chat.Data;
import com.rpcChat1.grpc.MulticasterGrpc;
import com.rpcChat1.grpc.MulticasterGrpc.MulticasterBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salahazekour
 */
public class GrpcClient implements Runnable {
    private RmiChatUI gui;
    private static final String IP_ADDRESS = "239.192.1.1";
    private static final int PORT = 6113;
    private String name;
    

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
    MulticasterBlockingStub clientStub = MulticasterGrpc.newBlockingStub(channel);

        
        

    
    public void receiveMessage(String ip, int port) throws IOException {
        byte[] buffer = new byte[1024];
        MulticastSocket socket = new MulticastSocket(PORT);
        InetAddress group = InetAddress.getByName(IP_ADDRESS);
        socket.joinGroup(group);
        
        while(true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> addressesFromNetworkInterface = networkInterface.getInetAddresses();
                while (addressesFromNetworkInterface.hasMoreElements()) {
                    InetAddress inetAddress = addressesFromNetworkInterface.nextElement();
                    if (inetAddress.isSiteLocalAddress()
                            && !inetAddress.isAnyLocalAddress()
                            && !inetAddress.isLinkLocalAddress()
                            && !inetAddress.isLoopbackAddress()
                            && !inetAddress.isMulticastAddress()) {
                        socket.setNetworkInterface(NetworkInterface.getByName(networkInterface.getName()));
                    }
                }
            }
                        socket.receive(packet);
            String message = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println(message);
            displayMessage(message + "\n");
            if("EXIT".equals(message)) {
                System.out.println("Exiting!!");
                break;
            }
        }
        socket.leaveGroup(group);
        socket.close();
    }
    
   
    
    public void sendMessage(String message) throws RemoteException {
        Data multicastRequest = Data.newBuilder().setMessage(message).setIp(IP_ADDRESS).setPort(PORT).build();
        clientStub.multicast(multicastRequest);
     
    }
    
    public void displayMessage(String message) {
        gui.jTextArea1.append(message);
    }
    
    public void setUsername(String username) {
        name = username;
       
    }

   
        public void initgui() throws IOException {
        
        gui = new RmiChatUI();
        gui.setVisible(true);
        displayMessage("Waiting for message!!!\n");
        
        gui.jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    String message = gui.jTextField1.getText();
                    gui.jTextField1.setText("");
                    try { 
                        sendMessage(name + ": "+ message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(GrpcClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
        });
        
        gui.jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    name = gui.jTextField2.getText();
                    setUsername(name);
                    gui.setTitle(name + " Chat");
                    gui.jTextField1.setText("");
                    try {
                        
                        sendMessage(name + " joined the Chat!!!");
                        
                    } catch(Exception ex) {
                        Logger.getLogger(GrpcClient.class.getName()).log(Level.SEVERE, null, ex);
                    
                    }
                }
        });
        
        receiveMessage(IP_ADDRESS, PORT);
    }

        
        
        @Override
        public void run() {
            
                System.setProperty("java.net.preferIPv4Stack", "true");
                
                try {
                    initgui();
                } catch (IOException ex) {
                    Logger.getLogger(GrpcClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        
}
