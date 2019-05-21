package exp10;

public class Employee {
	private String no;
	private String name;
	private String sex;
	private float salary;
	public Employee(String no,String name,String sex,float salary) {
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.salary = salary;
	}
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public float getSalary() {
		return salary;
	}
}
