package ru.maxima.util;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * 24.08.2021
 * 33. Simple Program with JDBC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class OncePerQueryDataSource implements DataSource {
    private String user;
    private String password;
    private String url;

    public OncePerQueryDataSource(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }

    @Override
    public Connection getConnection() throws SQLException {
        // при каждом вызове getConnection я создаю новое подключение к базе данных
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        throw new NotImplementedException();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new NotImplementedException();
    }
}
