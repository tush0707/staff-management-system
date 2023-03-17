package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mgmt extends Frame{
	private static final LayoutManager Null = null;
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    static Scanner sc= new Scanner(System.in);
    JFrame a;
    JMenu m;
    JMenuBar M;
    JMenuItem m1,m2,m3,m4,m5,m6; 
    JPanel po,p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13; 
    JButton hb1,hb2,hb3,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19;
    JTable t;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    JComboBox cb1,cb2;
    mgmt(){
    	a= new JFrame("STAFF MANAGEMENT SYSTEM");
    	po= new JPanel(new BorderLayout());po.setBounds(80,100,400,300); //home
        p0= new JPanel(new BorderLayout());p0.setBounds(80,100,400,200); //person
        p1= new JPanel();p1.setBounds(80,100,400,200); //service
        p2= new JPanel();p2.setBounds(80,100,400,200); //department
        p3= new JPanel();p3.setBounds(80,100,400,300); //place request
        p4= new JPanel();p4.setBounds(80,150,400,100); //view complaint details
        p5= new JPanel();p5.setBounds(0,0,400,300); //frame with complaint details
        p6= new JPanel();p6.setBounds(40,0,400,100); //give approval
        p7= new JPanel();p7.setBounds(0,100,500,300); //complaint tabel details
        p8= new JPanel();p8.setBounds(40,0,400,100); //assign work
        p9= new JPanel();p9.setBounds(0,150,500,150); //complaint accepted table
        p10= new JPanel();p10.setBounds(0,310,500,150); //servicestaff details table
        p11= new JPanel();p11.setBounds(80,150,400,100); //view work
        p12= new JPanel();p12.setBounds(0,50,500,150); //view panel for work details
        p13= new JPanel();p13.setBounds(80,150,400,100); //update work
        
        hb1=new JButton("Person Login");
        hb2=new JButton("ServiceStaff Login");
        hb3=new JButton("Department Login");
        po.add(hb1);
        po.add(hb2);
        po.add(hb3);
        po.setLayout(new GridLayout(3,1));
        a.add(po);
        
        b1=new JButton("Place Request");
        b2=new JButton("View Request details");
        p0.add(b1);
        p0.add(b2);
        p0.setLayout(new GridLayout(2,1));
        a.add(p0);
        
        b3=new JButton("View work");
        b13=new JButton("Update work");
        p1.add(b3);p1.add(b13);
        p1.setLayout(new GridLayout(2,1));
        a.add(p1);
        
        b4=new JButton("Give Approval");
        b5=new JButton("Assign Work");
        p2.add(b4);
        p2.add(b5);
        p2.setLayout(new GridLayout(2,1));
        a.add(p2);
        
        l0 = new JLabel("Enter Id: ");
        t1 = new JTextField("");
        l2 = new JLabel("Select comp_type:");
        String type[]= {"hardware","software","network","multimedia"};
        cb1 = new JComboBox(type);
        l1 = new JLabel("Complaint Specification:");
        t2 = new JTextField("");
        l3 = new JLabel("Select dept:");
        String department[]= {"cse","ece","eee"};
        cb2 = new JComboBox(department);
        b6 = new JButton("Submit");
        b7 = new JButton("Reset");
        p3.add(l0);p3.add(t1);p3.add(l2);p3.add(cb1);p3.add(l1);
        p3.add(t2);p3.add(l3);p3.add(cb2);p3.add(b6);p3.add(b7);        
        p3.setLayout(new GridLayout(6,2));
        a.add(p3);
        
        l4 = new JLabel("Enter your id:");
        t3 = new JTextField("");
        l5 = new JLabel("Enter your Complaint id:");
        t4 = new JTextField("");
        b9 = new JButton("View");
        b10 = new JButton("Reset");
        p4.add(l4);p4.add(t3);p4.add(l5);p4.add(t4);
        p4.add(b9);p4.add(b10);
        p4.setLayout(new GridLayout(3,2));
        a.add(p4);
        
        JFrame b = new JFrame("Details");        
        JLabel text1 = new JLabel("Your id:");text1.setFont(new Font("SansSerif", Font.BOLD, 15));
	    JLabel text2 = new JLabel(" ");text2.setFont(new Font("SansSerif", Font.BOLD, 15));
	    JLabel text3 = new JLabel("Complaint id:");text3.setFont(new Font("SansSerif", Font.BOLD, 15));
	    JLabel text4 = new JLabel(" ");text4.setFont(new Font("SansSerif", Font.BOLD, 15));
	    JLabel text5 = new JLabel("Complaint type:");text5.setFont(new Font("SansSerif", Font.BOLD, 15));
	    JLabel text6 = new JLabel(" ");text6.setFont(new Font("SansSerif", Font.BOLD, 15));
	    JLabel text7 = new JLabel("Specification:");text7.setFont(new Font("SansSerif", Font.BOLD, 15));
	    JLabel text8 = new JLabel(" ");text8.setFont(new Font("SansSerif", Font.BOLD, 15));
	    JLabel text9 = new JLabel("Status:");text9.setFont(new Font("SansSerif", Font.BOLD, 15));
	    JLabel text10 = new JLabel(" ");text10.setFont(new Font("SansSerif", Font.BOLD, 15));
	    p5.add(text1);p5.add(text2);p5.add(text3);p5.add(text4);p5.add(text5);p5.add(text6);
	    p5.add(text7);p5.add(text8);p5.add(text9);p5.add(text10);
	    p5.setLayout(new GridLayout(5,2));
	    b.add(p5);
	    b.setSize(400, 400);
	    
	    l6 = new JLabel("Enter complaint id:");
	    t5 = new JTextField("");
	    b11 = new JButton("Accept Approval");
	    b12 = new JButton("Cancel Approval");        
        p6.add(l6);p6.add(t5);p6.add(b11);p6.add(b12);
        p6.setLayout(new GridLayout(2,2));
        a.add(p6);
        
        l7 = new JLabel("Enter staff id:");
        t6 = new JTextField("");
        l8 = new JLabel("Enter complaint id:");
        t7 = new JTextField("");
        b14 = new JButton("Assign");
        b15 = new JButton("Reset");
        p8.add(l7);p8.add(t6);p8.add(l8);p8.add(t7);p8.add(b14);p8.add(b15);
        p8.setLayout(new GridLayout(3,2));
        a.add(p8);
        
        JFrame d = new JFrame("Details");
        d.setSize(550, 300);
        l9 = new JLabel("Enter your staff id:");
        t8 = new JTextField("");
        b16 = new JButton("View");
        b17 = new JButton("Reset");
        p11.add(l9);p11.add(t8);p11.add(b16);p11.add(b17);
        p11.setLayout(new GridLayout(2,2));
        a.add(p11);
        
        l10 = new JLabel("Enter your complaint id:");
        t9 = new JTextField("");
        b18 = new JButton("Work Completed");
        b19 = new JButton("Reset");
        p13.add(l10);p13.add(t9);p13.add(b18);p13.add(b19);
        p13.setLayout(new GridLayout(2,2));
        a.add(p13);
        
        b8 = new JButton("HOME");
        M = new JMenuBar();
        M.add(b8);
        a.setJMenuBar(M);
        a.setLayout(Null);
        a.setSize(600,600);
        a.setVisible(true);
        po.setVisible(true);
        p0.setVisible(false);
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
        p7.setVisible(false);
        p8.setVisible(false);
        p9.setVisible(false);
        p10.setVisible(false);
        p11.setVisible(false);
        p13.setVisible(false);
        
        ActionListener x=new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==hb1) { //person login
            		int x=0;
                    JFrame f1 = new JFrame();
                    String name1 = JOptionPane.showInputDialog(f1,"Enter your ID:","Login",JOptionPane.PLAIN_MESSAGE);
                    String name2 = JOptionPane.showInputDialog(f1,"Enter your Password:","Login",JOptionPane.PLAIN_MESSAGE);
                    
                    Connection c = null;
            		Statement stmt = null;
            	      try {
            	    	 Class.forName("org.postgresql.Driver");
            		     c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "4646");   
            		     c.setAutoCommit(false);
            		     System.out.println("Opened database successfully");
            	         stmt = c.createStatement();
            	         
            	         String sql = "SELECT p_id, password FROM personlogin";
            	         ResultSet rs = stmt.executeQuery(sql);
            	         while ( rs.next() ) {
            	        	 String p_id  = rs.getString("p_id");
            	             String password = rs.getString("password");
            	             
            	             if(name1.compareTo(p_id)==0 && name2.compareTo(password)==0) {
         	                    p0.setVisible(true);
         	                    p1.setVisible(false);
         	                    p2.setVisible(false);
         	                    p3.setVisible(false);
         	                    p4.setVisible(false);
         	                    p6.setVisible(false);
         	                    p7.setVisible(false);
         	                    p8.setVisible(false);
         	                    p9.setVisible(false);
         	                    p10.setVisible(false);
         	                    p11.setVisible(false);
         	                    p13.setVisible(false);
         	                    po.setVisible(false);
         	                    break;
                             }
            	             else {
            	            	 x=x+1;
                             }
            	             if(x>2) {
            	            	 JOptionPane.showMessageDialog(f1,"Wrong username or password!","Alert",JOptionPane.WARNING_MESSAGE);
            	             }
            	         }
            	         rs.close();
            	         stmt.close();
            	         c.close();
            	      } catch (Exception e1) {
            	         System.exit(0);
            	      }            	      
        		}
        		if(e.getSource()==hb2) { //servicestaff login
        			int x=0;
        			JFrame f2 = new JFrame();
        			String name1 = JOptionPane.showInputDialog(f2,"Enter your ID:","Login",JOptionPane.PLAIN_MESSAGE);
                    String name2 = JOptionPane.showInputDialog(f2,"Enter your Password:","Login",JOptionPane.PLAIN_MESSAGE);
                    
                    Connection c = null;
            		Statement stmt = null;
            	      try {
            	    	 Class.forName("org.postgresql.Driver");
            		     c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mgmt", "postgres", "4646");   
            		     c.setAutoCommit(false);
            		     System.out.println("Opened database successfully");
            	         stmt = c.createStatement();
            	         
            	         String sql = "SELECT ss_id, ss_pwd FROM servicelogin";
            	         ResultSet rs = stmt.executeQuery(sql);
            	         while ( rs.next() ) {
            	        	 String ss_id  = rs.getString("ss_id");
            	             String ss_pwd = rs.getString("ss_pwd");
            	             
            	             if(name1.compareTo(ss_id)==0 && name2.compareTo(ss_pwd)==0) {
            	            	 p0.setVisible(false);
            	                 p1.setVisible(true);
            	                 p2.setVisible(false);
            	                 p3.setVisible(false);
            	                 p4.setVisible(false);
            	                 p6.setVisible(false);
            	                 p7.setVisible(false);
            	                 p8.setVisible(false);
            	                 p9.setVisible(false);
            	                 p10.setVisible(false);
            	                 p11.setVisible(false);
            	                 p13.setVisible(false);
            	                 po.setVisible(false);
         	                     break;
                             }
            	             else {
            	            	 x=x+1;
                             }
            	             if(x>2) {
            	            	 JOptionPane.showMessageDialog(f2,"Wrong username or password!","Alert",JOptionPane.WARNING_MESSAGE);
            	             }          	             
            	         }
            	         rs.close();
            	         stmt.close();
            	         c.close();
            	      } catch (Exception e1) {
            	         System.exit(0);
            	      }	
        		}
        		if(e.getSource()==hb3) { //Department login
        			int x=0;
        			JFrame f3 = new JFrame();
        			String name1 = JOptionPane.showInputDialog(f3,"Enter your ID:","Login",JOptionPane.PLAIN_MESSAGE);
                    String name2 = JOptionPane.showInputDialog(f3,"Enter your Password:","Login",JOptionPane.PLAIN_MESSAGE);
                    
                    Connection c = null;
            		Statement stmt = null;
            	      try {
            	    	 Class.forName("org.postgresql.Driver");
            		     c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mgmt", "postgres", "4646");   
            		     c.setAutoCommit(false);
            		     System.out.println("Opened database successfully");
            	         stmt = c.createStatement();
            	         
            	         String sql = "SELECT d_id, d_pwd FROM deptlogin";
            	         ResultSet rs = stmt.executeQuery(sql);
            	         while ( rs.next() ) {
            	        	 String d_id  = rs.getString("d_id");
            	             String d_pwd = rs.getString("d_pwd");
            	             
            	             if(name1.compareTo(d_id)==0 && name2.compareTo(d_pwd)==0) {
            	            	 p0.setVisible(false);
            	                 p1.setVisible(false);
            	                 p2.setVisible(true);
            	                 p3.setVisible(false);
            	                 p4.setVisible(false);
            	                 p6.setVisible(false);
            	                 p7.setVisible(false);
            	                 p8.setVisible(false);
            	                 p9.setVisible(false);
            	                 p10.setVisible(false);
            	                 p11.setVisible(false);
            	                 p13.setVisible(false);
            	                 po.setVisible(false);
         	                    break;
                             }
            	             else {
            	            	 x=x+1;
                             }
            	             if(x>2) {
            	            	 JOptionPane.showMessageDialog(f3,"Wrong username or password!","Alert",JOptionPane.WARNING_MESSAGE);
            	             }            	             
            	         }
            	         rs.close();
            	         stmt.close();
            	         c.close();
            	      } catch (Exception e1) {
            	         System.exit(0);
            	      }        			
        		}
        		if(e.getSource()==b1) { //place request
        			p0.setVisible(false);
	                p1.setVisible(false);
	                p2.setVisible(false);
	                p3.setVisible(true);
	                p4.setVisible(false);
	                p6.setVisible(false);
	                p7.setVisible(false);
	                p8.setVisible(false);
	                p9.setVisible(false);
	                p10.setVisible(false);
	                p11.setVisible(false);
	                p13.setVisible(false);
	                po.setVisible(false);	                
        		}
        		if(e.getSource()==b2) { //request details
        			p0.setVisible(false);
	                p1.setVisible(false);
	                p2.setVisible(false);
	                p3.setVisible(false);
	                p4.setVisible(true);
	                p6.setVisible(false);
	                p7.setVisible(false);
	                p8.setVisible(false);
	                p9.setVisible(false);
	                p10.setVisible(false);
	                p11.setVisible(false);
	                p13.setVisible(false);
	                po.setVisible(false);	                
        		}
        		if(e.getSource()==b4) { //give approval
        			p0.setVisible(false);
	                p1.setVisible(false);
	                p2.setVisible(false);
	                p3.setVisible(false);
	                p4.setVisible(false);
	                p6.setVisible(true);
	                p8.setVisible(false);
	                p9.setVisible(false);
	                p10.setVisible(false);
	                p11.setVisible(false);
	                p13.setVisible(false);
	                po.setVisible(false);
	                Connection c = null;
	        		Statement stmt = null;
	        	      try {
	        	         Class.forName("org.postgresql.Driver");
	        	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mgmt", "postgres", "4646");
	        	         c.setAutoCommit(false);
	        	         String column[]={"p_id", "c_id", "comp_type", "comp_spec", "status"};
	        	         String[][] rows=new String[50][5];
	        		     int i=0;
	        	         stmt = c.createStatement();
	        	         ResultSet rs = stmt.executeQuery( "SELECT p_id,c_id,comp_type,comp_spec,status FROM complaint where status='pending';" );
	        	         while ( rs.next() ) {
	        	        	 rows[i][0] = rs.getString("p_id");
	        		         rows[i][1] = String.valueOf(rs.getInt("c_id"));
	        		         rows[i][2] = rs.getString("comp_type");
	        		         rows[i][3] = rs.getString("comp_spec");
	        		         rows[i][4] = rs.getString("status");
	        		         i++;
	        	         }
	        	         JTable table=new JTable(rows,column);
	        	         JScrollPane sp=new JScrollPane(table);
	        	         TableColumnModel columnModel = table.getColumnModel();
	        	         columnModel.getColumn(0).setPreferredWidth(10);
	        	         columnModel.getColumn(1).setPreferredWidth(10);
	        	         columnModel.getColumn(2).setPreferredWidth(50);
	        	         columnModel.getColumn(3).setPreferredWidth(150);
	        	         columnModel.getColumn(4).setPreferredWidth(50);
	        	         table.setFocusable(false);
	        	         p7.add(sp);
	        	         p7.setVisible(true);
	        	         a.add(p7);
	        	         rs.close();
	        	         stmt.close();
	        	         c.commit();
	        	         
	        	      } catch (Exception e1) {
	        	         e1.printStackTrace();
	        	         System.err.println(e1.getClass().getName()+": "+e1.getMessage());
	        	         System.exit(0);
	        	      }
        		}
        		if(e.getSource()==b8) { //home button
        			p0.setVisible(false);
	                p1.setVisible(false);
	                p2.setVisible(false);
	                p3.setVisible(false);
	                p4.setVisible(false);
	                p6.setVisible(false);
	                p7.setVisible(false);
	                p8.setVisible(false);
	                p9.setVisible(false);
	                p10.setVisible(false);
	                p11.setVisible(false);
	                p13.setVisible(false);
	                po.setVisible(true);	                
        		}
        		if(e.getSource()==b6) {  //submit button for complaint register		
    				Connection c = null;
    				Statement stmt = null;
    		    	try{
    		    		String p_id = t1.getText();
        				String comp_type = cb1.getSelectedItem().toString();
        				String comp_spec=t2.getText();
        				String p_dept = cb2.getSelectedItem().toString();
        				
    		    		Class.forName("org.postgresql.Driver");
    				    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mgmt", "postgres", "4646");   
    				    c.setAutoCommit(false);    				    
    				    
						Statement s = c.createStatement();
    				    ResultSet r = s.executeQuery("SELECT COUNT(*) AS count FROM complaint");
    				    r.next();
    				    int count = r.getInt("count");
    				    r.close();
    				    System.out.println("complaint: "+(count+1));
    				    count = count + 1;
    				    
    				    stmt = c.createStatement();
    				    String sql = "INSERT INTO complaint "+"VALUES ('"+p_id+"','"+comp_type+"','"+comp_spec+"','"+p_dept+"',"+count+",'pending');"; 
    				    stmt.executeUpdate(sql);
    				    stmt.close();  
    				    c.commit();
    				    JOptionPane.showMessageDialog(a,"Complaint registered.");
    				    
    				    JLabel text1 = new JLabel("Your complaint id is: ");text1.setFont(new Font("SansSerif", Font.BOLD, 18));
    				    JLabel text2 = new JLabel(" ");text2.setFont(new Font("SansSerif", Font.BOLD, 18));
    				    p3.add(text1);p3.add(text2);
    				    text2.setText(String.valueOf(count));    				    
    		    	}
    		    	catch(Exception e1) {
	       		    	e1.printStackTrace();
	       			    System.err.println(e1.getClass().getName()+": "+e1.getMessage());
    		    		System.exit(0);
    		    	}
        		}
        		if(e.getSource()==b9) { //view button to view request details
        			Connection c = null;
        			Statement stmt = null;
        		      try {
        		         Class.forName("org.postgresql.Driver");
        		         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mgmt", "postgres", "4646");
        		         c.setAutoCommit(false);
        		         
        		         String p_id = t3.getText();
        		         String c_id = t4.getText();
        		         int l = Integer.parseInt(c_id);
        		         String comp_type = null, comp_spec = null, status = null;
        		         
        		         stmt = c.createStatement();
        		         ResultSet rs = stmt.executeQuery( "SELECT comp_type,comp_spec,status FROM complaint where p_id='"+p_id+"' and c_id="+l+";" );
        		         while ( rs.next() ) {
        		            String s1 = rs.getString("comp_type");
        		            String s2= rs.getString("comp_spec");
        		            String s3  = rs.getString("status");
        		            comp_type = s1;comp_spec = s2;status = s3;
        		         }
        		         rs.close();
        		         stmt.close();
        		         c.commit();
        		         JOptionPane.showMessageDialog(a,"Press OK to view");
        		         
     				     b.setVisible(true);
     				     p5.setVisible(true);
     				     text2.setText(p_id);
     				     text4.setText(c_id);
     				     text6.setText(comp_type);
     				     text8.setText(comp_spec);
     				     text10.setText(status);
     				     
        		      } catch (Exception e1) {
        		    	 e1.printStackTrace();
        			     System.err.println(e1.getClass().getName()+": "+e1.getMessage());
        		         System.exit(0);
        		      }
        		}
        		if(e.getSource()==b11) { //Accept approval
        			Connection c = null;
        			Statement stmt = null;
        		      try {
        		         Class.forName("org.postgresql.Driver");
        		         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mgmt", "postgres", "4646");
        		         c.setAutoCommit(false);
        		         
        		         String c_id = t5.getText();
        		         int l = Integer.parseInt(c_id);        		         
        		         
        		         stmt = c.createStatement();
        		         String sql = "UPDATE complaint set status = 'accepted' where c_id="+l;
        		         stmt.executeUpdate(sql);
        		         stmt.close(); 
        		         c.commit();
        		         JOptionPane.showMessageDialog(a,"Approval given");
        		      
        		      } catch (Exception e1) {
        		         e1.printStackTrace();
        		         System.err.println(e1.getClass().getName()+": "+e1.getMessage());
        		         System.exit(0);
        		      }	                
        		}
        		if(e.getSource()==b12) { //cancel approval
        			Connection c = null;
        			Statement stmt = null;
        		      try {
        		         Class.forName("org.postgresql.Driver");
        		         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mgmt", "postgres", "4646");
        		         c.setAutoCommit(false);
        		         
        		         String c_id = t5.getText();
        		         int l = Integer.parseInt(c_id);        		         
        		         
        		         stmt = c.createStatement();
        		         String sql = "UPDATE complaint set status = 'denied' where c_id="+l;
        		         stmt.executeUpdate(sql);
        		         stmt.close();
        		         c.commit();
        		         JOptionPane.showMessageDialog(a,"denied approval");
        		      
        		      } catch (Exception e1) {
        		         e1.printStackTrace();
        		         System.err.println(e1.getClass().getName()+": "+e1.getMessage());
        		         System.exit(0);
        		      }	                
        		}
        		if(e.getSource()==b5) { //assign work
        			p0.setVisible(false);
	                p1.setVisible(false);
	                p2.setVisible(false);
	                p3.setVisible(false);
	                p4.setVisible(false);
	                p6.setVisible(false);
	                p7.setVisible(false);
	                p8.setVisible(true);
	                p11.setVisible(false);
	                p13.setVisible(false);
	                po.setVisible(false);
	        	      try {
	        	    	 Connection c = null;
	  	        		 Statement stmt = null;
	        	         Class.forName("org.postgresql.Driver");
	        	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mgmt", "postgres", "4646");
	        	         c.setAutoCommit(false);
	        	         String column[]={"c_id", "comp_type", "comp_spec", "status"};
	        	         String[][] rows=new String[50][4];
	        		     int i=0;
	        	         stmt = c.createStatement();
	        	         ResultSet rs = stmt.executeQuery( "SELECT c_id,comp_type,comp_spec,status FROM complaint where status='accepted';" );
	        	         while ( rs.next() ) {
	        		         rows[i][0] = String.valueOf(rs.getInt("c_id"));
	        		         rows[i][1] = rs.getString("comp_type");
	        		         rows[i][2] = rs.getString("comp_spec");
	        		         rows[i][3] = rs.getString("status");
	        		         i++;
	        	         }
	        	         JTable table=new JTable(rows,column);
	        	         JScrollPane sp=new JScrollPane(table);
	        	         TableColumnModel columnModel = table.getColumnModel();
	        	         columnModel.getColumn(0).setPreferredWidth(10);
	        	         columnModel.getColumn(1).setPreferredWidth(50);
	        	         columnModel.getColumn(2).setPreferredWidth(150);
	        	         columnModel.getColumn(3).setPreferredWidth(50);
	        	         table.setFocusable(false);
	        	         p9.add(sp);
	        	         p9.setVisible(true);
	        	         a.add(p9);
	        	         rs.close();
	        	         stmt.close();
	        	         c.commit();
	        	         
	        	      } catch (Exception e1) {
	        	         e1.printStackTrace();
	        	         System.err.println(e1.getClass().getName()+": "+e1.getMessage());
	        	         System.exit(0);
	        	      }
	        	      try {
		        	    Connection c = null;
		  	        	Statement stmt = null;
		        	    Class.forName("org.postgresql.Driver");
		        	    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mgmt", "postgres", "4646");
		        	    c.setAutoCommit(false);
		        	    String column[]={"ss_id", "ss_dept"};
		        	    String[][] rows=new String[50][2];
		        		int i=0;
		        	    stmt = c.createStatement();
		        	    ResultSet rs = stmt.executeQuery( "SELECT ss_id,ss_dept FROM servicestaff;" );
		        	    while ( rs.next() ) {
		        		     rows[i][0] = rs.getString("ss_id");
		        		     rows[i][1] = rs.getString("ss_dept");
		        		     i++;
		        	    }
		        	    JTable table=new JTable(rows,column);
		        	    JScrollPane sp=new JScrollPane(table);
		        	    table.setFocusable(false);
		        	    p10.add(sp);
		        	    p10.setVisible(true);
		        	    a.add(p10);
		        	    rs.close();
		        	    stmt.close();
		        	    c.commit();
		        	        
		        	    } catch (Exception e1) {
		        	       e1.printStackTrace();
		        	       System.err.println(e1.getClass().getName()+": "+e1.getMessage());
		        	       System.exit(0);
		        	    }
        		}
        		if(e.getSource()==b14) { //assign
        			Connection c = null;
        			Statement stmt = null;
        		      try {
        		         Class.forName("org.postgresql.Driver");
        		         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mgmt", "postgres", "4646");
        		         c.setAutoCommit(false);
        		         
        		         String ss_id = t6.getText();
        		         String c_id = t7.getText();
        		         int l = Integer.parseInt(c_id);
        		         String comp_type = null, comp_spec = null, status = null;
        		         
        		         stmt = c.createStatement();
        		         ResultSet rs = stmt.executeQuery( "SELECT comp_type,comp_spec,status FROM complaint where c_id="+l+";" );
        		         while ( rs.next() ) {
        		            String s1 = rs.getString("comp_type");
        		            String s2= rs.getString("comp_spec");
        		            String s3  = rs.getString("status");
        		            comp_type = s1;comp_spec = s2;status = s3;
        		         }
        		         status = "WorkInProgress";
        		         rs.close();
        		         stmt.close();
        		         c.commit();
        		         JOptionPane.showMessageDialog(a,"Work Assigned");
        		         stmt = c.createStatement();
     				     String sql = "INSERT INTO work "+"VALUES ('"+ss_id+"',"+l+",'"+comp_type+"','"+comp_spec+"','"+status+"');"; 
     				     stmt.executeUpdate(sql);
     				     stmt.close();  
     				     c.commit();
     				     stmt = c.createStatement();
       		             String sql1 = "UPDATE complaint set status = '"+status+"' where c_id="+l;
       		             stmt.executeUpdate(sql1);
       		             stmt.close();
       		             c.commit();
        		         System.out.println(ss_id+c_id+comp_type+comp_spec+status);
     				     
        		      } catch (Exception e1) {
        		    	 e1.printStackTrace();
        			     System.err.println(e1.getClass().getName()+": "+e1.getMessage());
        		         System.exit(0);
        		      }
        		}
        		if(e.getSource()==b3) { //view work
        			p0.setVisible(false);
	                p1.setVisible(false);
	                p2.setVisible(false);
	                p3.setVisible(false);
	                p4.setVisible(false);
	                p6.setVisible(false);
	                p7.setVisible(false);
	                p8.setVisible(false);
	                p9.setVisible(false);
	                p10.setVisible(false);
	                p11.setVisible(true);
	                p13.setVisible(false);
	                po.setVisible(false);	                
        		}
        		if(e.getSource()==b16) { //view button for work details
        			Connection c = null;
        			Statement stmt = null;
        		      try {
        		         Class.forName("org.postgresql.Driver");
        		         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mgmt", "postgres", "4646");
        		         c.setAutoCommit(false);
        		         
        		         String ss_id = t8.getText();
        		         String column[]={"ss_id", "c_id", "comp_type", "comp_spec", "status"};
	        	         String[][] rows=new String[30][5];
	        		     int i=0;
        		         stmt = c.createStatement();
        		         ResultSet rs = stmt.executeQuery( "SELECT * FROM work where ss_id='"+ss_id+"' and status='WorkInProgress';" );
        		         while ( rs.next() ) {
        		        	rows[i][0] = rs.getString("ss_id");
        		            rows[i][1] = String.valueOf(rs.getInt("c_id"));
        		            rows[i][2] = rs.getString("comp_type");
        		            rows[i][3] = rs.getString("comp_spec");
        		            rows[i][4] = rs.getString("status");
        		            i++;
        		         }       		         
        		         JOptionPane.showMessageDialog(a,"Press OK to view");
        		         JTable table=new JTable(rows,column);
	        	         JScrollPane sp=new JScrollPane(table);
	        	         TableColumnModel columnModel = table.getColumnModel();
	        	         columnModel.getColumn(0).setPreferredWidth(10);
	        	         columnModel.getColumn(1).setPreferredWidth(10);
	        	         columnModel.getColumn(2).setPreferredWidth(50);
	        	         columnModel.getColumn(3).setPreferredWidth(120);
	        	         columnModel.getColumn(4).setPreferredWidth(60);
	        	         table.setFocusable(false);
	        	         p12.add(sp);
	        	         p12.setVisible(true);
	        	         d.add(p12);
	        	         d.setVisible(true);
	        	         rs.close();
	        	         stmt.close();
	        	         c.commit();
     				     
        		      } catch (Exception e1) {
        		    	 e1.printStackTrace();
        			     System.err.println(e1.getClass().getName()+": "+e1.getMessage());
        		         System.exit(0);
        		      }
        		}
        		if(e.getSource()==b7 || e.getSource()==b10 || e.getSource()==b15 || e.getSource()==b17 || e.getSource()==b19) {
        			t1.setText("");
            		t2.setText("");
            		cb1.setSelectedIndex(0);
            		cb2.setSelectedIndex(0);
            		t3.setText("");
            		t4.setText("");
            		t6.setText("");
            		t7.setText("");
            		t8.setText("");
            		t9.setText("");
        		}
        		if(e.getSource()==b13) { //update work
        			p0.setVisible(false);
	                p1.setVisible(false);
	                p2.setVisible(false);
	                p3.setVisible(false);
	                p4.setVisible(false);
	                p6.setVisible(false);
	                p7.setVisible(false);
	                p8.setVisible(false);
	                p9.setVisible(false);
	                p10.setVisible(false);
	                p11.setVisible(false);
	                p13.setVisible(true);
	                po.setVisible(false);	                
        		}
        		if(e.getSource()==b18) { //work completed button
        			Connection c = null;
        			Statement stmt = null;
        		      try {
        		         Class.forName("org.postgresql.Driver");
        		         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mgmt", "postgres", "4646");
        		         c.setAutoCommit(false);
        		         
        		         String c_id = t9.getText();
        		         int l = Integer.parseInt(c_id);        		         
        		         
        		         stmt = c.createStatement();
        		         String sql = "UPDATE complaint set status = 'completed' where c_id="+l;
        		         stmt.executeUpdate(sql);
        		         String sql1 = "UPDATE work set status = 'completed' where c_id="+l;
        		         stmt.executeUpdate(sql1);
        		         stmt.close();
        		         c.commit();
        		         JOptionPane.showMessageDialog(a,"Updated successfully");
        		      
        		      } catch (Exception e1) {
        		         e1.printStackTrace();
        		         System.err.println(e1.getClass().getName()+": "+e1.getMessage());
        		         System.exit(0);
        		      }
        		}
            }
       };
       hb1.addActionListener(x);
       hb2.addActionListener(x);
       hb3.addActionListener(x);
       b1.addActionListener(x);
       b2.addActionListener(x);
       b4.addActionListener(x);
       b3.addActionListener(x);
       b5.addActionListener(x);
       b6.addActionListener(x);
       b7.addActionListener(x);
       b8.addActionListener(x);
       b9.addActionListener(x);
       b10.addActionListener(x);
       b11.addActionListener(x);
       b12.addActionListener(x);
       b13.addActionListener(x);
       b14.addActionListener(x);
       b15.addActionListener(x);
       b16.addActionListener(x);
       b17.addActionListener(x);
       b18.addActionListener(x);
       b19.addActionListener(x);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new mgmt();
	}
}