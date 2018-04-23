package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class RRfcfs extends Thread {
        public boolean boolcpu=false;
        public boolean booles=false;
        public boolean tableautrier=false;
        Algorithmes a=new Algorithmes();

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
                        fcfs(wait,quantum,arrivaltime,actualtime,i);
                        fcfs(wait,quantum,arrivaltime,actualtime,i);
                    }else {
                        wait.add(wait.get(i));
                        wait.remove(i);
                    }



                }else{
                    //terminé  //ajouter le status terminé
                }

            }
        }


        public synchronized void fcfs(ObservableList<process> wait,int quantum,int arrivaltime,int actualtime ,int i) throws InterruptedException {
            while (booles==true){
                wait();
            }
            wait.get(i).setPassedes(true);
            actualtime+=wait.get(i).getDuree();
        }}


