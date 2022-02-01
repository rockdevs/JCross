package connection.connector.abstracts;

import java.sql.Connection;
import java.sql.SQLException;

public interface CrossConnector {

    Connection connect();

    void disconnect() throws SQLException;
}
