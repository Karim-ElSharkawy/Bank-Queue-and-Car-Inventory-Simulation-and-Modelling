/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulationpart2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Karim
 */

//Class for The Calendar
public class Calendar {

    public Calendar() {
    }
    //Function to calculate Table 
    public ArrayList<CarDealer_Day> calculateTable(int NumberOfDays, int N) {
        //Random object
        Random rand = new Random();
        //Random Variables
        int rvDemand;
        int rvLead;
        //Final Calendar List
        ArrayList<CarDealer_Day> Table = new ArrayList<>();
        //First Day
        CarDealer_Day Day = new CarDealer_Day(rand.nextInt(100));
        //Set Given Values.
        Day.setInventory(3);
        Day.setScheduled(8);
        Day.setLead(2);
        //Add to List
        Table.add(Day);

        //Loop over Days Number
        for (int i = 1; i < NumberOfDays; i++) {
            //Random Variable for Demand
            rvDemand = rand.nextInt(100);
            // if Review Period and There is no Lead (There is no Order)
            if (i % N == 0 && (!(Table.get(i - 1).getLead() > 0))) {
                rvLead = rand.nextInt(100);
                Day = new CarDealer_Day(rvDemand, rvLead);
                //if day after Review Period (Order Sttarts)
            } else if (i % N == 1) {
                Day = new CarDealer_Day(rvDemand);
                //If Second Iteration decrease Lead by 1 (Only one Exception)
                if (i == 1) {
                    Day.setLead(Table.get(i - 1).getLead() - 1);
                } else {// Else
                    
                    Day.setLead(Table.get(i - 1).getLead());
                    Table.get(i - 1).setLead(0);

                }
                //Calculate Scheduled
                Day.setScheduled(11 - Table.get(i - 1).getInventory());
                
            } else { 
                //Calculate new Day
                Day = new CarDealer_Day(rvDemand);
                int newLead = 0;
                //If Previous Lead > 0, Decrement Lead in this iteration
                if (Table.get(i - 1).getLead() > 0) {
                    newLead = Table.get(i - 1).getLead() - 1;
                }
                //Set new Lead
                Day.setLead(newLead);
                //Set Scheduled
                Day.setScheduled(Table.get(i - 1).getScheduled());
            }
            // If Lead Reaches 0 and There is Scheduled cars ordered. Add Them to Inventory.
            if (Day.isOrderArrived() && Day.getScheduled() > 0) {
                Day.setInventory(Table.get(i - 1).getInventory() + Day.getScheduled() - Day.getDemand());
                Day.setScheduled(0);
                
                //Else Remove Demand Only
            } else {
                Day.setInventory(Table.get(i - 1).getInventory() - Day.getDemand());
            }

            Table.add(Day);
        }
        return Table;
    }

}
