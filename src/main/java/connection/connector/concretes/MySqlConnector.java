package connection.connector.concretes;

import connection.connector.abstracts.AbstractConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class MySqlConnector extends AbstractConnector {
    private Connection connection = null;

    private static final String template  = "jdbc:postgresql://";

    public MySqlConnector(String url,String user,String password) {
        super(MySqlConnector.template + url, user, password);
    }

    @Override
    public Connection connect() {
        return null;
    }

    @Override
    public void disconnect() throws SQLException {

    }
}
