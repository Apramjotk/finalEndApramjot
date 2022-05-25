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

public class Main {
    public static void main(String[] args) {
        CalcOperation demo = new CalcOperation();
        Derivative de= new Derivative();
        ArrayList<String> derivative= new ArrayList<String>();
        derivative.add("2x^3");
        //derivative.add("3x^3");
       // derivative.add("1x^3");
        //derivative.add("6x^2");
        derivative.add("1");
        System.out.println(de.powerRule(derivative));
        de.productRule(derivative, derivative);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.setVisible(true);
        demo.setSize(300,500);
    }
}
