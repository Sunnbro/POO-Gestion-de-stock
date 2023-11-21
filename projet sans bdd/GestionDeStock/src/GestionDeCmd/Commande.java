package GestionDeCmd;
import GestionDeProduit.*;

public class Commande {


    public int Code ;// ce code est unique pour chaque commande
    public  Produit ProCmd ;

    public  int  Validée =-1; // pour savoir si une commande est satisfaite ou en instance
    public String Cli =null;
    public String jour =null;
    public String mois =null;
    public String ans =null;
    public String ville =null;
    float PRIX =0;
    //-------------------------------------------------------------------------------------------
    public Commande () {} // le constructeur vide
    public Commande (int Code,String jour,String mois,String ans,String Cli,String ville ,Produit ProCmd,int  Validée,float PRIX) {// le constructeur qui permet de remplire La BDD
        this.Code=Code;
        this.Validée=Validée;
        this.Cli=Cli;
        this.jour=jour ;
        this.mois=mois ;
        this.ans= ans;
        this.ville= ville;
        this.PRIX=PRIX;
        this.ProCmd=ProCmd;
    }

    //--------------------------------------------------------------------------------------------
    public Produit getProCmd(){return ProCmd;}
    public int  getVald(){return Validée;}
    public int  getCode(){return Code;}
    public String getCli(){return Cli;}
    public String getjour (){return jour  ;}
    public String getmois (){return mois ;}
    public String getans (){return  ans ;}
    public String getville (){return ville  ;}
    public float getPRIX(){return PRIX;}
    public void  setCode(int Code){this.Code=Code;}
    public void  setVald(int Validée){this.Validée=Validée;}
    public void setClis(String Cli){this.Cli=Cli;}
    public void setjour (String jour){this.jour=jour ;}
    public void setmois (String mois){this.mois=mois ;}
    public void setans (String ans){this.ans= ans;}
    public void setville(String ville ){this.ville= ville;}
    public void setPRIX(float PRIX){this.PRIX=PRIX;}
    public void setProCmd(Produit ProCmd){this.ProCmd=ProCmd;}
    //----------------------------------------------------------------------------------------------------
    public void AfficherCMD()// affiche une seule commande
    {   System.out.println(ans+"/"+mois+"/"+jour);
        System.out.println("La Commande numero   : " + Code);
        System.out.println("Le Nom du Client   : " + Cli);
        System.out.println("Le Prix Totale de vos achats est de  : " + PRIX);
    }
    public void AfficherCmds()// affiche la liste des commande
    {   System.out.println("Le Nom du Client   : " + Cli);
        System.out.println("Le Produit : " + ProCmd );
        System.out.println("Le prix du produit    : " + ProCmd.getPrixprod());
    }

}



