package Bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class BankSystem implements ActionListener{

    //containers
    int initialDeposit = 500;
    JFrame frame = new JFrame("Personal New Bank Account");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();

    //Panel 1 contents
    JLabel label1 = new JLabel("Welcome to the Personal New Bank Account!", SwingConstants.CENTER);
    
    //Panel 2 contents
    JLabel FN = new JLabel("First Name: ");
    JTextField txtFN = new JTextField(20);
    JLabel MN = new JLabel("Middle Name: ");
    JTextField txtMN = new JTextField(20);
    JLabel LN = new JLabel("Last Name:");
    JTextField txtLN = new JTextField(20);

    //Panel 3 contents
    JLabel Gender = new JLabel("Gender: ");
    ButtonGroup genderGrp = new ButtonGroup();
    JRadioButton rbtMale = new JRadioButton("Male", true);
    JRadioButton rbtFemale = new JRadioButton("Female");
    JRadioButton rbtOther = new JRadioButton("Other");

    //Panel 4 contents 
    JLabel Address = new JLabel("Address:");
    JLabel BD = new JLabel("Birthdate: ");
    JTextField txtAddress = new JTextField(40);
    JTextField txtBD = new JTextField(20);

    //Panel 5 contents
    JLabel CN = new JLabel("Contact No.: ");
    JLabel FathersName = new JLabel("Father's Name: ");
    JLabel MothersName = new JLabel("Mother's Name: ");
    JTextField txtCN = new JTextField(20);
    JTextField txtFathersName = new JTextField(20);
    JTextField txtMothersName = new JTextField(20);
    JButton btnCont = new JButton("Continue >>");

    public BankSystem(){
        frame.setLayout(new GridLayout(5, 0));
        frame.setSize(900, 420);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        Toolkit tk = frame.getToolkit();
        Dimension size = tk.getScreenSize();
        frame.setLocation(size.width/2 - frame.getWidth()/2, size.height/2 - frame.getHeight()/2);

        Font f1 = new Font(Font.SERIF, Font.BOLD, 70);
        frame.setFont(f1);

        panel1.setLayout(new GridLayout(1,1));
        panel1.add(label1);

        panel2.add(FN);
        panel2.add(txtFN);
        panel2.add(MN);
        panel2.add(txtMN);
        panel2.add(LN);
        panel2.add(txtLN);

        genderGrp.add(rbtMale);
        genderGrp.add(rbtFemale);
        genderGrp.add(rbtOther);

        Box b1 = Box.createVerticalBox();
        b1.add(rbtMale);
        b1.add(rbtFemale);
        b1.add(rbtOther);

        panel3.setLayout(new FlowLayout());
        panel3.add(CN);
        panel3.add(txtCN);
        panel3.add(Gender);
        panel3.add(b1);

        panel4.add(BD);
        panel4.add(txtBD);
        panel4.add(Address);
        panel4.add(txtAddress);
        
        
        panel5.add(FathersName);
        panel5.add(txtFathersName);
        panel5.add(MothersName);
        panel5.add(txtMothersName);
        panel5.add(btnCont);

        btnCont.addActionListener(this);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);

        frame.pack();
        frame.setVisible(true);

    }
    

    public static void main(String[] args) {
        BankSystem GUI = new BankSystem();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       JOptionPane.showMessageDialog(null, "Your transaction is being processed", "Bank account created", JOptionPane.INFORMATION_MESSAGE);
       try{
        printTransaction();
       }
       catch(Exception ex){
        System.out.println("Error in printing the Transaction.");
       }
    }

    public void printTransaction() throws IOException{
        File transact = new File("NewAccount.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(transact));
        try{
            bw.write("============================[TRANSACTION]======================================");
            bw.newLine();
            bw.write("Account Holder : "+ txtFN.getText() + "" + txtMN.getText() + "" + txtLN.getText());
        } catch(IOException e){
            e.getCause();
        } finally{
            bw.flush();
            bw.close();
        }
    }  

}
