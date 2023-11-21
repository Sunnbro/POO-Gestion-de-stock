
import GestionDeStock.GUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import GestionDeProduit.*;
import GestionDEClient.*;
import GestionDeCmd.*;
import java.text.*;
public class GestionDeStock {
	    static Scanner sc = new Scanner(System.in);
	    static Produit meme; // permet de stocker  des valeurs volatile
	    static Client nouveaux ; // permet de cree un nv client
	    static Client same;
	    static Client user;// permet de stocker les information du client en ligne actuellement 
	   static Commande cmd;
	    static int num = 0; 
	   static int enligne =0;// permet d'inialiser par 1  si le client est enligne 
	    public static  Produit[] panier ;
	    public static ArrayList<Produit> produits = new ArrayList<>();// permet de cr�e  une liste de produit 
	    public static ArrayList<Client> Clients = new ArrayList<>();// permet de cr�e une liste de clients 
	    public static ArrayList<Commande>Cmds = new ArrayList<>();// permet de cr�e une liste de commandes
	    public static void main(String[] args) {
System.out.println("Bienvenu sur l'application de gestion de A3marDarek Electronics");
  while(true) {     
Menu();}}// permet d'appeller le Menu principale afin de lancer le programme
  public static void Connexion()// permet de se connecter
{  String m0,m1,m2;
      String p=null;
Scanner sc = new Scanner(System.in);
     System.out.println("Entrez votre nom");
	m0=sc.nextLine();
	System.out.println("Entrez votre Prenom");
	m1=sc.nextLine();
	System.out.println("Entrez votre Mot de passe");
     m2=sc.nextLine();
     for (Client client : Clients) {   // parcourir la liste de client pour verifi� si le client existe
    same = client;
    	 p= same.getpre();
    	 if (same.getnom().equals(m0)){if  (same.getpre().equals(m1)) {if (same.getpre().equals(m1)) {
        System.out.println("Vous vous etes connecte avec succes");
             enligne =1;
               user= same; 
            } }}}
    if (enligne==0) { System.out.println("Erreur de connexion veuilliez reesseyez ");
    	Connexion();} }  
  public static void deconnecte()// pour ce deconnecte en met la variable "enligne" a 1
	  {   enligne=0;
		   System.out.println("Vous etes deconnecte");Menu();}
  public static void Menu () // le 	Menu principale
    { 
        System.out.println("----------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("veuillez choisir un menu");
        System.out.println(" Tapez 0 pour vous connecte");
        System.out.println("Tapez 1 pour la Gestion de produit ");
        System.out.println("Tapez 2 pour la Gestion des clients ");
        System.out.println("Tapez 3 pour la Gestion des commandes ");
        System.out.println("Tapez 4 pour Quitter ");
        System.out.println("Tapez 5 pour vous deconnecte");
        try{int M =sc.nextInt();
        switch (M) {
            case 0: Connexion();Menu();break;
            case 1:{ GDP();}break;
            case 2:GDC();break;
            case 3: System.out.println(" pas de base de données concue pour les commandes pour l'instant!");break;
            case 4:System.out.println("Merci de votre Visite a bientot ");System.exit(M);break;
            case 5: deconnecte();break;
            default:System.out.println("Veuillez reessayer");Menu();
        }}
        catch(InputMismatchException IME) { System.out.println("un nombre s'il vous plait");   }}
    // GDP pour Gestion Des Produits
    public static void GDP ()
    {   System.out.println("----------------------------------------------");
        System.out.println("Que voulez vous faire");
        Scanner sc = new Scanner(System.in);
        System.out.println("Tapez 1 pour Creer une liste de produits ");
        System.out.println("Tapez 2 pour Ajouter un produit ");
        System.out.println("Tapez 3 pour Supprimer produit ");
        System.out.println("Tapez 4 pour Modifier produit ");
        System.out.println("Tapez 5 pour Afficher la liste Produit par type de produit  ");
        System.out.println("Tapez 6 pour Quitter ");
        try{int  N=sc.nextInt();
            switch (N) {
                case 1:Createliste();break;
                case 2:ajouterproduit();break;
                case 3:supprimerproduit();break;
                case 4:modifierproduit();break;
                case 5:listerproduit();break;
                case 6:Menu();break;
                default:System.out.println("Veuillez reessayer");
                }}
     catch(InputMismatchException IME) { System.out.println("un nombre s'il vous plait");   }}
    // GDC pour la Gestion des clients
    public static void GDC ()
    {
        System.out.println("----------------------------------------------");
        System.out.println("Que voulez vous faire");
        Scanner sc = new Scanner(System.in);
        System.out.println("Tapez 1 pour Creer une liste de Clients ");
        System.out.println("Tapez 2 pour Ajouter un Client ");
        System.out.println("Tapez 3 pour Supprimer Client ");
        System.out.println("Tapez 4 pour Modifier Client ");
        System.out.println("Tapez 5 pour Afficher la liste Client  ");
        System.out.println("Tapez 6 pour Afficher l'etat de fidelisation des clients ");
        System.out.println("Tapez 7 pour Quitter ");
      try {  int N = sc.nextInt();
        switch (N) {
            case 1:Createliste1(); break;
            case 2:ajouterClient();break;
            case 3:supprimerclient();break;
            case 4:modifierCli(); break;
            case 5:listerClient();break;
            case 6:AfficheFidCls();break;
            case 7:Menu();break;
            default:System.out.println("Veuillez reessayer");GDC();}}
        catch(InputMismatchException IME) { System.out.println("un nombre ya l7mar");  // permet d'afficher un message en cas d'insertion d'un caractere 
        }}
    // GDCmd pour la Gestion des commandes
    
    static void ajouterproduit()
    { String rep;
        do
        {
            meme = new Produit();
            meme.saisirValeur();
            meme.createProduct();
            meme.AfficherValeurprod();

            System.out.println("----------------------------------------------");

            System.out.println("Voulez vous ajouter un autre produit,  oui/non: ");
            rep = sc.next();

        }while(rep.equals("oui"));
        GDP();
    }


    static void modifierproduit()
    {   sc.nextLine();
        System.out.println("Saisir la reference du produit à modifier: ");
        String ni9 = sc.nextLine();
        Produit meme9 = new Produit();
        meme9.ModifierProduit(ni9);
        System.out.println("modifié avec succès !");
        System.out.println("----------------------------------------------");
        GDP();
    }



    static void rechercherReferenceproduit()
    {
        System.out.println("Saisir la reference du produit à supprimer: ");
        String ni = sc.nextLine();
        Produit meme1 = new Produit();
        meme1.setrefprodR(ni);
        meme1.deleteProduct();
    }
    static void Createliste()
    { ArrayList<Produit> produits = new ArrayList<>();
        System.out.println("votre liste a été crée avec succès !");
        GDP();
    }



    static void listerproduit()
    {
        Produit meme2 = new Produit();
        meme2.Listerprods();
        GDP();
    }

    private static void extracted() {
        Collections.sort(produits, Produit.comparerCat);
    }

    public static void supprimerproduit()
    {
        rechercherReferenceproduit();
        System.out.println("supprimé avec succès !");

        GDP();

    }
    // GESTION DE CLIENT -------------------------------------------------------------------------------------------------------------------------------------
    static void ajouterClient()
    { String Rep;
        do
        {   Client nouveaux = new Client();
            nouveaux.saisircord();
            nouveaux.createClient();
            nouveaux.AfficherCordCli();

            System.out.println("----------------------------------------------");
            System.out.println("Voulez vous ajouter un autre Client,  oui/non: ");
            Rep = sc.next();
        }while(Rep.equals("oui"));
        GDC();}

    static void modifierCli()
    {System.out.println("Saisir le Nom du Client a modifier: ");
        sc.nextLine();
        String co1 = sc.nextLine();
        Client nouveaux9 = new Client();
        nouveaux9.ModifierClient(co1);
System.out.println("modifié avec succès !");
        System.out.println("----------------------------------------------");
        
        GDC();}
    static void rechercherCordCli()
    {   sc.nextLine();
        System.out.println("Saisir le nom du client a supprimer: ");
        String name = sc.nextLine();
        Client nouveaux2 = new Client();
        nouveaux2.setnomR(name);
        nouveaux2.deleteClient();

    }
    static void Createliste1()
    { ArrayList<Client> Clients = new ArrayList<>();
        System.out.println("votre liste de Clients a �t� cr�e avec succ�s !");
        GDC();}

    static void listerClient()
    {Client nouveaux2 = new Client();
        nouveaux2.ListerClient();
        GDC();}
    static void AfficheFidCls()// lister la fideliter de tous les clients
    {for(Client c : Clients)
        c.AfficheFid();
        if(Clients.isEmpty() == true){System.out.println(" Il n'ya pas de clients pour l'instant !");}
        GDC();}
    public static void supprimerclient()
    {   rechercherCordCli();
        System.out.println("supprime avec succes !");
        GDC();}

}



