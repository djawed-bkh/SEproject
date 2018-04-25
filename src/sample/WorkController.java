package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class WorkController implements Initializable {
    //initialisations
    @FXML
    private TableView<process> wait;

    @FXML
    private Button retour;

    @FXML
    private TableColumn<process, Integer> qtfin;

    @FXML
    private Label turnaround;

    @FXML
    private TableColumn<process, String> etat;

    @FXML
    private TableColumn<process, String> tpro;

    @FXML
    private TableColumn<process, Integer> tarrive;

    private ObservableList<process>waitingprocess= FXCollections.observableArrayList();
    //initialisations



    //initialisation de tableview
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("marche1");

        tpro.setCellValueFactory(cellData-> cellData.getValue().nameProperty());
        tarrive.setCellValueFactory(cellData-> cellData.getValue().arrivalProprety().asObject());
        etat.setCellValueFactory(cellData-> cellData.getValue().etatProperty());
        qtfin.setCellValueFactory(cellData-> cellData.getValue().exittimeProperty().asObject());
    }

    RRfcfs op1=new RRfcfs();
    AceuilleController a=new AceuilleController();
    public void afficher(){
        //op1.rr(waitingprocess,a.getQuantumvariable(),tarrive,);
        wait.setItems(waitingprocess);
    }


}
