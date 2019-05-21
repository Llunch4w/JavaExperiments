package exp10.sql;

import java.sql.SQLException;

import exp10.Employee;

public class UpdateSql extends MysqlDriver{
	public void update(String id,float sal) {
		try {
			connect("exp10");
			String condition = String.format("where sno=\"%s\"", 
					id);
			String change = String.format("set salary=%.2f ",sal);
			String sql = "update employee " + change + condition;
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
