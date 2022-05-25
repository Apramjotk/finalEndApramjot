import javax.swing.JFrame;
import java.util.ArrayList;

public class CalcStarter {
    public static void main(String[] args) {
        CalcOperation demo = new CalcOperation();
        Derivative de= new Derivative();
        ArrayList<String> derivative= new ArrayList<String>();
        derivative.add("2x^7");
        derivative.add("3x^7");
        derivative.add("1x^2");
        derivative.add("6");
        derivative.add("1");
       de.simplifyPoly( derivative);
        System.out.println(de.powerRule(derivative));
        de.productRule(derivative, derivative);

        //.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // demo.setVisible(true);
        //demo.setSize(300,500);
    }
}
