package exp6;

import java.util.*;

public class SacnnerAndCount {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0,num;
		System.out.println("请输入若干整数，以999结束");
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
		System.out.println("最终结果:"+sum);
	}
}
