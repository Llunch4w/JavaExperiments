package exp7.main;

import java.util.*;

import exp7.exception.*;

public class ScanAndCount {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0,num;
		System.out.println("������������������999����(������������)");
		while(true) {		
			try {
				System.out.print("num:");
				num = scan.nextInt();
				check(num);
				if(num == 999)
					break;
				sum += num;
			}catch(NegativeException e) {
				System.out.println("error");
			}
		}
		System.out.println("���ս��:"+sum);
		
	}
	public static void check(int num) throws NegativeException {
		if(num < 0)
			throw new NegativeException();
	}
}
