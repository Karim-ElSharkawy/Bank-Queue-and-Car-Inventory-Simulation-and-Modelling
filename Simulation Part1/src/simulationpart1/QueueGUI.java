/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulationpart1;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

/**
 *
 * @author Karim
 */
public class QueueGUI extends javax.swing.JFrame {

    //ArrayList of Runs
    ArrayList<ArrayList<Job>> allTable;
    //ArrayList of Distinguished-Only Runs. (Incase of 2 Teller)
    ArrayList<ArrayList<Job>> allTableDistinguished;
    //ArrayList of Run Statistics
    ArrayList<Statistics> Stats;
    //ArrayList of Distinguished-only Statistics Runs (Incase of 2 Teller)
    ArrayList<Statistics> StatsDistinguished;

    public QueueGUI() {
        initComponents();
        allTable = new ArrayList<ArrayList<Job>>();
        allTableDistinguished = new ArrayList<ArrayList<Job>>();
        Stats = new ArrayList<Statistics>();
        StatsDistinguished = new ArrayList<Statistics>();
    }

    //Function to Create Histogram data from Statistics 
    private HistogramDataset createHistogramData(String Type, String Output) {

        // Histogram Dataset Variable
        HistogramDataset dataset = new HistogramDataset();
        dataset.setType(HistogramType.RELATIVE_FREQUENCY);
        //Array to hold Dataset Values
        double[] values = new double[Stats.size()];

        //Turn Run Values into Arrays
        //If Output String is "waiting"
        if (Output.equals("Waiting")) {
            for (int i = 0; i < Stats.size(); i++) {
                if (Type.equals("Ordinary")) {
                    //Set value as Average Waiting of Ordinary
                    values[i] = Stats.get(i).getAverageWaitingTime_Ordi();
                    
                } else if (Type.equals("Distinguished")) {
                    if (jCheckBox1.isSelected()) { //incase of 2 Teller
                        //Values for Distinguished-Only Queue Stats
                        values[i] = StatsDistinguished.get(i).getAverageWaitingTime_Disti();
                    } else {
                        //Values for Ordinary-Only Queue Stats
                        values[i] = Stats.get(i).getAverageWaitingTime_Disti();
                    }
                }
            }
            //If Output type is Service
        } else if (Output.equals("Service")) {
            for (int i = 0; i < Stats.size(); i++) {
                values[i] = Stats.get(i).getAverageServiceTime();
            }
            //If Output type is MaxQueue
        } else if (Output.equals("MaxQueue")) {
            for (int i = 0; i < Stats.size(); i++) {
                if (Type.equals("Ordinary")) {
                    values[i] = Stats.get(i).getMaxQueue_Ordi();
                } else if (Type.equals("Distinguished")) {
                    values[i] = Stats.get(i).getMaxQueue_Disti();
                }
            }
        } else if (Output.equals("Idle")) {
            for (int i = 0; i < Stats.size(); i++) {
                if (Type.equals("Ordinary") || Type.equals("")) {
                    values[i] = Stats.get(i).getIdleTimeSummation();
                } else if (Type.equals("Distinguished")) {
                    values[i] = StatsDistinguished.get(i).getIdleTimeSummation();
                }
            }
        } else if (Output.equals("ProbWait")) {
            for (int i = 0; i < Stats.size(); i++) {
                if (Type.equals("Ordinary")) {
                    values[i] = Stats.get(i).getWait_Ordi();
                } else if (Type.equals("Distinguished")) {
                    values[i] = Stats.get(i).getWait_Disti();
                }
            }
        } else if (Output.equals("TimeSpent")) {
            for (int i = 0; i < Stats.size(); i++) {
                if (Type.equals("Ordinary")) {
                    values[i] = Stats.get(i).getTotalTimeSpentOrdi();
                } else if (Type.equals("Distinguished")) {
                    if (jCheckBox1.isSelected()) {
                        values[i] = StatsDistinguished.get(i).getTotalTimeSpentDisti();
                    } else {
                        values[i] = Stats.get(i).getTotalTimeSpentDisti();
                    }
                }
            }
        } else if (Output.equals("IndividualService")) {
            for (int i = 0; i < Stats.size(); i++) {
                if (Type.equals("Ordinary")) {
                    values[i] = Stats.get(i).getServiceTimeOrdi();
                } else if (Type.equals("Distinguished")) {
                    if (jCheckBox1.isSelected()) {
                        values[i] = StatsDistinguished.get(i).getServiceTimeDisti();
                    } else {
                        values[i] = Stats.get(i).getServiceTimeDisti();
                    }
                }
            }
        } else if (Output.equals("InterArrival")) {
            for (int i = 0; i < Stats.size(); i++) {
                values[i] = Stats.get(i).getAverageInterArrival();
            }
        }
        //After Calculating one of the Output Type, Add Values to Dataset to be made into Histogram
        dataset.addSeries("Histogram", values, 15);
        return dataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Multi-Channel Queue");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Number of Tries: ");

        jTextField1.setText("5");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Ordinary:");

        jTextField2.setText("10");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Distinguished:");

        jTextField3.setText("10");
        jTextField3.setToolTipText("");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Calculate Table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Stats:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Average Service Time: ");
        jLabel6.setToolTipText("");

        jLabel7.setText("Average Waiting time Ordinary:");

        jLabel8.setText("Distinguished:");

        jLabel9.setText("Maximum queue length Ordinary:");

        jLabel10.setText("Distinguished:");

        jLabel11.setText("Prob of Customer Wait Ordinary:");

        jLabel12.setText("Distinguished:");

        jLabel13.setText("Idle time Prob;");

        jTextField4.setEditable(false);
        jTextField4.setText("0");

        jTextField5.setEditable(false);
        jTextField5.setText("0");

        jTextField6.setEditable(false);
        jTextField6.setText("0");

        jTextField7.setEditable(false);
        jTextField7.setText("0");

        jTextField8.setEditable(false);
        jTextField8.setText("0");

        jTextField9.setEditable(false);
        jTextField9.setText("0");

        jTextField10.setEditable(false);
        jTextField10.setText("0");

        jTextField11.setEditable(false);
        jTextField11.setText("0");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Total Statistics:");

        jLabel14.setText("Avg Service Time:");

        jTextField12.setEditable(false);
        jTextField12.setText("0");

        jLabel16.setText("Waiting Time Ordi:");

        jTextField13.setEditable(false);
        jTextField13.setText("0");

        jLabel17.setText("~Distinguished:");

        jTextField14.setEditable(false);
        jTextField14.setText("0");

        jLabel18.setText("Max Queue Ordi:");

        jTextField15.setEditable(false);
        jTextField15.setText("0");

        jLabel19.setText("~Distinguished:");

        jTextField16.setEditable(false);
        jTextField16.setText("0");

        jLabel20.setText("Prob of Wait Ordi:");

        jTextField17.setEditable(false);
        jTextField17.setText("0");

        jLabel21.setText("~Distinguished:");

        jTextField18.setEditable(false);
        jTextField18.setText("0");

        jLabel22.setText("Idle Time Prob:");

        jTextField19.setEditable(false);
        jTextField19.setText("0");

        jCheckBox1.setText("2 Tellers?");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel23.setText("Average InterArrival:");

        jTextField20.setEditable(false);
        jTextField20.setText("0");
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });

        jLabel24.setText("InterArrival Ordinary:");

        jTextField21.setEditable(false);
        jTextField21.setText("0");

        jLabel25.setText("~Distinguished:");

        jTextField22.setEditable(false);
        jTextField22.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField9))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField11))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField10))))
                                    .addComponent(jTextField4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField12)
                            .addComponent(jTextField13)
                            .addComponent(jTextField14)
                            .addComponent(jTextField15)
                            .addComponent(jTextField16)
                            .addComponent(jTextField17)
                            .addComponent(jTextField18)
                            .addComponent(jTextField19)
                            .addComponent(jTextField22, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jTextField20)
                            .addComponent(jTextField21))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jCheckBox1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Object of MultiChannelQueue to calculate Tables.
        MultiChannelQueue Sim = new MultiChannelQueue();
        
        allTable = new ArrayList<ArrayList<Job>>();
        allTableDistinguished = new ArrayList<ArrayList<Job>>();
        Stats = new ArrayList<Statistics>();
        StatsDistinguished = new ArrayList<Statistics>();
        //          ############################################      One Teller    ##################################
        if (!(jCheckBox1.isSelected())) {
            
            //Iterate over Tries number
            for (int i = 0; i < Integer.valueOf(jTextField1.getText()); i++) {
                //Calculate Table on Each Run
                ArrayList<Job> Table = Sim.CalculateTable(Integer.valueOf(jTextField2.getText()), Integer.valueOf(jTextField3.getText()));
                //Add to ArrayList of Tables
                allTable.add(Table);
                //Calculate Stats of Each Run
                Statistics Stat = Sim.CalculateStats(Table, Integer.valueOf(jTextField2.getText()), Integer.valueOf(jTextField3.getText()));
                //Add to ArrayList of Stats
                Stats.add(Stat);
            }

            //Get Last Run
            ArrayList<Job> finalTable = allTable.get(allTable.size() - 1);
            //Get Last Run Statistics
            Statistics Stat = Stats.get(Stats.size() - 1);

            //Model to change table Content
            DefaultTableModel model = new DefaultTableModel(finalTable.size(), 10);
            jTable1.setModel(model);

            //Columns of Table
            String[] Headers = {"Type", "ID", "InterArrival", "Arrival", "ServiceTime", "TimeServiceBegins", "WaitingTime", "TimeServiceEnds", "TimeSpent", "IdleTime"};

            //Loop over Columns and Set new Headers
            for (int i = 0; i < 10; i++) {
                TableColumn column1 = jTable1.getTableHeader().getColumnModel().getColumn(i);
                column1.setHeaderValue(Headers[i]);
            }
            //Display One Teller Graphs and Values.
            DisplayInfo(finalTable, Stat, "");

        } else {
            //Loop over Number of Tries
            for (int i = 0; i < Integer.valueOf(jTextField1.getText()); i++) {
                //Calculate Table of Ordinary-Only queue
                ArrayList<Job> TableOrdi = Sim.CalculateTable(Integer.valueOf(jTextField2.getText()), 0);
                allTable.add(TableOrdi);
                //Calculate Table of Distinguished-Only Queue
                ArrayList<Job> TableDisti = Sim.CalculateTable(0, Integer.valueOf(jTextField3.getText()));
                allTableDistinguished.add(TableDisti);
                
                //Calculate Stats of Ordinary-only Queue
                Statistics StatOrdi = Sim.CalculateStats(TableOrdi, Integer.valueOf(jTextField2.getText()), 0);
                //Calculate Stats of Distinguished-Only Queue
                Statistics StatDisti = Sim.CalculateStats(TableDisti, 0, Integer.valueOf(jTextField3.getText()));
                Stats.add(StatOrdi);
                StatsDistinguished.add(StatDisti);
            }

            //Get last Row Statistics of Ordinary and Distinguished
            ArrayList<Job> finalTableOrdi = allTable.get(allTable.size() - 1);
            ArrayList<Job> finalTableDisti = allTableDistinguished.get(allTableDistinguished.size() - 1);
            Statistics StatOrdi = Stats.get(Stats.size() - 1);
            Statistics StatDisti = StatsDistinguished.get(StatsDistinguished.size() - 1);
            DefaultTableModel model = null;
            //Set Header Column Names for 2 Tables one for ordinary and one for distinguished
            String[] Headers = {"Type", "ID", "InterArrival", "Arrival", "ServiceTime", "TimeServiceBegins", "WaitingTime", "TimeServiceEnds", "TimeSpent", "IdleTime", "####", "Type", "ID", "InterArrival", "Arrival", "ServiceTime", "TimeServiceBegins", "WaitingTime", "TimeServiceEnds", "TimeSpent", "IdleTime"};

            //Set Row of Tables by Larger Number of Customers in 2 Tellers
            if (finalTableDisti.size() <= finalTableOrdi.size()) {
                model = new DefaultTableModel(finalTableOrdi.size(), Headers.length);
            } else {
                model = new DefaultTableModel(finalTableDisti.size(), Headers.length);
            }

            jTable1.setModel(model);

            for (int i = 0; i < Headers.length; i++) {
                TableColumn column1 = jTable1.getTableHeader().getColumnModel().getColumn(i);
                column1.setHeaderValue(Headers[i]);
            }

            DisplayInfo2Teller(finalTableOrdi, StatOrdi, finalTableDisti, StatDisti);

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed
    //Displays Information in Histogram 
    public void DisplayInfo(ArrayList<Job> finalTable, Statistics Stat, String Type) {
        //Displays Ordinary-Only Related 
        if ("Ordinary".equals(Type) || Type.equals("")) {
            JFreeChart HistogramOrdi = ChartFactory.createHistogram("Histogram (Ordinary Average Waiting Time)", "Average Waiting Time", "Occurences of Tries (%)", createHistogramData("Ordinary", "Waiting"), PlotOrientation.VERTICAL, false, false, false);
            ChartPanel HistogramOrdiPanel = new ChartPanel(HistogramOrdi);
            StatisticsGUI GUIOrdi = new StatisticsGUI(HistogramOrdiPanel);
            GUIOrdi.setVisible(true);
            if ("Ordinary".equals(Type)) {
                JFreeChart HistogramIdleOrd = ChartFactory.createHistogram("Histogram (Idle Time Ordinary)", "Idle Time", "Occurences of Tries (%)", createHistogramData("Ordinary", "Idle"), PlotOrientation.VERTICAL, false, false, false);
                ChartPanel HistogramIdleOrdiPanel = new ChartPanel(HistogramIdleOrd);
                StatisticsGUI GUIIdleOrdi = new StatisticsGUI(HistogramIdleOrdiPanel);
                GUIIdleOrdi.setVisible(true);

                JFreeChart HistogramTotalTimeSpentOrdi = ChartFactory.createHistogram("Histogram (Ordinary Time Spent)", "Time Spent", "Occurences of Tries (%)", createHistogramData("Ordinary", "TimeSpent"), PlotOrientation.VERTICAL, false, false, false);
                ChartPanel HistogramTotalTimeSpentPanel = new ChartPanel(HistogramTotalTimeSpentOrdi);
                StatisticsGUI GUITotalTimeSpentOrdi = new StatisticsGUI(HistogramTotalTimeSpentPanel);
                GUITotalTimeSpentOrdi.setVisible(true);

                JFreeChart HistogramServiceOrdi = ChartFactory.createHistogram("Histogram (Ordinary Service Time)", "Service Time", "Occurences of Tries (%)", createHistogramData("Ordinary", "IndividualService"), PlotOrientation.VERTICAL, false, false, false);
                ChartPanel HistogramServiceOPanel = new ChartPanel(HistogramServiceOrdi);
                StatisticsGUI GUIServiceOrdi = new StatisticsGUI(HistogramServiceOPanel);
                GUIServiceOrdi.setVisible(true);
            }
        }
        //Displays Distinguished-Only Related 
        if ("Distinguished".equals(Type) || Type.equals("")) {
            JFreeChart HistogramDisti = ChartFactory.createHistogram("Histogram (Distinguished Average Waiting Time)", "Average Waiting Time", "Occurences of Tries (%)", createHistogramData("Distinguished", "Waiting"), PlotOrientation.VERTICAL, false, false, false);
            ChartPanel HistogramDistiPanel = new ChartPanel(HistogramDisti);
            StatisticsGUI GUIDisti = new StatisticsGUI(HistogramDistiPanel);
            GUIDisti.setVisible(true);
            if ("Distinguished".equals(Type)) {
                JFreeChart HistogramIdleDisti = ChartFactory.createHistogram("Histogram (Idle Time Distinguished)", "Idle Time", "Occurences of Tries (%)", createHistogramData("Distinguished", "Idle"), PlotOrientation.VERTICAL, false, false, false);
                ChartPanel HistogramIdleDistiPanel = new ChartPanel(HistogramIdleDisti);
                StatisticsGUI GUIIdleDisti = new StatisticsGUI(HistogramIdleDistiPanel);
                GUIIdleDisti.setVisible(true);

                JFreeChart HistogramTotalTimeSpentDisti = ChartFactory.createHistogram("Histogram (Distinguished Time Spent)", "Time Spent", "Occurences of Tries (%)", createHistogramData("Distinguished", "TimeSpent"), PlotOrientation.VERTICAL, false, false, false);
                ChartPanel HistogramTotalTimeSpentDPanel = new ChartPanel(HistogramTotalTimeSpentDisti);
                StatisticsGUI GUITotalTimeSpentDisti = new StatisticsGUI(HistogramTotalTimeSpentDPanel);
                GUITotalTimeSpentDisti.setVisible(true);

                JFreeChart HistogramServiceDisti = ChartFactory.createHistogram("Histogram (Distinguished Service Time)", "Time Spent", "Occurences of Tries (%)", createHistogramData("Distinguished", "IndividualService"), PlotOrientation.VERTICAL, false, false, false);
                ChartPanel HistogramServiceDPanel = new ChartPanel(HistogramServiceDisti);
                StatisticsGUI GUIServiceDisti = new StatisticsGUI(HistogramServiceDPanel);
                GUIServiceDisti.setVisible(true);
            }
        }
        //Displays Both Queus Related 
        if (Type.equals("")) {
            JFreeChart HistogramService = ChartFactory.createHistogram("Histogram (Average Service Time)", "Average Service Time", "Occurences of Tries (%)", createHistogramData("", "Service"), PlotOrientation.VERTICAL, false, false, false);
            ChartPanel HistogramServicePanel = new ChartPanel(HistogramService);
            StatisticsGUI GUIService = new StatisticsGUI(HistogramServicePanel);
            GUIService.setVisible(true);

            JFreeChart HistogramMaxQueue_Ordinary = ChartFactory.createHistogram("Histogram (Max Queue Ordinary)", "Max Queue", "Occurences of Tries(%)", createHistogramData("Ordinary", "MaxQueue"), PlotOrientation.VERTICAL, false, false, false);
            ChartPanel HistogramMaxQueue_OrdinaryPanel = new ChartPanel(HistogramMaxQueue_Ordinary);
            StatisticsGUI GUIMaxQueue_Ordinary = new StatisticsGUI(HistogramMaxQueue_OrdinaryPanel);
            GUIMaxQueue_Ordinary.setVisible(true);

            JFreeChart HistogramMaxQueue_Distinguished = ChartFactory.createHistogram("Histogram (Max Queue Distinguished)", "Max Queue", "Occurences of Tries(%)", createHistogramData("Distinguished", "MaxQueue"), PlotOrientation.VERTICAL, false, false, false);
            ChartPanel HistogramMaxQueue_DistinguishedPanel = new ChartPanel(HistogramMaxQueue_Distinguished);
            StatisticsGUI GUIMaxQueue_Distinguished = new StatisticsGUI(HistogramMaxQueue_DistinguishedPanel);
            GUIMaxQueue_Distinguished.setVisible(true);

            JFreeChart HistogramProbWait_Ordinary = ChartFactory.createHistogram("Histogram (Ordinary Probability of Waiting)", "Probability of Waiting", "Occurences of Tries (%)", createHistogramData("Ordinary", "ProbWait"), PlotOrientation.VERTICAL, false, false, false);
            ChartPanel HistogramProbWait_OrdinaryPanel = new ChartPanel(HistogramProbWait_Ordinary);
            StatisticsGUI GUIProbWait_Ordinary = new StatisticsGUI(HistogramProbWait_OrdinaryPanel);
            GUIProbWait_Ordinary.setVisible(true);

            JFreeChart HistogramProbWait_Distinguished = ChartFactory.createHistogram("Histogram (Distinguished Probability of Waiting)", "Probability of Waiting", "Occurences of Tries (%)", createHistogramData("Distinguished", "ProbWait"), PlotOrientation.VERTICAL, false, false, false);
            ChartPanel HistogramProbWait_DistinguishedPanel = new ChartPanel(HistogramProbWait_Distinguished);
            StatisticsGUI GUIProbWait_Distinguished = new StatisticsGUI(HistogramProbWait_DistinguishedPanel);
            GUIProbWait_Distinguished.setVisible(true);

            JFreeChart HistogramIdle = ChartFactory.createHistogram("Histogram (Idle Time)", "Idle Time", "Occurences of Tries (%)", createHistogramData("", "Idle"), PlotOrientation.VERTICAL, false, false, false);
            ChartPanel HistogramIdlePanel = new ChartPanel(HistogramIdle);
            StatisticsGUI GUIIdle = new StatisticsGUI(HistogramIdlePanel);
            GUIIdle.setVisible(true);

            JFreeChart HistogramInterArrival = ChartFactory.createHistogram("Histogram (Average InterArrival)", "Interarrival", "Occurences of Tries (%)", createHistogramData("", "InterArrival"), PlotOrientation.VERTICAL, false, false, false);
            ChartPanel HistogramInterarrivalPanel = new ChartPanel(HistogramInterArrival);
            StatisticsGUI GUIInterarrival = new StatisticsGUI(HistogramInterarrivalPanel);
            GUIInterarrival.setVisible(true);
        }

        //Loop Over Table ROws and add Data
        for (int i = 0; i < jTable1.getRowCount(); i++) {

            jTable1.setValueAt(finalTable.get(i).getType(), i, 0);
            jTable1.setValueAt(finalTable.get(i).getJobID() + 1, i, 1);
            jTable1.setValueAt(finalTable.get(i).getInterarrivalTime(), i, 2);
            jTable1.setValueAt(finalTable.get(i).getArrivalTime(), i, 3);
            jTable1.setValueAt(finalTable.get(i).getServiceTime(), i, 4);
            jTable1.setValueAt(finalTable.get(i).getTimeServiceBegins(), i, 5);
            jTable1.setValueAt(finalTable.get(i).getWaitingTime(), i, 6);
            jTable1.setValueAt(finalTable.get(i).getTimeServiceEnds(), i, 7);
            jTable1.setValueAt(finalTable.get(i).getTimeSpentInSystem(), i, 8);
            jTable1.setValueAt(finalTable.get(i).getIdleTime(), i, 9);

        }
        
        //If One Teller
        if (!(jCheckBox1.isSelected())) {
            //Set Value of Statistics of last Run
            jTextField4.setText(String.valueOf(Stat.getAverageServiceTime()));
            jTextField5.setText(String.valueOf(Stat.getAverageWaitingTime_Ordi()));
            jTextField6.setText(String.valueOf(Stat.getMaxQueue_Ordi()));
            jTextField7.setText(String.valueOf(Stat.getWait_Ordi()));
            jTextField8.setText(String.valueOf(Stat.getIdleTimeSummation()));
            jTextField9.setText(String.valueOf(Stat.getAverageWaitingTime_Disti()));
            jTextField10.setText(String.valueOf(Stat.getMaxQueue_Disti()));
            jTextField11.setText(String.valueOf(Stat.getWait_Disti()));
            //initialize Staistics object to calculate total runs Statistics
            Statistics totalStats = new Statistics(0, 0, 0, 0, 0, 0, 0, 0);
            for (int i = 0; i < Stats.size(); i++) {
                //Calculate total Runs statistics
                totalStats.setAverageServiceTime(totalStats.getAverageServiceTime() + Stats.get(i).getAverageServiceTime());
                totalStats.setAverageWaitingTime_Ordi(totalStats.getAverageWaitingTime_Ordi() + Stats.get(i).getAverageWaitingTime_Ordi());
                totalStats.setAverageWaitingTime_Disti(totalStats.getAverageWaitingTime_Disti() + Stats.get(i).getAverageWaitingTime_Disti());
                totalStats.setMaxQueue_Ordi(totalStats.getMaxQueue_Ordi() + Stats.get(i).getMaxQueue_Ordi());
                totalStats.setMaxQueue_Disti(totalStats.getMaxQueue_Disti() + Stats.get(i).getMaxQueue_Disti());
                totalStats.setWait_Ordi(totalStats.getWait_Ordi() + Stats.get(i).getWait_Ordi());
                totalStats.setWait_Disti(totalStats.getWait_Disti() + Stats.get(i).getWait_Disti());
                totalStats.setIdleTimeSummation(totalStats.getIdleTimeSummation() + Stats.get(i).getIdleTimeSummation());
                totalStats.setAverageInterArrival(totalStats.getAverageInterArrival() + Stats.get(i).getAverageInterArrival());
                totalStats.setInterArrivalOrdi(totalStats.getInterArrivalOrdi() + Stats.get(i).getInterArrivalOrdi());
                totalStats.setInterArrivalDisti(totalStats.getInterArrivalDisti() + Stats.get(i).getInterArrivalDisti());
            }

            //Set Values of Total Runs Statstics in TextFields
            jTextField12.setText(String.valueOf(totalStats.getAverageServiceTime() / Stats.size()));
            jTextField13.setText(String.valueOf(totalStats.getAverageWaitingTime_Ordi() / Stats.size()));
            jTextField15.setText(String.valueOf(totalStats.getMaxQueue_Ordi() / Stats.size()));
            jTextField17.setText(String.valueOf(totalStats.getWait_Ordi() / Stats.size()));
            jTextField19.setText(String.valueOf(totalStats.getIdleTimeSummation() / Stats.size()));
            jTextField14.setText(String.valueOf(totalStats.getAverageWaitingTime_Disti() / Stats.size()));
            jTextField16.setText(String.valueOf(totalStats.getMaxQueue_Disti() / Stats.size()));
            jTextField18.setText(String.valueOf(totalStats.getWait_Disti() / Stats.size()));
            jTextField20.setText(String.valueOf(totalStats.getAverageInterArrival() / Stats.size()));
            jTextField21.setText(String.valueOf(totalStats.getInterArrivalOrdi() / Stats.size()));
            jTextField22.setText(String.valueOf(totalStats.getInterArrivalDisti() / Stats.size()));

            
        } else { // 2 Teller

            //If Table is Ordinary. Show Ordinary Values
            if (Type.equals("Ordinary")) {

                jTextField5.setText(String.valueOf(Stat.getAverageWaitingTime_Ordi()));
                jTextField6.setText(String.valueOf(Stat.getMaxQueue_Ordi()));
                jTextField7.setText(String.valueOf(Stat.getWait_Ordi()));
            }
            //Show Distinguished Values
            if (Type.equals("Distinguished")) {
                jTextField4.setText(String.valueOf(Stat.getAverageServiceTime()));
                jTextField8.setText(String.valueOf(Stat.getIdleTimeSummation()));
                jTextField9.setText(String.valueOf(Stat.getAverageWaitingTime_Disti()));
                jTextField10.setText(String.valueOf(Stat.getMaxQueue_Disti()));
                jTextField11.setText(String.valueOf(Stat.getWait_Disti()));
            }
            //Calculate Total Statistics for Ordinary alone and distinguished alone.
            Statistics totalStats = new Statistics(0, 0, 0, 0, 0, 0, 0, 0);
            for (int i = 0; i < Stats.size(); i++) {
                if (Type.equals("Ordinary")) {

                    totalStats.setAverageWaitingTime_Ordi(totalStats.getAverageWaitingTime_Ordi() + Stats.get(i).getAverageWaitingTime_Ordi());
                    totalStats.setMaxQueue_Ordi(totalStats.getMaxQueue_Ordi() + Stats.get(i).getMaxQueue_Ordi());
                    totalStats.setWait_Ordi(totalStats.getWait_Ordi() + Stats.get(i).getWait_Ordi());
                    totalStats.setInterArrivalOrdi(totalStats.getInterArrivalOrdi() + Stats.get(i).getInterArrivalOrdi());
                }
                if (Type.equals("Distinguished")) {

                    totalStats.setAverageServiceTime(totalStats.getAverageServiceTime() + StatsDistinguished.get(i).getAverageServiceTime());
                    totalStats.setAverageWaitingTime_Disti(totalStats.getAverageWaitingTime_Disti() + StatsDistinguished.get(i).getAverageWaitingTime_Disti());
                    totalStats.setMaxQueue_Disti(totalStats.getMaxQueue_Disti() + StatsDistinguished.get(i).getMaxQueue_Disti());
                    totalStats.setWait_Disti(totalStats.getWait_Disti() + StatsDistinguished.get(i).getWait_Disti());
                    totalStats.setIdleTimeSummation(totalStats.getIdleTimeSummation() + StatsDistinguished.get(i).getIdleTimeSummation());
                    totalStats.setInterArrivalDisti(totalStats.getInterArrivalDisti() + StatsDistinguished.get(i).getInterArrivalDisti());
                }
            }
            if (Type.equals("Ordinary")) {
                jTextField12.setText(String.valueOf(totalStats.getAverageServiceTime() / Stats.size()));
                jTextField13.setText(String.valueOf(totalStats.getAverageWaitingTime_Ordi() / Stats.size()));
                jTextField15.setText(String.valueOf(totalStats.getMaxQueue_Ordi() / Stats.size()));
                jTextField17.setText(String.valueOf(totalStats.getWait_Ordi() / Stats.size()));
                jTextField19.setText(String.valueOf(totalStats.getIdleTimeSummation() / Stats.size()));

                jTextField21.setText(String.valueOf(totalStats.getInterArrivalOrdi() / Stats.size()));

            }
            if (Type.equals("Distinguished")) {
                jTextField19.setText(String.valueOf(totalStats.getIdleTimeSummation() / StatsDistinguished.size()));
                jTextField14.setText(String.valueOf(totalStats.getAverageWaitingTime_Disti() / StatsDistinguished.size()));
                jTextField16.setText(String.valueOf(totalStats.getMaxQueue_Disti() / StatsDistinguished.size()));
                jTextField18.setText(String.valueOf(totalStats.getWait_Disti() / StatsDistinguished.size()));
                jTextField22.setText(String.valueOf(totalStats.getInterArrivalDisti() / StatsDistinguished.size()));
                jTextField14.setText(String.valueOf(totalStats.getAverageWaitingTime_Disti() / StatsDistinguished.size()));
                jTextField16.setText(String.valueOf(totalStats.getMaxQueue_Disti() / StatsDistinguished.size()));
                jTextField18.setText(String.valueOf(totalStats.getWait_Disti() / StatsDistinguished.size()));
            }
        }
    }

    public void DisplayInfo2Teller(ArrayList<Job> finalTable, Statistics Stat, ArrayList<Job> finalTable2, Statistics Stat2) {

        //Ordinary
        JFreeChart HistogramOrdi = ChartFactory.createHistogram("Histogram (Ordinary Average Waiting Time)", "Average Waiting Time", "Occurences of Tries (%)", createHistogramData("Ordinary", "Waiting"), PlotOrientation.VERTICAL, false, false, false);
        ChartPanel HistogramOrdiPanel = new ChartPanel(HistogramOrdi);
        StatisticsGUI GUIOrdi = new StatisticsGUI(HistogramOrdiPanel);
        GUIOrdi.setVisible(true);

        JFreeChart HistogramIdleOrd = ChartFactory.createHistogram("Histogram (Idle Time Ordinary)", "Idle Time", "Occurences of Tries (%)", createHistogramData("Ordinary", "Idle"), PlotOrientation.VERTICAL, false, false, false);
        ChartPanel HistogramIdleOrdiPanel = new ChartPanel(HistogramIdleOrd);
        StatisticsGUI GUIIdleOrdi = new StatisticsGUI(HistogramIdleOrdiPanel);
        GUIIdleOrdi.setVisible(true);

        JFreeChart HistogramTotalTimeSpentOrdi = ChartFactory.createHistogram("Histogram (Ordinary Time Spent)", "Time Spent", "Occurences of Tries (%)", createHistogramData("Ordinary", "TimeSpent"), PlotOrientation.VERTICAL, false, false, false);
        ChartPanel HistogramTotalTimeSpentPanel = new ChartPanel(HistogramTotalTimeSpentOrdi);
        StatisticsGUI GUITotalTimeSpentOrdi = new StatisticsGUI(HistogramTotalTimeSpentPanel);
        GUITotalTimeSpentOrdi.setVisible(true);

        JFreeChart HistogramServiceOrdi = ChartFactory.createHistogram("Histogram (Ordinary Service Time)", "Service Time", "Occurences of Tries (%)", createHistogramData("Ordinary", "IndividualService"), PlotOrientation.VERTICAL, false, false, false);
        ChartPanel HistogramServiceOPanel = new ChartPanel(HistogramServiceOrdi);
        StatisticsGUI GUIServiceOrdi = new StatisticsGUI(HistogramServiceOPanel);
        GUIServiceOrdi.setVisible(true);

        //Distinguished
        JFreeChart HistogramDisti = ChartFactory.createHistogram("Histogram (Distinguished Average Waiting Time)", "Average Waiting Time", "Occurences of Tries (%)", createHistogramData("Distinguished", "Waiting"), PlotOrientation.VERTICAL, false, false, false);
        ChartPanel HistogramDistiPanel = new ChartPanel(HistogramDisti);
        StatisticsGUI GUIDisti = new StatisticsGUI(HistogramDistiPanel);
        GUIDisti.setVisible(true);

        JFreeChart HistogramIdleDisti = ChartFactory.createHistogram("Histogram (Idle Time Distinguished)", "Idle Time", "Occurences of Tries (%)", createHistogramData("Distinguished", "Idle"), PlotOrientation.VERTICAL, false, false, false);
        ChartPanel HistogramIdleDistiPanel = new ChartPanel(HistogramIdleDisti);
        StatisticsGUI GUIIdleDisti = new StatisticsGUI(HistogramIdleDistiPanel);
        GUIIdleDisti.setVisible(true);

        JFreeChart HistogramTotalTimeSpentDisti = ChartFactory.createHistogram("Histogram (Distinguished Time Spent)", "Time Spent", "Occurences of Tries (%)", createHistogramData("Distinguished", "TimeSpent"), PlotOrientation.VERTICAL, false, false, false);
        ChartPanel HistogramTotalTimeSpentDPanel = new ChartPanel(HistogramTotalTimeSpentDisti);
        StatisticsGUI GUITotalTimeSpentDisti = new StatisticsGUI(HistogramTotalTimeSpentDPanel);
        GUITotalTimeSpentDisti.setVisible(true);

        JFreeChart HistogramServiceDisti = ChartFactory.createHistogram("Histogram (Distinguished Service Time)", "Time Spent", "Occurences of Tries (%)", createHistogramData("Distinguished", "IndividualService"), PlotOrientation.VERTICAL, false, false, false);
        ChartPanel HistogramServiceDPanel = new ChartPanel(HistogramServiceDisti);
        StatisticsGUI GUIServiceDisti = new StatisticsGUI(HistogramServiceDPanel);
        GUIServiceDisti.setVisible(true);

        for (int i = 0; i < finalTable.size(); i++) {
            jTable1.setValueAt(finalTable.get(i).getType(), i, 0);
            jTable1.setValueAt(finalTable.get(i).getJobID() + 1, i, 1);
            jTable1.setValueAt(finalTable.get(i).getInterarrivalTime(), i, 2);
            jTable1.setValueAt(finalTable.get(i).getArrivalTime(), i, 3);
            jTable1.setValueAt(finalTable.get(i).getServiceTime(), i, 4);
            jTable1.setValueAt(finalTable.get(i).getTimeServiceBegins(), i, 5);
            jTable1.setValueAt(finalTable.get(i).getWaitingTime(), i, 6);
            jTable1.setValueAt(finalTable.get(i).getTimeServiceEnds(), i, 7);
            jTable1.setValueAt(finalTable.get(i).getTimeSpentInSystem(), i, 8);
            jTable1.setValueAt(finalTable.get(i).getIdleTime(), i, 9);
        }
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            jTable1.setValueAt("####", i, 10);
        }

        for (int i = 0; i < finalTable2.size(); i++) {

            jTable1.setValueAt(finalTable2.get(i).getType(), i, 11);
            jTable1.setValueAt(finalTable2.get(i).getJobID() + 1, i, 12);
            jTable1.setValueAt(finalTable2.get(i).getInterarrivalTime(), i, 13);
            jTable1.setValueAt(finalTable2.get(i).getArrivalTime(), i, 14);
            jTable1.setValueAt(finalTable2.get(i).getServiceTime(), i, 15);
            jTable1.setValueAt(finalTable2.get(i).getTimeServiceBegins(), i, 16);
            jTable1.setValueAt(finalTable2.get(i).getWaitingTime(), i, 17);
            jTable1.setValueAt(finalTable2.get(i).getTimeServiceEnds(), i, 18);
            jTable1.setValueAt(finalTable2.get(i).getTimeSpentInSystem(), i, 19);
            jTable1.setValueAt(finalTable2.get(i).getIdleTime(), i, 20);

        }

        jTextField5.setText(String.valueOf(Stat.getAverageWaitingTime_Ordi()));
        jTextField6.setText(String.valueOf(Stat.getMaxQueue_Ordi()));
        jTextField7.setText(String.valueOf(Stat.getWait_Ordi()));

        jTextField4.setText(String.valueOf(Stat2.getAverageServiceTime()));
        jTextField8.setText(String.valueOf(Stat2.getIdleTimeSummation()));
        jTextField9.setText(String.valueOf(Stat2.getAverageWaitingTime_Disti()));
        jTextField10.setText(String.valueOf(Stat2.getMaxQueue_Disti()));
        jTextField11.setText(String.valueOf(Stat2.getWait_Disti()));

        Statistics totalStats = new Statistics(0, 0, 0, 0, 0, 0, 0, 0);
        for (int i = 0; i < Stats.size(); i++) {

            totalStats.setAverageWaitingTime_Ordi(totalStats.getAverageWaitingTime_Ordi() + Stats.get(i).getAverageWaitingTime_Ordi());
            totalStats.setMaxQueue_Ordi(totalStats.getMaxQueue_Ordi() + Stats.get(i).getMaxQueue_Ordi());
            totalStats.setWait_Ordi(totalStats.getWait_Ordi() + Stats.get(i).getWait_Ordi());
            totalStats.setInterArrivalOrdi(totalStats.getInterArrivalOrdi() + Stats.get(i).getInterArrivalOrdi());

            totalStats.setAverageServiceTime(totalStats.getAverageServiceTime() + StatsDistinguished.get(i).getAverageServiceTime());
            totalStats.setAverageWaitingTime_Disti(totalStats.getAverageWaitingTime_Disti() + StatsDistinguished.get(i).getAverageWaitingTime_Disti());
            totalStats.setMaxQueue_Disti(totalStats.getMaxQueue_Disti() + StatsDistinguished.get(i).getMaxQueue_Disti());
            totalStats.setWait_Disti(totalStats.getWait_Disti() + StatsDistinguished.get(i).getWait_Disti());
            totalStats.setIdleTimeSummation(totalStats.getIdleTimeSummation() + StatsDistinguished.get(i).getIdleTimeSummation());
            totalStats.setInterArrivalDisti(totalStats.getInterArrivalDisti() + StatsDistinguished.get(i).getInterArrivalDisti());

        }

        jTextField12.setText(String.valueOf(totalStats.getAverageServiceTime() / Stats.size()));
        jTextField13.setText(String.valueOf(totalStats.getAverageWaitingTime_Ordi() / Stats.size()));
        jTextField15.setText(String.valueOf(totalStats.getMaxQueue_Ordi() / Stats.size()));
        jTextField17.setText(String.valueOf(totalStats.getWait_Ordi() / Stats.size()));
        jTextField19.setText(String.valueOf(totalStats.getIdleTimeSummation() / Stats.size()));

        jTextField21.setText(String.valueOf(totalStats.getInterArrivalOrdi() / Stats.size()));

        jTextField19.setText(String.valueOf(totalStats.getIdleTimeSummation() / StatsDistinguished.size()));
        jTextField14.setText(String.valueOf(totalStats.getAverageWaitingTime_Disti() / StatsDistinguished.size()));
        jTextField16.setText(String.valueOf(totalStats.getMaxQueue_Disti() / StatsDistinguished.size()));
        jTextField18.setText(String.valueOf(totalStats.getWait_Disti() / StatsDistinguished.size()));
        jTextField22.setText(String.valueOf(totalStats.getInterArrivalDisti() / StatsDistinguished.size()));
        jTextField14.setText(String.valueOf(totalStats.getAverageWaitingTime_Disti() / StatsDistinguished.size()));
        jTextField16.setText(String.valueOf(totalStats.getMaxQueue_Disti() / StatsDistinguished.size()));
        jTextField18.setText(String.valueOf(totalStats.getWait_Disti() / StatsDistinguished.size()));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QueueGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QueueGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QueueGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QueueGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QueueGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
