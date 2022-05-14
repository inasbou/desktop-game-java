import java.util.*;
/**
 * Write a description of class Jeu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jeu
{
    // instance variables - replace the example below with your own
    public static final Map <String, String> mots_def = new HashMap<String, String>();
    public static final Map <String, String> mots_imgs = new HashMap<String, String>();
    public static Map <String, Integer> joueurs_meilleur_score = new HashMap<String, Integer>();



    /**
     * Constructor for objects of class Jeu
     */
    public Jeu()
    {
        //init img_mots
        mots_imgs.put("Walk", "path1");
        mots_imgs.put("Eat", "path2");
        mots_imgs.put("Study", "path3");
        mots_imgs.put("Run", "path4");
        //init def_mots
        mots_def.put("Walk", "temchi");
        mots_def.put("Eat", "takel");
        mots_def.put("Study", "teqra");
        mots_def.put("Run", "tegri");
    }

    
    
    public void LancerPartie()
    {
        // put your code here
        // la variable j: represente le joueur authentifié
        Partie p= new Partie(j);
        //Case c= p.plateau[0];
    }
    
    public void entrerJoueur () {
        //obtenir le nom du joueur d'apres un formulaire
        //si le joueur existe on le fait entrer normalement
        //si le joueur n'existe pas on va le créer /l'ajouter à la map)
        //cette methode appelle lancerPartie
    }
}
