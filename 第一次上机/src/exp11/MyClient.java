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
			System.out.println("��������������" + serverName + " ���˿ںţ�" + port +"...");
			socket = new Socket(serverName,port);
			System.out.println("Զ��������ַ��" + socket.getRemoteSocketAddress());
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("�����������ǿͻ����������õ���");
			ReadThread readThread = new ReadThread(in);
			WriteThread writeThread = new WriteThread("�ͻ���",out);
			readThread.start();
			writeThread.start();
		}catch(Exception e) {
			this.interrupt();
//			e.printStackTrace();
		}
	}
}