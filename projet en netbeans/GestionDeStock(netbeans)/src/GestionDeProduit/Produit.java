package GestionDeProduit;
import java.util.*;
import java.sql.*;
import DataBase.*;
public class Produit { static Scanner sc = new Scanner(System.in);

private String Specificprod;
private String Nomprod;
private String refprod;
private String refprodR;
private String catprod;
private String Specprod;
private String descprod;
private int prixprod;
private int NbrVent;
public static ArrayList<Produit> produits = new ArrayList<>();



//-------------------------------------------------------------------
public String getNomprod(){return Nomprod;}
public String getRefprod(){return refprod;}
public String getRefprodR(){return refprodR;}
public String getSpecprod(){return Specprod;}
public String getCatprod(){return catprod;}
public String getDescprod(){return descprod;}
public float getPrixprod(){return prixprod;}
public int getNbrVent(){return NbrVent;}
public void setSpecificprod(String Specificprod) {this.Specificprod=Specificprod;}
public void setNomprod(String Nomprod){this.Nomprod=Nomprod;}
public void setrefprod(String refprod){this.refprod=refprod;}
public void setrefprodR(String refprodR){this.refprodR=refprodR;}
public void setcatprod(String catprod){this.catprod=catprod;}
public void setdescprod(String descprod){this.descprod=descprod;}
public void Specprod(String Specprod){this.Specprod=Specprod;}
public void setPrixprod(int prixprod){this.prixprod=prixprod;}
public void setNbrVent(int NbrVent){this.NbrVent=NbrVent;}
//-----------------------------------------------------------------------

public static Comparator<Produit> comparerCat;

static {
    comparerCat = new Comparator<Produit>() {

        @Override
        public int compare(Produit c1, Produit c2) {
            // TODO Auto-generated method stub
            return (c1.getCatprod().toLowerCase().compareTo(c2.getCatprod().toLowerCase()));
        }

    };
}

public String toString(){
    return " le nom du produit : " + this.Nomprod + ", La ref " + this.refprod + ", la catego" + this.catprod+ ", la descrip" + this.descprod+ ", le prisco" + this.prixprod;
}
public void AfficherValeurprod()
{
    System.out.println("Le nom du produit   : " + Nomprod);
    System.out.println("La reference du produit : " + refprod );
    System.out.println("Les specifications de ce produit : " + Specprod );
    System.out.println("Le categorie de ce produit     : " + catprod);
    System.out.println("La description de ce produit    : " + descprod );
    System.out.println("Le prix de ce produit     : " + prixprod + " Dinars Algerien" );
     }


public void saisirValeur()
{     /* les produits mobiles -- les prod electroniques === electromenager === informatiques === les kits solaires*/

    System.out.println("Saisir le Nom du produit: ");
    Nomprod = sc.nextLine();
    System.out.println("Saisir la reference du produit: ");
    refprod = sc.nextLine();
    System.out.println("Saisir les specifications du produit: ");
    Specprod = sc.nextLine();
    
    try{
        System.out.println("Saisir la categorie du produit : (veuillez entrer un nombre)\n 1- les produits mobiles.\n 2- les produits electroniques\n 3- les produits electromenagers\n 4- les produits informatiques\n 5- les kits solaires");


    switch (sc.nextInt()) {
        case 1: this.catprod = "les produits mobiles "; break;
        case 2:this.catprod = "les produits electroniques ";break;
        case 3:this.catprod = "les produits electromenagers ";break;
        case 4:catprod = "les produits informatiques ";break;
        case 5: catprod = "les kits solaires "; break;
        default:
    }
}
catch(InputMismatchException IME){
    System.out.println("veuillez entrer un nombre");
}
    sc.nextLine();
    System.out.println("Saisir la description: ");
    descprod = sc.nextLine();

    try{System.out.println("Saisir le prix: ");
    prixprod = sc.nextInt();
    sc.nextLine();
}
catch(InputMismatchException IME){
        System.out.println("veuillez entrer un nombre");
}
}

    public void createProduct() {
        String query3 = "INSERT INTO Produit VALUES (?,?,?,?,?,?)";

        Connection con = null;
        Statement st = null;

        try {

            System.out.println("driver loaded");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase", "zidane", "0123456789Z");
            System.out.println("connection done");//connection with database established
            st = con.createStatement();//create statement
            PreparedStatement p = con.prepareStatement(query3);
            p.setString(1, Nomprod);
            p.setString(2, refprod);
            p.setString(3, Specprod);
            p.setString(4, catprod);
            p.setString(5, descprod);
            p.setInt(6, prixprod);
            p.executeUpdate();
            p.close();
            System.out.println("statement created");
            st.execute(query3);//insert
            System.out.println("data inserted");
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    public void ModifierProduit(String S) {
        
        saisirValeur();
        String query = "UPDATE Produit set NOM=?, REFERENCE=?, SPECIFICATIONS=?,CATEGORIE=? ,DESCRIPTION=? ,PRIX=? where REFERENCE='"+S+"'  ";
        
        Connection con = null;
        Statement st = null;

        try {

            System.out.println("driver loaded");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase", "zidane", "0123456789Z");
            System.out.println("connection done");//connection with database established
            st = con.createStatement();//create statement
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, Nomprod);
            p.setString(2, refprod);
            p.setString(3, Specprod);
            p.setString(4, catprod);
            p.setString(5, descprod);
            p.setInt(6, prixprod);
            p.executeUpdate();
            p.close();
            System.out.println("statement created");
            st.execute(query);//insert
            System.out.println("data updated");
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
            }
        }
    }


    public void deleteProduct() {
        String query1 = "DELETE FROM Produit WHERE REFERENCE='"+this.refprodR+"' ";
        Connection con = null;
        Statement st = null;
        try {
            System.out.println("driver loaded");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase", "zidane", "0123456789Z");
            System.out.println("connection done");//connection with database established
            st = con.createStatement();//create statement
            System.out.println("statement created");
            st.execute(query1);//delete
            System.out.println("data changed");
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
    }
    public void Listerprods() {

        Connection con = null;
        Statement st = null;
        ResultSet rslt = null;
        String query3 = "Select * From zidane.Produit";
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase", "zidane", "0123456789Z");
            st = con.createStatement();
            rslt = st.executeQuery(query3);
            while (rslt.next()) {
                String nom = rslt.getString("NOM");
                String reference = rslt.getString("REFERENCE");
                String specifications = rslt.getString("SPECIFICATIONS");
                String categorie = rslt.getString("CATEGORIE");
                String description = rslt.getString("DESCRIPTION");
                int prix = rslt.getInt("PRIX");
                System.out.println(nom+"\t            "+ reference+"\t            "+ specifications+"\t            "+ categorie+"\t            "+ description+"\t            "+ prix);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}



}
//-----------------------------------------------------------------------------------------


	

