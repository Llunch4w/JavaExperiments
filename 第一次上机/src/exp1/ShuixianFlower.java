package exp1;
// 67 216
import java.util.*;

public class ShuixianFlower {
	private static int pow3(int x) {
		return x*x*x;
	}
	
	private static boolean isFlower(int x) {
		int sum = 0,copy_x = x;
		while(x != 0) {
			sum += pow3(x%10);
			x /= 10;
		}
		if(sum == copy_x)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 100;i <= 1000;i++) {
			if(isFlower(i) == true)
				array.add(i);
		}
		for(Integer i:array)
			System.out.println(i);
	}
}
