package Classes;

import java.util.concurrent.ThreadLocalRandom;

public class CaseSaut extends Case
 {
    // instance variables - replace the example below with your own
    public static final String color="orange" ;

    
    public CaseSaut(int num)
    {
       this.num=num;
    }
    public void PointeCase (Joueur j)
    {
    	int rndnum= ThreadLocalRandom.current().nextInt(-5,5);
        j.deplacer(rndnum);
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
