/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityman;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class Class_semister {

//    public static void fillStudent_com() {
//        dash.std_com.removeAllItems();
//        String selectedItem = "Choose Student ";
//        dash.std_com.addItem(selectedItem);
//        dashboard.std_com.setSelectedItem(selectedItem);
//
//        String query = "select * from fillstudent_view ";
//        DbConncection.fillComp(query, dashboard.std_com);
//    }
//
//    public static void fillAccademic_year_com() {
//        dashboard.year_com.removeAllItems();
//        String selectedItem = "Choose Accademic Year ";
//        dashboard.year_com.addItem(selectedItem);
//        dashboard.year_com.setSelectedItem(selectedItem);
//
//        String query = "select * from accademic_year_view ";
//        DbConncection.fillComp(query, dashboard.year_com);
//    }
//
//    public static void fillSemister_view() {
//        dashboard.semister_com.removeAllItems();
//        String selectedItem = "Choose Semister ";
//        dashboard.semister_com.addItem(selectedItem);
//        dashboard.semister_com.setSelectedItem(selectedItem);
//
//        String query = "select * from semister_view ";
//        DbConncection.fillComp(query, dashboard.semister_com);
//    }
//
//    public static void fill_Class_com() {
//        dashboard.Class_com.removeAllItems();
//        String selectedItem = "Choose Classess ";
//        dashboard.Class_com.addItem(selectedItem);
//        dashboard.Class_com.setSelectedItem(selectedItem);
//
//        String query = "select * from Class_view_com ";
//        DbConncection.fillComp(query, dashboard.Class_com);
//    }

 

//    public static boolean validateText() {
//        if (dashboard.Class_com.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(null, "Please Choose Class");
//            return false;
//        }
//        if (dashboard.std_com.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(null, "Please Choose Student");
//            return false;
//        }
//        if (dashboard.year_com.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(null, "Please Choose Academic  Year ");
//            return false;
//        }
//        if (dashboard.semister_com.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(null, "Please Choose Semister ");
//            return false;
//        }
//        return true;
//    }
//
//    public static void insertClassSemister() {
//        String oper = "insert";
////  String class_name  =  Class_txt.getText();
//        String cl_nameWith_id = dashboard.Class_com.getSelectedItem().toString();
//        String arrayForClass[] = cl_nameWith_id.split(" ");
//        int cl_no = Integer.parseInt(arrayForClass[0]);
//
//        String student_nameWith_id = dashboard.std_com.getSelectedItem().toString();
//        String arrayForStudent[] = student_nameWith_id.split(" ");
//        int id_no = Integer.parseInt(arrayForStudent[0]);
//
//        String year_nameWith_id = dashboard.year_com.getSelectedItem().toString();
//        String arrayForYear[] = year_nameWith_id.split(" ");
//        int year_no = Integer.parseInt(arrayForYear[0]);
//
//        String semister_nameWith_id = dashboard.semister_com.getSelectedItem().toString();
//        String arrayForSemistert[] = semister_nameWith_id.split(" ");
//        int sem_no = Integer.parseInt(arrayForSemistert[0]);
//
//        JOptionPane.showMessageDialog(null, cl_no + "" + id_no + "" + year_no + "" + sem_no);
//
//        String sql = "call class_semister('" + cl_no + "','" + id_no + "','" + year_no + "','" + sem_no + "','" + oper + "',null )";
//        DbConncection.setSQL(sql);
//        fill_student_class_semister();
//
//    }
//
//    public static void readData(int rowid) {
//        try {
//
//            String query = "select * from studentinromationdetails where ID ='" + rowid + "'";
//            Connection con = DbConncection.setConncetion();
//
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            while (rs.next()) {
//                String id = rs.getString(1);
//                String name = rs.getString(2);
//                dashboard.std_id.setText(id);
//                dashboard.stdName1.setText(name);
//
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//
//    }
//
//    public static void setStudentDetails() {
//        TableModel tm = dashboard.class_semister.getModel();
//        int selectedRow = dashboard.class_semister.getSelectedRow();
//        if (selectedRow == -1) {
//            JOptionPane.showMessageDialog(null, "Please Select Row ");
//
//        } else {
//
//        }
//    }



}
