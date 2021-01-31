package network;

//A Java program for a Client 
import java.net.*; 
import java.io.*; 

public class serverTcp {




	public static void main(String[] args) throws IOException {
		
		ServerSocket einSS = new ServerSocket(88);
		
		Socket einAS = einSS.accept();
		
		BufferedReader vomClient = new BufferedReader(
		 new InputStreamReader(einAS.getInputStream()));
		
		BufferedWriter zumClient = new BufferedWriter(
		 new OutputStreamWriter(einAS.getOutputStream()));
        
		DataOutputStream outToClient =
        new DataOutputStream(einAS.getOutputStream());

    
   
		String s;
		try {
		if((s = vomClient.readLine())!= null){
		System.out.println(s);
//		zumClient.write("java server send");
//		zumClient.newLine();
//		zumClient.flush();
		outToClient.writeBytes("xin chao"); 
		}
		} catch (Exception e) { }
		System.out.println("Client disconect!!!");
		vomClient.close();
		einAS.close();
		einSS.close();
		}

}
