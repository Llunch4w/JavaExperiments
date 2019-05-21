package exp10;

import exp10.sql.*;


public class EmployeeTest {
	public static void main(String[] args) {
		CreateSql createSql = new CreateSql();
		System.out.println("创建表....");
		String collection_s[] = {"sno varchar(4)\n","name varchar(8)\n",
				"sex varchar(2)\n",	"salary float"};
		createSql.create("employee",collection_s);
		System.out.println("创建成功！");
		InsertSql insertSql = new InsertSql();
		System.out.println("插入基础数据....");
		insertSql.insert(new Employee("1001","张强","男",(float)672.3));
		insertSql.insert(new Employee("1004","李春","女",(float)842));
		insertSql.insert(new Employee("1007","王大山","男",(float)765));
		insertSql.insert(new Employee("1010","赵玉花","女",(float)690));
		System.out.println("目前数据表：");
		QuerySql querySql = new QuerySql();
		querySql.query();
		System.out.println("增加邱雪花：");
		insertSql.insert(new Employee("2017","邢雪花","女",(float)650));
		System.out.println("目前数据表：");
		querySql.query();
		UpdateSql updateSql = new UpdateSql();
		System.out.println("将工号为2017人的薪资改为900");
		updateSql.update("2017", 900);
		System.out.println("目前数据表：");
		querySql.query();
	}
}
