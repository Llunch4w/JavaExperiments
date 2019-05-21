package exp11;

import java.io.*;
import java.net.*;
import exp11.wr.*;

public class MyClient {
	public static void main(String[] args) {
		ServerAsk client = new ServerAsk("localhost",1888);
		client.start();
	}
}

class ServerAsk extends Thread{
	private String serverName;
	private int port;
	private Socket socket;
	public ServerAsk(String name,int port) {
		serverName = name;
		this.port = port;
	}
	public void run() {
		try {
			System.out.println("尝试连接主机：" + serverName + " ，端口号：" + port +"...");
			socket = new Socket(serverName,port);
			System.out.println("远程主机地址：" + socket.getRemoteSocketAddress());
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("服务器，我是客户机，你听得到吗");
			ReadThread readThread = new ReadThread(in);
			WriteThread writeThread = new WriteThread("客户机",out);
			readThread.start();
			writeThread.start();
		}catch(Exception e) {
			this.interrupt();
//			e.printStackTrace();
		}
	}
}