import java.io.*;
import java.util.*;
import java.net.*;

public class server_ftp{
   public static void main(String[] args)throws Exception{
          ServerSocket ss = new ServerSocket(5000);
          Socket s = ss.accept();
          InetAddress IA = InetAddress.getByName("localhost");
          FileOutputStream fos = new FileOutputStream("Receiver.txt");
          BufferedOutputStream bos = new BufferedOutputStream(fos);
          InputStream is = s.getInputStream();
          byte[] contents = new byte[10000];
          int byteRead =0;
          while( (byteRead = is.read(contents)) != -1)
            bos.write(contents,0, byteRead);
           bos.flush();
           System.out.println("file saved successfully");
 	    s.close();
          ss.close();
       }
    }
	   
	    