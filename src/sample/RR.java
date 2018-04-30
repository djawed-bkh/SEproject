package sample;

import javafx.collections.ObservableList;


public class RR {


    // round robin methode (bugs)

public void rr(ObservableList<process>pro,int quantum,ObservableList<process>finish, int actualtime){
    int i=0;
    for ( int j=0;j<pro.size();j++){
        pro.get(j).setTempsecoule(pro.get(j).getBrust());
    }
    while (pro.size()>0){
        System.out.println("rr deb");
        if (pro.get(i).getTempsecoule()>quantum){
            System.out.println("rr deb2");
            pro.get(i).setTempsecoule(pro.get(i).getTempsecoule()-quantum);
            actualtime+=quantum;
            System.out.println("rr deb3");

        }else if(pro.get(i).getTempsecoule()<=quantum && pro.get(i).getTempsecoule()<pro.get(i).getBrust()){
            System.out.println("rr if");
            actualtime+= pro.get(i).getBrust() -pro.get(i).getTempsecoule();
            pro.get(i).setTempsecoule(0);
            finish.add(pro.get(i));
            pro.remove(i);
        }


  i++;
    }

    System.out.println("haja");

}







































}






























