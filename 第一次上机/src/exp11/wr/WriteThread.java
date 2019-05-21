package exp11.wr;

import java.io.*;
import java.util.Scanner;

public class WriteThread extends Thread{
	private DataOutputStream writer;
	private String hoster;
	public WriteThread(String name,DataOutputStream writer) {
		hoster = name;
		this.writer = writer;
	}
	public void run() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			try {
				writer.writeUTF(hoster + ":" + scan.nextLine());
				writer.flush();
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}
	}
}
