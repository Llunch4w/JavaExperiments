package exp4;

import java.util.*;


public class ComputeTime {
	public static void main(String[] args) {
		String type;
		int params[] = new int[3];
		Scanner scan = new Scanner(System.in);
		System.out.println("please input the type of transport tool:");
		type = scan.next();
		System.out.println("please input the A,B,C");
		for(int i = 0;i < 3;i++) {
			params[i] = scan.nextInt();
		}
		try {
			@SuppressWarnings("deprecation")
			String str = "exp4." + type;//一定得是完整包名
			Common transport = (Common)Class.forName(str).newInstance();
			System.out.println(1000/transport.calculateV(params[0],params[1],params[2]));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("没有此类");
		}
		
//		try {
//			@SuppressWarnings("deprecation")
//			String str = "exp4." + args[0];//一定得是完整包名
//			System.out.println(str);
//			Common transport = (Common)Class.forName(str).newInstance();
//			int A = Integer.parseInt(args[1]);
//			int B = Integer.parseInt(args[2]);
//			int C = Integer.parseInt(args[3]);
//			System.out.println(1000/transport.calculateV(A,B,C));
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("没有此类");
//		}
		
	}
}
