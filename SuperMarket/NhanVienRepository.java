package JP2.SuperMarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Connector {
    public final static String connectionString = "jdbc:mysql://localhost:3306/supermarket";
    public final static String user = "root";
    public final static String password = "";

    private static Connector instance;
    private Connection conn;
    private PreparedStatement statement;

    public Connector() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(connectionString,user,password);
    }
    public PreparedStatement getStatement(String sql) throws Exception{
        PreparedStatement statement = conn.prepareStatement(sql);
        return statement;
    }
    public static Connector getInstance() throws Exception{
        if (instance == null){
            instance = new Connector();
        }
        return instance;
    }
}
