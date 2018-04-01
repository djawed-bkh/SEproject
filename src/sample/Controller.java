package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    //initialisations + constructor
    private Main mainapp;
    @FXML
    private TextField tarrive;
    @FXML
    private TextField tbrust;
    @FXML
    private Button ajoutprocess;
    @FXML
    private TableView<process> table;
    @FXML
    private TableColumn<process,String> processcol;
    @FXML
    private TableColumn<process,Integer> arrivalcol;
    @FXML
    private TableColumn<process,Integer> brustcol;

    public Controller(){

    }

    process p=new process();
    private ObservableList<process> pr= FXCollections.observableArrayList();
    //initialisations

    private void initialize(){
        processcol.setCellValueFactory(cellData-> cellData.getValue().nameProperty());
        arrivalcol.setCellValueFactory(cellData-> cellData.getValue().arrivalProprety().asObject());
        brustcol.setCellValueFactory(cellData-> cellData.getValue().BrustProprety().asObject());
    }


    public void setMainapp(){
        this.mainapp=mainapp;
        table.setItems(mainapp.getpr());
    }
    public void addproc(ActionEvent event){
        pr.add(new process("p1",12,0));
        System.out.println(tarrive.getText());}
    public ObservableList<process> getPr() {
        return pr;}

}
