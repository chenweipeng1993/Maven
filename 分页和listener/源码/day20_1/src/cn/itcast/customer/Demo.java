package cn.itcast.customer;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.itcast.customer.utils.DataSourceUtils;
import cn.itcast.customer.utils.IdUtils;

public class Demo {

	@Test
	public void add() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		for (int i = 0; i < 100; i++) {

			runner.update("insert into customer(id) values(?)",
					IdUtils.getUUID());
		}
	}
}
