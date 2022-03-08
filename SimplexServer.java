import java.io.*;
import java.net.*;
public class SimplexServer{
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(3000);
            Socket s = ss.accept();
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            String str = "hii everyone";
            dos.writeUTF(str);
            dos.flush();
            dos.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}