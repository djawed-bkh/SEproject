package sample;


import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Algorithmes {

    public void firstcomefirstserve(ObservableList<process> pro, int burst, int quantum, int arrival){
        int currenttime=0;
        int nprocess=pro.size();
        ArrayList<process>waitinglist=new ArrayList<>();
        //  manque
        while (nprocess>0){
            System.out.println("current time"+currenttime);
            System.out.println("process filling phase:");

            for (int i=0;i<pro.size();i++){
                if (pro.get(i).getArrivalti()<=currenttime && !pro.get(i).isPassed()){
                    waitinglist.add(pro.get(i));
                    pro.get(i).setPassed(true);
                    //line 33
                }
            }
            System.out.println("process working phase:");
            if (waitinglist.size()>0){
                System.out.println("processus"+waitinglist.get(0).getName()+"is being processed");
                currenttime+=waitinglist.get(0).getTempscpu();
                waitinglist.get(0).processing(waitinglist.get(0).getTempscpu());
                System.out.println("process"+waitinglist.get(0).getName()+"left the system");
                int indexofprocessleaving=0;
                while (waitinglist.get(0).getName() !=pro.get(indexofprocessleaving).getName()){
                    ++indexofprocessleaving;
                }
                //50
                pro.get(0).setExittime(currenttime);

                waitinglist.remove(0);
                --nprocess;
                }else {
                System.out.println("pas de process en attente");
                ++currenttime;
            }
            if (pro.size()>0){
                System.out.println("remaining pro:");
                boolean check=false;
                for (int i=0;i<pro.size();i++){
                    if (!pro.get(i).isPassed()){
                        System.out.println("process"+pro.get(i).getName());
                        check=true;

                    }
                }
                if (!check){
                    System.out.println("no process remained");
                }
            }
            //78
        }

    }



    public void roundrobin(ObservableList<process> pro,int quantum){
        int currentTime = 0;
        int numberOfProcess = pro.size();

        ArrayList<process> waitingList = new ArrayList<>();

        //rr

        while (numberOfProcess > 0) {

            System.out.println("current time: " + currentTime);
            System.out.println();
            System.out.println("process filling phase:");

            for (int i = 0; i < pro.size(); i++) {
                //if the processus are arriving
                if (pro.get(i).getArrivalti() <= currentTime && !pro.get(i).isPassed()) {
                    System.out.println("the processus " + pro.get(i).getName() + " was added to the waiting list");
                    waitingList.add(pro.get(i));
                    pro.get(i).setPassed(true);
                   //rr
                }
            }



            System.out.println("process working phase:");
            if (waitingList.size() > 0) {

                currentTime += quantum;
                System.out.println("processus " + waitingList.get(0).getName() + " is being processed...");
                waitingList.get(0).processing(quantum);

                if (waitingList.get(0).getTempscpu() > 0) {
                    process p = waitingList.get(0);
                    //waitingList.add(waitingList.size() - 1, waitingList.get(0));
                    waitingList.remove(0);
                    waitingList.add(p);
                    System.out.println("processus " + waitingList.get(0).getName() + " is the head of the list");
                    System.out.println("processus " + waitingList.get(waitingList.size() - 1).getName() + " is the tail of the list");
                } else {
                    System.out.println("processus " + waitingList.get(0).getName() + " has left the system");
                    --numberOfProcess;
                    int indexOfProcessLeaving = 0;
                    while (waitingList.get(0).getName() != pro.get(indexOfProcessLeaving).getName()) {
                        ++indexOfProcessLeaving;
                    }

                    //rr
                    pro.get(0).setExittime(currentTime);
                    waitingList.remove(0);
                }


            } else {
                System.out.println("No processes available");
                currentTime++;
            }

            //---------
            System.out.println();

            if (pro.size() > 0) {
                System.out.println("remaining processes: ");
                boolean check = false;

                for (int i = 0; i < pro.size(); i++) {
                    if (!pro.get(i).isPassed()) {
                        System.out.println("Processus " + pro.get(i).getName());
                        check = true;
                    }
                }

                if (!check) {
                    System.out.println("No Proceses remained");
                }
            }
            System.out.println();
        }
    }










        public int plusproche(ObservableList<process> wait,int arrivaltime,int actualtime){
            //voir qui est le plus proche du temps actuel
            int plusproche=wait.get(0).getArrivalti()-actualtime;
            int indice=0;
            for (int i=0;i<=wait.size();i++){
                if(wait.get(i).getArrivalti()-actualtime<plusproche){
                    indice=i;
                }
            }
            return indice;
        }


    public void rr( ObservableList<process> wait,int quantum,int arrivaltime,int actualtime, ArrayList<process> finished){
        int turnto=plusproche(wait,arrivaltime,actualtime);

        while (wait.size()>0){
            wait.get(turnto).setBrust(wait.get(turnto).getBrust()-quantum);
            if (wait.get(turnto).getBrust()<=0){
            }

        }




    }














































}
