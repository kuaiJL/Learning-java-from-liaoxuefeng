package s_DesignPatterns.structural.proxy.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Queue;

public class PooledConnectionProxy extends AbstractConnectionProxy {
	// 实际的Connection:
	Connection target;
	// 空闲队列: 并不是PooledConnectionProxy独有的，而是引用PooledDataSource.idleQueue
	Queue<PooledConnectionProxy> idleQueue;

	public PooledConnectionProxy(Queue<PooledConnectionProxy> idleQueue, Connection target) {
		this.idleQueue = idleQueue;
		this.target = target;
	}

	@Override
	public void close() throws SQLException {
		System.out.println("Fake close and released to idle queue for future reuse: " + target);
		idleQueue.offer(this);
	}

	@Override
	protected Connection getRealConnection() {
		return target;
	}
}
