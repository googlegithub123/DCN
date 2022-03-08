import java.util.*;
public class Subnetting{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the ip address:");
        String ip = sc.nextLine();
        String split_ip[] = ip.split("\\.");
        String split_bip[] = new String[4];
        String bip = "";
        for(int i=0; i<4; i++){
            split_bip[i] = appendZero(Integer.toBinaryString(Integer.parseInt(split_ip[i])));
            bip += split_bip[i];
        }

        System.out.println("the binary of ip is:" + bip);

        System.out.println(" enter the subnetting mask:");
        int mask = sc.nextInt();

        int bit = 32- mask;

        if(mask>24){
            int over = mask-24;
            System.out.println("the no.of networking:" + Math.pow(2,(mask-24)));
            System.out.println("the host portion: " + (Math.pow(2,(8-over))-2));
        }else if(mask>16){
            int over = mask-16;
            System.out.println("the no.of networking" + Math.pow(2,(mask-16+8)));
            System.out.println("the host portion: " + (Math.pow(2,(8-over))-2));
        }else{
            int over = mask-8;
            System.out.println("the no.of networking" + Math.pow(2,(mask+8)));
            System.out.println("the host portion: " + (Math.pow(2,(8-over))-2));

        }

        int fbip[] = new int[32];
        for(int i=0; i<32; i++)
            fbip[i] = (int)bip.charAt(i)-48;

         for(int i=31; i>31-bit; i-- )
            fbip[i] &= 0;
            
         String fib[] = {"","","",""};
           
        for(int i=0; i<32; i++)
            
            fib[i/8] = new String(fib[i/8] + fbip[i] );
        
        System.out.print("the first address is:");
        
        for(int i=0; i<4; i++){
            System.out.print(Integer.parseInt(fib[i],2));
            if(i != 3){
                System.out.print(".");
            }
        }

        System.out.println();

        
        int lbip[] = new int[32];
        for(int i=0; i<4; i++)
            lbip[i] = (int)bip.charAt(i)-48;

        for(int i=31; i>31-bit; i-- )
            lbip[i] |= 1;
            
        String lib[] = {"","","",""};
           
        for(int i=0; i<32; i++)
            
            lib[i/8] = new String(lib[i/8] + lbip[i] );
        
        System.out.print("the last address is:");
        
        for(int i=0; i<4; i++){
            System.out.print(Integer.parseInt(lib[i],2));
            if(i != 3)System.out.print(".");
        }

        System.out.println();




             

    }


    static String appendZero(String s){
        String temp = new String("00000000");
        return temp.substring(s.length())+s;
    }
}