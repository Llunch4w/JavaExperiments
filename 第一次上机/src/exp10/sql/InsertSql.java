package exp10.sql;

import java.sql.SQLException;

import exp10.Employee;

public class InsertSql extends MysqlDriver{
	public void insert(Employee employee) {
		try {
			connect("exp10");
			String sql = "insert into employee ";
			String s = String.format("values(\"%s\",\"%s\",\"%s\",%.2f)",
					employee.getNo(),employee.getName(),
					employee.getSex(),employee.getSalary());
			sql += s;
//			System.out.println(sql);
			stmt.execute(sql);
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 完成后关闭
	          close();
		}
	}
}
