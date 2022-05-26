import javax.swing.JFrame;
import java.util.ArrayList;

public class CalcStarter {
    public static void main(String[] args) {
        CalcOperation demo = new CalcOperation();
        Derivative de= new Derivative();
        ArrayList<String> derivative= new ArrayList<String>();
        //derivative.add("8x^8");
        derivative.add("3x");
        derivative.add("-5x");
       // derivative.add("6x^2");
        derivative.add("1");
        derivative.add("3");
        //de.quotientRule(derivative, derivative);
       // de.reoderPoly(derivative);
       de.simplifyPoly( derivative);

        ///System.out.println(de.powerRule(derivative));
        //de.productRule(derivative, derivative);


        //.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // demo.setVisible(true);
        //demo.setSize(300,500);
    }
}
