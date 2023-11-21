/* Le binome:
 Doudou Amir 191931081313
 Belharrat Zidane 191931085131
 Section Acad C
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import GestionDeProduit.*;
import GestionDEClient.*;
import GestionDeCmd.*;
public class GestionDeStock {
    static Scanner sc = new Scanner(System.in);
    static Produit meme; // permet de stocker  des valeurs volatile
    static Client same;// permet de cree ou modifier un client
    static Client user;// permet de stocker les information du client en ligne actuellement
    static Commande cmd;// variable qui serre a la gestion des commande
    static int num = 9;//permet de definir le code commande car il existe dja neuf commande du coup la prochaine sera la 10 puis la 11...ect
    static int enligne =0;// permet d'inialiser par 1  si le client est enligne
    public static  Produit[] panier ;
    public static ArrayList<Produit> produits = new ArrayList<>();// permet de crée  une liste de produit
    public static ArrayList<Client> Clients = new ArrayList<>();// permet de crée une liste de clients
    public static ArrayList<Commande>Cmds = new ArrayList<>();// permet de crée une liste de commandes

    //----------------------------------------Main------------------------------------------------
    public static void main(String[] args) {
        System.out.println("Bienvenu sur l'application de gestion de A3marDarek Electronics");
        MMenu();// MMenu pour Main Menu
    }
//------------------------------------------------------------------------------------------------

    //permet d'appeller le Menu principale afin de lancer le programme
    public static void Connexion()// permet de se connecter
    {  String m0,m1,m2;

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez votre nom");
        m0=sc.nextLine();
        System.out.println("Entrez votre Prenom");
        m1=sc.nextLine();
        System.out.println("Entrez votre Mot de passe");
        m2=sc.nextLine();
        for (Client client : Clients) {   // parcourir la liste de client pour verifié si le client existe
            same = client;

            if (same.getnom().equals(m0)){if  (same.getpre().equals(m1)) {if (same.getMDP().equals(m2)) {
                System.out.println("Vous étes connecté avec succès");
                enligne =1;
                user= same;
            } }}}
        if (enligne==0) { System.out.println("Erreur de connexion veuilliez réesseyez ");
            Connexion();} }
    public static void déconnecté()// pour ce deconnecter en met la variable "enligne" a 1
    {   enligne=0;
        System.out.println("Vous étes deconnecté");MMenu();}
    @SuppressWarnings("resource")
    public static void MMenu() // le 	Menu principale
    { inisTabCCP();
        System.out.println("----------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("veuillez choisir un menu");
        System.out.println("Tapez 0 pour vous connecter");
        System.out.println("Tapez 1 pour la Gestion de produit ");
        System.out.println("Tapez 2 pour la Gestion des clients ");
        System.out.println("Tapez 3 pour la Gestion des commandes ");
        System.out.println("Tapez 4 pour Quitter ");
        System.out.println("Tapez 5 pour vous déconnecter");
        try{int M =sc.nextInt();
            switch (M) {
                case 0: Connexion();MMenu();break;
                case 1:GDP();break;
                case 2:GDC();break;
                case 3: GDCmd();break;
                case 4:System.out.println("Merci de votre Visite a bientot ");System.exit(M);break;//permet de quitter le programme
                case 5: déconnecté();break;
                default:System.out.println("Veuillez reessayer");MMenu();
            }}
        catch(InputMismatchException IME) { System.out.println("un nombre SVP");   }}
    // GDP pour Gestion Des Produits
    @SuppressWarnings("resource")
    public static void GDP ()
    {   System.out.println("----------------------------------------------");
        System.out.println("Que voulez vous faire");
        Scanner sc = new Scanner(System.in);

        System.out.println("Tapez 1 pour Ajouter un produit ");
        System.out.println("Tapez 2 pour Supprimer produit ");
        System.out.println("Tapez 3 pour Modifier produit ");
        System.out.println("Tapez 4 pour Afficher la liste Produit par type de produit  ");
        System.out.println("Tapez 5 pour Quitter ");
        try{int  N=sc.nextInt();
            switch (N) {
                case 1:ajouterproduit();GDP ();break;
                case 2:supprimerproduit();GDP ();break;
                case 3:modifierproduit();GDP ();break;
                case 4:listerproduit();GDP ();break;
                case 5:MMenu();break;
                default:System.out.println("Veuillez reessayer");
            }}
        catch(InputMismatchException IME) { System.out.println("un nombre svp");   }}
    // GDC pour la Gestion des clients
    public static void GDC ()// menu de la gestion des clients
    {
        System.out.println("----------------------------------------------");
        System.out.println("Que voulez vous faire");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println("Tapez 1 pour Ajouter un Client ");
        System.out.println("Tapez 2 pour Supprimer Client ");
        System.out.println("Tapez 3 pour Modifier Client ");
        System.out.println("Tapez 4 pour Afficher la liste Client  ");
        System.out.println("Tapez 5 pour Afficher l'état de fidelisation des clients ");
        System.out.println("Tapez 6 pour Quitter ");
        try {  int N = sc.nextInt();
            switch (N) {
                case 1:ajouterClient();GDC ();break;
                case 2:supprimerclient();GDC ();break;
                case 3:modifierCli(); GDC ();break;
                case 4:listerClient();GDC ();break;
                case 5:AfficheFidCls();GDC ();break;
                case 6:MMenu();break;
                default:System.out.println("Veuillez reessayer");GDC();}}
        catch(InputMismatchException IME) { System.out.println("un nombre SVP");  // permet d'afficher un message en cas d'insertion d'un caractere
        }}
    // GDCmd pour la Gestion des commandes
    public static void GDCmd ()
    {  System.out.println("----------------------------------------------");
        System.out.println("Que voulez vous faire");
        @SuppressWarnings("resource")
        Scanner sc= new Scanner(System.in);
        System.out.println("Tapez 1 pour Ajouter une commande ");
        System.out.println("Tapez 2 pour Supprimer une commande ");
        System.out.println("Tapez 3 pour Modifier une commande ");
        System.out.println("Tapez 4 pour Afficher la liste des commandes satisfaites ");
        System.out.println("Tapez 5 pour Afficher la liste des commandes en instance ");
        System.out.println("Tapez 6 pour Afficher le produit le plus commercialise sur une periode donne ");
        System.out.println("Tapez 7 pour Afficher le produit le moins commercialise sur une periode donne ");
        System.out.println("Tapez 8 pour Achats d'un produit donne sur une periode donne  ");
        System.out.println("Tapez 9 pour Achats d'un produit donne sur une periode donnee, par ville ");
        System.out.println("Tapez 10 pour Acheter");
        System.out.println("Tapez 11 pour Quitter ");
        try { int N = sc.nextInt();
            switch (N) {

                case 1:if (enligne==1) { ajouterCmd();} // avant d'excuter la methode ajout commande en verifie si le client est connecté d'abord si non on lui demande de ce connecter
                else {System.out.println(" Veillez vous connecter a votre compte d'abord ");
                    Connexion();ajouterCmd();}GDCmd ();break;
                case 2:supprimerCmd();GDCmd (); break;
                case 3: ModifCmd();GDCmd (); break;
                case 4:listerCmdSat();GDCmd ();break;
                case 5:listerCmdIns();GDCmd ();break;
                case 6:Affichetop();GDCmd ();break;
                case 7:AfficheFlop();GDCmd ();break;
                case 8:AfficheAchat1();GDCmd ();break;
                case 9:AfficheAchat2();GDCmd ();break;
                case 10:Achat();GDCmd ();break;
                case 11:MMenu(); break;
                default:System.out.println("Veuillez reessayer");GDCmd();}}
        catch(InputMismatchException IME) { System.out.println("un nombre svp");    } }
    static void ajouterproduit()// permet l'ajout d'un produit
    { String rep;
        do
        {   meme = new Produit();  //on cree meme de type produit
            meme.saisirValeur();    //on remplit meme
            produits.add(meme);      // on ajoute meme a la liste des produits
            meme.AfficherValeurprod();   //on affiche meme
            System.out.println("----------------------------------------------");
            System.out.println("Voulez vous ajouter un autre produit,  oui/non: ");
            rep = sc.next();
        }while(rep.equals("oui"));
        GDP();}
    static void modifierproduit()// permet le modification d'un produit
    { System.out.println("Saisir la reference du produit à modifier: ");
        sc.nextLine();
        String nl = sc.nextLine();   //prendre la valeur saisie par l'utilisateur
        for (Produit produit : produits) {
            meme = produit;
            if (meme.getRefprod().equals(nl)) {
                meme.saisirValeur();      //saisir les nouvelles valeurs

                System.out.println("Voici votre produit après la modification");
                meme.AfficherValeurprod();
                System.out.println("----------------------------------------------");
            }} GDP();}
    static int rechercherReferenceproduit()// on recherche un produit grace a sa reference puis on supprime
    {   sc.nextLine();
        System.out.println("Saisir la reference du produit à supprimer: ");
        String ni = sc.nextLine();
        for(int i=0; i<produits.size(); i++)
        { meme = produits.get(i);               //on recherche le produit dans la liste,si il existe on le supprime, cette methode nous aide dans SupprimeProduit()
            if(meme.getRefprod().equals(ni)){
                produits.remove(meme);  //supprimer l'element
                return i;} }
        System.out.println("Ce produit n'existe pas");
        return -1; }
    static void listerproduit() // afficher une liste de produit
    {extracted();
        for(Produit p : produits)
            p.AfficherValeurprod();
        if(produits.isEmpty() == true){System.out.println(" Il n'ya pas de produits pour l'instant !");}
        GDP(); }
    private static void extracted() {
        Collections.sort(produits, Produit.comparerCat);}
    public static void supprimerproduit()// supprimer un produit de la liste
    { int z = rechercherReferenceproduit();
        if (z != -1) {System.out.println("supprimé avec succès !");
        }
        GDP();}
    //GESTION DE CLIENT -------------------------------------------------------------------------------------------------------------------------------------
    static void ajouterClient() // ajouter un client
    { String Rep;
        do
        {same = new Client();  /*  permet l'ajout d'un client
                                    on cree meme de type client
                                    on remplit nouveaux
                                    on ajoute meme a la liste des clients
                                    on affiche nouveaux *: */
            same.saisircord();
            Clients.add(same);
            same.AfficherCordCli();
            System.out.println("----------------------------------------------");
            System.out.println("Voulez vous ajouter un autre Client,  oui/non: ");
            Rep = sc.next();
        }while(Rep.equals("oui"));
        GDC();}
    static void modifierCli() // modifier un client pour cela il devra tous resaisir, c'est le meme principe que modifierProduit()
    {System.out.println("Saisir la Nom du Client à modifier: ");
        sc.nextLine();
        String co1 = sc.nextLine();
        for (Client client : Clients) {
            same = client;
            if (same.getnom().equals(co1)) {
                same.saisircord();
                System.out.println("Voici les Coordonnées du Client après la modification");
                same.AfficherCordCli();
                System.out.println("----------------------------------------------");
            }}
        GDC();}
    static int rechercherCordCli()// recherche un client par son nom et prenom
    {   sc.nextLine();
        System.out.println("Saisir le nom du client à supprimer: ");
        String name = sc.nextLine();
        for(int i=0; i<Clients.size(); i++)
        {same = Clients.get(i);
            if(same.getnom().equals(name)){
                    Clients.remove(same);
                    return i;}}
        System.out.println("Ce Client n'existe pas");
        return -1;}
    static void listerClient()// afficher le liste de client
    {extracted();
        for(Client c : Clients)  //parcourt la liste et affiche
     c.AfficherCordCli();
        if(Clients.isEmpty() == true){System.out.println(" Il n'ya pas de clients pour l'instant !");}
        GDC();}
    static void AfficheFidCls()// lister la fideliter de tous les clients
    {for(Client c : Clients)
        c.AfficheFid();
        if(Clients.isEmpty() == true){System.out.println(" Il n'ya pas de clients pour l'instant !");}
        GDC();}
    public static void supprimerclient()
    {int z = rechercherCordCli();
        if (z != -1) {System.out.println("supprimé avec succès !");
        }GDC();}
    // Gestion de Commande ------------------------------------------------------------------------------------------------------------------------------------------------
    static void ajouterCmd() // l'ajout d'une commande
    {String Rep=null;
        do
        { int j =0;
            Commande cmd = new Commande();
            cmd.setClis(user.getnom());
            cmd.setVald(0);
            System.out.println("Saisir la reference du produit à Commander : ");
            sc.nextLine();
            String ni = sc.nextLine();
            for (Produit meme : produits   )
            {
                if(meme.getRefprod().equals(ni)){  //rechercher si le produit demandé est disponible
                    cmd.setProCmd(meme);
                    cmd.setCode(num++);
                    String  t = Getjours();
                    cmd.setjour(t);
                    t=Getmois();
                    cmd.setmois(t);
                    t =Getans();
                    cmd.setans(t);
                    cmd.setville(user.getAdresse());
                    cmd.setPRIX(meme.getPrixprod());
                    j=1; }}
            if (j==0)
            { System.out.println("votre produit n'est plus en stock");}
            else {    Cmds.add(cmd);}
            System.out.println("Voulez vous ajouter un autre Commande ,  oui/non: ");
            Rep = sc.next();
        }while(Rep.equals("oui"));
        GDCmd();}
    static int rechercherCmd()// rechercher une commande par son code fournie par le programme
    {   sc.nextLine();
        System.out.println("Saisir le Code de votre commande  à supprimer: ");
        int x = sc.nextInt();
        for(int i=0; i<Cmds.size(); i++)
        {cmd = Cmds.get(i);
            if(cmd.getCode()==x){
                Cmds.remove(cmd);
                return i;}}

        return -1; }
    public static void supprimerCmd()// permet la suppresion d'une commande apres la demende du client a cause d'uen annulation
    {int z = rechercherCmd();
        if (z != -1) {System.out.println("supprimé avec succès !");
        } GDCmd();}
    static void listerCmdSat()// permet d'afficher les commande satisfaite grace a la variable"Validée" si elle est mise a 1
    { for(Commande cm : Cmds)
        if (cm.getVald()==1) {
            System.out.println("Cette commande est Satisfaite");
            cm.AfficherCmds();}
        if(Cmds.isEmpty() == true){System.out.println(" Il n'ya pas de Commande satisafaite ");}
        GDCmd();}
    static void listerCmdIns() //  permet d'afficher les commande en instance  grace a la variable"Validée" si elle est mise a 0 car de base elle mise a -1
    { for(Commande cm : Cmds)
        if (cm.getVald()==0) {
            System.out.println("Cette commande est en instance");
            cm.AfficherCMD();}
        if(Cmds.isEmpty() == true){System.out.println(" Il n'ya pas de Commande en instance  ");}
        GDCmd();}
    // modif commande
    public static void ModifCmd()// permet de modifié une commande
    { int  y=0;
        System.out.println("Entrez le code de la commande a modifié");
        y = sc.nextInt();
        for (Commande  e : Cmds) {
            cmd = e;
            if (cmd.getCode()==y) { System.out.println("Entrez la nouveaux produit : ");
                sc.nextLine();
                String ni = sc.nextLine();
                for (Produit meme :produits)
                { ;
                    if(meme.getRefprod().equals(ni)){
                        cmd.setProCmd(meme);
                    } }
                System.out.println("Voici La Commande apres modification");
                cmd.AfficherCMD();
                System.out.println("----------------------------------------------");}
        }GDCmd();}// si ca vous revoie au menu sans affichage c parce que votre commande n'existe pas
    // Achat apres commande
    public static void Achat() {     // cette commande est en com  a cause de redondance est peut etre supprimer

        float y =0;
        if (enligne==1) { // le client doit d'abord etre en ligne sionon on lui demende de ce connecter
            System.out.println("Enterz Le code de votre Commande ");
            int x=sc.nextInt();
            for(int i=0; i<Cmds.size(); i++)
            {cmd = Cmds.get(i);
                if (cmd.getVald()==1) { System.out.println(" ");}
                else{  if((cmd.getCode()==x)&&( cmd.getVald()==0)){  if (Integer.valueOf(Getjours())-Integer.valueOf(cmd.getjour())<=2){ y = cmd.ProCmd.getPrixprod();
                    if ((cmd.ProCmd.getCatprod()=="les produits mobiles")||(cmd.ProCmd.getCatprod()=="les produits informatiques ")){ // on cherche la categorie du produit afin de determiner le rabais soit 5,10 ou 15%
                        if (user.getContFid1()==1) {
                            y=y-(y*5)/100;// si la commande ce verifie on diminue le prix d'achat
                            cmd.setPRIX(y);
                            cmd.setVald(1);// et on met la commande a l'etat 1 = satisafaite
                            user.setContFid1(0); } // et on remet inisialise la fidelité du client
                        else {   cmd.setPRIX(y);user.setContFid1(1);}// dans ce cas on effectue pas de rabais et on met la fidelité a 1
                        System.out.println("voici votre Commande merci pour votre Achats ");
                        cmd.AfficherCMD();}
                    // les commentaires son similaire pour les deux prochaine conditon
                    if ((cmd.ProCmd.getCatprod()=="les produits electromenagers")||(cmd.ProCmd.getCatprod()=="les produits electroniques"))// meme chose on cherche la categorie
                    {    if (user.getContFid2()==1) {
                        y=y-(y*10)/100;
                        cmd.setPRIX(y);
                        cmd.setVald(1);
                        user.setContFid2(0);}
                    else    {cmd.setPRIX(y);user.setContFid2(1);}
                        System.out.println("voici votre Commande merci pour votre Achats ");
                        cmd.AfficherCMD();}
                    if (cmd.ProCmd.getCatprod()=="les kits solaires ")
                    {   if (user.getContFid3()==1) {
                        y=y-(y*15)/100;
                        cmd.setPRIX(y);
                        cmd.setVald(1);
                        user.setContFid3(0);}
                    else {   cmd.setPRIX(y);user.setContFid3(1);}
                        System.out.println("voici votre Commande merci pour votre Achats ");
                        cmd.AfficherCMD();
                    }  } else{System.out.println("votre Commande a expiré");}// on affiche ce message si la priode de 2 jours (pariode entre la commande et l'achat) a expiré
                }}}}else{Connexion();Achat();}}
    //Meilleure vote ce fait par tranche de" mois par mois" exemple le produit le plus vendu le mois passé,les deux mois passé ...etc
    public  static void  Affichetop()   // affiche le produit le plus commercialiser sur une pariode donné
    {  ArrayList<String >Top = new ArrayList<>();
        int p,y =0;
        String k =Getmois(); // on obtient la date actuelle
        System.out.println("Entrez la pariode volue :");
        System.out.println("Entrez 0 pour ce mois ci");
        System.out.println("Entrez 1 pour le mois dernier");
        System.out.println("Entrez 2 pour les deux mois dernier");
        System.out.println("Entrez 3 pour les trois mois dernier ");
        int q=sc.nextInt();// on determine la pariode volue par le client
        // convertir la periode voulue
        p=Integer.valueOf(k);// convertir la date actuelle car le system revoi la date en type "String"
        y=p;// on sauvgarde la date actuelle
        p=p-q; // determiner la date d'étude
        int max =0;// contient la frenquence du produit le plus commercialisé
        for (Commande c : Cmds)
        {    if((Integer.valueOf(c.getmois())<=y)&&(Integer.valueOf(c.getmois())>=p)) {// on verifie  les deux condition
            Top.add(c.getProCmd().getRefprod());}}
        for (String  e : Top)
        {      q=Collections.frequency(Top,e);// on calcule le nombre de fois que la reference du produit ce repete
            if(q>max) { max =q;// on sauvgarde le nombre de repition dans max
                k=e; // on sauvgarde la reference dans k
            }}
        if (max==0) {System.out.println(" il  ya pas eu de vente pandant cette pariode dommage c'est dieux qui donne ");}
        else {System.out.println("Le produit le plus vendu pandant cette pariode est : "+k  );     }}
    static void AfficheFlop()// c'ets lesmems commentaire que pour la methode precedente  juste que min est l'inverse de max
    {   ArrayList<String >Top = new ArrayList<>();
        int p,y =0;
        String k =Getmois();
        String r= null;
        System.out.println("Entrez la pariode volue :");
        System.out.println("Entrez 0 pour ce mois ci");
        System.out.println("Entrez 1 pour le mois dernier");
        System.out.println("Entrez 2 pour les deux mois dernier");
        System.out.println("Entrez 3 pour les trois mois dernier ");
        int q=sc.nextInt();
// convertir la periode voulue
        p=Integer.valueOf(k);// convertir la date actuelle
        y=p;
        p=p-q; // determiner la date d'étude
        int min =100;// contien la frenquence du produit le plus commercialisé
        for (Commande c : Cmds)
        {    if((Integer.valueOf(c.getmois())<=y)&&(Integer.valueOf(c.getmois())>=p)) {
            Top.add(c.getProCmd().getRefprod());}}

        for (String  e : Top)
        {      q=Collections.frequency(Top,e);
            if(q<min) { min =q;
                r=e;
            }}
        if (min ==0) {System.out.println(" il  ya pas eu de vente pandant cette pariode  ");}
        else {System.out.println("Le produit le moins vendu pandant cette pariode est : "+r  );     }
    }
    // Achat par periode donné
    static void AfficheAchat1()// achat d'un produit par periode
    {
        int n=0;
        sc.nextLine();
        System.out.println("Entrez le mois d'achat :");
        String q=sc.nextLine();
        System.out.println("Enterz La ref de votre produit ");
        String  cc=sc.nextLine();

        for (Commande c : Cmds)
        {    if((c.getmois()==q)&&(c.getVald()==1)&&(c.getProCmd().getRefprod()==cc))
        { n++;}}


        System.out.println("Votre produit a ete achete "+n+" fois ");


    }

    //Achat pariode et ville donné
    static void AfficheAchat2()// achat d'un produit par periode et par ville autoriser
    {   int n =1;
        System.out.println("Entrez la ville  :");
        String v=sc.nextLine();
        System.out.println("Entrez le mois d'achat :");
        String m=sc.nextLine();
        System.out.println("Enterz La ref de votre produit ");
        String  cc=sc.nextLine();
        // on parcours la liste des commande et a chaque fois que la condition ce confirme on ajoute 1 a "n"

        for (Commande c : Cmds)
        {    if((c.getmois()==m)&&(c.getville()==v) &&(c.getProCmd().getRefprod()==cc)&&(c.getVald()==1)){
            n=n+1;}}
        System.out.println("Votre produit a ete achete "+n+" fois le "+m+" eme mois ");
    }


    //  DATE --------------------------------------------------------------------------------------------------------------------------------------------
    public static String Getjours() {// revoie le jours du system
        DateFormat format =new SimpleDateFormat("dd");
        Date date= new Date();
        String  d = format.format(date) ;// detmine la forme volue
        return d ;
    }
    public static String   Getmois() {// revoie le mois
        DateFormat format1 =new SimpleDateFormat("MM");
        Date date1= new Date();
        String    d = format1.format(date1) ;
        return d ;
    }
    public static String Getans() { // revoie l'année
        DateFormat format2 =new SimpleDateFormat("yyyy");
        Date date2= new Date();
        String  d = format2.format(date2) ;
        return d ;
    }
    // c'est une mini base de donné
    public static void inisTabCCP() {  // CCP pour Client/Commande/Produit
        Produit p1 =new Produit("tablette","ref1","noir,touchscreen","les produits mobiles","tablette touchscreen,5 pouces",5000);
        Produit p2 =new Produit("laptop","ref2","portable,i5,intel hd 620","les produits informatiques","laptop portable pour surfer sur le net,lire mails,faire des projets longs et interminables.",75000);
        Produit p3 =new Produit("Climatiseur","ref3","24000btu,econome","les produits electromenagers","refroidit ou rechauffe votre lieu ",45000);
        Produit p4=new Produit("Televiseur","ref4","4K,50 pouces,noir","les produits electroniques","diffuse du contenu divertisant en haute definition",60000);
        Produit p5 =new Produit("batterie solaire","ref5","autonomie 20h,lumiere bleue","les kits solaires","une lampe qui utilise la lumiere solaire comme energie",10000);
        Produit p6 =new Produit("lave linge","ref6","Capacité du tambour indicative","les produits electromenagers","lave vous linge les plus sale ",55000);
        Produit p7=new Produit("démodulateur","ref7","plus 5000 possibilité","les produits electroniques","decripte du contenu divertisant en haute definition",5000);
        Produit p8 =new Produit("régulateur de charge solaires","ref8","Il fonctionne avec des panneaux 12 ou 24V (36 ou 72 cellules)","les kits solaires","simple est peut couteux",7000);
        Produit p9 =new Produit("IPhone","ref9","4GB RAM, 6 pouce,Rouge","les produits mobiles","tres performantt  ",110000);
        Produit p10=new Produit("Mac book pro","ref10","32GB RAM gris","les produits informatiques","Plus Rapide que jamais",420000);
        Produit [] TabP = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10};
        for (Produit e : TabP) {
            produits.add(e);}
            Commande cm1 = new Commande (1,"23","06","2021","doudou","alger",p1,1,5000);
            Commande cm2 = new Commande(2,"24","06","2021","belharrat","bejaia",p2,1,75000);
            Commande cm3 = new Commande(3,"20","02","2021","doudou","alger",p7,0,5000);
            Commande cm4 = new Commande (4,"23","03","2021","doudou","alger",p1,1,5000);
            Commande cm5 = new Commande(5,"24","06","2021","belharrat","bejaia",p5,1,10000);
            Commande cm6 = new Commande(6,"19","04","2021","zamil","jijel",p10,1,420000);
            Commande cm7 = new Commande (7,"23","05","2021","zamil","jijel",p6,0,55000);
            Commande cm8 = new Commande(8,"5","06","2021","belharrat","bejaia",p8,0,7000);
            Commande cm9 = new Commande(9,"24","06","2021","doudou","alger",p9,0,110000);
            Commande[] TabCmd= {cm1,cm2,cm3,cm4,cm5,cm6,cm7,cm8,cm9};
            for (Commande c : TabCmd)
                Cmds.add(c);

            Client c1 = new Client("doudou","amir","191931081313","alger",0,0,1,0);
            Client c2 = new Client("belharrat","zidane","191931085131","bejaia",0,0,1,0);
            Client c3 = new Client("dehman","zamil","191931084201","jijel",0,1,0,1);
            Client[] TabC= {c1,c2,c3};
            for (Client c : TabC)
                Clients.add(c);
        }// il ya 3 clients 10 produits disponible et 9 commandes dans notre mini BDD
    }
