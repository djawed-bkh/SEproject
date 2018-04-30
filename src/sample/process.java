package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class process {



    private StringProperty name;
    private IntegerProperty arrivalti;
    private IntegerProperty brust;
    private IntegerProperty exittime;
    private IntegerProperty tempscpu;
    private IntegerProperty tpc;
    private IntegerProperty duree;
    private IntegerProperty tempsecoule;
    private boolean cpu;
    private boolean es;
    private StringProperty etat;
   private ArrayList<Integer> estime;

   //getters and setters and constructor


    public int getTempsecoule() {
        return tempsecoule.get();
    }

    public IntegerProperty tempsecouleProperty() {
        return tempsecoule;
    }

    public void setTempsecoule(int tempsecoule) {
        this.tempsecoule.set(tempsecoule);
    }

    //constructors
    public process(){

    StringProperty name=this.name;
    IntegerProperty arrivalti=this.arrivalti;
    IntegerProperty brust=this.brust;
    }


    public process(String name, int arrivalti, int brust, int tpc,int duree,int exittime,int tempsecoule ,String etat) {
        this.name = new SimpleStringProperty(name);
        this.arrivalti = new SimpleIntegerProperty(arrivalti);
        this.brust = new SimpleIntegerProperty(brust);
        this.tpc=new SimpleIntegerProperty(tpc);
        this.duree=new SimpleIntegerProperty(duree);
        this.exittime = new SimpleIntegerProperty(exittime);
        this.etat = new SimpleStringProperty(etat);
        this.tempsecoule=  new SimpleIntegerProperty(tempsecoule);
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

    public void setEtat(String etat) {
        this.etat.set(etat);
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
    public StringProperty EtatProperty() {
        return etat;
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








    //getters+setters

    //getters and setters


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




}
