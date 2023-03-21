/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityman;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import sun.java2d.pipe.SpanShapeRenderer;
import static universityman.PeopleForm.gmail;
import static universityman.PeopleForm.reg_date;
import static universityman.PeopleForm.sex;
import static universityman.PeopleForm.tell;


/**
 *
 * @author Administrator
 */
public class People {
    static SimpleDateFormat sdf;
    java.util.Date  birth ; 
    java.util.Date reg; 
    public static void fillPeopleTable(){
        String query   = "select * from people_view";
    DbConnection.viewTable(query, PeopleForm.People_table);
    }
     public static void fillPeopleTableInDash(){
        String query   = "select * from people_view";
    DbConnection.viewTable(query, dash.myPeopleTable);
    }

//        
//    }

}
