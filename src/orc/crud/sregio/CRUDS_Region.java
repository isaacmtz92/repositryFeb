package orc.crud.sregio;
// CRUD CREATE READ UPDTATE DELATE

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUDS_Region 
{
	static 	Connection connection;
	static String driver ="oracle.jdbc.driver.OracleDriver";
	static String URL ="jdbc:oracle:thin:@localhost:1521:orcl";
	
	public static void connectionOracleDataBase()throws IOException, SQLException{
		try {
			Class.forName(driver).newInstance();
			System.out.println("CARGO DRIVER CORRECTAMENTE");
		} catch(Exception e) {
			System.out.println("Exception:" + e.getMessage());
			}
		
		try {
			connection = DriverManager.getConnection(URL,"SYSTEM","Gato1004");
			System.out.println("conexion exitosa a oracle database");
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}
	
	public static void agregarS_Region(int id, String name) throws IOException,SQLException{
		try {
			connectionOracleDataBase();
			//CONSULTA
			String sql = "INSERT INTO S_REGION (ID,NAME) VALUES (?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.executeQuery();
			ps.close();
			connection.close();
			System.out.println("INSERTO:" + id + "," + name);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}
	
	public static void main(String[] args) throws IOException, SQLException{
		agregarS_Region(15, "COAHUILA");
		//actualizarS_Region("Coahuila", 15);
		//eliminarS_Region(15);
		//consultaIndividualS_Region(2);
		//consultaGeneralS_Region();
		//invocaProcedimientoAlmacenado(17, "TIJUANA 2");
	}

}
