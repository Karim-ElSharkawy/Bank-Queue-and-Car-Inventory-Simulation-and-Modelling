/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulationpart1;

/**
 *
 * @author Karim
 */

//Statistics Container to hold all Variables.
public class Statistics {

    double averageServiceTime;
    double averageWaitingTime_Ordi;
    double averageWaitingTime_Disti;
    double maxQueue_Ordi;
    double maxQueue_Disti;
    double wait_Ordi;
    double wait_Disti;
    double idleTimeSummation;
    double TotalTimeSpent;
    double TotalServiceTime;
    double TotalTimeSpentOrdi;
    double TotalTimeSpentDisti;
    double ServiceTimeOrdi;
    double ServiceTimeDisti;
    double AverageInterArrival;
    double InterArrivalOrdi;
    double InterArrivalDisti;

    public Statistics(double averageServiceTime, double averageWaitingTime_Ordi, double averageWaitingTime_Disti, double maxQueue_Ordi, double maxQueue_Disti, double wait_Ordi, double wait_Disti, double idleTimeSummation) {
        this.averageServiceTime = averageServiceTime;
        this.averageWaitingTime_Ordi = averageWaitingTime_Ordi;
        this.averageWaitingTime_Disti = averageWaitingTime_Disti;
        this.maxQueue_Ordi = maxQueue_Ordi;
        this.maxQueue_Disti = maxQueue_Disti;
        this.wait_Ordi = wait_Ordi;
        this.wait_Disti = wait_Disti;
        this.idleTimeSummation = idleTimeSummation;
        TotalTimeSpent = 0;
        TotalServiceTime = 0;
        TotalTimeSpentOrdi = 0;
        TotalTimeSpentDisti = 0;
        ServiceTimeOrdi = 0;
        ServiceTimeDisti = 0;
    }

    public Statistics(double averageServiceTime, double averageWaitingTime_Ordi, double averageWaitingTime_Disti, double maxQueue_Ordi, double maxQueue_Disti, double wait_Ordi, double wait_Disti, double idleTimeSummation, double TotalTimeSpentOrdi, double TotalTimeSpentDisti, double ServiceTimeOrdi, double ServiceTimeDisti) {
        this.averageServiceTime = averageServiceTime;
        this.averageWaitingTime_Ordi = averageWaitingTime_Ordi;
        this.averageWaitingTime_Disti = averageWaitingTime_Disti;
        this.maxQueue_Ordi = maxQueue_Ordi;
        this.maxQueue_Disti = maxQueue_Disti;
        this.wait_Ordi = wait_Ordi;
        this.wait_Disti = wait_Disti;
        this.idleTimeSummation = idleTimeSummation;
        this.TotalTimeSpentOrdi = TotalTimeSpentOrdi;
        this.TotalTimeSpentDisti = TotalTimeSpentDisti;
        this.ServiceTimeOrdi = ServiceTimeOrdi;
        this.ServiceTimeDisti = ServiceTimeDisti;
    }

    public Statistics() {
    }

    
    public double getAverageInterArrival() {
        return AverageInterArrival;
    }

    public void setAverageInterArrival(double AverageInterArrival) {
        this.AverageInterArrival = AverageInterArrival;
    }

    public double getInterArrivalOrdi() {
        return InterArrivalOrdi;
    }

    public void setInterArrivalOrdi(double InterArrivalOrdi) {
        this.InterArrivalOrdi = InterArrivalOrdi;
    }

    public double getInterArrivalDisti() {
        return InterArrivalDisti;
    }

    public void setInterArrivalDisti(double InterArrivalDisti) {
        this.InterArrivalDisti = InterArrivalDisti;
    }

    
    public double getTotalTimeSpent() {
        return TotalTimeSpent;
    }

    public void setTotalTimeSpent(double TotalTimeSpent) {
        this.TotalTimeSpent = TotalTimeSpent;
    }

    public double getTotalServiceTime() {
        return TotalServiceTime;
    }

    public void setTotalServiceTime(double TotalServiceTime) {
        this.TotalServiceTime = TotalServiceTime;
    }

    public double getTotalTimeSpentOrdi() {
        return TotalTimeSpentOrdi;
    }

    public void setTotalTimeSpentOrdi(double TotalTimeSpentOrdi) {
        this.TotalTimeSpentOrdi = TotalTimeSpentOrdi;
    }

    public double getTotalTimeSpentDisti() {
        return TotalTimeSpentDisti;
    }

    public void setTotalTimeSpentDisti(double TotalTimeSpentDisti) {
        this.TotalTimeSpentDisti = TotalTimeSpentDisti;
    }

    public double getServiceTimeOrdi() {
        return ServiceTimeOrdi;
    }

    public void setServiceTimeOrdi(double ServiceTimeOrdi) {
        this.ServiceTimeOrdi = ServiceTimeOrdi;
    }

    public double getServiceTimeDisti() {
        return ServiceTimeDisti;
    }

    public void setServiceTimeDisti(double ServiceTimeDisti) {
        this.ServiceTimeDisti = ServiceTimeDisti;
    }
    
    

    public double getAverageServiceTime() {
        return averageServiceTime;
    }

    public void setAverageServiceTime(double averageServiceTime) {
        this.averageServiceTime = averageServiceTime;
    }

    public double getAverageWaitingTime_Ordi() {
        return averageWaitingTime_Ordi;
    }

    public void setAverageWaitingTime_Ordi(double averageWaitingTime_Ordi) {
        this.averageWaitingTime_Ordi = averageWaitingTime_Ordi;
    }

    public double getAverageWaitingTime_Disti() {
        return averageWaitingTime_Disti;
    }

    public void setAverageWaitingTime_Disti(double averageWaitingTime_Disti) {
        this.averageWaitingTime_Disti = averageWaitingTime_Disti;
    }

    public double getMaxQueue_Ordi() {
        return maxQueue_Ordi;
    }

    public void setMaxQueue_Ordi(double maxQueue_Ordi) {
        this.maxQueue_Ordi = maxQueue_Ordi;
    }

    public double getMaxQueue_Disti() {
        return maxQueue_Disti;
    }

    public void setMaxQueue_Disti(double maxQueue_Disti) {
        this.maxQueue_Disti = maxQueue_Disti;
    }

    public double getWait_Ordi() {
        return wait_Ordi;
    }

    public void setWait_Ordi(double wait_Ordi) {
        this.wait_Ordi = wait_Ordi;
    }

    public double getWait_Disti() {
        return wait_Disti;
    }

    public void setWait_Disti(double wait_Disti) {
        this.wait_Disti = wait_Disti;
    }

    public double getIdleTimeSummation() {
        return idleTimeSummation;
    }

    public void setIdleTimeSummation(double idleTimeSummation) {
        this.idleTimeSummation = idleTimeSummation;
    }

}
