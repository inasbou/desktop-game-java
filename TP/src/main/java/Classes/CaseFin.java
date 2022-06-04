package Classes;

public class CaseFin extends Case 
{
    public final String color="black";


    
    public CaseFin(int num)
    {
        this.num=num;
    }

    
    public void PointeCase ( Joueur j)
    {
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