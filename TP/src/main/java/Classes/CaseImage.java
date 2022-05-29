package Classes;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class CaseImage extends CaseQuestion
{
    // instance variables - replace the example below with your own
    public static final String color="pink"  ;
      public String mot  ;
      public String images[] = new String[4]  ; //tableau de chemains vers les images
      public String  imgCorr  ;
       static int qstpos=0;
    /**
     * Constructor for objects of class CaseImage
     */
    public CaseImage()
    {

        String keys[] = new String[]{"Walk", "Eat", "Teacher", "Cat", "Sing", "Study", "Puppy", "Run"};
        //int rnd = new Random().nextInt(keys.length);
        //this.mot= keys[rnd];
        //for (int i=)
        //this.
        this.qstpos=(this.qstpos+1)%8;
        this.mot=keys[qstpos];
        this.imgCorr=Jeu.mots_imgs.get(this.mot);
        this.images[2]=this.imgCorr;
        this.images[0]=Jeu.mots_imgs.get(keys[(qstpos+1)%8]);
        this.images[1]=Jeu.mots_imgs.get(keys[(qstpos+2)%8]);
        this.images[3]=Jeu.mots_imgs.get(keys[(qstpos+3)%8]);

    }

       public void  PointeCase ( Joueur j)
    { 
        DonnerQuestion();
        if (tester()== true){
            j.deplacer(4);
            j.modifScore(20);
        }else{
            j.modifScore(-10);
            }
    }
    public String DonnerQuestion(){
        System.out.println("choisir l'image correspondante a ce mot " + this.mot) ;
        System.out.println("Veuillez cliquer votre réponse :")  ;
        String reponse="" ; // onClick on sauvgarde le nom de l'image 
           return reponse ;
    }
    public boolean  tester(){
         String reponse = DonnerQuestion (); 
    if (reponse == imgCorr ){
        return true ;
       }else return false ;

}

    @Override
    public String getColor() {
        return this.color;
    }}
