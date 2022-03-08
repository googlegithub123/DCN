import java.io.*;
import java.util.*;
import java.net.*;
public class ArpServer{
    public static void main(String args[])throws Exception{
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();
        try{

        while(true){
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
           String ip[] = {"192.168.43.44"};
           String mac[] = {"A8-7E-EA-FC-BB-69"};
           String str = dis.readLine();
           for(int i=0; i<ip.length; i++){
               if(str.equals(ip[i])){
                dos.writeBytes(mac[i] + '\n');
                break;
               }
               
           }
           dos.close();
        }
        }catch( Exception e){
            System.out.println(e);
        }
    }
}