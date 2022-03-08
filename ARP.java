import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ARP {
   public static void main(String[] args) {
      try {
         InetAddress address = InetAddress.getLocalHost();
         // InetAddress address = InetAddress.getByName("100.109.231.156");
         NetworkInterface n1 = NetworkInterface.getByInetAddress(address);
         if (n1 != null) {
            byte[] mac = n1.getHardwareAddress();

            if (mac != null) {
               for (int i = 0; i < mac.length; i++) {
                  System.out.format("%02X%S", mac[i], (i < mac.length - 1) ? "-" : "");
               }
            } else {
               System.out.println("address does not exit");
            }
         } else {
            System.out.println("network interface does not exit");
         }
      } catch (SocketException | UnknownHostException ex) {
         ex.printStackTrace();
      }
   }
}

// import java.net.InetAddress;
// import java.net.NetworkInterface;
// import java.net.SocketException;
// import java.net.UnknownHostException;

// public class ARP {
// public static void main(String[] args) {
// try {
// InetAddress address = InetAddress.getLocalHost();
// // InetAddress address = InetAddress.getByName("10.1.24.86");

// /*
// * Get NetworkInterface for the current host and then read
// * the hardware address.
// */
// NetworkInterface ni = NetworkInterface.getByInetAddress(address);
// if (ni != null) {
// byte[] mac = ni.getHardwareAddress();
// if (mac != null) {

// for (int i = 0; i < mac.length; i++) {
// System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
// }
// } else {
// System.out.println("Address doesn't exist or is not accessible.");
// }
// } else {
// System.out.println("Network Interface for the specified address is not
// found.");
// }
// } catch (UnknownHostException | SocketException e) {
// e.printStackTrace();
// }
// }
// }