package connection.connector.concretes;

import connection.connector.abstracts.AbstractConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class PostgreConnector extends AbstractConnector {

    private Connection connection = null;

    private static final String template  = "jdbc:postgresql://";

    public PostgreConnector(String dbName, String user, String password) {
        super(PostgreConnector.template+dbName,user,password);
    }

    @Override
    public Connection connect() {
        try {
            connection = DriverManager.getConnection(super.getUrl(),super.getUser(),super.getPassword());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    @Override
    public void disconnect() throws SQLException {
        if(connection!=null) connection.close();
    }
}
