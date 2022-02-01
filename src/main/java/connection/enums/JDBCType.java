package connection.enums;

import connection.connector.abstracts.CrossConnector;
import connection.connector.concretes.MySqlConnector;
import connection.connector.concretes.OracleConnector;
import connection.connector.concretes.PostgreConnector;

import java.sql.Connection;

public enum JDBCType {
    ORACLE{
        @Override
        public CrossConnector getConnection(String... args) {
            connector = new OracleConnector(args[0],args[1],args[2]);
            return connector;
        }
    },
    PostgreSQL{
        @Override
        public CrossConnector getConnection(String... args) {
            connector = new PostgreConnector(args[0],args[1],args[2]);
            return connector;
        }
    },
    MySQL{
        @Override
        public CrossConnector getConnection(String... args) {
            connector = new MySqlConnector(args[0],args[1],args[2]);
            return connector;
        }
    };
    CrossConnector connector;


    public abstract CrossConnector getConnection(String... args);

    JDBCType(){}

}
