
class Joueur
{
    // instance variables - replace the example below with your own
    private String nom;
    private int score;
    private int position; //indice dans la table partie
    public int meuilleurScore;
    

    /**
     * Constructor for objects of class Joueur
     */
    public Joueur(String nom, int score, int position) //au debut (nom, 0, 0)
    {
        // initialise instance variables
        this.nom=nom;
        this.score=score;
        this.position=position;
        this.meuilleurScore=Jeu.joueurs_meilleur_score.get(this.nom);
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom=nom;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public void setScore(int score) {
        this.score=score;
    }
    
    
    public int getPosition() {
        return this.position;
    }
    
    public void setPosition(int position) {
        this.position=position;
    }
    
    public void modifScore(int plus) { //plus est soit negatif ou positif
        this.score+=plus;
    }

    
    public void deplacer(int depl)
    {
        // put your code here
        int nv_pos= this.position + depl;
        if (nv_pos>100){
            int nb_recul=100-(this.position+depl-100);
            this.position-=nb_recul;
        } else if (nv_pos==100){
            //appelle fin partie
        }else{
            this.position=nv_pos;
        }
    }
    
    public int lancer() {
        return De.lancerDe()+De.lancerDe();
    }
}
