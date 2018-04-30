package sample;

import javafx.collections.ObservableList;

public class Fcfs {
    


    public void fcfs(ObservableList<process> wait, int quantum, int actualtime,ObservableList<process> finish) throws InterruptedException {
        for (int i=0 ;i<wait.size();i++){

            actualtime+=wait.get(i).getDuree();
            Integer exit=actualtime+ wait.get(i).getDuree();
            wait.get(i).setEtat("terminé");
            System.out.println("deb boucle");
            wait.get(i).setArrivalti(actualtime);
            wait.get(i).setExittime(exit);
            wait.get(i).setEtat("terminé");
            finish.add(wait.get(i));
        }


    }



}