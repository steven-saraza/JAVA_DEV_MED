package LaboratoryJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDb {


    //Metodo de tipo Connection retorna un objeto tipo Connection (Es un objeto de java.sql.Connection el cual es un driver)
    public Connection getConnectionDB(){
        Connection connectionBD = null;

        try {
            //Se genera la cadena de conexión del driver
            //Dentro de la URL se usa la dependencia del maria deb (jdbc:mariadb)
            connectionBD = DriverManager.getConnection("jdbc:mariadb://localhost:3305/JavaPDB", "example", "user-password");

            //Se valida que la cadena de conexión no venga nula
            // if(connectionBD != null){
            //     System.out.println("Conexion exitosa");
            // }
        } catch (Exception e) {
            System.out.println(e);
        }

        //Se retorna la cadena
        return connectionBD;
    }
}
