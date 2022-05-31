import java.util.Arrays;
import java.util.Collections;
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

            JLabel label1, label2, label3;

            JButton btnMode, btnPlus, btnMinus, btnMultiply, btnDivide, btnClear, btnRange, btnMean;
            JTextField txtField1, txtField2, txtField3,  txtField4;

         public CalcOperation(){
                setLayout(new GridLayout(10,10));
                setTitle("Basic operation calculator");
                //initializing label

                 label1 = new JLabel("Numbers :");
                 label3 = new JLabel("Result :", JLabel.LEFT);

                 //initializing buttons;
                 btnPlus = new JButton("Add Nums");
                 btnMinus = new JButton("Subtract Nums");
                 btnMultiply = new JButton("Multiply Nums");
                 btnDivide = new JButton("Divide Nums");
                 btnRange = new JButton("Range of Nums");
                 btnMean = new JButton("Mean of Nums");
                 btnMode = new JButton("Mode of Nums");
                 btnClear = new JButton("Clear");

                 //adding eventlistener
                 btnPlus.addActionListener(this);
                 btnMinus.addActionListener(this);
                 btnMultiply.addActionListener(this);
                 btnDivide.addActionListener(this);
                 btnRange.addActionListener(this);
                 btnMean.addActionListener(this);
                 btnMode.addActionListener(this);
                 btnClear.addActionListener(this);
                 //initializing textfield
                 //for(int i = 0; i < 3; i++)
                 txtField1 = new JTextField();
                 txtField2 = new JTextField();
                 txtField3 = new JTextField();

                 //adding to the frame
                 add(label1);
                 add(txtField1);


                 add(label3);
                 add(txtField3);
                 add(btnPlus);
                 add(btnMinus);
                 add(btnMultiply);
                 add(btnDivide);
                 add(btnRange);
                 add(btnMean);
                 add(btnMode);
                 add(btnClear);


        }//end of constructor


    @Override

    public void actionPerformed(ActionEvent e) {

        String opt = e.getActionCommand();
        String result="";
        int length=0;
        ArrayList<String> numbers= new ArrayList<>();
        System.out.println(txtField1.getText());
        String [] numberSet= txtField1.getText().split(",");
        Collections.addAll(numbers, numberSet);
        System.out.println(numbers);
        basicCalculations bc= new basicCalculations(numbers);

        if(opt.equals("Add Nums"))
            result=bc.totalSumNumbers();
        else if(opt.equals("Subtract Nums"))
            result=bc.totalDifferencNumbers();
        else if(opt.equals("Multiply Nums"))
            result=bc.mutiplyNumbers();
        else if(opt.equals("Divide Nums"))
            result=bc.divideNumbers();
        else if (opt.equals("Range of Nums")){
            result= bc.rangeOfNumbers();
        }
        else if (opt.equals("Mean of Nums")){
            result= ""+bc.meanOfNumbers();
        }
        else if (opt.equals("Mode of Nums")){
            result= bc.modeOfNumbers();
        }
        else if(opt.equals("Clear")){
            txtField1.setText("");
        }
        txtField3.setText(result);


    }
}



