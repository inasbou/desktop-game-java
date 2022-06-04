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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Classes.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //construction de la scene
        boolean clique;
        Text score = new Text();
        Text position = new Text("Position actuelle: 0");
        Text destination = new Text("Lancez les dés!");
        score.setText("score: 0");
        Jeu jeu = new Jeu(); // on lance le jeu
        BorderPane main = new BorderPane();


        //construction de la scene du formulaire
        Text t1 = new Text("Bienveue sur Spirale!");
        Text t2 = new Text("Entrez votre nom!");
        TextField nom_input = new TextField("Entrez votre nom..");
        Button valider = new Button("Jouer!");
        VBox panneau = new VBox(t1,t2,nom_input,valider);
        panneau.getStyleClass().add("form_login");

        Scene scene = new Scene(panneau);

        valider.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent actionEvent) {
                    try {
                    jeu.entrerJoueur(nom_input.getText()); }
                    catch (Exception e) {
                        System.out.println("e");
                    }
                    finally {
                        Partie partie = jeu.LancerPartie(nom_input.getText()); //on lance une nvelle partie contenant le plateau
                        HBox entete = new HBox(new Text(partie.getJoueur().getNom()), score, position, destination);
                        entete.getStyleClass().add("entete");
                        main.setTop(entete);
                        //---

                        Case plateau_code[] = partie.plateau; //le plateau encodé dans un tableau 1d
                        StackPane stack = new StackPane(); //stackpane qui va contenir le plateau
                        GridPane plateau = new GridPane(); //l'interface graphique du plateau
                        plateau.setHgap(10);
                        plateau.setVgap(10);

                        //LANCER LES DÉS
                        //--- DE1 et DE2 -------

                        ImageView de1 = new ImageView();
                        ImageView de2 = new ImageView();
                        HBox des = new HBox(de1, de2);
                        des.getStyleClass().add("hbox");
                        //---- button LANCER ------
                        Button lancer = new Button("Lancer");
                        lancer.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent actionEvent) {
                                int valeur_de1= De.lancerDe();
                                int valeur_de2= De.lancerDe();
                                de1.setImage(new Image("file:src/main/java/assets/"+valeur_de1+".png"));
                                de2.setImage(new Image("file:src/main/java/assets/"+valeur_de2+".png"));
                                position.setText("Position actuelle: " + partie.getJoueur().getPosition());
                                partie.getJoueur().setPosition((partie.getJoueur().deplacer(valeur_de1+ valeur_de2)));
                                destination.setText("Partez vers la case: " + partie.getJoueur().getPosition());
                                System.out.println(partie.getJoueur().getPosition());
                            }
                        });
                        //REGROUPER LES DÉS + LE BOUTTON LANCER DANS UN VBOX
                        VBox des_lancer = new VBox(des, lancer);

                        //--FIN----

                        //Remplissage du borderpane
                        main.setCenter(plateau);
                        main.setLeft(des_lancer);

                        //---


                        plateau.setGridLinesVisible(false); //bien definier les bornes du plateau

                        //remplissage du plateau (grid) avec les btns + définition des évenements
                        int count = 0;
                        int a = 0;
                        int b = 9;
                        int col;
                        int l;

                        //Logique de création du plateau
                        while (a <= 4 && b >= 5) {
                            for (l = a; l <= b; l++) {
                                col = a;
                                System.out.println("la ligne est :" + Integer.toString(l));
                                System.out.println("la colone  est :" + Integer.toString(col));

                                Case c = plateau_code[count];
                                Button btn = new Button(Integer.toString(count));
                                btn.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent actionEvent) {
                                        try {
                                            System.out.println(c.getNum());
                                            if (partie.getJoueur().getPosition() == c.getNum()) {
                                                position.setText("Position actuelle: " + partie.getJoueur().getPosition());
                                                c.PointeCase(partie.getJoueur());


                                                if (c.getColor() == "white") {    //si c une case de parcours on demande au joueur de lancer les dés
                                                    destination.setText("Lancez le dé! ");
                                                }
                                                else if (c.getNum()==99) { //case fin
                                                    System.out.println(99);
                                                    try {
                                                        partie.TerminerPartie();}
                                                    catch (Exception e) {
                                                        System.out.println("fichier scores_joueurs n'existe pas");
                                                    }
                                                } else { //on affiche la pos auquelle il doit deplacer sinon
                                                    destination.setText("Partez vers la case: " + partie.getJoueur().getPosition());
                                                }
                                                btn.setGraphic(new ImageView("file:src/main/java/assets/cercle.png")); //set Icon
                                                btn.setGraphicTextGap(3);
                                                score.setText("score: "+partie.getJoueur().getScore());

                                            } else {
                                                throw new CaseErroneeException();
                                            }
                                        } catch (CaseErroneeException e) {
                                            Stage popupwindow = new Stage();
                                            popupwindow.initModality(Modality.APPLICATION_MODAL);
                                            popupwindow.setTitle("Selectionnez la bonne Case!");
                                            HBox container = new HBox(new Text("Veuillez selectionner la bonne case"));
                                            Scene scene1 = new Scene(container, 400, 150);
                                            popupwindow.setScene(scene1);
                                            popupwindow.showAndWait();
                                        }
                                    }
                                });
                                btn.setStyle("-fx-background-color: " + plateau_code[count].getColor() + ";" + "-fx-padding:20px;");
                                plateau.add(btn, col, l);
                                count++;

                            }

                            //2eme boucle
                            for (col = a + 1; col <= b; col++) {
                                l = b;
                                System.out.println("la ligne est :" + Integer.toString(l));
                                System.out.println("la colone  est :" + Integer.toString(col));
                                Case c = plateau_code[count];
                                Button btn = new Button(Integer.toString(count));
                                btn.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent actionEvent) {
                                        try {
                                            System.out.println(c.getNum());
                                            if (partie.getJoueur().getPosition() == c.getNum()) {
                                                position.setText("Position actuelle: " + partie.getJoueur().getPosition());
                                                c.PointeCase(partie.getJoueur());


                                                if (c.getColor() == "white") {    //si c une case de parcours on demande au joueur de lancer les dés
                                                    destination.setText("Lancez le dé! ");
                                                }
                                                else if (c.getNum()==99) { //case fin
                                                    System.out.println(99);
                                                    try {
                                                        partie.TerminerPartie();}
                                                    catch (Exception e) {
                                                        System.out.println("fichier scores_joueurs n'existe pas");
                                                    }
                                                } else { //on affiche la pos auquelle il doit deplacer sinon
                                                    destination.setText("Partez vers la case: " + partie.getJoueur().getPosition());
                                                }
                                                btn.setGraphic(new ImageView("file:src/main/java/assets/cercle.png")); //set Icon
                                                btn.setGraphicTextGap(3);
                                                score.setText("score: "+partie.getJoueur().getScore());

                                            } else {
                                                throw new CaseErroneeException();
                                            }
                                        } catch (CaseErroneeException e) {
                                            Stage popupwindow = new Stage();
                                            popupwindow.initModality(Modality.APPLICATION_MODAL);
                                            popupwindow.setTitle("Selectionnez la bonne Case!");
                                            HBox container = new HBox(new Text("Veuillez selectionner la bonne case"));
                                            Scene scene1 = new Scene(container, 400, 150);
                                            popupwindow.setScene(scene1);
                                            popupwindow.showAndWait();
                                        }
                                    }
                                });
                                btn.setStyle("-fx-background-color: " + plateau_code[count].getColor() + ";" + "-fx-padding:20px;");
                                plateau.add(btn, col, l);
                                count++;

                            }


                            //3ème boucle
                            for (l = b - 1; l >= a; l--) {
                                System.out.println("la ligne est :" + Integer.toString(l));
                                System.out.println("la colone  est :" + Integer.toString(col));
                                col = b;
                                Case c = plateau_code[count];
                                Button btn = new Button(Integer.toString(count));
                                btn.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent actionEvent) {
                                        try {
                                            System.out.println(c.getNum());
                                            if (partie.getJoueur().getPosition() == c.getNum()) {
                                                position.setText("Position actuelle: " + partie.getJoueur().getPosition());
                                                c.PointeCase(partie.getJoueur());


                                                if (c.getColor() == "white") {    //si c une case de parcours on demande au joueur de lancer les dés
                                                    destination.setText("Lancez le dé! ");
                                                }
                                                else if (c.getNum()==99) { //case fin
                                                    System.out.println(99);
                                                    try {
                                                        partie.TerminerPartie();}
                                                    catch (Exception e) {
                                                        System.out.println("fichier scores_joueurs n'existe pas");
                                                    }
                                                } else { //on affiche la pos auquelle il doit deplacer sinon
                                                    destination.setText("Partez vers la case: " + partie.getJoueur().getPosition());
                                                }
                                                btn.setGraphic(new ImageView("file:src/main/java/assets/cercle.png")); //set Icon
                                                btn.setGraphicTextGap(3);
                                                score.setText("score: "+partie.getJoueur().getScore());

                                            } else {
                                                throw new CaseErroneeException();
                                            }
                                        } catch (CaseErroneeException e) {
                                            Stage popupwindow = new Stage();
                                            popupwindow.initModality(Modality.APPLICATION_MODAL);
                                            popupwindow.setTitle("Selectionnez la bonne Case!");
                                            HBox container = new HBox(new Text("Veuillez selectionner la bonne case"));
                                            Scene scene1 = new Scene(container, 400, 150);
                                            popupwindow.setScene(scene1);
                                            popupwindow.showAndWait();
                                        }
                                    }
                                });
                                btn.setStyle("-fx-background-color: " + plateau_code[count].getColor() + ";" + "-fx-padding:20px;");
                                plateau.add(btn, col, l);
                                count++;

                            }


                            //4ème boucle
                            for (col = b - 1; col >= a + 1; col--) {
                                System.out.println("la ligne est :" + Integer.toString(l));
                                System.out.println("la colone  est :" + Integer.toString(col));
                                l = a;
                                Case c = plateau_code[count];
                                Button btn = new Button(Integer.toString(count));
                                btn.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent actionEvent) {
                                        try {
                                            System.out.println(c.getNum());
                                            if (partie.getJoueur().getPosition() == c.getNum()) {
                                                position.setText("Position actuelle: " + partie.getJoueur().getPosition());
                                                c.PointeCase(partie.getJoueur());


                                                if (c.getColor() == "white") {    //si c une case de parcours on demande au joueur de lancer les dés
                                                    destination.setText("Lancez le dé! ");
                                                }
                                                else if (c.getNum()==99) { //case fin
                                                    System.out.println(99);
                                                    try {
                                                        partie.TerminerPartie();}
                                                    catch (Exception e) {
                                                        System.out.println("fichier scores_joueurs n'existe pas");
                                                    }
                                                } else { //on affiche la pos auquelle il doit deplacer sinon
                                                    destination.setText("Partez vers la case: " + partie.getJoueur().getPosition());
                                                }
                                                btn.setGraphic(new ImageView("file:src/main/java/assets/cercle.png")); //set Icon
                                                btn.setGraphicTextGap(3);
                                                score.setText("score: "+partie.getJoueur().getScore());

                                            } else {
                                                throw new CaseErroneeException();
                                            }
                                        } catch (CaseErroneeException e) {
                                            Stage popupwindow = new Stage();
                                            popupwindow.initModality(Modality.APPLICATION_MODAL);
                                            popupwindow.setTitle("Selectionnez la bonne Case!");
                                            HBox container = new HBox(new Text("Veuillez selectionner la bonne case"));
                                            Scene scene1 = new Scene(container, 400, 150);
                                            popupwindow.setScene(scene1);
                                            popupwindow.showAndWait();
                                        }
                                    }
                                });
                                btn.setStyle("-fx-background-color: " + plateau_code[count].getColor() + ";" + "-fx-padding:20px;");
                                plateau.add(btn, col, l);
                                count++;

                            }

                            a++;
                            b--;


                        }


                        //ajouter le plateau à stackpane
                        stack.getChildren().add(main);
                        //------le centrer^----------

                        Scene scene = new Scene(stack, 1000, 1000); //la scene contenant tout le contenu
                        scene.getStylesheets().add("file:src/main/java/css/style.css");
                        stage.setTitle("Jeu Spirale");
                        stage.setScene(scene);
                        stage.show();


                        //Donner un nom au Stage (facultatif)


                        //ajouter la scène au Stage
                    }
        } });

        scene.getStylesheets().add("file:src/main/java/css/style.css");
        stage.setTitle("Jeu Spirale");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
