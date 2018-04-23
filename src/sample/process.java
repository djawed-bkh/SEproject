package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class process {
    public boolean isCpu() {
        return cpu;
    }

    public void setCpu(boolean cpu) {
        this.cpu = cpu;
    }

    public boolean isEs() {
        return es;
    }

    public void setEs(boolean es) {
        this.es = es;
    }

    public boolean isPassedes() {
        return passedes;
    }

    public void setPassedes(boolean passedes) {
        this.passedes = passedes;
    }

    private boolean passedes;
    private StringProperty name;
    private IntegerProperty arrivalti;
    private IntegerProperty brust;
    private IntegerProperty exittime;
    private IntegerProperty tempscpu;
    private IntegerProperty tpc;
    private IntegerProperty duree;
    private int tempsecoule=0;
    private boolean cpu;
    private boolean es;
    private StringProperty etat;
   private ArrayList<Integer> estime;
 //getters and setters and constructor

    public int getTempsecoule() {
        return tempsecoule;
    }

    public void setTempsecoule(int tempsecoule) {
        this.tempsecoule = tempsecoule;
    }

    public process(boolean passedes, StringProperty name, IntegerProperty arrivalti, IntegerProperty brust, IntegerProperty exittime, IntegerProperty tempscpu, IntegerProperty tpc, IntegerProperty duree, int tempsecoule, boolean cpu, boolean es, StringProperty etat, ArrayList<Integer> estime) {
        this.passedes = passedes;
        this.name = name;
        this.arrivalti = arrivalti;
        this.brust = brust;
        this.exittime = exittime;
        this.tempscpu = tempscpu;
        this.tpc = tpc;
        this.duree = duree;
        this.tempsecoule = tempsecoule;
        this.cpu = cpu;
        this.es = es;
        this.etat = etat;
        this.estime = estime;
    }

    //constructors
    public process(){

    StringProperty name=this.name;
    IntegerProperty arrivalti=this.arrivalti;
    IntegerProperty brust=this.brust;
    }

    public process(String name, int arrivalti, int brust, int tpc,int duree) {
        this.name = new SimpleStringProperty(name);
        this.arrivalti = new SimpleIntegerProperty(arrivalti);
        this.brust = new SimpleIntegerProperty(brust);
        this.tpc=new SimpleIntegerProperty(tpc);
        this.duree=new SimpleIntegerProperty(duree);
    }
    //constructors
    //getters+setters

    public String getName() {
        return name.get();
    }

    public ArrayList<Integer> getEstime() {
        return estime;
    }

    public void setEstime(ArrayList<Integer> estime) {
        this.estime = estime;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;

    }

    public int getExittime() {
        return exittime.get();
    }

    public int getTcp() {
        return tpc.get();
    }

    public IntegerProperty tpcProperty() {
        return tpc;
    }

    public void setTpc(int tpc) {
        this.tpc.set(tpc);
    }

    public int getDuree() {
        return duree.get();
    }

    public IntegerProperty dureeProperty() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree.set(duree);
    }

    public IntegerProperty exittimeProperty() {

        return exittime;
    }

    public void setExittime(int exittime) {
        this.exittime.set(exittime);
    }

    public int getTempscpu() {
        return tempscpu.get();
    }

    public IntegerProperty tempscpuProperty() {
        return tempscpu;
    }

    public void setTempscpu(int tempscpu) {
        this.tempscpu.set(tempscpu);
    }

    public int getArrivalti() {
        return arrivalti.get();
    }

    public void setArrivalti(int arrivalti) {
        this.arrivalti.set(arrivalti);
    }

   /* public IntegerProperty arrivaltiProperty() {
        return arrivalti;
    }*/

    public int getBrust() {
        return brust.get();
    }

    public void setBrust(int brust) {
        this.brust.set(brust);
    }

    /*public IntegerProperty brustProperty() {
        return brust
    };*/

    public String getEtat() {
        return etat.get();
    }

    public StringProperty etatProperty() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat.set(etat);
    }
    //getters+setters

    //getters and setters
    //gestion des inputs et dans le table views
    //gestion des inputs et dans le table views

    public StringProperty nameProprety(){
        if(name==null){
            name=new SimpleStringProperty(this,"nameprocess"); }
        return name;
    }
    public IntegerProperty arrivalProprety(){
        if(arrivalti==null){
            arrivalti=new SimpleIntegerProperty(this,"arrivalprocess"); }
        return arrivalti;
    }
    public IntegerProperty BrustProprety(){
        if(brust==null){
            brust=new SimpleIntegerProperty(this,"Brustprocess"); }
        return brust; }

    public void processing(int timeToProcess) {
        setTempscpu(getTempscpu() - timeToProcess);

    }
}
