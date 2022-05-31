package Classes;
public class CaseMalus  extends Case 
 {
    // instance variables - replace the example below with your own
    public static final String color="red" ;

    
    public CaseMalus(int num)
    {
        this.num=num;
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
     public int getNum ()
     {
         return this.num;
     }
}
