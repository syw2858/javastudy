import java.io.*;
import java.net.*;
public class SenderThread extends Thread {
	Socket socket;
	SenderThread(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			while (true) {
				String str = reader.readLine(); //키보드로 메세지 입력
				if (str.equals("bye"))
					break;
				writer.println(str); // 송신
				writer.flush();
			}
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
		}
	}
}
