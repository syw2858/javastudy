import java.io.*;
import java.net.*;

public class ServerExample1 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept(); //메세지가 들어왔네! -> 소켓 객체 만들고 입출력 객체
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			byte arr[] = new byte[100];
			in.read(arr);
			System.out.println(new String(arr));
			String str = "Hello, Client";
			out.write(str.getBytes()); //송신
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch (Exception ignored) {
			}
			try {
				serverSocket.close();
			}
			catch (Exception ignored) {
			}
		}
	}
}
