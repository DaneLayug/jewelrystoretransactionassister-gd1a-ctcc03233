import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;

//This class will contain the methods that will be used to check the item's price.
class Methods
{
    public double Multiply_Price (int a, double b, double c) //This method will multiply the item's price to the amount the user needs.
    {
        c = a*b;
        return c;
    }
    
    public double Discount_Price (double a, double b, double c) //This method will give a discounted price to the user.
    {
        c = a*(b / 100);
        return c;
    }
    
}

//This class will be used to connect the database to the program.
class Program_DataBaseConnect 
{
    public Connection connect;
    public static Program_DataBaseConnect dbc;
    Program_DataBaseConnect()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelry_items","root","");
            System.out.println("Connection is Established");
        }
        
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
    }
    public static Program_DataBaseConnect getDatabaseConnection()
    {
        if(dbc==null)
        {
            dbc = new Program_DataBaseConnect();
        }
        return dbc;
    }
}

class JewelryStore_Transaction_Menu extends JFrame //This class is used to create the starting page of the program.
{
    //This is to initialize the program's variables and components.
    JFrame mFrame;
    JButton mButton1 ,mButton2;
    JLabel mLabel;
    JewelryStore_Transaction_Menu() //This constructor will be used to make the frame show if an object is created.
    {
        mFrame = new JFrame("JustJewelries Main Menu"); //Creation of the frame, and the title it will use.
        mLabel = new JLabel("Welcome User! What would you like o do?"); //Introductory Message.
        mLabel.setBounds(80,10,500,100); //This sets the placement of the introductory message.
        mLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20 )); //This sets the size and font of the introductory message.
        
        //These are the buttons that the program will use for the start up page, along with their placements and sizes.
        mButton1 = new JButton("Browse Jewelries"); 
        mButton1.setBounds(180, 100,150,80);
        mButton1.setFont(new Font("Times New Roman", Font.PLAIN, 16 ));
        mButton2 = new JButton("Exit Shop");
        mButton2.setBounds(180,250,150,80);
        mButton2.setFont(new Font("Times New Roman", Font.PLAIN, 20 ));
        
        //These are used to add the components onto the starting frame.
        mFrame.add(mLabel);
        mFrame.add(mButton1); mFrame.add(mButton2);
        
        //This makes the program close when you press the x button at the frames top right corner.
        mFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        mButton1.addActionListener(new ActionListener() //This is the action listener for the browse button.
        {
            public void actionPerformed(ActionEvent ae)
            {      
                JewelryStore_Transaction_BrowseMenu bm = new JewelryStore_Transaction_BrowseMenu(); //This makes the browse frame show up.
                mFrame.setVisible(false);//This removes the starting frame.
            }       
        });
        
        mButton2.addActionListener(new ActionListener() //This is is the action listener for the exit button.
        {
            public void actionPerformed(ActionEvent ae)
            {      
               System.exit(0);//This closes the program.
            }       
        });
          
        mFrame.setSize(500,500); //This is used to set the size of the starting frame.
        mFrame.setLayout(null);//This makes the frame's components editable.
        mFrame.setVisible(true);//This makes the starting frame visible.
    }
}


class JewelryStore_Transaction_BrowseMenu extends JFrame//This class is  used to create the browse frame of the program.
{
    //These are to initialize the components and variables needed for the browse frame.
    JFrame bFrame;
    JButton bButton1 ,bButton2 ,bButton3, bButton4 ;
    JTable bTable;
    JLabel pLabel1, pLabel2, pLabel3, pLabel4, pLabel5 ,pLabel6 ,pLabel7;
    JTextField pTxtF1, pTxtF2, pTxtF3;
    JPanel bPanel;
    int rep = 0;
    double total;
    double price;
    double discounted_price;
    Methods m = new Methods();
    JewelryStore_Transaction_BrowseMenu() //This constructor will be used to make the frame shown if an object is created.
    {
       //This array list will be used for prices each item has.
        ArrayList<Double> Prices = new ArrayList<>();    
        Prices.add(2050.00);
        Prices.add(3500.00);
        Prices.add(1170.00);
        Prices.add(7590.00);
        Prices.add(7000.00);
        Prices.add(4950.00);
        Prices.add(6750.00);
        Prices.add(6990.00);
        Prices.add(15390.00);
        Prices.add(34950.00);
        Prices.add(64350.00);
        Prices.add(5200.00);
        Prices.add(5950.00);
        Prices.add(6350.00);
        Prices.add(6700.00);
        Prices.add(12050.00);
        Prices.add(26090.00);
        Prices.add(4950.00);
        Prices.add(7290.00);
        Prices.add(50390.00);
        
        
        Program_DataBaseConnect dbc = new Program_DataBaseConnect(); //This creates the connection of the database to the program.
        bFrame = new JFrame("JustJewelries Browse Menu");//Creation of the frame, and the title it will use.
        
        //These are the buttons that the browser frame will use along with their positions.
        bButton1 = new JButton("Show Jewelries");
        bButton1.setBounds(120, 500,150,30);
        bButton2 = new JButton("Add Item");
        bButton2.setBounds(30,300,100,30);
        bButton3 = new JButton("Check Out");
        bButton3.setBounds(300,500,150,30);
        bButton4 = new JButton("Retun to Main Menu");
        bButton4.setBounds(510,500,150,30);
        
        //These are the labels that the browser frame will use.
        pLabel1 = new JLabel("|Price Check Here|");
        pLabel1.setBounds(20, 10,150,30);
        //These are labels that tell the user what each inputs are required to be entered in the text fields.
        pLabel2 = new JLabel("Jewelries Number Index");
        pLabel2.setBounds(10,50,150,30);
        pLabel3 = new JLabel("Amount of Jewelries");
        pLabel3.setBounds(30,120,150,30);
        pLabel4 = new JLabel("Discount Given");
        pLabel4.setBounds(30,180,150,30);
        
        //This label is used to tell the user the total price.
        pLabel5 = new JLabel("Total: PHP" + total);
        pLabel5.setBounds(10,250,150,30);
        
        //This label the user how much they saved from the given discount.
        pLabel6 = new JLabel("");
        pLabel6.setBounds(10,270,150,30);
        
        //This label will give the user instructions after pressing the checkout button.
        pLabel7 = new JLabel("");
        pLabel7.setBounds(30,450,400,30);
        
        //These are the Text Fields that the browse frame uses along with their position and size.
        pTxtF1 = new JTextField();
        pTxtF1.setBounds(10, 80,150,30);
        pTxtF2 = new JTextField();
        pTxtF2.setBounds(10,150,150,30);
        pTxtF3 = new JTextField();
        pTxtF3.setBounds(10,210 ,150,30);
        
        //This table will be used to display information from the database.
        bTable = new JTable();
        
        //This Panel will be used to house the table.
        bPanel = new JPanel();
        bPanel.setSize(450, 400);//This sets the size of the panel.
        bPanel.setBounds(110,50,650, 500);//This sets the position of the panel.
        bPanel.add(bTable); //This adds the table component on to the panel.
        
        //These adds every component created for the frame onto the browser frame.
        bFrame.add(pLabel1); bFrame.add(pLabel2);  bFrame.add(pLabel3) ;
        bFrame.add(pLabel4);bFrame.add(pLabel5);bFrame.add(pLabel6);
        bFrame.add(pLabel7);
        bFrame.add(pTxtF1); bFrame.add(pTxtF2);  bFrame.add(pTxtF3);
        bFrame.add(bButton1); bFrame.add(bButton2);  bFrame.add(bButton3); bFrame.add(bButton4);
        bFrame.add(bPanel);
        
        //This makes the program close when you press the x button at the frames top right corner.
        bFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        bButton1.addActionListener(new ActionListener() //This is the action listener for the show jewelries button.
        {
            public void actionPerformed(ActionEvent ae)
            {      

               //This is used to for the data base to show its contents onto the table.
               try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver"); //This connects the driver of my sql to the program.
                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelry_items","root","");//This creates the connection to the database.
                    
                    //This query will get the requested information from the database.
                    String query = "SELECT `jewelry_number`,`jewelry_karat`, `jewelry_type`, `jewelry_design`, `jewelry_grams`, `jewelry_length`, `jewelry_price` FROM `jewelries` WHERE 1";
                    Statement st = connect.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData(); //This gets every data that was requested from the query.
                    DefaultTableModel model = (DefaultTableModel)bTable.getModel(); //This sets the model of the table.
                    
                    //These set the columns of the table.
                    int column = rsmd.getColumnCount();
                    String[] column_name = new String[column];
                    for(int i = 0; i<column; i++)
                        column_name[i] = rsmd.getColumnName(i+1);
                    model.setColumnIdentifiers(column_name);
                    
                    //This creates the table's rows and displays the data requested from the database.
                    String jewelry_number, jewelry_karat, jewelry_type, jewelry_design, jewelry_grams, jewelry_length, jewelry_price;
                    while(rs.next())
                    {
                        jewelry_number = rs.getString(1);
                        jewelry_karat = rs.getString(2);
                        jewelry_type = rs.getString(3);
                        jewelry_design = rs.getString(4);
                        jewelry_grams = rs.getString(5);
                        jewelry_length = rs.getString(6);
                        jewelry_price = rs.getString(7);
                        
                        String[] row = {jewelry_number, jewelry_karat, jewelry_type, jewelry_design, jewelry_grams, jewelry_length, jewelry_price};
                        model.addRow(row);
                    }
                    
                    //These closes the statement and the connection once the table is shown.
                    st.close();
                    connect.close();
                }
                
               //This catch triggers if the program is not connected to the database.
               catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(null,e);
                }
            }       
        });
        
        bButton2.addActionListener(new ActionListener() //This is the action listener for the Add Item button.
        {
            public void actionPerformed(ActionEvent ae)
            {      
               pLabel7.setText(""); //This sets the label that shows the discounted price to blank.
               
               //This if statement triggers when the discount Text Feild is empty.
               if (pTxtF3.getText().isBlank())
                   
               {
                    int index = Integer.parseInt(pTxtF1.getText()) -1; //This gets the index of the item based on the user input.
                    price = Prices.get(index); //This gets the price from the array list depending on the index that was input.

                    int multiplier = Integer.parseInt(pTxtF2.getText()); //This gets the user's input for the amount of items for one item.
                    total = m.Multiply_Price(multiplier, price, total); //This calculates the total of the item's price times how many the user wants.
                    pLabel5.setText("Total: PHP" + Double.toString(total)); //This shows the total of the calculation.
                    
               }
               //This else triggers when the discount text field has an input.
               
               else
               {
                    int index = Integer.parseInt(pTxtF1.getText()) -1;//This gets the index of the item based on the user input.
                    price = Prices.get(index); //This gets the price from the array list depending on the index that was input.

                    int multiplier = Integer.parseInt(pTxtF2.getText()); //This gets the user's input for the amount of items for one item.
                    total = m.Multiply_Price(multiplier, price, total); //This calculates the total of the item's price times how many the user wants.

                    double discount =  Double.parseDouble(pTxtF3.getText()); //This gets the discount input.
                    discounted_price = m.Discount_Price(total, discount, discounted_price); //This calculates the discounted price.
                    total = total - discounted_price; //This reduces the total price with the discounted price.
                    pLabel5.setText("Total: PHP" + Double.toString(total)); //This shows the total of the calculation.
                    pLabel6.setText("You will Save PhP " + discounted_price ); //This shows the price reduced due to the discount.
                    
               } 
               
            }       
        });
        
          bButton3.addActionListener(new ActionListener() //This is the action listener for the check out button.
        {
            public void actionPerformed(ActionEvent ae)
            {      
              pLabel7.setText("Please Proceed to the Nearest Check Out! Have a Nice Day!"); //Instructions for the user.
            }       
        });
          
        bButton4.addActionListener(new ActionListener() //This is the action listener for the return to main menu button.
        {
            public void actionPerformed(ActionEvent ae)
            {      
               JewelryStore_Transaction_Menu mm = new JewelryStore_Transaction_Menu(); //This returns the starting menu.
               bFrame.setVisible(false); //This removes the browse menu.
            }       
        });
        
        bFrame.setSize(750,600);  //This is used to set the size of the browse frame.
        bFrame.setLayout(null); //This makes the frame's components editable.
        bFrame.setVisible(true); //This makes the browse frame visible.
    }
}


public class JewelryStore_Transaction_Assister
{
    public static void main(String []args)
    {
       JewelryStore_Transaction_Menu menu = new JewelryStore_Transaction_Menu(); //This object is used to show the staring menu once the program is run.
    }
}