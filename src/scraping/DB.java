
package scraping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DB {
 
	public Connection conn = null;
 
	public DB() throws InstantiationException, IllegalAccessException {
		try {
                        // returns class object for mysql driver, creates new object
			Class.forName("com.mysql.jdbc.Driver").newInstance();
                        //url of mysql db that needs to be passed
			String url = "jdbc:mysql://localhost:3306/dummy";
                        //create connection
			conn = DriverManager.getConnection(url, "root", "__Kb@11952__");
			System.out.println("conn built");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
 
	public ResultSet runSql(String sql) throws SQLException {
		Statement sta = conn.createStatement();
		return sta.executeQuery(sql);
	}
 
	public boolean runSql2(String sql) throws SQLException {
		Statement sta = conn.createStatement(); // creates statement object that contains sql quey
		return sta.execute(sql);
	}
 
	@Override
	protected void finalize() throws Throwable {
		if (conn != null || !conn.isClosed()) {
			conn.close();
		}
	}

    
}