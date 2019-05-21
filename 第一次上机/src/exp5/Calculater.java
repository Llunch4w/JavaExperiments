//Calculater.java
package exp5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculater extends JFrame{
	private ShowWindow showResult = new ShowWindow();
	private ButtonWindow buttonGrid = new ButtonWindow();
	public Calculater(String s) {//初始布局
		super(s);
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH,showResult);
		add(BorderLayout.CENTER,buttonGrid);
		setSize(500,400); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		buttonGrid.bindText(showResult.textField);
	}
	public static void main(String[] args) {
		Calculater calulater = new Calculater("计算器");	
	}
}


class ShowWindow extends JPanel{
	public JTextField textField = new JTextField(40);
	public ShowWindow() {
		add(textField);
	}
}

class ButtonWindow extends JPanel{
	private ArrayList<JButton> numberButtons = new ArrayList<JButton>();
	private ArrayList<JButton> charButtons = new ArrayList<JButton>();
	private ArrayList<JButton> allButtons = new ArrayList<JButton>();
	private CalControl calMan = new CalControl();
	private JTextField textField;
	private void init_all_buttons() {
		for(int i = 2;i >= 0;i--) {
			for(int j = 1;j <= 3;j++) {
				allButtons.add(numberButtons.get(i*3+j));
			}
			allButtons.add(charButtons.get(2-i));
		}
		allButtons.add(numberButtons.get(0));
		for(int i = 3;i < 6;i++)
			allButtons.add(charButtons.get(i));
		for(int i = 0;i < 16;i++) {
			allButtons.get(i).addActionListener(new ActionListener(){//给按钮加监听
				public void actionPerformed(ActionEvent e) {
					String str = e.getActionCommand();
					if(str.equals("=")) {
						Double result = calMan.cal(textField.getText());
						textField.setText(result.toString());
					}
					else {	
						str = textField.getText() + str;
						textField.setText(str);
					}
				}
			});
		}
	}
	public ButtonWindow() {
		setSize(500,300);
		setLayout(new GridLayout(4,4));
		
		for(int i = 0;i < 10;i++) {
			numberButtons.add(new JButton(Integer.toString(i)));//数字按键		
		}
			
		String enum_charactor[] = {"/","*","-",".","=","+"};//符号按键
		for(String c:enum_charactor) {
			charButtons.add(new JButton(c));
		}
		init_all_buttons();
		for(int i = 0;i < 16;i++)
			add(allButtons.get(i));
	}
	public void bindText(JTextField text) {
		textField = text;
	}
}

class CalControl{
	private double func(double num1,double num2,String c) {
		if(c.equals("+"))
			return num1+num2;
		else if(c.equals("-"))
			return num1-num2;
		else if(c.equals("*"))
			return num1*num2;
		else
			return num1/num2;
	}
	public double cal(String s) {
		Stack<Double> doubleSta = new Stack<Double>();
//		Stack<Integer> integerSta = new Stack<Integer>();
		Stack<String> stringSta = new Stack<String>();
		String newS = "";
		ArrayList<Double> temp_doubles = new ArrayList<Double>();
//		ArrayList<Integer> temp_ints = new ArrayList<Integer>();
		for(int i = 0;i < s.length();i++) {//解析字符串
			System.out.println(s.charAt(i));
			
			if(Character.isDigit(s.charAt(i))) {
				int front = i;
				i++;
				while(i < s.length() && Character.isDigit(s.charAt(i)))
					i++;
				if(i < s.length() && s.substring(i,i+1).equals(".")) {
					int back = i+1;
					while(back < s.length() && Character.isDigit(s.charAt(back)))
						back++;
					int a = Integer.parseInt(s.substring(front, i));
					int b = Integer.parseInt(s.substring(i+1, back));
					double sum = a + (double)b/(Math.pow(10, back-i-1));
					temp_doubles.add(sum);
					newS += "#";
					newS += s.substring(back,back+1);
					i = back;
				}
				else {				
					int a = Integer.parseInt(s.substring(front, i));
					temp_doubles.add((double)a);
					newS += "#";
					if(i < s.length())
						newS += s.substring(i, i+1);
				}
			}
			else {
				System.out.println("not digit");
			}
		}
		System.out.println(newS);
		System.out.println(temp_doubles);
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("+", 0);
		map.put("-", 0);
		map.put("*", 1);
		map.put("/", 1);
		int cnt = 0;
		for(int i = 0;i < newS.length();i++) {//用堆栈进行逻辑计算
			if(!newS.substring(i,i+1).equals("#")){	
				if(stringSta.empty() || map.get(stringSta.peek()) < map.get(newS.substring(i,i+1)))
					stringSta.push(newS.substring(i, i+1));
				else {
					double num2 = doubleSta.peek();
					doubleSta.pop();
					double num1 = doubleSta.peek();
					doubleSta.pop();
					double res = func(num1,num2,stringSta.peek());
					System.out.println(res);
					doubleSta.push(res);
					stringSta.pop();
					stringSta.push(newS.substring(i,i+1));
				}
			}
			else {
				doubleSta.push(temp_doubles.get(cnt++));
			}
		}
		while(!stringSta.empty()) {
			double num2 = doubleSta.peek();
			doubleSta.pop();
			double num1 = doubleSta.peek();
			doubleSta.pop();
			double res = func(num1,num2,stringSta.peek());
			System.out.println(res);
			doubleSta.push(res);
			stringSta.pop();
		}
		return doubleSta.peek();
	}
	
}

