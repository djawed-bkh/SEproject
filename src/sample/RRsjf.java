package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class RRsjf {
    //initialisations
    public boolean boolcpu=false;
    public boolean booles=false;
    public boolean tableautrier=false;
    Algorithmes a=new Algorithmes();
    //initialisations



    public synchronized void rr(ObservableList<process> wait, int quantum, int arrivaltime, int actualtime, ArrayList<process> finished) throws InterruptedException {
        int i;
        a.triwaiting(wait);// si le tableau n'est pas trié une seule fois alors on le fais
        for (i=0;i<=wait.size();i++){//pour parcourir toute la waiting list
            while (boolcpu==true){
                wait();
            }
            if (wait.get(i).getBrust()>0){
                actualtime+=quantum;
                wait.get(i).setBrust(wait.get(i).getBrust()-quantum);
                wait.get(i).setTempsecoule(wait.get(i).getTempsecoule()+quantum);
                if (wait.get(i).getTcp()>=wait.get(i).getTempsecoule() && !(wait.get(i).isPassedes())){
                    //call fcfs algorithme
                    //sjf alorithme
                }else {
                    wait.add(wait.get(i));
                    wait.remove(i);
                }



            }else{
                //terminé  //ajouter le status terminé
            }

        }
    }
}
