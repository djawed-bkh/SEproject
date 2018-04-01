package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class process {
    private StringProperty name;
    private IntegerProperty arrivalti;
    private IntegerProperty brust;
 //getters and setters and constructor

    //constructors
    public process(){
    StringProperty name=this.name;
    IntegerProperty arrivalti=this.arrivalti;
    IntegerProperty brust=this.brust;
    }
    public process(String name, int arrivalti,int brust) {
        this.name = new SimpleStringProperty(name);
        this.arrivalti = new SimpleIntegerProperty(arrivalti);
        this.brust = new SimpleIntegerProperty(brust);}
    //constructors
    //getters+setters
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
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
}
