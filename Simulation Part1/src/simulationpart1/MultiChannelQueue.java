package simulationpart1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Karim
 */

// A class made to calculate the table values alongside its stats. This table also populates the initial interarrival and service times using the number of Ordinary and Distinguished
public class MultiChannelQueue {

    //Array to Hold Interarrival of Ordinary and Service time of Ordinary
    static int[] OrdiCustomer_InterArrivalTime;
    static int[] OrdiCustomer_ServiceTime;

    //Array to hold Interarrival of Distinguished and Service time of Distinguished
    static int[] DistiCustomer_InterArrivalTime;
    static int[] DistiCustomer_ServiceTime;

    public MultiChannelQueue() {

    }

    //Function that calculates the initial interarrival and service times of both Customer types.
    static private void PopulateGivenTables(int NumOfOrdi, int NumOfDisti) {
        //If Values = 0, Initialize the values with the same values as the report.
        if (NumOfOrdi == 0 && NumOfDisti == 0) {
            OrdiCustomer_InterArrivalTime = new int[]{0, 2, 2, 4, 4, 2, 1, 4, 2, 3};
            OrdiCustomer_ServiceTime = new int[]{2, 3, 3, 4, 2, 4, 1, 3, 4, 2};

            DistiCustomer_InterArrivalTime = new int[]{2, 4, 3, 4, 1, 3, 3, 2, 4, 1};
            DistiCustomer_ServiceTime = new int[]{1, 2, 4, 3, 4, 3, 4, 3, 4, 1};

        } else { // If Values > 0
            //Initialize Arrays with Size equal to their respective customer number.
            OrdiCustomer_InterArrivalTime = new int[NumOfOrdi];
            OrdiCustomer_ServiceTime = new int[NumOfOrdi];

            //Random Object to get random variables.
            Random rand = new Random();

            //Assumes the first customer to arrive is ordinary.
            if (NumOfOrdi != 0) {
                OrdiCustomer_InterArrivalTime[0] = 1; // Beginner of Queue
            }
            //Loop over 
            for (int i = 1; i < NumOfOrdi; i++) {
                //Find Number between 0 - 99
                int Num = rand.nextInt(100);
                int ServiceNum = rand.nextInt(100);

                //Probability Cumulative Ranges. This part sets the value of Interarrival depending on Random Variable value and at what range it lies.
                if (0 < Num && Num <= 9) {
                    OrdiCustomer_InterArrivalTime[i] = 0;
                } else if (9 < Num && Num <= 26) {
                    OrdiCustomer_InterArrivalTime[i] = 1;
                } else if (26 < Num && Num <= 53) {
                    OrdiCustomer_InterArrivalTime[i] = 2;
                } else if (53 < Num && Num <= 73) {
                    OrdiCustomer_InterArrivalTime[i] = 3;
                } else if (73 < Num && Num <= 88) {
                    OrdiCustomer_InterArrivalTime[i] = 4;
                } else if ((88 < Num && Num <= 99) || Num == 0) {
                    OrdiCustomer_InterArrivalTime[i] = 5;
                }

                if (0 < ServiceNum && ServiceNum <= 20) {
                    OrdiCustomer_ServiceTime[i] = 1;
                } else if (20 < ServiceNum && ServiceNum <= 60) {
                    OrdiCustomer_ServiceTime[i] = 2;
                } else if (60 < ServiceNum && ServiceNum <= 88) {
                    OrdiCustomer_ServiceTime[i] = 3;
                } else if ((88 < ServiceNum && ServiceNum <= 99) || ServiceNum == 0) {
                    OrdiCustomer_ServiceTime[i] = 4;
                }
            }
            //*********************** Same as Ordinary Part ********************************************
            //Set array size of Distinguished equal to number of Distinguished customers.
            DistiCustomer_InterArrivalTime = new int[NumOfDisti];
            DistiCustomer_ServiceTime = new int[NumOfDisti];

            //Loop Over
            for (int i = 0; i < NumOfDisti; i++) {
                //Random Variable between 0-99
                int Num = rand.nextInt(100);
                int ServiceNum = rand.nextInt(100);

                if (0 < Num && Num <= 10) {
                    DistiCustomer_InterArrivalTime[i] = 1;
                } else if (10 < Num && Num <= 30) {
                    DistiCustomer_InterArrivalTime[i] = 2;
                } else if (30 < Num && Num <= 60) {
                    DistiCustomer_InterArrivalTime[i] = 3;
                } else if ((60 < Num && Num <= 99) || Num == 0) {
                    DistiCustomer_InterArrivalTime[i] = 4;
                }

                if (0 < ServiceNum && ServiceNum <= 10) {
                    DistiCustomer_ServiceTime[i] = 1;
                } else if (10 < ServiceNum && ServiceNum <= 40) {
                    DistiCustomer_ServiceTime[i] = 2;
                } else if (40 < ServiceNum && ServiceNum <= 78) {
                    DistiCustomer_ServiceTime[i] = 3;
                } else if ((78 < ServiceNum && ServiceNum <= 99) || ServiceNum == 0) {
                    DistiCustomer_ServiceTime[i] = 4;
                }
            }
        }

    }

    //A Function to find the Last Arrival of a Certain "Type" from "Table" of Customers. Used in calculating Arrival times.
    static private int FindLastArrival(String type, ArrayList<Job> Table) {
        Job Result = null;
        for (Job J : Table) {
            if (J.getType().equals(type)) {
                Result = J;
            }
        }
        if (Result == null) {
            return 0;
        } else {
            return Result.getArrivalTime();
        }
    }

    //A function to calculate a single row. It uses Current Row Value using previous Customer row data. As well as, last customer of same type to calculate arrival.
    static private Job CalcTable(Job obj, Job prevObj) {
        int Arrival = obj.getArrivalTime();

        int TimeServiceBegins;

        if (prevObj.getTimeServiceEnds() > Arrival) {
            TimeServiceBegins = prevObj.getTimeServiceEnds();
        } else {
            TimeServiceBegins = Arrival;
        }

        int TimeServiceEnds = TimeServiceBegins + obj.getServiceTime();

        int idleTime = 0;
        if (prevObj.getTimeServiceEnds() <= Arrival) {
            idleTime = Arrival - prevObj.getTimeServiceEnds();
        }

        int WaitingTime = 0;
        if (prevObj.getTimeServiceEnds() > Arrival) {
            WaitingTime = TimeServiceBegins - Arrival;
        }

        int TimeSpentInSys = obj.serviceTime + WaitingTime;

        //Set values of current row
        obj.setArrivalTime(Arrival);
        obj.setWaitingTime(WaitingTime);
        obj.setTimeServiceBegins(TimeServiceBegins);
        obj.setTimeServiceEnds(TimeServiceEnds);
        obj.setTimeSpentInSystem(TimeSpentInSys);
        obj.setIdleTime(idleTime);
        return obj;
    }

    //A Function to calculate whole table values while iterating over rows .
    public ArrayList<Job> CalculateTable(int NumOrdinary, int NumDisti) {
        //ArrayList of Rows. This will hold final Table of Customers
        ArrayList<Job> finalTable = new ArrayList<>();
        //Random Object
        Random rand = new Random();
        //ServiceTime between 1-4 for first customer
        int ServiceTime = rand.nextInt(4) + 1;
        //Initialize first customer.
        Job Job1 = new Job(0, 0, 0, ServiceTime, 0, 0, ServiceTime, ServiceTime, 0);
        //If Values = 0, Initialize Customer like the one in report.
        if (NumOrdinary == 0 && NumDisti == 0) {
            Job1 = new Job(0, 0, 0, 2, 0, 0, 2, 2, 0);
        }
        //First Customer is Ordinary
        Job1.setType("Ordinary");
        //If no Ordinary custoemrs, First Customer is Distinguished.
        if (NumOrdinary == 0) {
            Job1.setType("Distinguished");
        }
        //Add Customer to List
        finalTable.add(Job1);
        //Counter for current Index of both queues.
        int OrdinaryCustomerCounter = 1;
        int DistiCustomerCounter = 0;
        //If no Ordinary is Present.
        if (NumOrdinary == 0) {
            DistiCustomerCounter = 1;
        }
        //time variable to hold the current last time of iteration.
        int timeCounter = Job1.getTimeServiceEnds();

        //Function to Populate the interarrival and service time arrays of both queues.
        PopulateGivenTables(NumOrdinary, NumDisti);
        // Default Values (like report)
        if (NumOrdinary == 0 && NumDisti == 0) {
            NumOrdinary = 10;
            NumDisti = 10;
        }

        //While Ordinary Counter hasnt reached total ordinary number OR Distinguished Counter hasnt reached total distinguished number
        while (OrdinaryCustomerCounter < OrdiCustomer_InterArrivalTime.length || DistiCustomerCounter < DistiCustomer_InterArrivalTime.length) {
            Job newJob = null;

            //If Distinguished Counter hasnt reached total distinguished number AND TimeCounter is Equal to or bigger than next distinguished Arrival.
            if (DistiCustomerCounter < DistiCustomer_InterArrivalTime.length && timeCounter >= FindLastArrival("Distinguished", finalTable) + DistiCustomer_InterArrivalTime[DistiCustomerCounter]) {
                //Initialize Distinguished Customer Object
                newJob = new Job((finalTable.size()), DistiCustomer_InterArrivalTime[DistiCustomerCounter], DistiCustomer_ServiceTime[DistiCustomerCounter]);
                //Set Distinguished Arrival time (Last Distinguished Arrival + Current Inter Arrival)
                newJob.setArrivalTime(FindLastArrival("Distinguished", finalTable) + newJob.getInterarrivalTime());
                //Calculate values of Distinguished Customer using the previous row
                newJob = CalcTable(newJob, finalTable.get(finalTable.size() - 1));
                newJob.setType("Distinguished");
                finalTable.add(newJob);

                //Increment Distinguished customer Counter
                DistiCustomerCounter++;
                //Time Counter to hold Ending of current Iteration
                timeCounter = newJob.getTimeServiceEnds();

                //If Ordinary Counter hasnt reached total Ordinary number AND TimeCounter is Equal to or bigger than next Ordinary Arrival.
            } else if (OrdinaryCustomerCounter < OrdiCustomer_InterArrivalTime.length && timeCounter >= FindLastArrival("Ordinary", finalTable) + OrdiCustomer_InterArrivalTime[OrdinaryCustomerCounter]) {
                //Initialize Ordinary Customer Object
                newJob = new Job((finalTable.size()), OrdiCustomer_InterArrivalTime[OrdinaryCustomerCounter], OrdiCustomer_ServiceTime[OrdinaryCustomerCounter]);
                //Set Ordinary Arrival time (Last Ordinary Arrival + Current Inter Arrival)
                newJob.setArrivalTime(FindLastArrival("Ordinary", finalTable) + newJob.getInterarrivalTime());
                //Calculate values of Ordinary Customer using the previous row
                newJob = CalcTable(newJob, finalTable.get(finalTable.size() - 1));
                newJob.setType("Ordinary");
                finalTable.add(newJob);

                //Increment Ordinary customer Counter
                OrdinaryCustomerCounter++;
                //Time Counter to hold Ending of current Iteration
                timeCounter = newJob.getTimeServiceEnds();
            } else {
                //If no Customer to enter yet Increase Time (Idle Time)
                timeCounter++;
            }

        }

        return finalTable;
    }

    // A Function to Calculate Stats of One Try
    public Statistics CalculateStats(ArrayList<Job> finalTable, int NumOrdinary, int NumDisti) {

        //Values to be Used and calculated
        double averageServiceTime = 0;
        double averageWaitingTime_Ordi = 0;
        double averageWaitingTime_Disti = 0;
        double maxQueue_Ordi = 0;
        double maxQueue_Disti = 0;
        double wait_Ordi = 0;
        double wait_Disti = 0;
        double idleTimeSummation = 0;
        double TotalInterArrival = 0;
        double InterArrivalOrdi = 0;
        double InterArrivalDisti = 0;
        double TotalTimeSpentOrdi = 0;
        double TotalTimeSpentDisti = 0;
        double ServiceTimeOrdi = 0;
        double ServiceTimeDisti = 0;

        //Variable to calculate length of queue
        int queueLength = 1;
        for (int i = 0; i < finalTable.size(); i++) {
            //Current Customer
            Job currentRow = finalTable.get(i);
            //Summation of Service Time
            averageServiceTime += currentRow.getServiceTime();
            //Summation of Interarrival time
            TotalInterArrival += currentRow.getInterarrivalTime();

            //If Current Customer is Distinguished
            if (currentRow.getType().equals("Distinguished")) {
                //Sum of Distinguished Values
                averageWaitingTime_Disti += currentRow.getWaitingTime();
                TotalTimeSpentDisti += currentRow.getTimeSpentInSystem();
                ServiceTimeDisti += currentRow.getServiceTime();
                InterArrivalDisti += currentRow.getInterarrivalTime();
                
            //Sum of Ordinary Values
            } else if (currentRow.getType().equals("Ordinary")) {
                averageWaitingTime_Ordi += currentRow.getWaitingTime();
                TotalTimeSpentOrdi += currentRow.getTimeSpentInSystem();
                ServiceTimeOrdi += currentRow.getServiceTime();
                InterArrivalOrdi += currentRow.getInterarrivalTime();
            }

            //After first Iteration
            if (i > 0) {
                //If Current row Type is same as previous Row type. Increase Queue Length
                if (currentRow.getType().equals(finalTable.get(i - 1).getType())) {
                    queueLength++;
                    if (currentRow.getType().equals("Ordinary") && queueLength > maxQueue_Ordi) {
                        maxQueue_Ordi = queueLength;
                    } else if (currentRow.getType().equals("Distinguished") && queueLength > maxQueue_Disti) {
                        maxQueue_Disti = queueLength;
                    }
                } else {
                    queueLength = 1;
                }
            }

            //If Ordinary has waiting. increase number of Waiting Ordinary
            if (currentRow.getWaitingTime() > 0 && currentRow.getType().equals("Ordinary")) {
                wait_Ordi += 1;
            //If Distinguished has waiting. Increaes number of waiting Distinguished.
            } else if (currentRow.getWaitingTime() > 0 && currentRow.getType().equals("Distinguished")) {
                wait_Disti += 1;
            }

            //Summation of Idle time
            idleTimeSummation += currentRow.getIdleTime();
        }

        // Division of Averages over Multiple Runes
        averageServiceTime = averageServiceTime / finalTable.size();
        averageWaitingTime_Ordi = averageWaitingTime_Ordi / wait_Ordi;
        averageWaitingTime_Disti = averageWaitingTime_Disti / wait_Disti;
        wait_Ordi = wait_Ordi / NumOrdinary;
        wait_Disti = wait_Disti / NumDisti;
        TotalTimeSpentOrdi = TotalTimeSpentOrdi / NumOrdinary;
        TotalTimeSpentDisti = TotalTimeSpentDisti / NumDisti;
        ServiceTimeOrdi = ServiceTimeOrdi / NumOrdinary;
        ServiceTimeDisti = ServiceTimeDisti / NumDisti;
        InterArrivalOrdi = InterArrivalOrdi / NumOrdinary;
        InterArrivalDisti = InterArrivalDisti / NumDisti;
        TotalInterArrival = TotalInterArrival / finalTable.size();

        //Set Statistics Values inside Statistics Container.
        Statistics FinalResult = new Statistics();
        FinalResult.setAverageServiceTime(averageServiceTime);
        FinalResult.setAverageWaitingTime_Ordi(averageWaitingTime_Ordi);
        FinalResult.setAverageWaitingTime_Disti(averageWaitingTime_Disti);
        FinalResult.setMaxQueue_Ordi(maxQueue_Ordi);
        FinalResult.setMaxQueue_Disti(maxQueue_Disti);
        FinalResult.setWait_Ordi(wait_Ordi);
        FinalResult.setWait_Disti(wait_Disti);
        FinalResult.setIdleTimeSummation(idleTimeSummation / finalTable.get(finalTable.size() - 1).getTimeServiceEnds());
        FinalResult.setTotalTimeSpentOrdi(TotalTimeSpentOrdi);
        FinalResult.setTotalTimeSpentDisti(TotalTimeSpentDisti);
        FinalResult.setServiceTimeOrdi(ServiceTimeOrdi);
        FinalResult.setServiceTimeDisti(ServiceTimeDisti);
        FinalResult.setInterArrivalOrdi(InterArrivalOrdi);
        FinalResult.setInterArrivalDisti(InterArrivalDisti);
        FinalResult.setAverageInterArrival(TotalInterArrival);

        return FinalResult;

    }
}
