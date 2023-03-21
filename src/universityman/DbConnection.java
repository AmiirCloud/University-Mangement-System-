
package universityman;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
//import static myscool_syd.dashboard.teacherNamesComp;
import net.proteanit.sql.DbUtils;

public class DbConnection {
    static Connection  con  ; 
    final static String URL = "jdbc:mysql://localhost/simad2";
    final  static String USER  = "root";
    final static String password = "";
    static ResultSet rs;
    static String   counter;
    static Statement st;
    public static Connection setConncetion(){
        try{
        con  =  DriverManager.getConnection(URL, USER, password);
//            JOptionPane.showMessageDialog(null, "Conncected ");
        }catch(Exception e ){
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
    return con ;
    }
      public static void setSQL(String sql){
        try{
            Connection con =  DbConnection.setConncetion();
            Statement st = con.createStatement();
             rs =st.executeQuery(sql);
            JOptionPane.showMessageDialog(null, rs.next()?rs.getString("msg"):"failed");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public static void  viewTable(String sql,JTable table){
         try{
            Connection con =  DbConnection.setConncetion();
            Statement std = con.createStatement();
           rs=std.executeQuery(sql);
           table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//
    public static String count(String sql ){
    Connection con = DbConnection.setConncetion();
    try{
            Statement std = con.createStatement();

     rs  = std.executeQuery(sql);
     
     while(rs.next()){
       counter =  rs.getString(1);
     }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return counter;
    }
     public static void  fillComp(String query ,JComboBox com){
          con =DbConnection.setConncetion();
        try {
            st = con.createStatement();
            rs =  st.executeQuery(query);
            while(rs.next()){
            String id =  rs.getString(1);
            String name =  rs.getString(2);
            
            com.addItem(id+ " "+name);
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
          
    }
    
}
