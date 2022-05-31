package com.example.tp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Classes.*;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //construction de la scene
        Text score = new Text();
        Text position = new Text();
        Text destination = new Text();
        score.setText("0");
        Jeu jeu = new Jeu(); // on lance le jeu
        BorderPane main = new BorderPane();
        Partie partie = jeu.LancerPartie(); //on lance une nvelle partie contenant le plateau
        HBox entete = new HBox(new Text(partie.getJoueur().getNom()), score, position,destination);
        entete.getStyleClass().add("entete");
        main.setTop(entete);
        //---

        Case plateau_code[]= partie.plateau; //le plateau encodé dans un tableau 1d
        StackPane stack = new StackPane(); //stackpane qui va contenir le plateau
        GridPane plateau = new GridPane(); //l'interface graphique du plateau
        plateau.setHgap(10);
        plateau.setVgap(10);

        //LANCER LES DÉS
            //--- DE1 et DE2 -------
            Text de1 = new Text();
            Text de2 = new Text();
            HBox des = new HBox(de1, de2);
            des.getStyleClass().add("hbox");
            //---- button LANCER ------
            Button lancer= new Button ("Lancer");
            lancer.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent actionEvent) {
                    de1.setText(Integer.toString(De.lancerDe()));
                    de2.setText(Integer.toString(De.lancerDe()));
                    position.setText("Position actuelle: "+partie.getJoueur().getPosition());
                    partie.getJoueur().setPosition((partie.getJoueur().deplacer(Integer.parseInt(de1.getText())+Integer.parseInt((de2.getText())))));
                    destination.setText("Partez vers la case: "+partie.getJoueur().getPosition());
                    System.out.println(partie.getJoueur().getPosition());
            }});
            //REGROUPER LES DÉS + LE BOUTTON LANCER DANS UN VBOX
            VBox des_lancer = new VBox(des,lancer);

        //--FIN----

        //HBox plateau_des = new HBox(plateau);
        main.setCenter(plateau);
        main.setLeft(des_lancer);

        //---


        plateau.setGridLinesVisible(false); //bien definier les bornes du plateau

        //remplissage du plateau (grid) avec les btns + définition des évenements
        int count=0;
        for (int i=0;i<10;i++) {
            for (int j=0;j<10;j++) {

                Case c=plateau_code[count] ;
                Button btn = new Button(Integer.toString(count));
                btn.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent actionEvent) {
                        try{
                            System.out.println(c.getNum());
                            if (partie.getJoueur().getPosition() == c.getNum()) {
                                position.setText("Position actuelle: "+partie.getJoueur().getPosition());
                                c.PointeCase(partie.getJoueur());


                                if (c.getColor()=="white") {    //si c une case de parcours on demande au joueur de lancer les dés
                                    destination.setText("Lancez le dé! ");
                                }else { //on affiche la pos auquelle il doit deplacer sinon
                                    destination.setText("Partez vers la case: "+partie.getJoueur().getPosition());
                                }
                                btn.setText("+");
                                score.setText(Integer.toString(partie.getJoueur().getScore()));

                            } else {
                                throw new CaseErroneeException();
                            }
                        }catch (CaseErroneeException e) {
                            Stage popupwindow=new Stage();
                            popupwindow.initModality(Modality.APPLICATION_MODAL);
                            popupwindow.setTitle("Selectionnez la bonne Case!");
                            HBox container = new HBox (new Text("Veuillez selectionner la bonne case"));
                            Scene scene1= new Scene(container, 400, 150);
                            popupwindow.setScene(scene1);
                            popupwindow.showAndWait();
                        }
                }});
                btn.setStyle("-fx-background-color: "+plateau_code[count].getColor()+";"+"-fx-padding:20px;");
                plateau.add(btn, i, j);
                count++;

            }
        }



        //ajouter le plateau à stackpane
        stack.getChildren().add(main);
        //------le centrer^----------

        Scene scene = new Scene(stack,1000,1000); //la scene contenant tout le contenu
        scene.getStylesheets().add("file:src/main/java/css/style.css");
        //colorer la scène (facultatif)
        scene.setFill(Color.GREEN);

        //Donner un nom au Stage (facultatif)

        stage.setTitle("Première fenêtre");
        //ajouter la scène au Stage
        stage.setScene(scene);

        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
