/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulationpart2;

/**
 *
 * @author Karim
 */

//Container for Day of Calendar
public class CarDealer_Day {

    int rvDemand;
    int Demand;
    int rvLead;
    int Lead;
    int Scheduled;
    int Inventory;
    int Shortage;

    boolean OrderArrived;

    public CarDealer_Day(int rvDemand, int rvLead) {
        this.rvDemand = rvDemand;
        this.rvLead = rvLead;

        this.Demand = Probability_Table.CalculateDemand(rvDemand);
        this.Lead = Probability_Table.CalculateLead(rvLead);
    }

    public CarDealer_Day(int rvDemand) {
        this.rvDemand = rvDemand;

        this.Demand = Probability_Table.CalculateDemand(rvDemand);
    }

    public int getRvDemand() {
        return rvDemand;
    }

    public void setRvDemand(int rvDemand) {
        this.rvDemand = rvDemand;
    }

    public int getDemand() {
        return Demand;
    }

    public void setDemand(int Demand) {
        this.Demand = Demand;
    }

    public int getRvLead() {
        return rvLead;
    }

    public void setRvLead(int rvLead) {
        this.rvLead = rvLead;
    }

    public int getLead() {
        return Lead;
    }

    public void setLead(int Lead) {
        this.Lead = Lead;
        if (Lead > 0) {
            OrderArrived = false;
        } else {
            OrderArrived = true;
        }
    }

    public int getScheduled() {
        return Scheduled;
    }

    public void setScheduled(int Scheduled) {
        this.Scheduled = Scheduled;
    }

    public int getInventory() {
        return Inventory;
    }

    public void setInventory(int Inventory) {
        if (Inventory < 0) {
            this.Inventory = 0;
            setShortage(Math.abs(Inventory));
        } else {
            this.Inventory = Inventory;
        }
    }

    public int getShortage() {
        return Shortage;
    }

    public void setShortage(int Shortage) {
        this.Shortage = Shortage;
    }

    public boolean isOrderArrived() {
        return OrderArrived;
    }

    public void setOrderArrived(boolean OrderArrived) {
        this.OrderArrived = OrderArrived;
    }


}
