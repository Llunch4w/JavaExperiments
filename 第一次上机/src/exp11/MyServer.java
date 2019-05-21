package exp11;

import java.io.*;
import java.net.*;
import exp11.wr.*;

public class MyServer {
	public static void main(String[] args) {
		try {
			ClientListener server = new ClientListener(1888);
			server.start();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

class ClientListener extends Thread{
	private ServerSocket serverSocket;
	private Socket socket;
	public ClientListener(int port) throws IOException{
		serverSocket = new ServerSocket(port);
	    serverSocket.setSoTimeout(1000000);
	}
	public void run() {
		try {
			System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
			socket = serverSocket.accept();
//			System.out.println("连接成功");
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			System.out.println("客户机：" + in.readUTF());
			out.writeUTF("服务器：我是服务器，我听到了，我们可以聊天了！");
//			sleep(3000);
			ReadThread readThread = new ReadThread(in);
			WriteThread writeThread = new WriteThread("服务器",out);
			readThread.start();
			writeThread.start();
		}catch(Exception e) {
			this.interrupt();
//			e.printStackTrace();
		}
	}
}