package GestionDEClient;
import java.util.*;
import java.sql.*;

public class Client {
	public String NomCli = null;// nom du client 
	public String NomCliR = null;
        public String PrenomCli = null; // Prenom du client 
	public String AdresseCli = null; // Adresse Client 
	public int NombreAchat =0; // le nombre d'achat effectuer par le client 
	public int  ContFid1=0; // carte fideliter du client 
	public int  ContFid2=0;
	public int  ContFid3=0;
	public String MDP = null ;   // mots de passe du client 
     public static ArrayList<Client> clients = new ArrayList<Client>();
     public String getnom(){return NomCli;}	
     public String getnomR(){return NomCliR;}
     public String getpre(){ return PrenomCli;}
     public String getAdresse(){ return AdresseCli;}
     public int getNbrAchat() { return NombreAchat;}
     public int getContFid1() { return ContFid1;}
     public int getContFid2() { return ContFid2;}
     public int getContFid3() { return ContFid3;}
     public String getMDP(){ return  MDP;}
       public String  setnom(String NomCli){ return this.NomCli=NomCli ;}
       public String  setnomR(String NomCliR){ return this.NomCliR=NomCliR ;}
       public String setpre (String PrenomCli ){ return this.PrenomCli=PrenomCli;}
       public String setAdresse (String AdresseCli){ return this. AdresseCli=AdresseCli;}
       public  int setNbrAchat (int NombreAchat){ return this.NombreAchat=NombreAchat;}
       public  int setContFid1 (int ContFid1){ return this.ContFid1=ContFid1;}
       public  int setContFid2 (int ContFid2){ return this.ContFid2=ContFid2;}
       public  int setContFid3 (int ContFid2){ return this.ContFid3=ContFid3;}
       public  String setMDP (String MDP){ return this.MDP=MDP;}
 public String toString(){
        return " le nom du Client : " + this.NomCli + ", Le Prenom" + this.PrenomCli + ", l' Adresse" + this.AdresseCli+ ", Le Mots De Passe " + this.MDP+ ", Le Compte de fidelit�" + this.ContFid1+
  " "+ContFid2+" "+ContFid3;  }
public void saisircord(){
	 Scanner sc = new Scanner(System.in);	
	 System.out.println("Saisir le Nom du Client: ");
        NomCli = sc.nextLine();
        System.out.println("Saisir Le prenom du Client: ");
        PrenomCli = sc.nextLine();
         System.out.println("Saisir L'Adresse du Client: ");
        AdresseCli = sc.nextLine();
        System.out.println("Saisir votre  Mots De Passe: ");
        MDP = sc.nextLine();
}
public void AfficherCordCli()
    {   System.out.println("Le Nom du Client   : " + NomCli);
        System.out.println("Le Prenom du Client: " + PrenomCli );
        System.out.println("L'Adresse du Client est    : " + AdresseCli);
        System.out.println("Le Mot de passe  du Client    : " + "***************");
        System.out.println("Le Nombre D'achat du Client    : " + NombreAchat);
         }
public void AfficheFid()
{System.out.println("Le Client "+" "+NomCli+" "+PrenomCli+" benificie d'un rabais de dans la Cat�gorie  "+ContFid1*5+"%" );// permt d'affiche la fid�lit� du client 
}

    public void createClient() {
        String query4 = "INSERT INTO Client VALUES (?,?,?,?,?,?)";

        Connection con = null;
        Statement st = null;

        try {

            System.out.println("driver loaded");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase", "zidane", "0123456789Z");
            System.out.println("connection done");//connection with database established
            st = con.createStatement();//create statement
            PreparedStatement p = con.prepareStatement(query4);
            p.setString(1, NomCli);
            p.setString(2, PrenomCli);
            p.setString(3, AdresseCli);
            p.setInt(4, NombreAchat);
            p.setInt(5, ContFid1);
            p.setString(6, MDP);
            p.executeUpdate();
            p.close();
            System.out.println("statement created");
            st.execute(query4);//insert
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

    public void ModifierClient(String D) {
        saisircord();
        String query6 = "UPDATE Client SET NOM=?,PRENOM=?,ADRESSE=?,NOMBRE_ACHATS=?,CONTFID=?,MOT_DE_PASSE=? WHERE NOM='"+D+"'  ";
        Connection con = null;
        Statement st = null;

        try {

            System.out.println("driver loaded");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase", "zidane", "0123456789Z");
            System.out.println("connection done");//connection with database established
            st = con.createStatement();//create statement
            PreparedStatement p = con.prepareStatement(query6);
            p.setString(1, NomCli);
            p.setString(2, PrenomCli);
            p.setString(3, AdresseCli);
            p.setInt(4, NombreAchat);
            p.setInt(5, ContFid1);
            p.setString(6, MDP);
            p.executeUpdate();
            p.close();
            System.out.println("statement created");
            st.execute(query6);//insert
            System.out.println("data changed");
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


    public void deleteClient() {
        String query1 = "DELETE FROM Client WHERE NOM='"+this.NomCliR+"' ";
        Connection con = null;
        Statement st = null;
        System.out.println(query1);
        System.out.println(query1);
        try {
            System.out.println("driver loaded");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase", "zidane", "0123456789Z");
            System.out.println("connection done");//connection with database established
            st = con.createStatement();//create statement
            System.out.println("statement created");
            st.execute(query1);//delete
            System.out.println("data deleted");
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
    }
    public void ListerClient() {

        Connection con = null;
        Statement st = null;
        ResultSet rslt = null;
        String query3 = "Select * From zidane.Client";
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase", "zidane", "0123456789Z");
            st = con.createStatement();
            rslt = st.executeQuery(query3);
            while (rslt.next()) {
                String nom = rslt.getString("NOM");
                String prenom = rslt.getString("PRENOM");
                String adresse = rslt.getString("ADRESSE");
                String nombre_achats = rslt.getString("NOMBRE_ACHATS");
                int contfid = rslt.getInt("CONTFID");
                String mdp = rslt.getString("MOT_DE_PASSE");
                System.out.println(nom+"\t            "+ prenom+"\t            "+ adresse+"\t            "+ nombre_achats+"\t            "+ contfid+"\t            "+ mdp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }





}
