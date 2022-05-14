
import java.util.Scanner ;
public class CaseDefinition extends CaseQuestion 
{
      public final String color="bleu" ;
     public String mot ;
     public String definition ;       
    public CaseDefinition( )
    {
        
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
        System.out.println("donner le mot de la definition suivant"+ definition ) ;
       Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir votre réponse :");
           String reponse= sc.next();
           return reponse ;
    }
    public boolean  tester(){
         String reponse = DonnerQuestion (); 
    if (reponse == mot ){
        return true ;
       }else return false ;
}}
