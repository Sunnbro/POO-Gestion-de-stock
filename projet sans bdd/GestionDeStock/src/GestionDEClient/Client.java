package GestionDEClient;
import java.util.*;
public class Client {
    static Scanner sc = new Scanner(System.in);
    public String NomCli = null;// nom du client
    public String PrenomCli = null; // Prenom du client
    public String AdresseCli = null; // Adresse Client
    public int NombreAchat =0; // le nombre d'achat effectuer par le client
    public int  ContFid1=0; // carte fideliter du client
    public int  ContFid2=0;
    public int  ContFid3=0;
    public String MDP = null ;   // mots de passe du client
    public static ArrayList<Client> clients = new ArrayList<Client>();
    //---------------------------------------------------------------------------------------------
    public Client() {}
    public Client(String NomCli,String PrenomCli,String MDP,String AdresseCli,int  NombreAchat, int ContFid1,int ContFid2,int ContFid3)// permet de remplire la BDD
    {   this.NomCli=NomCli ;
        this.PrenomCli=PrenomCli;
        this. AdresseCli=AdresseCli;
        this.NombreAchat=NombreAchat;
        this.ContFid1=ContFid1;
        this.ContFid2=ContFid2;
        this.ContFid3=ContFid3;
        this.MDP=MDP;}



    //-------------------------------------------------------------------------------------------
    public String getnom(){return NomCli;}
    public String getpre(){ return PrenomCli;}
    public String getAdresse(){ return AdresseCli;}
    public int getNbrAchat() { return NombreAchat;}
    public int getContFid1() { return ContFid1;}
    public int getContFid2() { return ContFid2;}
    public int getContFid3() { return ContFid3;}
    public String getMDP(){ return  MDP;}
    public String  setnom(String NomCli){ return this.NomCli=NomCli ;}
    public String setpre (String PrenomCli ){ return this.PrenomCli=PrenomCli;}
    public String setAdresse (String AdresseCli){ return this. AdresseCli=AdresseCli;}
    public  int setNbrAchat (int NombreAchat){ return this.NombreAchat=NombreAchat;}
    public  int setContFid1 (int ContFid1){ return this.ContFid1=ContFid1;}
    public  int setContFid2 (int ContFid2){ return this.ContFid2=ContFid2;}
    public  int setContFid3 (int ContFid3){ return this.ContFid3=ContFid3;}
    public  String setMDP (String MDP){ return this.MDP=MDP;}
    public String toString(){
        return " le nom du Client : " + this.NomCli + ", Le Prenom" + this.PrenomCli + ", l' Adresse" + this.AdresseCli+ ", Le Mots De Passe " + this.MDP+ ", Le Compte de fidelité" + this.ContFid1+
                " "+ContFid2+" "+ContFid3;  }
    public void saisircord(){
        /* @SuppressWarnings("resource") */
        sc.nextLine();
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir le Nom du Client: ");
        NomCli = sc.nextLine();
        sc.nextLine();
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
    {System.out.println("Le Client "+" "+NomCli+" "+PrenomCli+" bénificie d'un rabais de   "+ContFid1*5+"%"+" pour les produits mobiles et informatique \n  "+ContFid2*10+"%  pour les produits electronique et electromenagers\n et "+ContFid3*15+"% pour les Kits solaire" );// permt d'affiche la fidélité du client
    }




}


