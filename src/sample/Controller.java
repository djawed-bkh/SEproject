package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

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
    private ObservableList<process> inputOutputPersonne  = FXCollections.observableArrayList();
    private ArrayList<process> waitinglist;

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
    final Handler handler = new Handler() {
        @Override
        public void publish(LogRecord record) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };

    public Controller(){

    }
    //initialisations

    //Threads

    Thread addpro=new Thread();
    //Threads
    @FXML
    void menubaraction(ActionEvent event) {
        /*ToggleGroup tGroup=new ToggleGroup();
        RadioMenuItem rr=new RadioMenuItem("Round Robin");
        rr.setToggleGroup(tGroup);
        rr.setSelected(true);

        RadioMenuItem sjf=new RadioMenuItem("Sjf");
        sjf.setToggleGroup(tGroup);
        sjf.setSelected(true);
        quantum.getItems().addAll(rr,sjf,new SeparatorMenuItem());

        menuBar.getMenus().addAll(systeme);
       // menuBar.addEventHandler(new EventType<>());*/
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

    }

    @FXML
    void sjfmet(ActionEvent event) {

    }
    @FXML
    void fcfsmet(ActionEvent event) {

    }

    @FXML
    void sjfmetes(ActionEvent event) {

    }


        public void addwainting(){
        for (int i=0;i<=observablepersonne.size();i++){
            if (actualtime>=observablepersonne.get(i).getArrivalti()){
                waitinglist.add(observablepersonne.get(i));
                observablepersonne.remove(i);
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

    @Override
    public void run() {
        temparrive= Integer.parseInt(tarrive.getText());
        tempburst=Integer.parseInt(tbrust.getText());
        pc=Integer.parseInt(tpc.getText());
        tdure=Integer.parseInt(tduree.getText());
        observablepersonne.add(new process("porcess"+i++,temparrive,tempburst,pc,tdure));


        tprocess.setItems(observablepersonne);
    }
}
