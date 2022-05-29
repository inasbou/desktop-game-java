package Classes;

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
        this.plateau[0]= new CaseDepart();
        this.plateau[99]= new CaseFin();

        int indices []= new int [20];

        for(int i=0;i<20;i++){
            boolean trouv= true;
            Arrays.sort(indices);
            while (trouv==true) {
                System.out.println("in while loop ");
                for (int k=0;k<indices.length;k++) {
                    System.out.println("indices----"+Integer.toString(indices[k]));
                }
                int randnum=ThreadLocalRandom.current().nextInt(1,98);
                int res= Arrays.binarySearch(indices, randnum);
                trouv = res >= 0 ? true : false;
                if (trouv==false) {
                    indices[i]=randnum;
                }
            }


            if (i<5) {
                //creer une case et lattribuer à plateau [randnum]
                System.out.println("CAse Bonus"+i);
                this.plateau[indices[i]]= new CaseBonus();
                System.out.println(indices[i]);

            } else if (5<=i && i<10) {
                System.out.println("CAse Malus");
                this.plateau[indices[i]]= new CaseMalus();
                System.out.println(indices[i]);

            }  else if (10<=i && i<15) {
                this.plateau[indices[i]]= new CaseImage();
                System.out.println(indices[i]);

            } else if (15<=i && i<20) {
                this.plateau[indices[i]]= new CaseDefinition();
                System.out.println(indices[i]);

            }
        }
        Arrays.sort(indices);
        for (int k=0;k<20;k++) {
            System.out.println("indices----"+Integer.toString(indices[k]));
        }
        for (int j=1;j<=98;j++) {

            int res= Arrays.binarySearch(indices, j);
            boolean trouv = res > 0 ? true : false;
            if (trouv==false) {
                this.plateau[j]=new CaseParcours();
                System.out.println("parcours-----------"+Integer.toString(j));
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
        if (joueur.getScore()>joueur.meilleurScore) {
            Jeu.joueurs_meilleur_score.put(joueur.getNom(), joueur.getScore());
        }
    }
    
    public void PauserPartie(int y)
    {
        // enregistrer position, score, nom du joueur
        // enregistrer le plateau
    }
}
