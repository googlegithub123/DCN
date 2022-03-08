import java.io.*;
import java.net.*;
import java.util.*;
public class Arp{
    public static void main(String args[])throws Exception{
        try{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Socket s = new Socket("127.0.0.1", 3000);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        System.out.println("Enter the ip address:");
        String str = in.readLine();
        dos.writeBytes(str + '\n');
        String str1 = dis.readLine();
        System.out.println("the mac address:" + str1 );
        s.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}