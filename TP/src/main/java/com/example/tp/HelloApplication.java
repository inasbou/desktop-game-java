package com.example.tp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Classes.*;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Jeu jeu = new Jeu(); // on lance le jeu
        Partie partie = jeu.LancerPartie(); //on lance une nvelle partie contenant le plateau
        Case plateau_code[]= partie.plateau; //le plateau encodé dans un tableau 1d

        GridPane plateau = new GridPane(); //l'interface graphique du plateau
        int count=0;
        for (int i=0;i<10;i++) {
            for (int j=0;j<10;j++) {
                count++;
                plateau.add(new Button(), i, j);

            }
        }





        Group root = new Group();
        //BorderPane panneau=new BorderPane();
        //Créer une scène en passant l’objet Group, la hauteur et la largeur
        Scene scene = new Scene(plateau,600,600);

        //colorer la scène (facultatif)
        scene.setFill(Color.GREEN);

        //Donner un nom au Stage (facultatif)

        stage.setTitle("Première fenêtre");
        //ajouter la scène au Stage
        stage.setScene(scene);
        //Rendre le contenu du Stage visible (montrer le Stage)
        //Text text=new Text();
        //text.setText("hello");
       // root.getChildren().add(text);
        //panneau.setCenter(text);
        //       text.setFont(new Font("Verdana",20));
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
