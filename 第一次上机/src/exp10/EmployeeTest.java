package exp10;

import exp10.sql.*;


public class EmployeeTest {
	public static void main(String[] args) {
		CreateSql createSql = new CreateSql();
		System.out.println("������....");
		String collection_s[] = {"sno varchar(4)\n","name varchar(8)\n",
				"sex varchar(2)\n",	"salary float"};
		createSql.create("employee",collection_s);
		System.out.println("�����ɹ���");
		InsertSql insertSql = new InsertSql();
		System.out.println("�����������....");
		insertSql.insert(new Employee("1001","��ǿ","��",(float)672.3));
		insertSql.insert(new Employee("1004","�","Ů",(float)842));
		insertSql.insert(new Employee("1007","����ɽ","��",(float)765));
		insertSql.insert(new Employee("1010","����","Ů",(float)690));
		System.out.println("Ŀǰ���ݱ�");
		QuerySql querySql = new QuerySql();
		querySql.query();
		System.out.println("������ѩ����");
		insertSql.insert(new Employee("2017","��ѩ��","Ů",(float)650));
		System.out.println("Ŀǰ���ݱ�");
		querySql.query();
		UpdateSql updateSql = new UpdateSql();
		System.out.println("������Ϊ2017�˵�н�ʸ�Ϊ900");
		updateSql.update("2017", 900);
		System.out.println("Ŀǰ���ݱ�");
		querySql.query();
	}
}
