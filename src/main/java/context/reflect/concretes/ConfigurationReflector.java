package context.reflect.concretes;

import connection.connector.abstracts.CrossConnector;
import connection.enums.JDBCType;

import java.util.Map;

public class ConfigurationReflector {

    private String mainPath;
    private CrossConnector connector;
    public ConfigurationReflector(String mainPath){}

    {

    }

    private void getConnector(JDBCType jdbcType, Map<String,String> properties){
        connector = jdbcType.getConnection(properties.get("url"),properties.get("user"),properties.get("password"));
    }

    
}
