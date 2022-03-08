import java.io.*;
import java.net.*;
import java.util.*;
public class ClientFTP{
    public static void main(String[] args)throws Exception{
        do{
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the choice 1.send file, 2.exit");
        int Choice = sc.nextInt();
        Socket s = new Socket(InetAddress.getByName("localhost"), 5000);
     
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
      
        switch ( Choice) {
            case 1:
            {
                System.out.println("enter the file name:");
                String fileName = sc.next();
                File file = new File(fileName);
                try{
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                OutputStream os = s.getOutputStream();
                byte[] contents;
                long fileLength = file.length();
                long current = 0;
                while(current != fileLength){
                    int size = 1000;
                    if((fileLength-current) >= size){
                        current += size;
                    }else{
                        size = (int)(fileLength-current);
                        current = fileLength;
                    }
                    contents = new byte[size];
                    
                    bis.read(contents, 0, size);
                    os.write(contents);
                }
                os.flush();
                s.close();
                System.out.println("file transfer successfully");


                }catch ( Exception e){
                    System.out.println(e);
                }

                break;
            }case 2:
            {
                System.exit(1);
                break;
            }
            
                  
        
            
        }
    }while(true);
    }
}