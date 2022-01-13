package s_DesignPatterns.structural.proxy.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Supplier;

public class LazyConnectionProxy extends AbstractConnectionProxy {

	private Supplier<Connection> supplier;
	private Connection target = null;

	public LazyConnectionProxy(Supplier<Connection> supplier) {
		//只是返回supplier接口，并没有真正运行
		/**
		 * () -> {
		 * 			Connection conn = DriverManager.getConnection(url, username, password);
		 * 			System.out.println("Open connection: " + conn);
		 * 			return conn;}
		 */
		this.supplier = supplier;
	}

	// 覆写close方法：只有target不为null时才需要关闭:
	@Override
	public void close() throws SQLException {
		if (target != null) {
			System.out.println("Close connection: " + target);
			super.close();
		}
	}

	/**
	 * 调用任何类似prepareStatement()方法时，触发getRealConnection()调用），
	 * 才会真正打开实际的JDBC Connection。
	 */
	@Override
	protected Connection getRealConnection() {
		if (target == null) {
			target = supplier.get();
		}
		return target;
	}
}
/**
 * 如果调用者没有执行任何SQL语句，那么target字段始终为null。
 * 只有第一次执行SQL语句时（即调用任何类似prepareStatement()方法时，
 * 触发getRealConnection()调用），才会真正打开实际的JDBC Connection。
 */