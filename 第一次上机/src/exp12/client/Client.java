package exp12.client;

import java.io.*;
import java.net.*;
import java.util.*;

import exp12.Ticket;

public class Client {
	private String serverName;
	private int port;
	private Socket socket;
	private ReadThread reader;
	private WriteThread writer;
	private ArrayList<Ticket>  tickets = new ArrayList<Ticket>();
	public Client(String server,int port) {
		serverName = server;
		this.port = port;
		try {		
			System.out.println("�������ӷ�������ַ��" + serverName + ":" + port);
			socket = new Socket(serverName,port);
			System.out.println("���ӳɹ�,����������Ʊ��������ʵ�ֹ�Ʊ");
			reader = new ReadThread(new ObjectInputStream(socket.getInputStream()),this);
			writer = new WriteThread(new DataOutputStream(socket.getOutputStream()));
			reader.start();
			writer.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void getTicket(Object ticket) {
		tickets.add((Ticket)ticket);
	}
	public void viewTickets() {
		for(Ticket ticket:tickets) {
			ticket.show();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client("localhost",9999);
	}
	
}

class ReadThread extends Thread{
	private ObjectInputStream reader;
	private Client client;
	public ReadThread(ObjectInputStream reader,Client client) {
		this.reader = reader;
		this.client = client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void run() {
		while(true) {
			try {
				if(this.isInterrupted())
					break;
				Object tmp = reader.readObject();
				if(tmp instanceof Ticket) {
					client.getTicket(tmp);
					System.out.println("��Ʊ�ɹ�");
					Ticket ticket = (Ticket)tmp;
					ticket.show();
				}
				else if(tmp instanceof String) {
					System.out.println("��Ʊʧ�ܣ�");
					System.out.println(tmp);
				}
				else {
					System.out.println("What is the wrong");
				}
			}catch(Exception e) {
				e.printStackTrace();
				this.interrupt();
			}
		}
	}
}

class WriteThread extends Thread{
	private DataOutputStream writer;
	public WriteThread(DataOutputStream writer) {
		this.writer = writer;
	}
	public void run() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			try {
				writer.writeUTF(scan.nextLine());
				writer.flush();
			} catch (IOException e) {
				this.interrupt();
			}
		}
	}
}