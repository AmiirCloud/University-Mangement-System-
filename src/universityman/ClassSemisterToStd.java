
package universityman;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ClassSemisterToStd extends javax.swing.JFrame {

    public ClassSemisterToStd() {
        initComponents();
        // Class semister combox 
        fill_Class_com();
        fillStudent_com();
        fillSemister_view();
        fillAccademic_year_com();
        
        // Fill Class Semister Table 
        fillStudentClassesSemister();
        
        //double  click method 
        doubleClickForStdInfromatin();
        
    }
    public static void fillStudentClassesSemister() {
        String query = "select * from stdClassSemister";
        DbConnection.viewTable(query, Class_semister_table);
    }
    public static void fillStudent_com() {
        std_com.removeAllItems();
        String selectedItem = "Choose Student ";
        std_com.addItem(selectedItem);
        std_com.setSelectedItem(selectedItem);

        String query = "select * from fillstudent_view ";
        DbConnection.fillComp(query, std_com);
    }

    public static void fillAccademic_year_com() {
        year_com.removeAllItems();
        String selectedItem = "Choose Accademic Year ";
        year_com.addItem(selectedItem);
        year_com.setSelectedItem(selectedItem);

        String query = "select * from accademic_year_view ";
        DbConnection.fillComp(query, year_com);
    }

    public static void fillSemister_view() {
        semister_com.removeAllItems();
        String selectedItem = "Choose Semister ";
        semister_com.addItem(selectedItem);
        semister_com.setSelectedItem(selectedItem);

        String query = "select * from semister_view ";
        DbConnection.fillComp(query, semister_com);
    }
//
    public static void fill_Class_com() {
        Class_com.removeAllItems();
        String selectedItem = "Choose Class ";
        Class_com.addItem(selectedItem);
        Class_com.setSelectedItem(selectedItem);

        String query = "select * from Class_view_com ";
        DbConnection.fillComp(query, Class_com);
    }
//     double Click Event for The Table 
        public static void doubleClickForStdInfromatin() {

        Class_semister_table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
//                    int rowId = Class_semister_table.getSelectedRow();
                    setCombox();
                }
            }
        });
    }
        // set the combox to Update 
           public static void setCombox() {
        TableModel tm = Class_semister_table.getModel();
        int selectedRow = Class_semister_table.getSelectedRow();
        String std = tm.getValueAt(selectedRow, 1).toString();
        String class_name = tm.getValueAt(selectedRow, 2).toString();
        String sem_name = tm.getValueAt(selectedRow, 3).toString();
        String year_name = tm.getValueAt(selectedRow, 7).toString();

        std_com.addItem(std);
        std_com.setSelectedItem(std);

        Class_com.addItem(class_name);
        Class_com.setSelectedItem(class_name);
        semister_com.addItem(sem_name);
        semister_com.setSelectedItem(sem_name);
        year_com.addItem(year_name);
        year_com.setSelectedItem(year_name);

    }
//  Data Manipulation 
//======================================================================
       public static void insertClassSemister() {
        String oper = "insert";
        String cl_nameWith_id = Class_com.getSelectedItem().toString();
        String arrayForClass[] = cl_nameWith_id.split(" ");
        int cl_no = Integer.parseInt(arrayForClass[0]);

        String student_nameWith_id = std_com.getSelectedItem().toString();
        String arrayForStudent[] = student_nameWith_id.split(" ");
        int id_no = Integer.parseInt(arrayForStudent[0]);

        String year_nameWith_id = year_com.getSelectedItem().toString();
        String arrayForYear[] = year_nameWith_id.split(" ");
        int year_no = Integer.parseInt(arrayForYear[0]);

        String semister_nameWith_id = semister_com.getSelectedItem().toString();
        String arrayForSemistert[] = semister_nameWith_id.split(" ");
        int sem_no = Integer.parseInt(arrayForSemistert[0]);


        String sql = "call class_semister('" +id_no + "','" + cl_no + "','" + sem_no + "','" + year_no + "','" + oper + "',null )";
        DbConnection.setSQL(sql);
        fillStudentClassesSemister();//  Fill The Table when insertion is occured 

    }
    public static boolean validateText() {
        if (std_com.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Please Choose Student");
            return false;
        }
        if (Class_com.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Please Choose Class");
            return false;
        }
        if (semister_com.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Please Choose Semister ");
            return false;
        }

        if (year_com.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Please Choose Academic  Year ");
            return false;
        }

        return true;
    }
    // UPdate 
     public void updateStudentClassSemister() {
        String oper = "update";
        TableModel dtm = (TableModel) Class_semister_table.getModel();
        int selectedRow = Class_semister_table.getSelectedRow();
        int cs_no = Integer.parseInt(dtm.getValueAt(selectedRow, 0).toString());

        //  String class_name  =  Class_txt.getText();
        String cl_name = Class_com.getSelectedItem().toString();
        String arrayForClass[] = cl_name.split(" ");
        int cl_no = Integer.parseInt(arrayForClass[0]);

        String student_name = std_com.getSelectedItem().toString();
        String arrayForStudent[] = student_name.split(" ");
        int std_no = Integer.parseInt(arrayForStudent[0]);

        String year_name = year_com.getSelectedItem().toString();
        String arrayForYear[] = year_name.split(" ");
        int year_no = Integer.parseInt(arrayForYear[0]);

        String semister_name = semister_com.getSelectedItem().toString();
        String arrayForSemister[] = semister_name.split(" ");
        int sem_no = Integer.parseInt(arrayForSemister[0]);
        JOptionPane.showMessageDialog(null, cl_no+  " "+std_no+ " "+ sem_no+ "  "+year_no); 
        String sql = "call class_semister('" + std_no + "','" + cl_no + "','" + sem_no + "','" + year_no + "','" + oper + "','" + cs_no + "')";
        DbConnection.setSQL(sql);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Class_com = new RSMaterialComponent.RSComboBoxMaterial();
        std_com = new RSMaterialComponent.RSComboBoxMaterial();
        year_com = new RSMaterialComponent.RSComboBoxMaterial();
        semister_com = new RSMaterialComponent.RSComboBoxMaterial();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Class_semister_table = new javax.swing.JTable();
        rSButtonMaterialIconOne9 = new RSMaterialComponent.RSButtonMaterialIconOne();
        UpdateClassSem = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("x");
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 70, 50));

        jLabel2.setBackground(new java.awt.Color(9, 121, 105));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Assgin Student To Class And Semister ");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 50));

        Class_com.setForeground(new java.awt.Color(102, 102, 102));
        Class_com.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        jPanel1.add(Class_com, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 250, -1));

        std_com.setForeground(new java.awt.Color(102, 102, 102));
        std_com.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        jPanel1.add(std_com, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 250, -1));

        year_com.setForeground(new java.awt.Color(102, 102, 102));
        year_com.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        jPanel1.add(year_com, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 250, -1));

        semister_com.setForeground(new java.awt.Color(102, 102, 102));
        semister_com.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        jPanel1.add(semister_com, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 250, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setText("Semister");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setText("Student");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("Class");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("Year");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 80, -1));

        Class_semister_table = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                for(int i = 0;i<Class_semister_table.getRowCount();i++){
                    if(row == i){
                        return false;
                    }

                }           return true ;
            };
        };
        Class_semister_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Class_semister_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 273, 990, 310));

        rSButtonMaterialIconOne9.setBackground(new java.awt.Color(9, 121, 105));
        rSButtonMaterialIconOne9.setText("Insert ");
        rSButtonMaterialIconOne9.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        rSButtonMaterialIconOne9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSButtonMaterialIconOne9.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        rSButtonMaterialIconOne9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconOne9ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMaterialIconOne9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 120, -1));

        UpdateClassSem.setBackground(new java.awt.Color(9, 121, 105));
        UpdateClassSem.setText("Update");
        UpdateClassSem.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        UpdateClassSem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UpdateClassSem.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        UpdateClassSem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateClassSemActionPerformed(evt);
            }
        });
        jPanel1.add(UpdateClassSem, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        setSize(new java.awt.Dimension(1000, 591));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
 this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSButtonMaterialIconOne9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne9ActionPerformed
            if(validateText()){
              insertClassSemister();
           
        };        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMaterialIconOne9ActionPerformed

    private void UpdateClassSemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateClassSemActionPerformed
    int row   = Class_semister_table.getSelectedRow();
    if(row !=  -1){
       updateStudentClassSemister();
       fillStudentClassesSemister();
     
    }
    }//GEN-LAST:event_UpdateClassSemActionPerformed

    public static void main(String args[]) {
      
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClassSemisterToStd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassSemisterToStd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassSemisterToStd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassSemisterToStd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassSemisterToStd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static RSMaterialComponent.RSComboBoxMaterial Class_com;
    public static javax.swing.JTable Class_semister_table;
    private RSMaterialComponent.RSButtonMaterialIconOne UpdateClassSem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne9;
    public static RSMaterialComponent.RSComboBoxMaterial semister_com;
    public static RSMaterialComponent.RSComboBoxMaterial std_com;
    public static RSMaterialComponent.RSComboBoxMaterial year_com;
    // End of variables declaration//GEN-END:variables
}
