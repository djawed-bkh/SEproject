package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AceuilleController implements Initializable{
    static int actualtime=0;
    static int algo;
    static int i=0;
    static int temparrive ,tempburst,pc,tdure;
    static int quantumvariable=1;
    //initialisations
    @FXML
    private TextField tarrive;

    @FXML
    private  Menu systeme;
    @FXML
    private TextField quantumin;

    public int getQuantumvariable() {
        return quantumvariable;
    }

    public void setQuantumvariable(int quantumvariable) {
        this.quantumvariable = quantumvariable;
    }

    @FXML
    private TextField tbrust;
    @FXML
    private TextField tduree;
    @FXML
    private TextField tpc;
    @FXML
    private Button quantumbutton;
    @FXML
    private Button demarrer;
    @FXML
    private Button ajoutprocess;
    @FXML
    private TableView<process> tprocess;
    @FXML
    private TableColumn<process,String> processcol;
    @FXML
    private TableColumn<process,Integer> arrivalcol;
    @FXML
    private MenuBar menuBar=new MenuBar();
    @FXML
    private MenuItem setfsjf;
    @FXML
    private MenuItem vider;
    @FXML
    private MenuItem rrsjf;

    @FXML
    private MenuItem rrfcfs;
    @FXML
    private MenuItem setffcfs;
    @FXML
    private MenuItem random;
    @FXML
    private TableColumn<process,Integer> burstcol;
    @FXML
    private TableColumn<process, Integer> dureecol;
    @FXML
    private TableColumn<process,Integer > pccol;
    @FXML
     static ObservableList<process> observablepersonne = FXCollections.observableArrayList();
    @FXML
    private ObservableList<process> waitinglist  = FXCollections.observableArrayList();

    //initialisations

    @FXML
    void menubaraction(ActionEvent event) {



    }



    public void inittable(){ //methode pour rajouter des données au tableau

        temparrive= Integer.parseInt(tarrive.getText());
        tempburst=Integer.parseInt(tbrust.getText());
        pc=Integer.parseInt(tpc.getText());
        tdure=Integer.parseInt(tduree.getText());
        observablepersonne.add(new process("porcess"+i++,temparrive,tempburst,pc,tdure,0,0,"terminé"));
        tprocess.setItems(observablepersonne);
    }

    public void initdata(ActionEvent event){//remplir le tableau
        inittable();
          }

          //precision du quantum
    @FXML
    void quantumvalidate(ActionEvent event){
        quantumvariable= Integer.parseInt(quantumin.getText());
    }


    @FXML
    void demare(ActionEvent event) throws IOException, InterruptedException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("verification");
        Parent root = FXMLLoader.load(getClass().getResource("/sample/work.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("mainwork");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
       /*switch (algo){
           case 1:;break;
           case 2:;break;
         case 3:f1.fcfs(observablepersonne,quantumvariable,actualtime,WorkController.finished);break;
           case 4:;break;
       }*/
    }



       @FXML
       void vider(ActionEvent event) { // methode qui vide le tableau
                observablepersonne.removeAll(observablepersonne);
       }
    @FXML
    void remprand(ActionEvent event) {    // methode pour remplir le tableau automatiquement
           for (int i=0;i<=10;i++){
               observablepersonne.add(new process("porcessrand"+i,5+i,10+i,20-i,5+i,0,0,"terminé"));
               tprocess.setItems(observablepersonne);
           }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {  // methode pour initialiser le table view
        System.out.println("marche1");
        processcol.setCellValueFactory(cellData-> cellData.getValue().nameProperty());
        arrivalcol.setCellValueFactory(cellData-> cellData.getValue().arrivalProprety().asObject());
        burstcol.setCellValueFactory(cellData-> cellData.getValue().BrustProprety().asObject());
        pccol.setCellValueFactory(cellData-> cellData.getValue().tpcProperty().asObject());
        dureecol.setCellValueFactory(cellData-> cellData.getValue().dureeProperty().asObject());
        }



}
