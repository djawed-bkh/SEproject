package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable,Runnable{
    static int actualtime=0;
    static int i=0;
    int temparrive ,tempburst,pc,tdure;
    private int quantumvariable;
    //initialisations + constructor
    // PANNEL1
    @FXML
    private MenuItem rr;
    @FXML
    private MenuItem fcfs;
    @FXML
    private MenuItem sjfes;
    @FXML
    private MenuItem sjf;
    @FXML
    private TextField tarrive;
    @FXML
    private MenuBar menuBar=new MenuBar();
    @FXML
    private  Menu systeme;
    @FXML
    private Menu es;
    @FXML
    private Menu quantum;
    @FXML
    private TextField quantumin;
    @FXML
    private Button quantumbutton;
    @FXML
    private TextField tbrust;
    @FXML
    private TextField tduree;
    @FXML
    private TextField tpc;
    @FXML
    private Button ajoutprocess;
    @FXML
    private TableView<process> tprocess;
    @FXML
    private TableColumn<process,String> processcol;
    @FXML
    private TableColumn<process,Integer> arrivalcol;
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
    // PANEL 2
    @FXML
    private TableView<process> results;
    @FXML
    private TableColumn<process, String > presult;

    @FXML
    private TableColumn<process, String> etat;

    @FXML
    private TableColumn<process, Integer> tdebut;
    @FXML
    private TableColumn<process, Integer> tfin;


    // PANEL 2


    public Controller(){

    }
    //initialisations

    //Threads


    //Threads
    @FXML
    void menubaraction(ActionEvent event) {



    }


    public void initdata(ActionEvent event){//remplir le tableau
        run();

          }
    @FXML
    void quantumvalidate(ActionEvent event){
        quantumvariable= Integer.parseInt(quantumin.getText());
    }

    @FXML
    void roundrobin(ActionEvent event) {
        System.out.println("rr methode");
    }

    @FXML
    void sjfmet(ActionEvent event) {
        System.out.println("sjf methode");
        waitinglist.add(new process());
    }
    @FXML
    void fcfsmet(ActionEvent event) {

    }

    @FXML
    void sjfmetes(ActionEvent event) {
        System.out.println("sjf methode");
    }


        public void addwainting(){
        for (int i=0;i<=observablepersonne.size();i++){
            if (actualtime>=observablepersonne.get(i).getArrivalti()){
                observablepersonne.get(i).setEtat("waiting");
                waitinglist.add(observablepersonne.get(i));
                observablepersonne.remove(i);
                results.setItems(waitinglist);
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

        presult.setCellValueFactory(cellData-> cellData.getValue().nameProperty());
        tdebut.setCellValueFactory(cellData-> cellData.getValue().arrivalProprety().asObject());
        etat.setCellValueFactory(cellData-> cellData.getValue().etatProperty());
        tfin.setCellValueFactory(cellData-> cellData.getValue().exittimeProperty().asObject());
        }


    @Override
    public void run() {
        synchronized (this){

        }
        temparrive= Integer.parseInt(tarrive.getText());
        tempburst=Integer.parseInt(tbrust.getText());
        pc=Integer.parseInt(tpc.getText());
        tdure=Integer.parseInt(tduree.getText());
        observablepersonne.add(new process("porcess"+i++,temparrive,tempburst,pc,tdure));
        waitinglist.add(observablepersonne.get(i));
        results.setItems(waitinglist);
        tprocess.setItems(observablepersonne);
    }

}
