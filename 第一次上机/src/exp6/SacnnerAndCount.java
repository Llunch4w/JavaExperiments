package exp6;

import java.util.*;

public class SacnnerAndCount {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0,num;
		System.out.println("������������������999����");
		while(true) {		
			try {
				System.out.print("num:");
				num = scan.nextInt();
				if(num == 999)
					break;
				sum += num;
			}catch(InputMismatchException e) {
				System.out.println("error");
				scan.next();
			}
		}
		System.out.println("���ս��:"+sum);
	}
}
