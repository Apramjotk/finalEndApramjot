import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Scanner;

public class CalcStarter {
    public static void main(String[] args) {

        runFrameCalculator de= new runFrameCalculator();
        de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       de.setVisible(true);
        de.setSize(1600,800);
        //derivativeDisplay de= new derivativeDisplay();
        ArrayList<String> derivative= new ArrayList<String>();
        ArrayList<String> numbers= new ArrayList<String>();
        derivative.add("8x^8");
        derivative.add("3x");
       derivative.add("5x^2");
        derivative.add("-3x^2");
        //derivative.add("3x^2");
        derivative.add("x");
       derivative.add("5x^9");
       // derivative.add("x");
       // derivative.add("5x^2");
        derivative.add("-8");
       // derivative.add("4x");
       // derivative.add("-8");
         numbers.add("+2");
         numbers.add("+1");
         numbers.add("*8");
         numbers.add("+3");
       //Derivative de= new Derivative(derivative);
        //GeometryCalc  gc= new GeometryCalc("3", "6");
        //basicCalculations bc= new basicCalculations(numbers);
        //System.out.println(bc.caculateOfNumbers());
       // System.out.println(gc.missingLength(true));
        //System.out.println(gc.areaCircle());
        //de.quotientRule(derivative, derivative);
        //de.reoderPoly(derivative);
       //de.simplifyPoly( derivative));
        //Derivative bd= new Derivative(derivative);
       //System.out.println( bd.slopeWithDerivative("2"));
       //firstDerivative bd= new Derivative(derivative);
       //System.out.println( );
        //System.out.println( );
       // System.out.println(de.powerRule(derivative));
        //de.productRule(derivative, derivative);


    }
}
