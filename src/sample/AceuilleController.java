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
    int temparrive ,tempburst,pc,tdure;
    private int quantumvariable=1;
    //initialisations + constructor
    // PANNEL1
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
    private MenuItem rrsjf;

    @FXML
    private MenuItem rrfcfs;
    @FXML
    private MenuItem setffcfs;
    @FXML
    private TableColumn<process,Integer> burstcol;
    @FXML
    private TableColumn<process, Integer> dureecol;
    @FXML
    private TableColumn<process,Integer > pccol;
    @FXML
    private ObservableList<process> observablepersonne = FXCollections.observableArrayList();
    @FXML
    private ObservableList<process> waitinglist  = FXCollections.observableArrayList();

    // PANNEL1

    public AceuilleController(){

    }
    //initialisations

    @FXML
    void menubaraction(ActionEvent event) {



    }


    //rajouter des données au tableau
    public void inittable(){

        temparrive= Integer.parseInt(tarrive.getText());
        tempburst=Integer.parseInt(tbrust.getText());
        pc=Integer.parseInt(tpc.getText());
        tdure=Integer.parseInt(tduree.getText());
        observablepersonne.add(new process("porcess"+i++,temparrive,tempburst,pc,tdure));
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
    void stffcfs(ActionEvent event) {
        algo=1;
    }

    @FXML
    void setfsjf(ActionEvent event) {
        algo=2;
    }

    @FXML
    void rrfcfs(ActionEvent event) {
        algo=3;
    }

    @FXML
    void rrsjf(ActionEvent event) {
        algo=4;
    }
    @FXML
    void demare(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("verification");
        Parent root = FXMLLoader.load(getClass().getResource("/sample/work.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("mainwork");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        //lalgo a utiliser
    }


        public void addwainting(){
        for (int i=0;i<=observablepersonne.size();i++){
            if (actualtime>=observablepersonne.get(i).getArrivalti()){
                observablepersonne.get(i).setEtat("waiting");
               // waitinglist.add(observablepersonne.get(i));
                observablepersonne.remove(i);
               // results.setItems(waitinglist);
            }
        }
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("marche1");
        processcol.setCellValueFactory(cellData-> cellData.getValue().nameProperty());
        arrivalcol.setCellValueFactory(cellData-> cellData.getValue().arrivalProprety().asObject());
        burstcol.setCellValueFactory(cellData-> cellData.getValue().BrustProprety().asObject());
        pccol.setCellValueFactory(cellData-> cellData.getValue().tpcProperty().asObject());
        dureecol.setCellValueFactory(cellData-> cellData.getValue().dureeProperty().asObject());
        }



}
