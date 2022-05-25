import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class CalcOperation extends JFrame implements ActionListener {
        JLabel  firstL;
        JLabel secondL;
        JLabel third1;
        JButton btnPlus, btnMinus, btnMultiply, btnClear;
        JTextField txtField1, txtField2, txtField3;
        public CalcOperation(){
            setLayout(new GridLayout(6,2));
            setTitle("Calc, Basic Arthemtic,equation solver and phyatageron theorem ");
            for (int i=0; i< 3; i++) {
                firstL = new JLabel("    Number" +1 +" :", JLabel.LEFT);
            }
            secondL = new JLabel("     Number 2 :",JLabel.LEFT);


            btnPlus = new JButton(" Calculus");
            btnMinus = new JButton("Arthimetic");
            btnMultiply = new JButton("Geometry");
            btnClear = new JButton("Equation ");
            btnPlus.addActionListener(this);
            btnMinus.addActionListener(this);
            btnMultiply.addActionListener(this);
            btnClear.addActionListener(this);
            //initializing textfield
            //for(int i = 0; i < 3; i++)
            txtField1 = new JTextField();
            txtField2 = new JTextField();
            txtField3 = new JTextField();

            //adding to the frame
            add(firstL,0);
            add(txtField1);
            add(secondL);
            add(txtField2);
            add(btnPlus);
            add(btnMinus);
            add(btnMultiply);
            add(btnClear);
        }//end of constructor


    @Override
    public void actionPerformed(ActionEvent e) {
        String opt = e.getActionCommand();
        int num1, num2, num = 0;
        num1 = Integer.parseInt(txtField1.getText());
        num2 = Integer.parseInt(txtField2.getText());
        Derivative de= new Derivative();
        ArrayList<String> derivative= new ArrayList<String >();
        derivative.add("3x^2");
        derivative.add("2x");
        derivative.add("3");
        de.powerRule(derivative);
    }
}



