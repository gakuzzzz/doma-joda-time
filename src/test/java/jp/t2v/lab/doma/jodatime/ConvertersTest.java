package jp.t2v.lab.doma.jodatime;


import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.seasar.doma.jdbc.tx.LocalTransaction;

public class ConvertersTest {

	private final TestEntityDao dao = new TestEntityDaoImpl();
	
	@Before
	public void setUp() throws SQLException {
		final Connection conn = DomaConfig.getOriginalDataSource().getConnection();
		try {
			final Statement st = conn.createStatement();
			try {
				st.execute("create table test(date_time Timestamp, local_date Date, local_time Time);");
				st.execute("insert into test (date_time, local_date, local_time) values ('2012-12-07 12:00:00', '2012-12-07', '12:00:00')");
			} finally {
				st.close();
			}
		} finally {
			conn.close();
		}
	}
	
	@After
	public void tearDown() throws SQLException {
		final Connection conn = DomaConfig.getOriginalDataSource().getConnection();
		try {
			final Statement st = conn.createStatement();
			try {
				st.execute("drop table test;");
			} finally {
				st.close();
			}
		} finally {
			conn.close();
		}
	}
	
	@Test
	public void select() {
        final LocalTransaction tx = DomaConfig.getLocalTransaction();
        try {
            tx.begin();
			final List<TestEntity> all = dao.findAll();
			assertEquals(Arrays.asList(new TestEntity(new DateTime(2012, 12, 7, 12, 0, 0), new LocalDate(2012, 12, 7), new LocalTime(12, 0, 0))), all);
        } finally {
        	tx.rollback();
        }
	}

	@Test
	public void insert() {
        final LocalTransaction tx = DomaConfig.getLocalTransaction();
        try {
            tx.begin();
            final TestEntity entity = new TestEntity(new DateTime(2012, 12, 8, 12, 0, 0), new LocalDate(2012, 12, 8), new LocalTime(12, 0, 0));
            dao.insert(entity);
			final List<TestEntity> all = dao.findAll();
			assertEquals(2, all.size());
        } finally {
        	tx.rollback();
        }
	}
}
