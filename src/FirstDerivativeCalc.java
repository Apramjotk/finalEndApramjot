import java.util.ArrayList;

public class FirstDerivativeCalc extends DerivativeCalc {

    ArrayList<String> equation2= new ArrayList<String>();
    private String xValue;

    public FirstDerivativeCalc(ArrayList<String> equation){

        super(equation);

        equation2=equation;

    }

    public String slopeWithDerivative(String xValue){

        String slope="";
        double slopeValue=0;

        ArrayList<String> derivative= new ArrayList<>();

            derivative=super.reorderADD1(super.powerRule(equation2));


        for (int i=0; i< derivative.size(); i++){
            if (derivative.get(i).indexOf("^0")==-1|| derivative.get(i).indexOf("^1")==-1){
                int coefficent= Integer.parseInt(derivative.get(i).substring(0,derivative.get(i).indexOf("x")));
                int power= Integer.parseInt(derivative.get(i).substring(derivative.get(i).indexOf("^")+1));
                slopeValue+= coefficent*Math.pow(Double.parseDouble(xValue), power);

            }
            else{
               slopeValue+= Integer.parseInt(derivative.get(i).substring(0,derivative.get(i).indexOf("x")));
            }
        }
        return ""+ slopeValue;
    }
    public String tangentLine(String xValue){
        double yValue=0;
        equation2=super.reorderADD1(equation2);
        double slope= Double.parseDouble(slopeWithDerivative(xValue));
        for (int i=0; i<equation2.size(); i++){
            if (equation2.get(i).indexOf("^0")==-1){
                int coefficent= Integer.parseInt(equation2.get(i).substring(0,equation2.get(i).indexOf("x")));
                int power= Integer.parseInt(equation2.get(i).substring(equation2.get(i).indexOf("^")+1));
                yValue+= coefficent*Math.pow(Double.parseDouble(xValue), power);

            }
            else{
                yValue+= Integer.parseInt(equation2.get(i).substring(0,equation2.get(i).indexOf("x")));
            }
        }
        return "(y-"+ yValue +")="+ slope+"(x-"+ xValue+ ")";
    }

}
