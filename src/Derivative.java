import java.util.ArrayList;

public class Derivative {



    public ArrayList<String> reorderADD1 (ArrayList<String> equation){
        for (int i=0; i< equation.size(); i++){
          if (equation.get(i).indexOf("^")==-1 & equation.get(i).indexOf("x")!=-1 ){
              if (equation.get(i).indexOf("x")==0) {
                  equation.set(i, "1"+equation.get(i) + "^1");
              }
              else{ equation.set(i, "1"+equation.get(i) + "^1");}

          }
        }

        return equation;
    }
    public void simplifyPoly(ArrayList<String> equation){
        reorderADD1(equation);
        int equalCoefficent=0;
        for (int i=0; i< equation.size(); i++){
            for (int g=i+1; g< equation.size(); g++){
                if (equation.get(i).indexOf("^")==-1 && equation.get(g).indexOf("^")==-1){
                    equalCoefficent= Integer.parseInt(equation.get(i))+ Integer.parseInt(equation.get(g));


                }
              else if(Integer.parseInt(equation.get(i).substring(equation.get(i).indexOf("^")+1))==Integer.parseInt(equation.get(g).substring(equation.get(g).indexOf("^")+1))){
                    equalCoefficent=Integer.parseInt(equation.get(i).substring(0,equation.get(i).indexOf("x")))+ Integer.parseInt(equation.get(g).substring(0,equation.get(g).indexOf("x")));
                    System.out.println("hello" +equalCoefficent);
                }
                }



            }

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
        public void productRule(ArrayList<String> fEquation,ArrayList<String> gEquation ){
            ArrayList<String> firstderivative = new ArrayList<String>();
            ArrayList<String>  secondDerivative = new ArrayList<String>();
            ArrayList<String>  productDerivative = new ArrayList<String>();
              firstderivative = reorderADD1(powerRule(fEquation));
               secondDerivative= reorderADD1(powerRule(gEquation));
               gEquation= reorderADD1(gEquation);
               fEquation= reorderADD1(fEquation);
            int cofficent=0;
            int secondCoeficent=0;
            int exponent=0;
            int sExponent=0;

              for (int i=0; i< firstderivative.size(); i++){
                  for (int g=0; g< gEquation.size(); g++){
                      if (firstderivative.get(i).indexOf("^")==-1|| gEquation.get(g).indexOf("^")==-1) {
                          if (firstderivative.get(i).length() != 0 && firstderivative.get(i).indexOf("x") == -1) {
                              cofficent = Integer.parseInt(firstderivative.get(i));
                              exponent = 0;
                          }
                          if (gEquation.get(g).length() != 0 && gEquation.get(g).indexOf("x") == -1) {
                              secondCoeficent = Integer.parseInt(gEquation.get(g));
                              System.out.println(cofficent);
                              sExponent = 0;

                          }
                          if (firstderivative.get(i).indexOf("x") != -1){
                              if (firstderivative.get(i).indexOf("x") == 0){
                                  cofficent= 1;
                                  exponent=1;
                              }
                              else{
                                  cofficent= Integer.parseInt(firstderivative.get(i).substring(0, firstderivative.get(i).indexOf("x")));
                                  exponent=1;
                              }
                          }
                          if ( gEquation.get(g).indexOf("x")  != -1){
                              if (gEquation.get(g).indexOf("x")==0){secondCoeficent=1; exponent=1; }
                              else{
                                  secondCoeficent=Integer.parseInt(gEquation.get(g).substring(0, gEquation.get(g).indexOf("x")));
                                  exponent=0;
                              }
                          }
                      }

                 else if (firstderivative.get(i).indexOf("x")!=0 &&  gEquation.get(g).indexOf("x")!=0) {
                          if (firstderivative.get(i).indexOf("x")==-1){
                              cofficent= Integer.parseInt(firstderivative.get(i));
                              exponent=0;
                          }
                          if (gEquation.get(g).indexOf("x")==-1){
                              cofficent= Integer.parseInt(gEquation.get(g));
                              System.out.println(cofficent);
                              sExponent=0;

                          }
                          else {
                              cofficent = Integer.parseInt(firstderivative.get(i).substring(0, firstderivative.get(i).indexOf("x")));
                             // System.out.println("1.   " + cofficent);
                              secondCoeficent = Integer.parseInt(gEquation.get(g).substring(0, gEquation.get(g).indexOf("x")));
                             // System.out.println("2.   " + secondCoeficent);
                              exponent = Integer.parseInt(firstderivative.get(i).substring(firstderivative.get(i).indexOf("^") + 1));
                            //  System.out.println("3..   " + exponent);
                              sExponent = Integer.parseInt(gEquation.get(g).substring(gEquation.get(g).indexOf("^") + 1));
                             // System.out.println("4.   " + sExponent);
                          }
                      }
                      if (firstderivative.get(i).indexOf("x")==0){
                          cofficent= 1;
                      }
                      if (gEquation.get(g).indexOf("x")==0){
                          secondCoeficent=1;
                      }
                      int exponentVal= exponent+sExponent;

                     productDerivative.add(cofficent* secondCoeficent+ "x^"+ exponentVal );
                  }
              }
              System.out.println(productDerivative);
           }

        }





