import java.io.*;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.GridLayout;

public class SimpleCalcDisplay extends JFrame implements ActionListener {

            JLabel label1, label2, label3;

            JButton btnMode, btnPlus, btnMinus, btnMultiply, btnDivide, btnClear, btnRange, btnMean;
            JTextField txtField1, txtField2, txtField3,  txtField4;

         public SimpleCalcDisplay(){

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
             ArrayList<String> previousEntered= new ArrayList<>();
             try {
                 BufferedReader reader= new BufferedReader(new FileReader("inputtedNumUser.txt"));
                 String line;
                 while ((line= reader.readLine())!= null){
                     System.out.println(line);
                     previousEntered.add(line);
                 }

                 reader.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             if (previousEntered.size()==1){
                 txtField1.setText(previousEntered.get(0));
             }

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
        String [] numberSet= txtField1.getText().split(",");
        try {
            BufferedWriter writer= new BufferedWriter(new FileWriter("inputtedNumUser.txt"));
            if(!opt.equals("Clear")){
                writer.write(txtField1.getText());
            }

            if(opt.equals("Clear")){
                writer.write("");
                txtField1.setText("");

            }
            writer.close();
        } catch (IOException b) {
            b.printStackTrace();
        }
        Collections.addAll(numbers, numberSet);
        BasicCalculationsCalc bc= new BasicCalculationsCalc(numbers);

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

        txtField3.setText(result);


    }
}



