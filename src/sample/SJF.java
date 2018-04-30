package sample;

import javafx.collections.ObservableList;

public class SJF {


    public int  rechercheshort(ObservableList<process> petit){      //donne le plus petit ellement de la liste
        int index=0;
        for (int i=0;i<petit.size();i++){
            if (petit.get(i).getBrust()<petit.get(index).getBrust()){
                index=i;
            }
        }

        return index;
    }

    public void sjf(ObservableList<process>pro,int quantum,ObservableList<process>finish , int actual){
        while (pro.size()>0){
            if (pro.get(rechercheshort(pro)).getBrust()>0){
                actual+=quantum;
                pro.get(rechercheshort(pro)).setBrust(pro.get(rechercheshort(pro)).getBrust()-quantum);

            }else {
                pro.get(rechercheshort(pro)).setExittime(actual);
                finish.add(pro.get(rechercheshort(pro)));
                pro.remove(rechercheshort(pro));
            }

        }

    }
}
