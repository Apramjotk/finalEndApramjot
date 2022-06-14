import java.util.ArrayList;
import java.util.Collections;

public class BasicCalculationsCalc {
    private ArrayList<String> numbers= new ArrayList<>();
    boolean anyDoubles;


    public BasicCalculationsCalc(ArrayList<String>userNumbers)
    {
        numbers= userNumbers;
        for (int i=0; i<numbers.size(); i++){
            if (numbers.get(i).indexOf(".")!=-1){
                anyDoubles= true;
                break;
            }
            else{
                anyDoubles= false;

            }

        }
    }

    public String totalSumNumbers()
    {
        int wholeSum=0;
        String totalAddition= "";
        boolean displayAsDoubles= false;
        double totalSum=0;
        for (int i=0; i<numbers.size(); i++){
            if (anyDoubles){
                totalSum+=Double.parseDouble(numbers.get(i));
                displayAsDoubles= true;
            }
            else{
                wholeSum+= Integer.parseInt(numbers.get(i));
                displayAsDoubles= false;
            }

        }
        if (displayAsDoubles== true){
            totalAddition+= totalSum;
        }
        else{
            totalAddition+= "\n "+wholeSum;
        }
        return totalAddition;
    }

    public String totalDifferencNumbers()
    {
        int wholeDifference=0;
        String totalAddition= "Total Difference is: ";
        boolean displayAsDoubles= false;
        double totalDifference=Double.parseDouble(numbers.get(0));
        for (int i=1; i<numbers.size(); i++)
        {

                totalDifference-=Double.parseDouble(numbers.get(i));
                displayAsDoubles= true;

        }

            totalAddition+="\n "+ totalDifference;

        return totalAddition;
    }

    public String mutiplyNumbers()
    {
        String totalMutiplication = "Total Multipication is: ";
        double totalMutiply = Double.parseDouble(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++)
        {

                totalMutiply *= Double.parseDouble(numbers.get(i));

        }

            totalMutiplication+= "\n "+ totalMutiply;

        return totalMutiplication;
    }

    public String divideNumbers()
    {
        String totalDivision= "Total Division is: ";

        double totalDivide=Double.parseDouble(numbers.get(0));
        for (int i=1; i<numbers.size(); i++)
        {

            totalDivide/=Double.parseDouble(numbers.get(i));


        }
        totalDivision+= "\n "+totalDivide;
        return totalDivision;
    }

    public double meanOfNumbers()
    {
        int length= numbers.size();
        return Double.parseDouble(totalSumNumbers())/ length;
    }

    public String modeOfNumbers()
    {
        String mode= "";
        double maxValue=(Double.parseDouble(numbers.get(0)));
        double maxCount=0;

        for (int i=0; i<numbers.size(); i++) {
            int count=0;
            for (int j=0; j<numbers.size(); j++)
            {
              if (Double.parseDouble(numbers.get(i))==Double.parseDouble(numbers.get(j)) )
              {
                  count++;
              }
            }
            if (count>maxCount)
            {
                 maxCount= count;
                 maxValue= Double.parseDouble(numbers.get(i));
            }

        }
        if (maxValue==0){
            mode= "There is no number that shows up the most";
        }
        else{
            mode= "The mode is: "+ maxValue;
        }
        return mode;
    }

    public String rangeOfNumbers(){
       Collections.sort(numbers);

        String range="";
        double max=Double.parseDouble(numbers.get(0));;
        double min=Double.parseDouble(numbers.get(0));
        for (int i=0; i<numbers.size(); i++) {
              if (max<Double.parseDouble(numbers.get(i))) {
                  max= Double.parseDouble(numbers.get(i));
            }
            if (min>Double.parseDouble(numbers.get(i))) {
                min= Double.parseDouble(numbers.get(i));
            }
        }

       range= "Max is:"+ max + ", Min is "+ min;
        return range;
    }


}

