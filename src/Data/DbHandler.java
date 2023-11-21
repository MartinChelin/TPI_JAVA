package Data;
import java.sql.*;

public class DbHandler {
	private static DbHandler instancia;
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="127.0.0.1";
	private String port="3306";
	private String user="admin";
	private String password="admin12345!";
	private String db="javamarket";
	private int conectados=0;
	private Connection conn=null;
	
				//PRUEBA DE CONEXION
	public static void main(String[] args) {
        DbHandler dbHandler = DbHandler.getInstancia();
        Connection conn = dbHandler.getConn();

        if (conn != null) {
            System.out.println("Conexión exitosa");
            dbHandler.releaseConn();
        } else {
            System.err.println("Error de conexión. Verifica las credenciales.");
        }
    }
	
	public DbHandler() {
		try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
			}		
	}
	
	public static DbHandler getInstancia() {
		if (instancia==null) {
			instancia=new DbHandler(); 
			//Patron Singleton
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
			if (conn==null || conn.isClosed()) {
				conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);
				conectados=0;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}