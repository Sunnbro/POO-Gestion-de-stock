package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection myconObj = null;
        Statement mystatObj = null;
        ResultSet myresObj = null;
        String query = "Select * From zidane.Produit";
        try {
            myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase", "zidane", "0123456789Z");
            mystatObj = myconObj.createStatement();
            myresObj = mystatObj.executeQuery(query);
            while (myresObj.next()) {
                String nom = myresObj.getString("NOM");
                String reference = myresObj.getString("REFERENCE");
                String specifications = myresObj.getString("SPECIFICATIONS");
                String categorie = myresObj.getString("CATEGORIE");
                String description = myresObj.getString("DESCRIPTION");
                int prix = myresObj.getInt("PRIX");
                System.out.println(nom+"\t   "+ reference+"\t   "+ specifications+"\t   "+ categorie+"\t   "+ description+"\t   "+ prix);                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}