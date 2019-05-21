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
			System.out.println("�ȴ�Զ�����ӣ��˿ں�Ϊ��" + serverSocket.getLocalPort() + "...");
			socket = serverSocket.accept();
//			System.out.println("���ӳɹ�");
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			System.out.println("�ͻ�����" + in.readUTF());
			out.writeUTF("�����������Ƿ��������������ˣ����ǿ��������ˣ�");
//			sleep(3000);
			ReadThread readThread = new ReadThread(in);
			WriteThread writeThread = new WriteThread("������",out);
			readThread.start();
			writeThread.start();
		}catch(Exception e) {
			this.interrupt();
//			e.printStackTrace();
		}
	}
}