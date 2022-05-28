package Classes;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class CaseImage extends CaseQuestion
{
    // instance variables - replace the example below with your own
    public static final String color="rose"  ;
      public String mot  ;
      public String[] images  ; //tableau de chemains vers les images
      public String  imgCorr  ;
    /**
     * Constructor for objects of class CaseImage
     */
    public CaseImage()
    {

        //String keys[] = new String[]{"Walk", "Eat", "Teacher", "Cat", "Sing", "Study", "Puppy", "Run"};
        //int rnd = new Random().nextInt(keys.length);
        //this.mot= keys[rnd];
        //for (int i=)
        //this.
    }

       public void  PointeCase ( )
    { 
        DonnerQuestion();
        if (tester()== true){
            //Deplecer(4);
            //modifScore(20);
    }else   {} //modifScore(-10)
            }
    public String DonnerQuestion(){
        //System.out.println("choisir l'image correspondante a ce mot " + mot) ;
        //System.out.println("Veuillez cliquer votre réponse :")  ;
        String reponse="" ; // onClick on sauvgarde le nom de l'image 
           return reponse ;
    }
    public boolean  tester(){
         String reponse = DonnerQuestion (); 
    if (reponse == imgCorr ){
        return true ;
       }else return false ;

} }
