package exp2;

import java.awt.Point;
import java.util.Scanner;
import java.util.*;
// 

public class Traingle {
//	private ArrayList<Point> points = new ArrayList<Point>();
	private Point points[] = new Point[3];
	public void setPoints() {
		Scanner scan = new Scanner(System.in);
		System.out.println("please input the points:");
		for(int i = 0;i < 3;i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			points[i] = new Point(x,y);
		}
	}
	public double calculate() {
		double x[] = new double[3];
		double y[] = new double[3];
		for(int i = 0;i < 3;i++) {
			x[i] = points[i].getX();
			y[i] = points[i].getY();
		}
		double S = (x[0]*y[1]+x[1]*y[2]+x[2]*y[0]-x[0]*y[2]-x[1]*y[0]-x[2]*y[1]);
		S = S/2.0;
		return S;
	}
	public static void main(String[] args) {
		Traingle traingle = new Traingle();
		traingle.setPoints();
		System.out.println(traingle.calculate());
	}
}
