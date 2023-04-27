import java.io.*;
import java.net.*;

public class ClientExample1 {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket( "127.0.0.1" , 9000);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			String str = "Hello, Server";
			out.write(str.getBytes()); // 송신
			byte arr[] = new byte[100];
			in.read(arr); //수신
			System.out.println(new String(arr)); //출력
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch (Exception e) {
			}
		}
	}
}
