package exp10.sql;

import java.sql.SQLException;
import java.util.*;

public class CreateSql extends MysqlDriver{
	public void create(String table_name,String[] propers) {
		try {
			connect("exp10");
			String sql = "create table " + table_name + " ";
			String tmp = "(";
			for(String s:propers) {
				tmp += s + ",";
			}
			sql += tmp.substring(0, tmp.length()-1) + ")";
//			System.out.println(sql);
			stmt.execute(sql);
		}catch(SQLException se) {
			System.out.println("表已创建...");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 完成后关闭
	          close();
		}
	}
}
