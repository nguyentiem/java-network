package UDP;
	import java.io.IOException; 
	import java.net.DatagramPacket; 
	import java.net.DatagramSocket; 
	import java.net.InetAddress; 
	import java.util.Scanner; 
	  
public class UDP {

	
	    public static void main(String args[]) throws IOException 
	    { 
//	        Scanner sc = new Scanner(System.in); 
	  
	    	 byte[] receive = new byte[65535]; 
	    	  
	         DatagramPacket DpReceive = null; 
	        DatagramSocket ds = new DatagramSocket(); 
	  
            InetAddress ip = InetAddress.getByName("192.168.1.229");
	        byte buf[] = null; 
	  
	        // loop while user not enters "bye" 
	        
	            String inp = "Nguyen Van Tiem"; 
	  
	            // convert the String input into the byte array. 
	            buf = inp.getBytes(); 
	  
	            // Step 2 : Create the datagramPacket for sending 
	            // the data. 
	            DatagramPacket DpSend = 
	                  new DatagramPacket(buf, buf.length, ip, 88); 
	  
	            // Step 3 : invoke the send call to actually send 
	            // the data. 
	            ds.send(DpSend); 
	           //////////////////////////////////////////////////////
	            // Step 2 : create a DatgramPacket to receive the data. 
	            DpReceive = new DatagramPacket(receive, receive.length); 
	  
	            // Step 3 : revieve the data in byte buffer. 
	            ds.receive(DpReceive); 
	  
	            System.out.println("Client:-" + data(receive)); 
	  
	            // Exit the server if the client sends "bye" 
//	            if (data(receive).toString().equals("bye")) 
//	            { 
//	                System.out.println("Client sent bye.....EXITING"); 
//	                break; 
//	            } 
	  
	    } 
	    public static StringBuilder data(byte[] a) 
	    { 
	        if (a == null) 
	            return null; 
	        StringBuilder ret = new StringBuilder(); 
	        int i = 0; 
	        while (a[i] != 0) 
	        { 
	            ret.append((char) a[i]); 
	            i++; 
	        } 
	        return ret; 
	    } 

}
