package exp10.sql;

import java.sql.ResultSet;

import exp10.Employee;

public class QuerySql extends MysqlDriver{
	public void query() {
		try {
			connect("exp10");
			String sql = "select * from employee";
//			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("����|����|�Ա�|н��");
			while(rs.next()){
				// ͨ���ֶμ���
				System.out.println(String.format("%s|%s|%s|%.2f",
						rs.getString("sno"),
						rs.getString("name"),rs.getString("sex"),
						rs.getFloat("salary")));

			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
}
