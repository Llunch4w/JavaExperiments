package exp2;

import java.awt.Point;
import java.util.*;

public class Traingle {
	private Point points[] = new Point[3];
	public void setPoints() {
		Scanner scan = new Scanner(System.in);//用户输入数据
		for(int i = 1;i <= 3;i++) {
			System.out.println("please input the " + i + " point:");
			int x = scan.nextInt();
			int y = scan.nextInt();
			points[i-1] = new Point(x,y);
		}
	}
	public double calculate() {
		double x[] = new double[3];
		double y[] = new double[3];
		for(int i = 0;i < 3;i++) {
			x[i] = points[i].getX();//获取所有点的横坐标
			y[i] = points[i].getY();//获取所有点的纵坐标
		}
		//计算面积
		double S = (x[0]*y[1]+x[1]*y[2]+x[2]*y[0]-x[0]*y[2]-x[1]*y[0]-x[2]*y[1]);
		S = S/2.0;
		return S;
	}
	public static void main(String[] args) {
		Traingle traingle = new Traingle();
		traingle.setPoints();
		if(traingle.calculate() <= 0) {
			System.out.println("不构成三角形");
		}
		else
			System.out.println(traingle.calculate());
	}
}
