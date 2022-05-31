package Classes;

public class CaseFin extends Case 
{
    public final String color="black";


    
    public CaseFin(int num)
    {
        this.num=num;
    }

    
    public void PointeCase ( Joueur j)
    {   /*   int num =100 ; // on vachanger num vers la position de joueur 
        if( num==this.num){
            return true;
        }else return false ;*/
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