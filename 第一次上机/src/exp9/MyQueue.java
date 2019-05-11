package exp9;

import java.util.*;

public class MyQueue<T> {
	private List<T> list = new ArrayList<T>();
	public T get() {		
		T t = list.get(0);
		list.remove(0);
		return t;
	}
	public void put(T t) {
		list.add(t);
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MyQueue<Integer> q = new MyQueue<Integer>(); 
		while(true) {
			System.out.println("��ѡ��");
			System.out.println("1.����");
			System.out.println("2.���");
			System.out.println("3.�Ƿ�Ϊ��");
			int choose = scan.nextInt();
			if(choose==1) {
				System.out.println(q.get() + "����");
			}
			else if(choose == 2) {
				System.out.print("���Ԫ��:");
				q.put(scan.nextInt());
			}
			else if(choose == 3) {
				System.out.println("�Ƿ�Ϊ��:" + q.isEmpty());
			}
			else{
				System.out.println("���벻��Ҫ��");
			}
		}
	}
}
