package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WorkController implements Initializable {
    //initialisations
    @FXML
    private TableView<process> wait;

    @FXML
    private Button retour;
    @FXML
    private Button rr;
    @FXML
    private Button fcfs;
    @FXML
    private TableColumn<process, Integer> qtfin;

    @FXML
    private Label turnaround;


    @FXML
    private Button sjf;

    @FXML
    private TableColumn<process, String> etat;

    @FXML
    private TableColumn<process, String> tpro;

    @FXML
    private TableColumn<process, Integer> tarrive;

    static ObservableList<process>finished= FXCollections.observableArrayList();
    process p=new process();
    Fcfs f=new Fcfs();
    //initialisations




    @Override
    public void initialize(URL location, ResourceBundle resources) {        //methode qui initialise le table view
        System.out.println("marche tableau 2");

        tpro.setCellValueFactory(cellData-> cellData.getValue().nameProperty());
        tarrive.setCellValueFactory(cellData-> cellData.getValue().arrivalProprety().asObject());
      qtfin.setCellValueFactory(cellData-> cellData.getValue().exittimeProperty().asObject());
        etat.setCellValueFactory(cellData-> cellData.getValue().EtatProperty());

    }

    public void afficher(){                 // methode qui affiche les resultats
        System.out.println("ajout donnees");
        wait.setItems(finished);
        System.out.println("ajout donnees post");
    }

    @FXML
    void retour(ActionEvent event) throws IOException {             //boutton de retour a la page d'acceuil
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("verification");
        Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("mainwork");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    @FXML
    void fcfsmet(ActionEvent event) throws InterruptedException {       //fcfs methode
        f.fcfs(AceuilleController.observablepersonne,AceuilleController.quantumvariable,AceuilleController.actualtime,WorkController.finished);
        afficher();

        turnaround.setText(String.valueOf(turnaround()));
    }

        public int turnaround(){        //calcul turn around
        int var=0;
        for (int i=0;i<finished.size();i++){
            var+=finished.get(i).getExittime()-finished.get(i).getArrivalti();
        }
        return var/finished.size();
        }

        SJF s=new SJF();
    @FXML
    void sjfmet(ActionEvent event) {    // sjf methode
    s.sjf(AceuilleController.observablepersonne,AceuilleController.quantumvariable,finished,AceuilleController.actualtime);
    afficher();
    turnaround.setText(String.valueOf(turnaround()));
    }
    RR r=new RR();
    @FXML
    void rrmet(ActionEvent event) {         //round robin methode (bugs)
       r.rr(AceuilleController.observablepersonne,AceuilleController.quantumvariable,finished,AceuilleController.actualtime);
        System.out.println("erreurs");
       afficher();
     turnaround.setText(String.valueOf(turnaround()));
    }


}
