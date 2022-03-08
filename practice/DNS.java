import java.io.*;
import java.net.*;
import java.util.*;
public class DNS{
    public static void main(String[] args) {
        int n;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("\n 1.DNS, 2.Exit");
            System.out.println("Enter Your Choice:");
            n = sc.nextInt();
            if(n==1){
                try{
                    System.out.println("Enter the host:");
                    String hname = in.readLine();
                    InetAddress address;
                    address = InetAddress.getByName(hname);
                    System.out.println("The host:" + address.getHostName());
                    System.out.println("The Ip:"+ address.getHostAddress());
            
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }while(!(n==2));
    }
}