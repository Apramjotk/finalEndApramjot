import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
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

public class runFrameCalculator extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
     String poly1;
    JButton btnStatistics,btnTriangle, btnBasicOperation, btnCircle, btnPowerRule, btnProductRule, btnQuotientRule, btnRectangle, btnSquare, btnPhytagereon, btnCircumference, btnInteriorAngle;
    JTextField txtField1, txtField2, txtField3,  txtField4;
    public runFrameCalculator(){
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

            derivativeDisplay de= new derivativeDisplay("Power");
            de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            de.setVisible(true);
            de.setSize(800,800);



        }
        if (e.getActionCommand().equals("Find Derivative with Product Rule")){

            derivativeDisplay de= new derivativeDisplay("Product");
            de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            de.setVisible(true);
            de.setSize(800,800);

        }
        if (e.getActionCommand().equals("Find Derivative with Quotient Rule")){
            derivativeDisplay de= new derivativeDisplay("Quotient");
            de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            de.setVisible(true);
            de.setSize(800,800);

        }

        if (e.getActionCommand().equals("Find mean, mode and range")){

           CalcOperation de= new CalcOperation();
            de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            de.setVisible(true);
            de.setSize(800,800);

        }
        if (e.getActionCommand().equals("Add, Subtract, multiply and divide")){

            CalcOperation de= new CalcOperation();
            de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            de.setVisible(true);
            de.setSize(800,800);

        }
        if (e.getActionCommand().equals("Area/circumference of a circle")){
          geometryDisplay gd= new geometryDisplay("  Circle");
            gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setVisible(true);
            gd.setSize(800,800);
        }
        if (e.getActionCommand().equals("Area of a rectangle")){
            geometryDisplay gd= new geometryDisplay("rectangle");
            gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setVisible(true);
            gd.setSize(800,800);
        }
        if (e.getActionCommand().equals("Area of a Square")){
            geometryDisplay gd= new geometryDisplay("square");
            gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setVisible(true);
            gd.setSize(800,800);
        }
        if (e.getActionCommand().equals("Area of a Triangle")){
            geometryDisplay gd= new geometryDisplay("triangle");
            gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setVisible(true);
            gd.setSize(800,800);
        }
        if (e.getActionCommand().equals("Pythagorean Theorem")){
            geometryDisplay gd= new geometryDisplay("Pythagorean Theorem");
            gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setVisible(true);
            gd.setSize(800,800);
        }
        if (e.getActionCommand().equals("Interior Angles")){
            geometryDisplay gd= new geometryDisplay("interior angles");
            gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gd.setVisible(true);
            gd.setSize(800,800);
        }





    }



}
