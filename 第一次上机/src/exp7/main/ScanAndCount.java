package exp7.main;

import java.util.*;

import exp7.exception.*;

public class ScanAndCount {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0,num;
		System.out.println("请输入若干整数，以999结束(负数将被忽略)");
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
		System.out.println("最终结果:"+sum);
		
	}
	public static void check(int num) throws NegativeException {
		if(num < 0)
			throw new NegativeException();
	}
}
