// import java.io.*;
// import java.net.*;
// import java.util.*;
// public class ClientS{
//     public static void main(String[] args) throws Exception{
//         try{
//         Scanner sc = new Scanner(System.in);
//         Socket soc = new Socket("localhost", 3000);
//         System.out.println("connected nto the server");
//         while(true){
//             DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
//             System.out.println("your msg:");
//             String fs = sc.nextLine();
//             dos.writeUTF(fs);
//             if(fs.equals("STOP")){
//                 break;
//             }
//             DataInputStream dis = new DataInputStream(soc.getInputStream());
//             String reply = dis.readUTF();
//             System.out.println("server says:"+ reply);
//             if(reply.equals("STOP")){
//                 break;
//             }

//         }
//         soc.close();
//         sc.close();
//     }catch (Exception e){
//         System.out.println(e);
//     }
//     }
// }


import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ClientS {
    public static void main(String[] args) {
        try {
            Scanner scan=new Scanner(System.in);
            Socket s = new Socket("localhost", 3000);
            System.out.println("CLIENT CONNECTED TO SERVER");
            while(true){
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                System.out.print("Your Message: ");
                String data = scan.nextLine();
                dos.writeUTF(data);
                if(data.equals("STOP"))
                    break;
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String res = dis.readUTF();
                System.out.println("Server: " + res);
                if(res.equals("STOP"))
                    break;
            }
            scan.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
};