package MessManagements;
import java.sql.*;


public class Conn {
    Connection c;

    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c =DriverManager.getConnection("jdbc:mysql:///MessManagement","root","rehman01@");
            s=c.createStatement();



        }catch(Exception e){
            e.printStackTrace();
        }


    }

}
