import java.io.*;
import java.util.*;
import java.net.*;
public class ClientSlide{
    public static void main(String args[])throws Exception{
        Socket s = new Socket("localhost", 3000);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        int f = dis.readInt();
        String data[] = new String[f];
        int i=0;
        while(i<f){
            int a = Integer.parseInt((String)dis.readUTF());
            int k = 0;
            for(int j=0; j<a; j++){
                data[i] = (String)dis.readUTF();
                System.out.println("the frame data "+ k + "are:" + data[i]);
                
                i++;
                k++;
            }
            System.out.println("acknowledged sent "+ a + "frame sent" );
            dos.writeUTF(Integer.toString(i));
        }
    }
}

// import java.net.*;
// import java.util.*;
// import java.io.*;
// public class ClientSlide{
//     public static void main(String args[])throws Exception{
//         Socket s= new Socket("localhost",6666);
//         DataInputStream din =new DataInputStream(s.getInputStream());
//         DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//         int f = (din.readInt());
//         String[] data = new String[f];
//         int i=0;
//         while(i<f)
//         {
//             int a = Integer.parseInt((String)din.readUTF());
//             int k=0;
//             for(int j=0;j<a;j++)
//             {
//                 data[i] = (String) din.readUTF();
//                 System.out.println("The Data in the "+k+" Frame:"+data[i]);
//                 i++;
//                 k++;
//             }
//             System.out.println("Acknowledgement Sent for "+a+" Frames.");
//             dout.writeUTF(Integer.toString(i));
//         }
//     }
// }