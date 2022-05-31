package Classes;

public class CaseDepart extends Case 
{
    public final String color="yellow";


    
    public CaseDepart(int num)
    {
        this.num=num;
    }

    
    public void PointeCase ( Joueur j)
    {
        j.setScore(0);
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
