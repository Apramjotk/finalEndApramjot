import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;


public class Derivative {



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

    public void reoderPoly(ArrayList<String> equation) {
        reorderADD1(equation);
        int max = 0;
        int min = -1;
        ArrayList<String> simplifiedPoly = new ArrayList<String>();
        ArrayList<String> newSimplifiedPoly = new ArrayList<String>();
        ArrayList<String> reorder = new ArrayList<String>();
        int length = equation.size();
        for (int i = 0; i < equation.size() - 1; i++) {
            if (equation.get(i).indexOf("^") != -1 ) {
                simplifiedPoly.add(equation.get(i).substring(equation.get(i).indexOf("^") + 1));
            } else {
                simplifiedPoly.add(0 + "");
            }
            Collections.sort(simplifiedPoly);
        }
        for (int i = simplifiedPoly.size() - 1; i >= 0; i--) {
            newSimplifiedPoly.add(simplifiedPoly.get(i));
        }
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(newSimplifiedPoly);

        ArrayList<String> listWithoutDuplicates = new ArrayList<String>(hashSet);
        System.out.println("Max" + listWithoutDuplicates);

       for (int b = 0; b <listWithoutDuplicates.size(); b++) {
           for (int i = 0; i <equation.size(); i++) {
               if (equation.get(i).indexOf("^") != -1 && Integer.parseInt(equation.get(i).substring(equation.get(i).indexOf("^") + 1)) == Integer.parseInt(newSimplifiedPoly.get(b))) {
                   reorder.add(b, equation.get(i));
               }

           }
       }
        System.out.println(reorder);
    }

        /*int index=0;
        int sIndex=0;
        for (int i=0; i< equation.size()-1; i++) {
            if (Integer.parseInt(equation.get(i).substring(equation.get(i).indexOf("^")+1))==max){
                simplifiedPoly.add(index,equation.get(i));
                equation.remove(i);
                i--;
            }
            if (Integer.parseInt(equation.get(i).substring(equation.get(i).indexOf("^")+1))>min){
                simplifiedPoly.add(index,equation.get(i));
            }
        }*/


    public void simplifyPoly(ArrayList<String> equation){
        reorderADD1(equation);
        boolean sameExpoonent= false;
        ArrayList<String> simplifiedPoly= new ArrayList<String>();
        int equalCoefficent=0;

        for (int i=0; i< equation.size(); i++){
            for (int g=i+1; g< equation.size(); g++){

                if (equation.get(i).indexOf("^")==-1 && equation.get(g).indexOf("^")==-1){
                    sameExpoonent= true;
                    equalCoefficent= Integer.parseInt(equation.get(i))+ Integer.parseInt(equation.get(g));
                    simplifiedPoly.add(""+ equalCoefficent);


                }

               if(Integer.parseInt(equation.get(i).substring(equation.get(i).indexOf("^")+1))==Integer.parseInt(equation.get(g).substring(equation.get(g).indexOf("^")+1))){

                  sameExpoonent= true;
                    equalCoefficent+= Integer.parseInt(equation.get(g).substring(0,equation.get(g).indexOf("x")));
                    simplifiedPoly.add(equalCoefficent+ "x^"+equation.get(i).substring(equation.get(i).indexOf("^")+1 ));
                }


                }



            }
        System.out.println("Simplied:"+ simplifiedPoly);

    }
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
                System.out.println(coefficent);
                int exponent = equation.get(i).indexOf("^");
                System.out.println(exponent);
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
                        System.out.println(coefficent);
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

            System.out.println(derivativeForm);
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

        public void productRule(ArrayList<String> fEquation,ArrayList<String> gEquation ){
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
            System.out.println(removePowerTo1(productRule));
           }
           public void quotientRule(ArrayList<String> fEquation,ArrayList<String> gEquation){


           }

        }





