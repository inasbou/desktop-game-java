package Classes;
public class CaseParcours extends  Case  
{
      public static final String color="white";

    public CaseParcours(int num)
    {
        this.num=num;
    }

    

    public void PointeCase (Joueur j )
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
