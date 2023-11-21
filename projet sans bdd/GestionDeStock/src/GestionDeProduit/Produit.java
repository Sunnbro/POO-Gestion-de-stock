package GestionDeProduit;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class Produit {static Scanner sc = new Scanner(System.in);


    private String Nomprod;
    private String refprod;
    private String Specprod;
    private String catprod;
    private String descprod;
    private int prixprod;
    private int NbrVent;
    public static ArrayList<Produit> produits = new ArrayList<>();
    //---------------------------------------------------------------------------
    public Produit()
    {}
    public Produit(String Nomprod,String refprod,String Specprod,String catprod,String descprod, int prixprod)// permet de remplire la BDD
    {this.Nomprod=Nomprod;
        this.refprod=refprod;
        this.Specprod=Specprod;
        this.catprod=catprod;
        this.descprod=descprod;
        this.prixprod=prixprod;}
    //-------------------------------------------------------------------
    public String getNomprod(){return Nomprod;}
    public String getRefprod(){return refprod;}
    public String getSpec0prod(){return Specprod;}
    public String getCatprod(){return catprod;}
    public String getDescprod(){return descprod;}
    public float getPrixprod(){return prixprod;}
    public int getNbrVent(){return NbrVent;}
    public void setSpecprod(String Specprod) {this.Specprod=Specprod;}
    public void setNomprod(String Nomprod){this.Nomprod=Nomprod;}
    public void setrefprod(String refprod){this.refprod=refprod;}
    public void setcatprod(String catprod){this.catprod=catprod;}
    public void setdescprod(String descprod){this.descprod=descprod;}
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

//-----------------------------------------------------------------------------------------
}


