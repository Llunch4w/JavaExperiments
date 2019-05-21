package exp12.server;

import java.io.*;
import java.net.*;
import java.util.*;

import exp12.Ticket;

public class Server extends Thread{
	HashSet<Ticket> tickets = new HashSet<Ticket>();
	private ServerSocket serverSocket;
	private Socket socket;
	int port;
	private ReadThread reader;
	private WriteMan writer;
	int remained = 100;
	
	public Server(int port) {
		this.port = port;
	}
	
	public void run() {
		try {
			init();
			serverSocket = new ServerSocket(port);
			System.out.println("正在等待连接");
			socket = serverSocket.accept();
			System.out.println("连接成功");
			DataInputStream in = new DataInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			reader = new ReadThread(in,this);
			writer = new WriteMan(out);
			reader.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init() {
		for(int i = 1;i <= remained;i++) {
			tickets.add(new Ticket(i,1200.0,"长沙","长春"));
		}
	}
	
	public void process(String name) {
		if(remained <= 0) {
			writer.write("已无余票");
		}
		else {
			Iterator<Ticket> it = tickets.iterator();
			if(it.hasNext()) {
				Ticket ticket = it.next();
				ticket.setCustomer(name);
				writer.write(ticket);
				tickets.remove(ticket);
				remained--;
			}
			else {
				System.out.println("error");
			}
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server(9999);
		server.start();
	}
}

class ReadThread extends Thread{
	private DataInputStream reader;
	private Server server;
	public ReadThread(DataInputStream reader,Server server) {
		this.reader = reader;
		this.server = server;
	}
	public void setServer(Server server) {
		this.server = server;
	}
	public void run() {
		while(true) {
			try {
				if(this.isInterrupted())
					break;
				String s = reader.readUTF();
				System.out.println(s);
				server.process(s);
			}catch(Exception e) {
//				e.printStackTrace();
				this.interrupt();
			}
		}
	}
}

class WriteMan{
	private ObjectOutputStream writer;
	public WriteMan(ObjectOutputStream writer) {
		this.writer = writer;
	}
	public void write(Object obj) {
		try {
			writer.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
