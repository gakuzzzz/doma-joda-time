package jp.t2v.lab.doma.jodatime;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.SimpleDataSource;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.seasar.doma.jdbc.tx.KeepAliveLocalTransaction;
import org.seasar.doma.jdbc.tx.LocalTransaction;
import org.seasar.doma.jdbc.tx.LocalTransactionalDataSource;

public class DomaConfig extends DomaAbstractConfig {

    private static final DataSource originalDataSource = createDataSource();

    private static final LocalTransactionalDataSource localTxDataSource = createLocalTxDataSource();

    private static final Dialect dialect = new H2Dialect();

    @Override
    public DataSource getDataSource() {
        return localTxDataSource;
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    protected static DataSource createDataSource() {
        SimpleDataSource dataSource = new SimpleDataSource();
        dataSource.setUrl("jdbc:h2:mem:tutorial;DB_CLOSE_DELAY=-1");
        dataSource.setUser("sa");
        return dataSource;
    }

    protected static LocalTransactionalDataSource createLocalTxDataSource() {
        return new LocalTransactionalDataSource(originalDataSource);
    }

    public static LocalTransaction getLocalTransaction() {
        return localTxDataSource.getLocalTransaction(defaultJdbcLogger);
    }

    public static KeepAliveLocalTransaction getKeepAliveLocalTransaction() {
        return localTxDataSource
                .getKeepAliveLocalTransaction(defaultJdbcLogger);
    }

    public static DataSource getOriginalDataSource() {
        return originalDataSource;
    }
}
