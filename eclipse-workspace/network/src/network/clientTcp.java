package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
	import java.net.Socket;
	 
public class clientTcp{
	
	public static void main(String[] args) throws IOException {
           
	            Socket socket = new Socket( "192.168.1.229", 88 );

	           try {
	        	BufferedReader in = new BufferedReader(
	        				 new InputStreamReader(socket.getInputStream()));
	          
	    		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
	  
	    		out.writeBytes("xin chao Nguyen Van Tiem");
	           
	            String line = in.readLine();
	            
	            System.out.println( line );
	             
	           
	            in.close();
	            out.close();
	            socket.close();
	        }
	        catch( Exception e )
	        {
	            e.printStackTrace();
	        }
	    }
}
