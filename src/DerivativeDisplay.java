import java.awt.*;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;
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

public class DerivativeDisplay extends JFrame implements ActionListener {
   JLabel label0, label1, label2, label3, label4, label5, label6,label7, label8;
   JButton btnDerivative, btnSlope;
   String result="";

    JFrame frame1 = new JFrame();
    JFrame frame2 = new JFrame();

    JTextField txtField1, txtField2, txtField3,  txtField4, txtField5, txtField6, txtField7, txtField8;
   public DerivativeDisplay(String result){
       this.result= result;
       setLayout(new GridLayout(16,15));
       setTitle("Derivative calculator");
       frame1.setVisible(false);
       btnDerivative = new JButton(" Derivative");
       btnSlope = new JButton("Slope");

       btnDerivative.addActionListener(this);
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
           ArrayList<String> previousEntered= new ArrayList<>();

           try {
               BufferedReader reader= new BufferedReader(new FileReader("inputtedUser.txt"));
               String line;
               while ((line= reader.readLine())!= null){
                   previousEntered.add(line);
               }

               reader.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
           if (previousEntered.size()==1){
               txtField1.setText(previousEntered.get(0));
           }
           if (previousEntered.size()==2){
               txtField1.setText(previousEntered.get(0));
               txtField6.setText(previousEntered.get(1));
           }


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
           add(btnSlope);
       }
       else{
           ArrayList<String> previousEntered= new ArrayList<>();
           try {
               BufferedReader reader= new BufferedReader(new FileReader("inputtedUserPolys.txt"));
               String line;
               while ((line= reader.readLine())!= null){
                   previousEntered.add(line);
               }

               reader.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
           if (previousEntered.size()==1){
               txtField1.setText(previousEntered.get(0));
           }
           if (previousEntered.size()==2){
               txtField1.setText(previousEntered.get(0));
               txtField2.setText(previousEntered.get(1));
           }


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
               try {
                   BufferedWriter writer= new BufferedWriter(new FileWriter("inputtedUser.txt"));
                   writer.write(txtField1.getText());
                   writer.close();
               } catch (IOException b) {
                   b.printStackTrace();
               }
               String[] elementsPoly = txtField1.getText().split(",");
               DerivativeCalc de = new DerivativeCalc(equation1);
               Collections.addAll(equation1, elementsPoly);
               txtField2.setText(de.reoderPoly(de.powerRule(equation1)));
               txtField3.setText(de.reoderPoly(equation1));
                txtField7.setText("n/a");
                txtField6.setText("n/a");
                txtField8.setText("n/a");

           }
           if (e.getActionCommand().equals("Slope")) {
               try {
                   BufferedWriter writer= new BufferedWriter(new FileWriter("inputtedUser.txt"));
                   writer.write(txtField1.getText());
                   writer.write("\n"+txtField6.getText());
                   writer.close();
               } catch (IOException b) {
                   b.printStackTrace();
               }
               String[] elementsPoly = txtField1.getText().split(",");
               DerivativeCalc de = new DerivativeCalc(equation1);
               Collections.addAll(equation1, elementsPoly);
               txtField2.setText(de.polyForm(de.powerRule(equation1)));
               txtField3.setText(de.polyForm(equation1));
               de.slopeWithDerivative(txtField6.getText());
               txtField7.setText(de.slopeWithDerivative(txtField6.getText()));
               txtField8.setText(de.tangentLine(txtField6.getText()));
           }
       }
       if (result.equals("Product")){
           try {

               BufferedWriter writer= new BufferedWriter(new FileWriter("inputtedUserPolys.txt"));
               writer.write(txtField1.getText());
               writer.write("\n"+txtField2.getText());
               writer.close();
           } catch (IOException b) {
               b.printStackTrace();
           }
           if (e.getActionCommand().equals(" Derivative")) {
               String[] elementsPoly = txtField1.getText().split(",");
               String[] elementsPoly2 = txtField2.getText().split(",");
               Collections.addAll(equation1, elementsPoly);
               Collections.addAll(equation2, elementsPoly2);
               DerivativeCalc de = new DerivativeCalc(equation1);
               txtField5.setText("f'(x): " + de.reoderPoly(de.powerRule(equation1)) + "  g'(x): " + de.reoderPoly(de.powerRule(equation2)));
               derivative = de.reoderPoly(de.productRule(equation1, equation2));
               polyForm2 = " f(x):" + de.reoderPoly(equation1) + "\n" + "  g(x): " + de.reoderPoly(equation2);
               txtField3.setText(derivative);
               txtField4.setText(polyForm2);

           }

       }
       if (result.equals("Quotient")){
           try {
               BufferedWriter writer= new BufferedWriter(new FileWriter("inputtedUserPolys.txt"));
               writer.write(txtField1.getText());
               writer.write("\n"+txtField2.getText());
               writer.close();
           } catch (IOException b) {
               b.printStackTrace();
           }
           if (e.getActionCommand().equals(" Derivative")) {
               String[]elementsPoly= txtField1.getText().split(",");
               String[]elementsPoly2= txtField2.getText().split(",");
               Collections.addAll(equation1, elementsPoly);
               Collections.addAll(equation2, elementsPoly2);
               DerivativeCalc de= new DerivativeCalc(equation1);
               txtField5.setText(" f'(x): " + de.reoderPoly(de.powerRule(equation1)) + "  g'(x): " + de.reoderPoly(de.powerRule(equation2)));
               derivative= (de.quotientRule(equation1, equation2));
               polyForm2= " f(x):"+  de.reoderPoly(equation1)+ "\n"+ "  g(x): "+ de.reoderPoly(equation2);
               txtField3.setText(derivative);
               txtField4.setText(polyForm2);


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


}

