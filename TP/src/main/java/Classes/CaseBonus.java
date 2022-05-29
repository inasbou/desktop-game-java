package Classes;

public class CaseBonus extends Case
 {
    // instance variables - replace the example below with your own
    public static final String color="green" ;

    
    public CaseBonus()
    {
    }
    public void PointeCase (Joueur j)
    {
        j.modifScore(10);
        j.deplacer(2);
    }
    public String getColor ()
    {
       return this.color;
    }
    
}