package exp8;

public class Ticket implements Runnable{
	private int remainTickets = 100;
	public Ticket(int remainTickets) {
		this.remainTickets = remainTickets;
	}
	public void run() {
		while(remainTickets > 0) {	
			synchronized(this) {
				if(remainTickets > 0) {
					try {
						Thread.sleep(20);
					}catch(Exception e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+"_________"+remainTickets--);
					}
			}
		}
	}
	public static void main(String[] args) {
		Ticket ticket = new Ticket(100);
		for(Integer i = 1;i <= 5;i++) {
			new Thread(ticket,i.toString()).start();
		}
	}
}
