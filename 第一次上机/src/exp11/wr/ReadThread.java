package exp11.wr;

import java.io.*;

public class ReadThread extends Thread{
	private DataInputStream reader;
	public ReadThread(DataInputStream reader) {
		this.reader = reader;
	}
	public void run() {
		while(true) {
			try {
				System.out.println(reader.readUTF());
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}
	}
}
