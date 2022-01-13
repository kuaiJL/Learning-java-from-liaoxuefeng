package s_DesignPatterns.structural.proxy;

import s_DesignPatterns.structural.proxy.pool.LazyDataSource;
import s_DesignPatterns.structural.proxy.pool.PooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;



/**
 * App entry for Maven project.
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws Exception {
		DataSource lazyDataSource = new LazyDataSource(jdbcUrl, jdbcUsername, jdbcPassword);
		System.out.println("get lazy connection...");
		try (Connection conn1 = lazyDataSource.getConnection()) {
			// 并没有实际打开真正的Connection，只返回了一个supplier的接口，此接口返回真正的connections,
			// 但是并没有执行supplier.get();
			//conn2.prepareStatement()=>return getRealConnection(),才真正执行了supplier.get();
			System.out.println("如果打开真正的connection，会打印这句话：“Open connection: com.mysql.jdbc.JDBC4Connection@7a36aefa”");
		}
		System.out.println("get lazy connection...");
		try (Connection conn2 = lazyDataSource.getConnection()) {
			try (PreparedStatement ps = conn2.prepareStatement("SELECT * FROM students")) { // 打开了真正的Connection
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						System.out.println(rs.getString("name"));
					}
				}
			}
		}
		DataSource pooledDataSource = new PooledDataSource(jdbcUrl, jdbcUsername, jdbcPassword);
		try (Connection conn = pooledDataSource.getConnection()) {
		}
		try (Connection conn = pooledDataSource.getConnection()) {
			// 获取到的是同一个Connection
		}
		try (Connection conn = pooledDataSource.getConnection()) {
			// 获取到的是同一个Connection
		}
	}

	static final String jdbcUrl = "jdbc:mysql://localhost/test?useSSL=false&characterEncoding=utf8";
	static final String jdbcUsername = "root";
	static final String jdbcPassword = "970311KL";
}
