public class CaseImage extends CaseQuestion 
{
    // instance variables - replace the example below with your own
    public static final String color="Rose"  ;
      public String mot  ;
      public String[] images  ;
      public String  imgCorr  ;
    /**
     * Constructor for objects of class CaseImage
     */
    public CaseImage()
    {
    // on doit appeler la map pour utiliser une enregistrement mot  ,tableau et les affecter aaux attributs 
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
        System.out.println("choisir l'image correspondante a ce mot " + mot) ;  
        System.out.println("Veuillez cliquer votre réponse :")  ;
        String reponse="" ; // onClick on sauvgarde le nom de l'image 
           return reponse ;
    }
    public boolean  tester(){
         String reponse = DonnerQuestion (); 
    if (reponse == imgCorr ){
        return true ;
       }else return false ;

} }
