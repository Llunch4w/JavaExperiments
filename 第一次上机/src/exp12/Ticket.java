package exp12;

import java.io.Serializable;

public class Ticket implements Serializable{
	private static final long serialVersionUID = 1L;//实现Serializable必要一步
	private int id;
	private double price;
	private String customer;
	private String src,des;
	public Ticket(int id,double price,String src,String des) {
		this.id = id;
		this.price = price;
		this.src = src;
		this.des = des;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setCustomer(String name) {
		customer = name;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getId() {
		return id;
	}
	public double getPrice() {
		return price;
	}
	public String getCustomer() {
		return customer;
	}
	public String getSrc() {
		return src;
	}
	public String getDes() {
		return des;
	}
	public void show() {
		System.out.println("---------------------");
		System.out.println("Ticket ID: " + id);
		System.out.println("Ticket Price: " + price);
		System.out.println("Ticket source: " + src);
		System.out.println("Ticket destination: " + des);
		System.out.println("The passenger: " + customer);
		System.out.println("---------------------");
	}
}