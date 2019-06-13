package per.sun.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	private static final String database="legend";
	
	public static Connection getConnection() {
		
		String driver = "com.mysql.jdbc.Driver";
		String root = "root";
		String pass = "sunyu";
		String url = "jdbc:mysql://localhost:3306/"+database+"?useUnicode=true&characterEncoding=UTF-8";

		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection=null;
		try {
			connection = DriverManager.getConnection(url, root, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	/*
	 * public static Connection getConnection() {
	 * 
	 * String driver="oracle.jdbc.driver.OracleDriver"; try { try {
	 * Class.forName(driver).newInstance();//注册一个驱动
	 * System.out.println("成功加载oracle驱动程序"); } catch (InstantiationException |
	 * IllegalAccessException e) { e.printStackTrace(); } } catch
	 * (ClassNotFoundException e) { e.printStackTrace();
	 * System.out.println("加载oracle驱动程序失败"); }
	 * 
	 * String url="jdbc:oracle:thin:@127.0.0.1:1521:myoracle"; String
	 * user="plat_manager"; String pass="123456789"; Connection connection=null; try
	 * { connection=DriverManager.getConnection(url,user,pass);
	 * System.out.println("已获取连接对象"); } catch (SQLException e) {
	 * e.printStackTrace(); System.out.println("获取连接对象失败"); } return connection;
	 * 
	 * }
	 */
	public static void close(Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("连接对象关闭失败");
		}
	}

	public static void close(PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("语句传输对象关闭失败");
		}
	}

	public static void close(ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			System.out.println("结果集对象关闭失败");
		}
	}
}
