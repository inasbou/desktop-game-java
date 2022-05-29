package Classes;
public class CaseMalus  extends Case 
 {
    // instance variables - replace the example below with your own
    public static final String color="orange" ;

    
    public CaseMalus()
    {
    }
    public void PointeCase (Joueur j)
    {
        j.modifScore(-10);
        j.deplacer(-2);
    }

    @Override
    public String getColor() {
       return this.color;
    }
    
}
