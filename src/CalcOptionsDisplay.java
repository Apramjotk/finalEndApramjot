import java.awt.*;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcOptionsDisplay extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
     String poly1;
    JButton btnStatistics,btnTriangle, btnBasicOperation, btnCircle, btnPowerRule, btnProductRule, btnQuotientRule, btnRectangle, btnSquare, btnPhytagereon, btnCircumference, btnInteriorAngle;
    public CalcOptionsDisplay(){
        setLayout(new GridLayout(12,25));
        setTitle("Multi-Step Calculator System");
        label1 = new JLabel("   Welcome to the MultiCalculator, choose a option: ");

        btnPowerRule= new JButton("Find Derivative with Power Rule");
        btnProductRule=new JButton("Find Derivative with Product Rule");
        btnQuotientRule= new JButton("Find Derivative with Quotient Rule");

        btnStatistics = new JButton("Find mean, mode and range");
        btnBasicOperation = new JButton("Add, Subtract, multiply and divide");
        btnCircle = new JButton("Area/circumference of a circle");
        btnRectangle = new JButton("Area of a rectangle");
        btnSquare= new JButton("Area of a Square");
        btnTriangle= new JButton("Area of a Triangle");
        btnPhytagereon= new JButton("Pythagorean Theorem");
        btnInteriorAngle= new JButton("Interior Angles");

        btnPowerRule.addActionListener(this);
        btnProductRule.addActionListener(this);
        btnQuotientRule.addActionListener(this);
        btnStatistics.addActionListener(this);
        btnBasicOperation.addActionListener(this);
        btnCircle.addActionListener(this);
        btnRectangle.addActionListener(this);
        btnSquare.addActionListener(this);
        btnTriangle.addActionListener(this);
        btnPhytagereon.addActionListener(this);
        btnInteriorAngle.addActionListener(this);

        add(label1);
        add(btnPowerRule);
        add(btnProductRule);
        add(btnQuotientRule);
        add(btnStatistics);
        add(btnBasicOperation);
        add(btnCircle);
        add(btnRectangle);
        add(btnSquare);
        add(btnTriangle);
        add(btnPhytagereon);
        add(btnInteriorAngle);

    }
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Find Derivative with Power Rule")){

            DerivativeDisplay de= new DerivativeDisplay("Power");
            de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            de.setVisible(true);
            de.setSize(800,800);



        }
        if (e.getActionCommand().equals("Find Derivative with Product Rule")){

            DerivativeDisplay de= new DerivativeDisplay("Product");
            de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            de.setVisible(true);
            de.setSize(800,800);

        }
        if (e.getActionCommand().equals("Find Derivative with Quotient Rule")){
            DerivativeDisplay de= new DerivativeDisplay("Quotient");
            de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            de.setVisible(true);
            de.setSize(800,800);

        }

        if (e.getActionCommand().equals("Find mean, mode and range")){

           SimpleCalcDisplay de= new SimpleCalcDisplay();
            de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            de.setVisible(true);
            de.setSize(800,800);

        }
        if (e.getActionCommand().equals("Add, Subtract, multiply and divide")){

            SimpleCalcDisplay de= new SimpleCalcDisplay();
            de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            de.setVisible(true);
            de.setSize(800,800);

        }
        if (e.getActionCommand().equals("Area/circumference of a circle")){
          GeometryDisplay gd= new GeometryDisplay("  Circle");
            gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setVisible(true);
            gd.setSize(800,800);
        }
        if (e.getActionCommand().equals("Area of a rectangle")){
            GeometryDisplay gd= new GeometryDisplay("rectangle");
            gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setVisible(true);
            gd.setSize(800,800);
        }
        if (e.getActionCommand().equals("Area of a Square")){
            GeometryDisplay gd= new GeometryDisplay("square");
            gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setVisible(true);
            gd.setSize(800,800);
        }
        if (e.getActionCommand().equals("Area of a Triangle")){
            GeometryDisplay gd= new GeometryDisplay("triangle");
            gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setVisible(true);
            gd.setSize(800,800);
        }
        if (e.getActionCommand().equals("Pythagorean Theorem")){
            GeometryDisplay gd= new GeometryDisplay("Pythagorean Theorem");
            gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setVisible(true);
            gd.setSize(800,800);
        }
        if (e.getActionCommand().equals("Interior Angles")){
            GeometryDisplay gd= new GeometryDisplay("interior angles");
            gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setVisible(true);
            gd.setSize(800,800);
        }





    }



}
