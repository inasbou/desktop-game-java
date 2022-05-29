package Classes;

public class CaseDepart extends Case 
{
    public final String color="yellow";
    public final int num=0 ;

    
    public CaseDepart()
    {}

    
    public void PointeCase ( Joueur j)
    {    /**int num =0 ; // on vachanger num vers la position de joueur 
        if( num==this.num){
            return true;
        }else return false ;*/
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
