package sample;


import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;


public class Algorithmes {

    public boolean boolcpu=false;
    public boolean booles=false;
    public boolean tableautrier=false;



       /* public int plusproche(ObservableList<process> wait,int arrivaltime,int actualtime){
            //voir qui est le plus proche du temps actuel
            int plusproche=wait.get(0).getArrivalti()-actualtime;
            int indice=0;
            for (int i=0;i<=wait.size();i++){
                if(wait.get(i).getArrivalti()-actualtime<plusproche){
                    indice=i;
                }
            }
            return indice;
        }*/

        //methode qui trie le tableau selon le plus petit arrival time
        public  void triwaiting(ObservableList<process>wait){
            if (tableautrier==false){
                for (int i=0;i<=wait.size();i++){
                    for (int j=i+1;j<=wait.size();j++){
                        if (wait.get(i).getArrivalti()<wait.get(j).getArrivalti()){
                            process inter;
                            inter=wait.get(j);
                            wait.add(j,wait.get(i));
                            wait.add(i,inter);
                        }
                    }

                }
            }

        }


   /* public synchronized void rr( ObservableList<process> wait,int quantum,int arrivaltime,int actualtime, ArrayList<process> finished) throws InterruptedException {
        int i;
        triwaiting(wait);// si le tableau n'est pas trié une seule fois alors on le fais
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

        }*/

    }















































