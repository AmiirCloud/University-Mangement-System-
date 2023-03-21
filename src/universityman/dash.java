
package universityman;

import com.sun.prism.j2d.J2DPipeline;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable ;
import javax.swing.table.TableModel;

public class dash extends javax.swing.JFrame {
    public dash() {
        initComponents();
        // people 
        People.fillPeopleTableInDash();
        
        //Students 
        Students.fillStudentForDash();
        
        // faculties 
        Faculties.fill_class_semister_table();
        
        // Class Semisater Table 
//        Class_semister.fillStudentClassesSemister();

// There are  tow tables one for dash  and one  for panes
        
    
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dash_panel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Panes = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        updatePeopleButto = new RSMaterialComponent.RSButtonMaterialOne();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myPeopleTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        student_table = new javax.swing.JTable();
        rSButtonMaterialIconOne1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        fac_view_table = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        rSButtonMaterialIconOne2 = new RSMaterialComponent.RSButtonMaterialIconOne();
        rSButtonMaterialIconOne4 = new RSMaterialComponent.RSButtonMaterialIconOne();
        rSButtonMaterialIconOne5 = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Class_semister_table = new javax.swing.JTable();
        rSButtonMaterialIconOne3 = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dash_panel1.setBackground(new java.awt.Color(54, 69, 79));
        dash_panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(54, 69, 79));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Studentsac.png"))); // NOI18N
        jLabel3.setText("  Students");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        dash_panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 260, 40));

        jLabel4.setBackground(new java.awt.Color(255, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Homeac.png"))); // NOI18N
        jLabel4.setText("  Home");
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        dash_panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 40));

        jPanel3.setBackground(new java.awt.Color(54, 69, 79));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(54, 69, 79));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Studentsdac.png"))); // NOI18N
        jLabel2.setText("   Admission ");
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 40));

        dash_panel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 280, 50));

        jPanel4.setBackground(new java.awt.Color(54, 69, 79));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(54, 69, 79));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Studentsac.png"))); // NOI18N
        jLabel7.setText("  Admission ");
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 40));

        dash_panel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 280, 50));

        jLabel6.setBackground(new java.awt.Color(54, 69, 79));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Assign Subjectac.png"))); // NOI18N
        jLabel6.setText("  Faculties");
        jLabel6.setOpaque(true);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        dash_panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 260, 40));

        jLabel9.setBackground(new java.awt.Color(54, 69, 79));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Faculitiesdac.png"))); // NOI18N
        jLabel9.setText("   Assign");
        jLabel9.setOpaque(true);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        dash_panel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 260, 40));

        getContentPane().add(dash_panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 700));
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, -10, -1, -1));

        Panes.setBackground(new java.awt.Color(255, 255, 255));
        Panes.setOpaque(true);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Panes.addTab("Dash", jLayeredPane1);

        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updatePeopleButto.setBackground(new java.awt.Color(9, 121, 105));
        updatePeopleButto.setText("New Registraitons ");
        updatePeopleButto.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        updatePeopleButto.setOpaque(true);
        updatePeopleButto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePeopleButtoActionPerformed(evt);
            }
        });
        jLayeredPane2.add(updatePeopleButto, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, -1, -1));

        jLabel1.setBackground(new java.awt.Color(102, 215, 207));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("University ManageMent System ");
        jLabel1.setOpaque(true);
        jLayeredPane2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 160));

        myPeopleTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(myPeopleTable);

        jLayeredPane2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 1040, -1));

        Panes.addTab("Admission", jLayeredPane2);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(25, 25, 112));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("University ManageMent System ");
        jLabel5.setOpaque(true);
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 160));

        student_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(student_table);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 257, 1040, 410));

        rSButtonMaterialIconOne1.setBackground(new java.awt.Color(9, 121, 105));
        rSButtonMaterialIconOne1.setText("Manage Students");
        rSButtonMaterialIconOne1.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        rSButtonMaterialIconOne1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        rSButtonMaterialIconOne1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconOne1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSButtonMaterialIconOne1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, -1, -1));

        Panes.addTab("Students", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fac_view_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(fac_view_table);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 377, 1030, 300));

        jLabel8.setBackground(new java.awt.Color(102, 215, 207));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("University ManageMent System ");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 160));

        rSButtonMaterialIconOne2.setBackground(new java.awt.Color(9, 121, 105));
        rSButtonMaterialIconOne2.setText("Mangae Classes ");
        rSButtonMaterialIconOne2.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        rSButtonMaterialIconOne2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSButtonMaterialIconOne2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLASS);
        rSButtonMaterialIconOne2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconOne2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMaterialIconOne2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, -1));

        rSButtonMaterialIconOne4.setBackground(new java.awt.Color(9, 121, 105));
        rSButtonMaterialIconOne4.setText("Departments");
        rSButtonMaterialIconOne4.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        rSButtonMaterialIconOne4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSButtonMaterialIconOne4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconOne4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMaterialIconOne4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 170, -1));

        rSButtonMaterialIconOne5.setBackground(new java.awt.Color(9, 121, 105));
        rSButtonMaterialIconOne5.setText("Faculties");
        rSButtonMaterialIconOne5.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        rSButtonMaterialIconOne5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSButtonMaterialIconOne5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLASS);
        rSButtonMaterialIconOne5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconOne5ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMaterialIconOne5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 320, 170, -1));

        Panes.addTab("Faculties", jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane4.setViewportView(Class_semister_table);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 1030, 520));

        rSButtonMaterialIconOne3.setText("show");
        rSButtonMaterialIconOne3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconOne3ActionPerformed(evt);
            }
        });
        jPanel5.add(rSButtonMaterialIconOne3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        Panes.addTab("Class-semister", jPanel5);

        getContentPane().add(Panes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 1510, 700));

        setSize(new java.awt.Dimension(1381, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updatePeopleButtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePeopleButtoActionPerformed


 PeopleForm p  = new PeopleForm();
 p.show();
 
     
    }//GEN-LAST:event_updatePeopleButtoActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
   Panes.setSelectedIndex(1);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
 Panes.setSelectedIndex(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void rSButtonMaterialIconOne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne1ActionPerformed
   Students s = new Students();
   s.show();
    }//GEN-LAST:event_rSButtonMaterialIconOne1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
 Panes.setSelectedIndex(2);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    Panes.setSelectedIndex(3);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void rSButtonMaterialIconOne5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne5ActionPerformed
 Faculties f   = new Faculties();
 f.show();// TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMaterialIconOne5ActionPerformed

    private void rSButtonMaterialIconOne4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne4ActionPerformed
Departments d = new Departments();
d.show();// TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMaterialIconOne4ActionPerformed

    private void rSButtonMaterialIconOne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne2ActionPerformed
 addClasses cls = new addClasses();
 cls.show();// TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMaterialIconOne2ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
   Panes.setSelectedIndex(4);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void rSButtonMaterialIconOne3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne3ActionPerformed
ClassSemisterToStd cs = new ClassSemisterToStd();
cs.show();// TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMaterialIconOne3ActionPerformed

    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Class_semister_table;
    private javax.swing.JTabbedPane Panes;
    private javax.swing.JPanel dash_panel1;
    public static javax.swing.JTable fac_view_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable myPeopleTable;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne1;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne2;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne3;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne4;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne5;
    public static javax.swing.JTable student_table;
    private RSMaterialComponent.RSButtonMaterialOne updatePeopleButto;
    // End of variables declaration//GEN-END:variables
}
