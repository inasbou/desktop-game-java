import  java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

/**
 * Write a description of class Partie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Partie
{
    // instance variables - replace the example below with your own
    public Case plateau[] = new Case[100];
    private Joueur joueur; //le seul qui joue à cette partie

    /**
     * Constructor for objects of class Partie
     */
    public Partie(Joueur joueur)
    {
        this.joueur=joueur;
        plateau[0]= new CaseDebut();
        plateau[99]= new CaseFin();
        int indices []= new int [20];
        
        for(int i=0;i<20;i++){
            boolean trouv= true;
            while (trouv==true) { 
                int randnum=ThreadLocalRandom.current().nextInt(1,98);
                int res= Arrays.binarySearch(indices, randnum);
                trouv = res > 0 ? true : false;
                if (trouv==false) {
                    indices[i]=randnum;
                    Arrays.sort(indices);
                }
            }
            if (i<5) {
                //creer une case et lattribuer à plateau [randnum]
                plateau[indices[i]]= new CaseBonus();
            } else if (5<=i & i<10) {
                plateau[indices[i]]= new CaseMalus();
            }  else if (10<=i & i<15) {
                plateau[indices[i]]= new CaseImage();                
            } else if (15<=i & i<20) {
                plateau[indices[i]]= new CaseDefinition();
            }
        }
        
        for (int i=1;i<98;i++) {
            int res= Arrays.binarySearch(indices, i);
            boolean trouv = res > 0 ? true : false;
            if (trouv==false) {
                plateau[i]=new CaseParcours();
            }
        }
    }
    
    public Joueur getJoueur() {
        return this.joueur;
    }
    
    public void setJoueur(Joueur joueur) {
        this.joueur=joueur;
    }

    
    public void TerminerPartie(int y)
    {
        // comparer le score actuelle du joueur avec son meilleur score
        if (joueur.getScore()>joueur.meuilleurScore) {
            Jeu.joueurs_meilleur_score.put(joueur.getNom(), joueur.getScore());
        }
    }
    
    public void PauserPartie(int y)
    {
        // enregistrer position, score, nom du joueur
        // enregistrer le plateau
    }
}
