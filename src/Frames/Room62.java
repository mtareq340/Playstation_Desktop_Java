/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Connection.Sql;
import Daos.billDao;
import Daos.billDrinkDao;
import Daos.deviceDao;
import Daos.drinkDao;
import entities.Bill;
import entities.Device;
import entities.Drink;
import entities.billDrink;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import playstation.loginFrame;

/**
 *
 * @author AT
 */
public class Room62 extends javax.swing.JFrame {

    static double setSeconds = 0;
    static double setMinutes = 0;
    static double setHours = 0;
    static double getSeconds = 0;
    static double getMinutes = 0;
    static double getHours = 0 ;
    static String result = "" ;
    static String startTime = "" ;
    static String endTime = "" ;
    static String dcurrentDate = "" ;
    static String currentDate = "" ;
    static boolean stat = true;
    static double total= 0.0;
    static double totalAll=0.0;
   
    /**
     * Creates new form Room1
     */
    public Room62() {
        initComponents();
        Sql sql=new Sql();
        drinkDao drinkdao=new drinkDao();
        List<Drink> list=drinkdao.selectDrink();
        DefaultTableModel model=(DefaultTableModel)drinkTable.getModel();
       
        Object[] row=new Object[2];
        for (int i = 0; i < list.size(); i++) {
             row[0] = list.get(i).getDrinkName();      
             row[1] = list.get(i).getDrinkPrice();
            
            drinkTable.setRowHeight( 25);
            drinkTable.getColumn("Add").setCellRenderer(new ButtonRenderer(){
            //  JButton button=new JButton("bbb");
            
            });
             drinkTable.getColumn("Add").setCellEditor(new ButtonEditor(new JCheckBox()));
             
               
            model.addRow(row);
        }
      
        sql.close();
    }
      public double getsum(){
        int rowcount=drinkTable2.getRowCount();
        double sum=0;
        for(int i=0;i<rowcount;i++){
            sum=sum+Double.parseDouble(drinkTable2.getValueAt(i, 1).toString());
        }
        return sum;
    }

    class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;
    
    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton("Add");
       
      
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
              
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
      
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
             
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
             
        }
       
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
             Sql sql=new Sql();

       TableModel model1=drinkTable.getModel();
        int[] indexs=drinkTable.getSelectedRows();
        Object[] row=new Object[2];
         DefaultTableModel model2=(DefaultTableModel)drinkTable2.getModel();
        for (int i = 0; i < indexs.length; i++) {
           
            row[0] = model1.getValueAt(indexs[i], 0);
            row[1] = model1.getValueAt(indexs[i], 1);
         
           
            model2.addRow(row);
             
     //   textsum.setText(Double.toString(getsum()));
        }
        }
        isPushed = false;
        return label;
    }
    

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}
class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
      
    }
   
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if (isSelected) {
            setForeground(drinkTable.getSelectionForeground());
            setBackground(drinkTable.getSelectionBackground());
        } else {
            setForeground(drinkTable.getForeground());
            setBackground(UIManager.getColor(".background"));
        }
       
        return this;
    }
    
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
        btnStart = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        drinkTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        drinkTable2 = new javax.swing.JTable();
        second = new javax.swing.JLabel();
        minute = new javax.swing.JLabel();
        hour = new javax.swing.JLabel();
        hour3 = new javax.swing.JLabel();
        hour4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CKmultiuser = new javax.swing.JCheckBox();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Room 6(2)");

        btnStart.setBackground(new java.awt.Color(0, 204, 0));
        btnStart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnStart.setText("Start");
        btnStart.setMaximumSize(new java.awt.Dimension(100, 50));
        btnStart.setMinimumSize(new java.awt.Dimension(100, 50));
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("End");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        drinkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "price", "Add"
            }
        ));
        jScrollPane1.setViewportView(drinkTable);

        drinkTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "price"
            }
        ));
        jScrollPane2.setViewportView(drinkTable2);

        second.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        second.setText("00");

        minute.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        minute.setText("00");

        hour.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        hour.setText("00");

        hour3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        hour3.setText(" :");

        hour4.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        hour4.setText(" :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("  Multi User");

        CKmultiuser.setText("Multi");
        CKmultiuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CKmultiuserActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setText("Remove Drink");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(162, 162, 162))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(hour)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hour3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minute)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hour4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(second)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CKmultiuser))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2))
                                .addGap(86, 86, 86)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addGap(16, 16, 16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(second, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CKmultiuser))
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                .addGap(40, 40, 40))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(47, 47, 47))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        stat = true;
        btnStart.setEnabled(false);
        Thread t = new Thread()
        {
            public void run()
            {
               for(;;)
               {
                    if(stat)
                    {
                        try {
                                sleep(1000);
                                
                                setSeconds++;
                                
                                if(setSeconds>60)
                                {
                                    setSeconds = 0;
                                    setMinutes++;
                                }
                                
                                if(setMinutes>60)
                                {
                                    setSeconds = 0;
                                    setMinutes = 0;
                                    setHours++;
                                }
                                
                                second.setText(""+setSeconds);
                                minute.setText(""+setMinutes);
                                hour.setText(""+setHours);
                        } catch (Exception e) {
                        }
                    }
                    else
                    {
            
         //   hour.setText("00");
          //  minute.setText("00");
          //  second.setText("00");                         
            break;
            
                    }
               }
            }
        };
        t.start();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        startTime = sdf.format(date);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         btnStart.setEnabled(true);
        
        Sql sql=new Sql();
        drinkDao dDao=new drinkDao();
        billDrinkDao bdDao=new billDrinkDao();
        billDao bDao=new billDao();
        stat = false;
        totalAll=getsum();
        
        deviceDao devicedao=new deviceDao();
       List<Device> device=devicedao.searchDevice("Room 6(2)");
        String strprice=device.get(0).getDevicePrice();
        String strmulti=device.get(0).getDevicemulti();
        double multi=Double.parseDouble(strmulti);

        
            double price=Double.parseDouble(strprice);
            
            getHours = Double.parseDouble(hour.getText());
            getMinutes =  Double.parseDouble(minute.getText());
            getSeconds =  Double.parseDouble(second.getText());
            
            
            result = getHours + " : " + getMinutes + " : " + getSeconds ;
            
            if(CKmultiuser.isSelected()){
                
                 price+=multi;
            }else{
               
            }
            
            total = (getHours * price) + ((getMinutes/60) * price) + ((getSeconds/3600) * price);
            totalAll+=total;

            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            endTime = sdfTime.format(date);
            currentDate = sdfDate.format(date);
            Bill b = new Bill(startTime, endTime, result, ""+total, currentDate,""+totalAll);
            bDao.insertBill(b);
            int rowcount=drinkTable2.getRowCount();
            int maxID= bDao.SelectMaxBillID();
            for(int i=0;i<rowcount;i++){
           
            List<Drink> drink=dDao.searchDrink(drinkTable2.getValueAt(i, 0).toString());
            int drinkID=drink.get(0).getDrinkId();
            billDrink bdrink=new billDrink( maxID,drinkID);
              
           bdDao.insertBillDrink(bdrink);
           
            }
            if(rowcount>0)
            {
            Connection con = null ;
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "ps"
                + "?useUnicode=true&characterEncoding=UTF-8", "root", "");

        } catch (Exception ex) {
            //getMessage() ÈÊÌÈáì ÑÓÇáå ÈÇáÇßÓÈÔä Çááì ÍÕá ÈÇáÙÈØ
            System.out.println(ex.getMessage());

        }
                JasperReport jasperReport;
        try {
            File f = new File("Report/billReport.jrxml");
            jasperReport = JasperCompileManager.compileReport(f.getAbsolutePath());  
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null ,con);
            JasperViewer jv = new JasperViewer( jasperPrint, false );
            jv.viewReport( jasperPrint, false );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            }
            else
            {Connection con = null ;
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "ps"
                + "?useUnicode=true&characterEncoding=UTF-8", "root", "");

        } catch (Exception ex) {
            //getMessage() ÈÊÌÈáì ÑÓÇáå ÈÇáÇßÓÈÔä Çááì ÍÕá ÈÇáÙÈØ
            System.out.println(ex.getMessage());

        }
        
        JasperReport jasperReport;
        try {
            File f = new File("Report/billReportDrinks.jrxml");
            jasperReport = JasperCompileManager.compileReport(f.getAbsolutePath());  
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null ,con);
            JasperViewer jv = new JasperViewer( jasperPrint, false );
            jv.viewReport( jasperPrint, false );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            }
            DefaultTableModel model = (DefaultTableModel) drinkTable2.getModel();
            model.setRowCount(0);
        

            
        
// TODO add your handling code here
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CKmultiuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CKmultiuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CKmultiuserActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

         stat=false;
        btnStart.setEnabled(true);
         CKmultiuser.setSelected(false);
        
            setHours = 0;
            setMinutes = 0;
            setSeconds = 0;
            getHours = 0;
            getMinutes = 0;
            getSeconds = 0;
            
            hour.setText(Double.toString(getHours));
            minute.setText(Double.toString(getMinutes));
            second.setText(Double.toString(getSeconds));
            
               DefaultTableModel model = (DefaultTableModel) drinkTable2.getModel();
            model.setRowCount(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        // TODO add your handling code here:

        DefaultTableModel model2=(DefaultTableModel)drinkTable2.getModel();
        int row=drinkTable2.getSelectedRow();
        try {
            model2.removeRow(row);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Select Drink ");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(Room62.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Room62.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Room62.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Room62.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Room62().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CKmultiuser;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnStart;
    private javax.swing.JTable drinkTable;
    private javax.swing.JTable drinkTable2;
    private javax.swing.JLabel hour;
    private javax.swing.JLabel hour3;
    private javax.swing.JLabel hour4;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel minute;
    private javax.swing.JLabel second;
    // End of variables declaration//GEN-END:variables
}
