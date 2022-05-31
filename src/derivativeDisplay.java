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
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;
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

public class derivativeDisplay extends JFrame implements ActionListener {
   JLabel label0, label1, label2, label3, label4, label5, label6,label7, label8;
   JButton btnDerivative, btnClear, btnSlope;
   String result="";
   String poly1="";
    JFrame frame1 = new JFrame();
    JFrame frame2 = new JFrame();

    JTextField txtField1, txtField2, txtField3,  txtField4, txtField5, txtField6, txtField7, txtField8;
   public derivativeDisplay(String result){
       this.result= result;
       setLayout(new GridLayout(16,15));
       setTitle("Derivative calculator");
       frame1.setVisible(false);
       btnDerivative = new JButton(" Derivative");
       btnClear = new JButton("Return");
       btnSlope = new JButton("Slope");
       btnDerivative.addActionListener(this);
       btnClear.addActionListener(this);
       btnSlope.addActionListener(this);


       txtField1 = new JTextField();
       txtField2 = new JTextField();
       txtField3 = new JTextField();
       txtField4 = new JTextField();
       txtField5= new JTextField();
       txtField6= new JTextField();
       txtField7= new JTextField();
       txtField8= new JTextField();

       label0= new JLabel("Enter only (x) variable and (,) between each element  :");

       System.out.println();
       if (result.equalsIgnoreCase("Power")) {
           label0 = new JLabel("    Derivative of (a^n) is (na^n-1) ", JLabel.LEFT);
           label1 = new JLabel("    Polynominal 1( enter only (x) use (,) between each)       ", JLabel.LEFT);

           label6=new JLabel("  x Value (YOU ENTER (NUM ONLY):     ", JLabel.LEFT);
           label2 = new JLabel("    Derivative:        ", JLabel.LEFT);
           label4 = new JLabel("    Polynominal FORM:     ", JLabel.LEFT);

           label7=new JLabel("  Slope at x:     ", JLabel.LEFT);
           label8=new JLabel("  Tangent Line at x:     ", JLabel.LEFT);
           add(label0);
           add(label1);
           add(txtField1);
           add(label6);
           add(txtField6);
           add(label2);
           add(txtField2);
           add(label4);
           add(txtField3);
           add(label7);
           add(txtField7);
           add(label8);
           add(txtField8);
           add(btnDerivative);
           add(btnClear);
           add(btnSlope);
       }
       else{
           if (result.equals("Product")){
               label0 = new JLabel("    Derivative is f(x)g'(x)+ g(x)f'(x) ");
           }
           if (result.equals("Quotient")){
               label0 = new JLabel("    Derivative is ( g(x) f'(x) -  f(x) g'(x) ) / ( g(x)^2 ) ");
           }
           label1 = new JLabel("    Polynominal 1( enter only (x) use (,) between each):       ", JLabel.LEFT);


           label3 = new JLabel("   Polynominal 2 ( enter only (x) use (,) between each)", JLabel.LEFT);


           label2 = new JLabel("    Derivative:        ", JLabel.LEFT);

           label4 = new JLabel("    Polynominal FORM:     ", JLabel.LEFT);
           label5 = new JLabel("    Derivative FORM:     ", JLabel.LEFT);
           add(label0);
           add(label1);
           add(txtField1);
           add(label3);
           add(txtField2);
           add(label2);
           add(txtField3);
           add(label4);
           add(txtField4);
           add(label5);
           add(txtField5);
           add(btnDerivative);
           add(btnClear);
       }





   }
   public void actionPerformed(ActionEvent e) {
       Scanner answer= new Scanner(System.in);
       String answerChoice="";
       String derivative="";
       String polyForm2="";
       ArrayList<String>equation1= new ArrayList<>();
       ArrayList<String>equation2= new ArrayList<>();
       if (result.equals("Power")) {
           if (e.getActionCommand().equals(" Derivative")) {
               String[] elementsPoly = txtField1.getText().split(",");
               Derivative de = new Derivative(equation1);
               Collections.addAll(equation1, elementsPoly);
               txtField2.setText(de.polyForm(de.powerRule(equation1)));
               txtField3.setText(de.polyForm(equation1));
               //  txtField7.setText("n/a");
               //  txtField6.setText("n/a");
               // txtField8.setText("n/a");

           }
           if (e.getActionCommand().equals("Slope")) {
               String[] elementsPoly = txtField1.getText().split(",");
               Derivative de = new Derivative(equation1);
               Collections.addAll(equation1, elementsPoly);
               txtField2.setText(de.polyForm(de.powerRule(equation1)));
               txtField3.setText(de.polyForm(equation1));
               de.slopeWithDerivative(txtField6.getText());
               txtField7.setText(de.slopeWithDerivative(txtField6.getText()));
               txtField8.setText(de.tangentLine(txtField6.getText()));
           }
       }
       if (result.equals("Product")){
           if (e.getActionCommand().equals(" Derivative")) {
               String[] elementsPoly = txtField1.getText().split(",");
               String[] elementsPoly2 = txtField2.getText().split(",");
               Collections.addAll(equation1, elementsPoly);
               Collections.addAll(equation2, elementsPoly2);
               Derivative de = new Derivative(equation1);
               derivative = de.reoderPoly(de.productRule(equation1, equation2));
               polyForm2 = " f(x):" + de.polyForm(equation1) + "\n" + "  g(x): " + de.polyForm(equation2);
               txtField3.setText(derivative);
               txtField4.setText(polyForm2);
               txtField5.setText("f'(x): " + de.polyForm(de.powerRule(equation1)) + "  g'(x): " + de.polyForm(de.powerRule(equation2)));
           }

       }
       if (result.equals("Quotient")){
           if (e.getActionCommand().equals(" Derivative")) {
               String[]elementsPoly= txtField1.getText().split(",");
               String[]elementsPoly2= txtField2.getText().split(",");
               Collections.addAll(equation1, elementsPoly);
               Collections.addAll(equation2, elementsPoly2);
               Derivative de= new Derivative(equation1);
               derivative= de.quotientRule(equation1, equation2);
               polyForm2= " f(x):"+  de.polyForm(equation1)+ "\n"+ "  g(x): "+ de.polyForm(equation2);
               txtField3.setText(derivative);
               txtField4.setText(polyForm2);
               txtField5.setText(" f'(x): " + de.polyForm(de.powerRule(equation1)) + "  g'(x): " + de.polyForm(de.powerRule(equation2)));
           }

       }

       /*if (result.equalsIgnoreCase("n")|| e.getActionCommand().equals("2 polynominals")){
           String[]elementsPoly= txtField1.getText().split(",");
           String[]elementsPoly2= txtField2.getText().split(",");
           Collections.addAll(equation1, elementsPoly);
           Collections.addAll(equation2, elementsPoly2);
           System.out.println("Are you multiplying the polynomial or dividing (m)/(d)");
           answerChoice= answer.nextLine();
           Derivative de= new Derivative(equation1);

           if(answerChoice.equalsIgnoreCase("m")){
              derivative= de.productRule(equation1, equation2);
              polyForm2= "Poly 1:"+  de.polyForm(equation1)+ "\n"+ "Poly 2: "+ de.polyForm(equation2);

               txtField3.setText(derivative);
               txtField4.setText(polyForm2);
               txtField5.setText("Equation 1: " +de.polyForm(de.powerRule(equation1))+ "  Equation 2: " +de.polyForm(de.powerRule(equation2)));

           }
           if(answerChoice.equalsIgnoreCase("d")){
               derivative= de.quotientRule(equation1, equation2);
               polyForm2= "Poly 1:"+  de.polyForm(equation1)+ "\n"+ "Poly 2: "+ de.polyForm(equation2);
               txtField3.setText(derivative);
               txtField4.setText(polyForm2);
           }
       }*/

   }
    public void save() {
        try {
            File f = new File("src/derivative.data");
            f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/derivative.data");
            fw.write(txtField1+ "\n");
            fw.write(txtField2+ "\n");
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }

}

