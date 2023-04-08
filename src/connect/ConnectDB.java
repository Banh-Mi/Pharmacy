package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static ConnectDB instances;
    private Connection connection;

    public ConnectDB() throws Exception
    {
        String url="jdbc:sqlserver://localhost:1433;databaseName=QLThuoc;trustServerCertificate=true";
        try {
            connection = DriverManager.getConnection(url,"sa","sapassword");
            System.out.println("connected");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectDB getInstances() throws Exception {
        if (instances==null)
            instances = new ConnectDB();
        return instances;
    }
    
    public void close()
    {
        try {
            connection.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
