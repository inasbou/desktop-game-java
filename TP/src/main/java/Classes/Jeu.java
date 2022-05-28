package Classes;
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
        mots_imgs.put("Walk", "assets/walk.jpg");
        mots_imgs.put("Eat", "assets/eat.jpg");
        mots_imgs.put("Teacher", "assets/teacher.jpg");
        mots_imgs.put("Cat", "assets/cat.jpg");
        mots_imgs.put("Sing", "assets/sing.png");
        mots_imgs.put("Study", "assets/study.jpg");
        mots_imgs.put("Puppy", "assets/puppy.jpg");
        mots_imgs.put("Run", "assets/run.jpg");
        //init def_mots
        mots_def.put("Walk", "Marcher");
        mots_def.put("Eat", "Manger");
        mots_def.put("Teacher", "Enseignant");
        mots_def.put("Cat", "Chat");
        mots_def.put("Sing", "Chanter");
        mots_def.put("Study", "Etudier");
        mots_def.put("Puppy", "Chien");
        mots_def.put("Run", "Courrir");
    }

    
    
    public Partie LancerPartie()
    {
        // put your code here
        // la variable j: represente le joueur authentifié
        Joueur j= new Joueur("Latif", 0,0);
        Partie p= new Partie(j);
        return p;
        //Case c= p.plateau[0];
    }
    
    public void entrerJoueur () {
        //obtenir le nom du joueur d'apres un formulaire
        //si le joueur existe on le fait entrer normalement
        //si le joueur n'existe pas on va le créer /l'ajouter à la map)
        //cette methode appelle lancerPartie
    }
}
