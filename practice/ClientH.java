import java.io.*;
import java.net.*;
import java.util.*;

public class ClientH{
    public static void main(String[] args){
       try{
        Socket soc = new Socket("localhost", 3000);
        Scanner Sc = new Scanner(System.in);
        DataInputStream dis = new DataInputStream(soc.getInputStream());
        System.out.println("Enter the URL:");
        String str = Sc.nextLine();
        DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
        dos.writeUTF(str);
        str = (String)dis.readUTF();
        System.out.println("The HTML code of the website is"+ str);
        soc.close();   
    }catch (Exception e) {
        System.out.println(e);
}
}
}