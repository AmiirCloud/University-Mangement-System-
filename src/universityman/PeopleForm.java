/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityman;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class PeopleForm extends javax.swing.JFrame {

    public static String fileName = "";
    String photoPath = "";
  

    public PeopleForm() {
        initComponents();
        fillCombo();
        People.fillPeopleTable();
        doubleClick();
    }
     public void doubleClick(){
    
 People_table.addMouseListener(new MouseAdapter() {
     
     public void mouseClicked(MouseEvent e ){
         if(e.getClickCount() == 2){
            int selectedRow  = People_table.getSelectedRow();
//            TableModel t  = PeopleTable.getModel();
SimpleDateFormat sdf  = new SimpleDateFormat("yy-mm-d");
            TableModel dtm = (TableModel) People_table.getModel();
          String ID = dtm.getValueAt(selectedRow, 0).toString();
            String NAME = dtm.getValueAt(selectedRow, 1).toString();
            String TELL = dtm.getValueAt(selectedRow, 2).toString();
            String SEX =dtm.getValueAt(selectedRow, 3).toString();
            String GMAIL =dtm.getValueAt(selectedRow, 4).toString();
            String BIRTH = dtm.getValueAt(selectedRow, 5).toString();
            String ADDRES = dtm.getValueAt(selectedRow, 6).toString();
            String REGDATE = dtm.getValueAt(selectedRow, 7).toString();
            String PROFILE_PIC = dtm.getValueAt(selectedRow, 8).toString();
            String imagePath = dtm.getValueAt(selectedRow, 9).toString();
//    
       people_id.setText(ID);
       fName.setText(NAME);
       tell.setText(TELL);
       gmail.setText(GMAIL);
       sex.setSelectedItem(SEX);
       add_com.addItem(ADDRES);
       add_com.setSelectedItem(ADDRES);
            profile.setIcon(image(imagePath, null));
       
       java.util.Date MYBIRTH;
             try {
                 MYBIRTH = sdf.parse(BIRTH);
                      java.util.Date MYREGDATE = sdf.parse(BIRTH);
                      java.util.Date REH_DATE = sdf.parse(REGDATE);

                      birth_date1.setDate(MYREGDATE);
            reg_date.setDate(REH_DATE);
             } catch (ParseException ex) {
                 Logger.getLogger(PeopleForm.class.getName()).log(Level.SEVERE, null, ex);
             }
    
       

         }
     }
 });
}
    public static void setTextForPeopel( int selectedRow){
        JOptionPane.showMessageDialog(null, selectedRow +" id");
   
     try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
          
//          
            PeopleForm.gmail.setText("hello");
//            tell.setText(TELL);
//            sex.setSelectedItem(SEX);
//            gmail.setText(GMAIL);
//         
//            p.address_no1.setText(ADDRES);
//            reg_date.setD(MYREGDATE);
//            p.path.setText(imagePath);
//            p.profile.setIcon(People.image(imagePath,null));

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "Error");
        }
     finally{
     JOptionPane.showMessageDialog(null, "Excuted");
     }

//        //       Store data to a variabl3es
//      
//
//       
//
//        JOptionPane.showMessageDialog(null, imagePath);
//
////     
////        //       p.motherName.setText(MOTHER);
////
//        try{
////            SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
////            //format the date
////           ;
////           
//////            p.studentId.setText(ID);
////            //         p.path.setText(PATH);
////            //         p.fileName = PATH;
////            //Reszie image icon
////            //       byte[] IMAGE = (byte[])dtm.getValueAt(rowId, 8);
////            //                String imagePath = dtm.getValueAt(rowId, 9).toString();
//
//            //       ImageIcon ICON =   new ImageIcon("C:\\sc\\College-Management-System-In-Java-master\\Faculities Profile pic\\Shivang-Prajapati.png");
////            String path = "C:\\sc\\College-Management-System-In-Java-master\\Faculities Profile pic\\Shivang-Prajapati.png";
//            //ICON.setImage(ICON.getImage().getScaledInstance(p.profile.getWidth(), p.profile.getHeight(), Image.SCALE_SMOOTH));
//            p.profile.setIcon(People.image(imagePath,null));
//            ;
//
//            //        -----------------------------------
//
//        }catch(Exception e){
//        }
//        //
//        //            p.reg_date.setDate(sdf.parse(birth));
//        //            p.birth_date1.setDate(sdf.parse(Reg_date));
//        //            p.address_no.setText(add_no);       // TODO add your handling code here:
    }                                      
    

    public void clearTextBox() {
        tell.setText("");
        tell.setText("");
        sex.setSelectedIndex(0);
        gmail.setText("");

     

    }

    public void check() {
        if (reg_date.getDate() == null) {

        }

    }

    public void deletePeople(int row) {
        try {

          
            String oper = "delete";
           
            String sql = "call people_pro(null,null,null,null,null,null,null,null,null,'" + oper + "','" + row + "' )";

            DbConnection.setSQL(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void updatePeople() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String fname = fName.getText();
            String mytell = tell.getText();
            String mysex = (String) sex.getSelectedItem();
            String mygmail = gmail.getText();
            String myBirth = sdf.format(birth_date1.getDate());
            String address =  (String) add_com.getSelectedItem();
            String array[] = address.split(" ");
            int add_no   = Integer.parseInt(array[0]);
            String myreg_date = sdf.format(reg_date.getDate());
            ImageIcon photopath = image(photoPath, null);
            String imagePath = photoPath.replaceAll("\\\\", "/");
    
            String oper = "update";
           
            
             int p_no =  Integer.parseInt(people_id.getText());
            String sql = "call people_pro('" + fname + "',  '" + mytell + "', '" + mysex + "',  '" + mygmail + "',  '" + myBirth + "',  '" + add_no + "',  '" + myreg_date + "',  '" + photopath + "',  '" + imagePath + "','" + oper + "','"+p_no+"' )";
           DbConnection.setSQL(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void insertPeople() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String fname = tell.getText();
            String mytell = tell.getText();
            String mysex = (String) sex.getSelectedItem();
            String mygmail = gmail.getText();
            String myBirth = sdf.format(reg_date.getDate());
            String address =  (String) add_com.getSelectedItem();
            String array[] = address.split(" ");
            int add_no   = Integer.parseInt(array[0]);
            String myreg_date = sdf.format(reg_date.getDate());
            ImageIcon photopath = image(photoPath, null);
            String imagePath = photoPath.replaceAll("\\\\", "/");
    
            String oper = "insert";
            int num = 0;
            String sql = "call people_pro('" + fname + "',  '" + mytell + "', '" + mysex + "',  '" + mygmail + "',  '" + myBirth + "',  '" + add_no + "',  '" + myreg_date + "',  '" + photopath + "',  '" + imagePath + "','" + oper + "',null )";
            DbConnection.setSQL(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ImageIcon image(String photoPath, byte[] photo) {
        ImageIcon myPhoto = null;
        if (photoPath != null) {
            myPhoto = new ImageIcon(photoPath);
        } else {
            myPhoto = new ImageIcon(photo);
        }
        Image img = myPhoto.getImage();
        Image img1 = img.getScaledInstance(profile.getWidth(), profile.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ph = new ImageIcon(img1);
        return ph;
    }

    public boolean validateTexBox() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String fname = tell.getText();

        String mytell = tell.getText();
        String mysex = (String) sex.getSelectedItem();
        String mygmail = gmail.getText();

    
        int myaddress =  add_com.getSelectedIndex();
//      
        if (fname.equals("")) {
            JOptionPane.showMessageDialog(null, "Full Name  Required");
            return false;
        }

        if (mytell.equals("")) {
            JOptionPane.showMessageDialog(null, "Phone Number Required");
            return false;
        }
        if (mygmail.equals("")) {
            JOptionPane.showMessageDialog(null, "Gmial  Required");
            return false;
        }
        if (birth_date1.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Birth Date   Required");
            return false;
        }
        if (myaddress == 0) {
            JOptionPane.showMessageDialog(null, "Please Choose Address");
            return false;
        }
        if (reg_date.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Reg date   Required");
            return false;
        }

        
       
        if (profile.getIcon() == null) {

            JOptionPane.showMessageDialog(null, "path is empty ");
            return false;
        } else {
            return true;
        }
    }

  public void  fillCombo(){
      add_com.removeAllItems();
      String  selectedItem =  "Choose choose Address";
      add_com.addItem(selectedItem);
      add_com.setSelectedItem(selectedItem);
      
      String query = "select * from filllAddressCom ";
      DbConnection.fillComp(query, add_com);
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sex = new RSMaterialComponent.RSComboBoxMaterial();
        jPanel2 = new javax.swing.JPanel();
        profile = new javax.swing.JLabel();
        SAVE = new javax.swing.JLabel();
        path = new javax.swing.JLabel();
        width1 = new javax.swing.JLabel();
        hhhh = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hhhh1 = new javax.swing.JLabel();
        rSButtonMaterialIconOne1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        DeletePeopleButton = new RSMaterialComponent.RSButtonMaterialIconTwo();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        add_com = new RSMaterialComponent.RSComboBoxMaterial();
        gmail = new RSMaterialComponent.RSTextFieldOne();
        reg_date = new com.toedter.calendar.JDateChooser();
        birth_date1 = new com.toedter.calendar.JDateChooser();
        fName = new RSMaterialComponent.RSTextFieldOne();
        tell = new RSMaterialComponent.RSTextFieldOne();
        jScrollPane1 = new javax.swing.JScrollPane();
        People_table = new javax.swing.JTable();
        people_id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sex.setForeground(new java.awt.Color(51, 51, 51));
        sex.setMaximumRowCount(2);
        sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        sex.setToolTipText("");
        sex.setColorMaterial(new java.awt.Color(51, 51, 255));
        sex.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        sex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexActionPerformed(evt);
            }
        });
        jPanel1.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 370, 45));

        jPanel2.setBackground(new java.awt.Color(246, 245, 245));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile.setBackground(new java.awt.Color(255, 255, 255));
        profile.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        profile.setForeground(new java.awt.Color(102, 102, 102));
        profile.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 1, 2, new java.awt.Color(153, 153, 153)));
        profile.setOpaque(true);
        jPanel2.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 150));

        SAVE.setBackground(new java.awt.Color(102, 215, 207));
        SAVE.setFont(new java.awt.Font("Sitka Banner", 1, 24)); // NOI18N
        SAVE.setForeground(new java.awt.Color(255, 255, 255));
        SAVE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SAVE.setText("Insert");
        SAVE.setToolTipText("");
        SAVE.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        SAVE.setOpaque(true);
        SAVE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SAVEMouseClicked(evt);
            }
        });
        jPanel2.add(SAVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 180, 40));

        path.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        path.setForeground(new java.awt.Color(51, 51, 255));
        path.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(path, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 630, 30));

        width1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        width1.setForeground(new java.awt.Color(51, 102, 255));
        width1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(width1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 107, 230, 30));

        hhhh.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        hhhh.setText("File Path :");
        jPanel2.add(hhhh, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 80, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("browse");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 70, 30));

        hhhh1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        hhhh1.setText("File Size  :");
        jPanel2.add(hhhh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 80, -1));

        rSButtonMaterialIconOne1.setBackground(new java.awt.Color(102, 215, 207));
        rSButtonMaterialIconOne1.setText("update");
        rSButtonMaterialIconOne1.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        rSButtonMaterialIconOne1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSButtonMaterialIconOne1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        rSButtonMaterialIconOne1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconOne1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSButtonMaterialIconOne1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 140, -1));

        DeletePeopleButton.setBackground(new java.awt.Color(102, 215, 207));
        DeletePeopleButton.setText("Delete");
        DeletePeopleButton.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        DeletePeopleButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeletePeopleButton.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        DeletePeopleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletePeopleButtonActionPerformed(evt);
            }
        });
        jPanel2.add(DeletePeopleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 105, 120, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 870, 170));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 215, 207));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("People Registration ");
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 20));

        jLabel20.setBackground(new java.awt.Color(102, 215, 207));
        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("X");
        jLabel20.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel20.setOpaque(true);
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 80, 30));

        add_com.setForeground(new java.awt.Color(102, 102, 102));
        add_com.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        jPanel1.add(add_com, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 370, -1));
        jPanel1.add(gmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 370, -1));
        jPanel1.add(reg_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 390, 40));
        jPanel1.add(birth_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 390, 40));
        jPanel1.add(fName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 370, -1));
        jPanel1.add(tell, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 370, -1));

        People_table  = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                for(int i = 0;i<People_table.getRowCount();i++){
                    if(row == i){
                        return false;
                    }

                }           return true ;
            };
        };
        People_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(People_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 490, 850, 220));
        jPanel1.add(people_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 50, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(882, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fNameActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        this.dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
 JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new File("C:\\school"));
    FileNameExtensionFilter fileExtension = new FileNameExtensionFilter("*. image","png","jpg");
    chooser.addChoosableFileFilter(fileExtension);
    int answer  =chooser.showSaveDialog(null);
    if(answer == JFileChooser.APPROVE_OPTION){
    File selectedFile  =  chooser.getSelectedFile();
    String path  =  selectedFile.getAbsolutePath();
    profile.setIcon(image(path,null));
    this.photoPath =  path; 
        }


    }//GEN-LAST:event_jLabel4MouseClicked

    private void sexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexActionPerformed

    private void SAVEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SAVEMouseClicked
        if (validateTexBox()) {

            insertPeople();
            People.fillPeopleTable();
        }
    }//GEN-LAST:event_SAVEMouseClicked

    private void rSButtonMaterialIconOne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne1ActionPerformed
    if (validateTexBox()) {
        int row  = People_table.getSelectedRow();
        if(row == -1){
     JOptionPane.showMessageDialog(null, "Please Select a  Row To Update");
        }else{

            updatePeople();
            People.fillPeopleTable();
        }
    }
    }//GEN-LAST:event_rSButtonMaterialIconOne1ActionPerformed

    private void DeletePeopleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePeopleButtonActionPerformed
   
        int row  = People_table.getSelectedRow();
        if(row == -1){
     JOptionPane.showMessageDialog(null, "Please Select a  Row To Delete");
        }else{

            deletePeople(row);
                 People.fillPeopleTable();
        
    }
    }//GEN-LAST:event_DeletePeopleButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PeopleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeopleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeopleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeopleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeopleForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconTwo DeletePeopleButton;
    public static javax.swing.JTable People_table;
    private javax.swing.JLabel SAVE;
    private RSMaterialComponent.RSComboBoxMaterial add_com;
    public static com.toedter.calendar.JDateChooser birth_date1;
    public static RSMaterialComponent.RSTextFieldOne fName;
    public static RSMaterialComponent.RSTextFieldOne gmail;
    private javax.swing.JLabel hhhh;
    private javax.swing.JLabel hhhh1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel path;
    private javax.swing.JLabel people_id;
    public static javax.swing.JLabel profile;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne1;
    public static com.toedter.calendar.JDateChooser reg_date;
    public static RSMaterialComponent.RSComboBoxMaterial sex;
    public static RSMaterialComponent.RSTextFieldOne tell;
    public static javax.swing.JLabel width1;
    // End of variables declaration//GEN-END:variables
}
