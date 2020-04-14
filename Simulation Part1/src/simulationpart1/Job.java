package simulationpart1;

/**
 *
 * @author Karim
 */

// Class for a Single queue Job alongside its variables.
public class Job {
    String Type;
    int jobID;
    int interarrivalTime;
    int arrivalTime;
    int serviceTime;
    int timeServiceBegins;
    int waitingTime;
    int timeServiceEnds;
    int timeSpentInSystem;
    int idleTime;

    public Job(int jobID, int interarrivalTime, int arrivalTime, int serviceTime, int timeServiceBegins, int waitingTime, int timeServiceEnds, int timeSpentInSystem, int idleTime)
    {
        this.jobID = jobID;
        this.interarrivalTime = interarrivalTime;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.timeServiceBegins = timeServiceBegins;
        this.waitingTime = waitingTime;
        this.timeServiceEnds = timeServiceEnds;
        this.timeSpentInSystem = timeSpentInSystem;
        this.idleTime = idleTime;
    }
    
    public Job(int jobID, int interarrivalTime, int serviceTime){
        this.jobID = jobID;
        this.interarrivalTime = interarrivalTime;
        this.serviceTime = serviceTime;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    
    public int getInterarrivalTime() {
        return interarrivalTime;
    }

    public void setInterarrivalTime(int interarrivalTime) {
        this.interarrivalTime = interarrivalTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getTimeServiceBegins() {
        return timeServiceBegins;
    }

    public void setTimeServiceBegins(int timeServiceBegins) {
        this.timeServiceBegins = timeServiceBegins;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTimeServiceEnds() {
        return timeServiceEnds;
    }

    public void setTimeServiceEnds(int timeServiceEnds) {
        this.timeServiceEnds = timeServiceEnds;
    }

    public int getTimeSpentInSystem() {
        return timeSpentInSystem;
    }

    public void setTimeSpentInSystem(int timeSpentInSystem) {
        this.timeSpentInSystem = timeSpentInSystem;
    }

    public int getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(int idleTime) {
        this.idleTime = idleTime;
    }
    
    
}
