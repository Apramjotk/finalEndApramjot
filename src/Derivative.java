import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class Derivative {
    ArrayList<String> equation= new ArrayList<String>();
    public Derivative(ArrayList<String> equation){
        this. equation= equation;
    }
    public String slopeWithDerivative(String xValue){
        firstDerivative first= new firstDerivative(equation);

        return first.slopeWithDerivative(xValue);
    }
    public String tangentLine(String xValue){
        firstDerivative first= new firstDerivative(equation);
        return  first.tangentLine(xValue);
    }

    public ArrayList<String> reorderADD1 (ArrayList<String> equation){
        for (int i=0; i< equation.size(); i++){
          if (equation.get(i).indexOf("^")==-1 && equation.get(i).indexOf("x")!=-1 ){
              if (equation.get(i).indexOf("x")==0) {
                  equation.set(i, "1"+equation.get(i) + "^1");
              }
              else{ equation.set(i, equation.get(i) + "^1");}

          } if (equation.get(i).indexOf("^")==-1 && equation.get(i).indexOf("x")==-1 ){

                    equation.set(i, equation.get(i) + "x^0");
                }

        }

        return equation;
    }

    public String reoderPoly(ArrayList<String> equation2) {
        equation = reorderADD1(equation2);
        System.out.println(equation);
        int max = 0;
        int min = -1;
        ArrayList<String> simplifiedPoly = new ArrayList<String>();
        ArrayList<String> newSimplifiedPoly = new ArrayList<String>();
        ArrayList<String> reorder = new ArrayList<String>();
        ArrayList<String> collection = new ArrayList<String>();

        int length = equation.size();
        for (int i = 0; i < equation.size(); i++) {
            if (equation.get(i).indexOf("^") != -1) {
                simplifiedPoly.add(equation.get(i).substring(equation.get(i).indexOf("^") + 1));
                System.out.println(simplifiedPoly);
            } else {
                simplifiedPoly.add(0 + "");
            }
            Collections.sort(simplifiedPoly);
        }
        for (int i = simplifiedPoly.size() - 1; i >= 0; i--) {
            newSimplifiedPoly.add(simplifiedPoly.get(i));
        }
        System.out.println(newSimplifiedPoly);
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(newSimplifiedPoly);

        ArrayList<String> listWithoutDuplicates = new ArrayList<String>(hashSet);
        System.out.println("Max" + listWithoutDuplicates);

        for (int i = 0; i < newSimplifiedPoly.size(); i++) {
            for (int g = 0; g < equation.size(); g++) {
                if (newSimplifiedPoly.get(i).equals(equation.get(g).substring(equation.get(g).indexOf("^") + 1))) {
                    reorder.add(i, equation.get(g));
                    collection.add(equation.remove(g));
                    g--;


                }

            }


        }
      return  polyForm(removePowerTo1(collection));
    }




    public void simplifyPoly(ArrayList<String> equation){
        //equation=reoderPoly(reorderADD1(equation));
        System.out.println("Hw" +equation);
        boolean sameExpoonent= false;
        ArrayList<String> simplifiedPoly= new ArrayList<String>();
        int equalCoefficent=0;
        int x=0;
       int totalSum=0;


                   // System.out.println("Hello2 " + equalCoefficent);

                   // equalCoefficent+= Integer.parseInt(equation.get(g).substring(0, equation.get(g).indexOf("x")));
                    //System.out.println("Hello" + Integer.parseInt(equation.get(g).substring(0, equation.get(g).indexOf("x"))));
                    //equation.remove(g);
                   // g--;


                }

                    //simplifiedPoly.add(equalCoefficent + "x^" + equation.get(i).substring(equation.get(i).indexOf("^") + 1));







            //System.out.println(firstTermCofficent);




    public ArrayList<String> removePowerTo1(ArrayList<String> equation) {
        for (int i = 0; i < equation.size(); i++) {
            if (equation.get(i).indexOf("x^0")!=-1){
                equation.set(i,equation.get(i).substring(0,equation.get(i).indexOf("x^0") ) );
            }
            if (equation.get(i).indexOf("x^1")!=-1){
                equation.set(i,equation.get(i).substring(0,equation.get(i).indexOf("x")+1 ) );
            }
        }
        return equation;
    }


    public ArrayList<String> powerRule(ArrayList<String> equation) {
        ArrayList<String> firstderivative = new ArrayList<String>();
            for (int i = 0; i < equation.size(); i++) {
                int coefficent = equation.get(i).indexOf("x");

                int exponent = equation.get(i).indexOf("^");
                if (exponent == -1 || Integer.parseInt(equation.get(i).substring(exponent + 1)) == 1) {
                    if (coefficent == 0) {
                        firstderivative.add("1");
                    } else if (coefficent == -1) {
                        break;
                    } else {
                        firstderivative.add(equation.get(i).substring(0, coefficent));
                    }
                } else if (coefficent == -1) {
                    firstderivative.add("0");
                } else {

                    if (coefficent != 0) {
                        coefficent = Integer.parseInt(equation.get(i).substring(0, coefficent));

                    } else {
                        coefficent = 1;
                    }
                    exponent = Integer.parseInt(equation.get(i).substring(exponent + 1));
                    int newCoefficent = coefficent * exponent;
                    int newExponent = exponent - 1;
                    if (newExponent != 1) {
                        firstderivative.add(newCoefficent + "x^" + newExponent);
                    } else {
                        firstderivative.add(newCoefficent + "x");
                    }

                }

            }
            String derivativeForm= "";
            for(int i=0; i<firstderivative.size(); i++ ){
                if (i==0){
                    derivativeForm= firstderivative.get(i);
                }
                else if (firstderivative.get(i).indexOf("-")!=-1){
                    derivativeForm+= " "+firstderivative.get(i);
                }
                else {
                    derivativeForm+= " + " + firstderivative.get(i);
                }

            }


            return firstderivative;
        }
        public ArrayList<String> factor(ArrayList<String> fEquation,ArrayList<String> gEquation){
            int cofficent=0;
            int secondCoeficent=0;
            int exponent=0;
            int sExponent=0;
            ArrayList<String>  distributePoly = new ArrayList<String>();
            for (int i=0; i< fEquation.size(); i++){
                for (int g=0; g< gEquation.size(); g++){

                    cofficent = Integer.parseInt(fEquation.get(i).substring(0, fEquation.get(i).indexOf("x")));
                    // System.out.println("1.   " + cofficent);
                    secondCoeficent = Integer.parseInt(gEquation.get(g).substring(0, gEquation.get(g).indexOf("x")));
                    // System.out.println("2.   " + secondCoeficent);
                    exponent = Integer.parseInt(fEquation.get(i).substring(fEquation.get(i).indexOf("^") + 1));
                    //  System.out.println("3..   " + exponent);
                    sExponent = Integer.parseInt(gEquation.get(g).substring(gEquation.get(g).indexOf("^") + 1));
                    // System.out.println("4.   " + sExponent);


                    if (fEquation.get(i).indexOf("x")==0){
                        cofficent= 1;
                    }
                    if (gEquation.get(g).indexOf("x")==0){
                        secondCoeficent=1;
                    }
                    int exponentVal= exponent+sExponent;

                    distributePoly.add(cofficent* secondCoeficent+ "x^"+ exponentVal );

                }
            }
            return distributePoly;
        }

        public ArrayList<String> productRule(ArrayList<String> fEquation, ArrayList<String> gEquation ){
            ArrayList<String> firstderivative = new ArrayList<String>();
            ArrayList<String>  secondDerivative = new ArrayList<String>();
            ArrayList<String>  firstProductRule = new ArrayList<String>();
            ArrayList<String>  productRule = new ArrayList<String>();
            ArrayList<String>  secondProductRule = new ArrayList<String>();
              firstderivative = reorderADD1(powerRule(fEquation));
               secondDerivative= reorderADD1(powerRule(gEquation));
               gEquation= reorderADD1(gEquation);
               fEquation= reorderADD1(fEquation);
               firstProductRule= factor(firstderivative,gEquation);
               secondProductRule=factor(secondDerivative, fEquation);
               for (int i=0; i< firstProductRule.size(); i++){
                   productRule.add(firstProductRule.get(i));
               }
            for (int i=0; i< secondProductRule.size(); i++){
                productRule.add(secondProductRule.get(i));
            }
             return productRule;
           }
           public String polyForm (ArrayList<String> polynominal){
                String polyForm="";
                removePowerTo1(polynominal);
              for (int i=0; i< polynominal.size(); i++){
                  if ( i==0){
                      polyForm= polynominal.get(i);
                  }
                  else {
                      polyForm += " + " + polynominal.get(i);
                  }
              }
              return polyForm;
           }
           public String quotientRule(ArrayList<String> fEquation,ArrayList<String> gEquation){
               ArrayList<String> firstderivative = new ArrayList<String>();
               ArrayList<String>  secondDerivative = new ArrayList<String>();
               firstderivative = reorderADD1(powerRule(fEquation));
               secondDerivative= reorderADD1(powerRule(gEquation));
               gEquation= reorderADD1(gEquation);
               fEquation= reorderADD1(fEquation);
               ArrayList<String>  firstQuotientRule = new ArrayList<String>();
               ArrayList<String> quotientRule = new ArrayList<String>();
               ArrayList<String>  secondQuotientRule = new ArrayList<String>();
               firstQuotientRule=factor(firstderivative,gEquation);
               secondQuotientRule=factor(secondDerivative, fEquation);
               for (int i=0; i< firstQuotientRule.size(); i++){

                   quotientRule.add( firstQuotientRule.get(i));
               }

               quotientRule.add("-"+secondQuotientRule.get(0));
               for (int i=1; i< secondQuotientRule.size(); i++){

                       quotientRule.add(secondQuotientRule.get(i));


               }
              return "("+polyForm(removePowerTo1(quotientRule))+") /"+" ("+ polyForm(removePowerTo1(gEquation))+ ")^2";

           }

        }





