package TEST;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        String rutaConexion = "jdbc:mysql://localhost:3306/test_jdbc?useSSL=false&useTimeZone=true&serverTimeZone=UTC$allowPublicKeyRetrieval=true";

        try {
            Connection conexion = DriverManager.getConnection(rutaConexion, "root", "gi18052930");
            Statement instruccion = conexion.createStatement();
            String sentenciaSql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sentenciaSql);

            while(resultado.next()){
                System.out.print("ID persona: " +resultado.getInt("id_persona"));
                System.out.print(" Nombre: " + resultado.getString("Nombre"));
                System.out.print(" Apellido: " + resultado.getString("Apellido"));
                System.out.print(" Email: " + resultado.getString("Email"));
                System.out.print( "Telefono: " + resultado.getString("Telefono"));
                System.out.println("");
            }

            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
}
