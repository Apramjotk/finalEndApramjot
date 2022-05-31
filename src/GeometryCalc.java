import java.util.ArrayList;

public class GeometryCalc {
    private String length1;
    private String length2;
    private boolean isDoubleFormat;

    public GeometryCalc(String length1, String length2){
        this.length1=length1;
        this.length2= length2;


    }

    public String missingLength( boolean isMissingHypotense){
        double missingL=0;
         String missingLength="";
        if (isMissingHypotense){

                missingL= Math.sqrt( (Double.parseDouble(length1) * Double.parseDouble(length1)) + (Double.parseDouble(length2)* Double.parseDouble(length2)));
                missingLength+= "The hypotense is: "+  missingL;

        }
        else{
                missingL= Math.sqrt( Math.abs(Double.parseDouble(length1) * Double.parseDouble(length1) - (Double.parseDouble(length2)* Double.parseDouble(length2))));
                missingLength+= "The missing length is: "+  missingL;

        }
        return missingLength;
    }

    public String areaTriangle(){
        String area=  "";

            area+=  ((Double.parseDouble(length1)*Double.parseDouble(length2))/2);



        return area;
    }
    public String areaRectangle(){
        String area="";
        area+= ((Integer.parseInt(length1)*Integer.parseInt(length2)));
        return area;
    }

    public String areaCircle(){
        String area="";
        area+= ((Integer.parseInt(length1)*Integer.parseInt(length2)))+ "π";
        return area;
    }

    public String circumferenceCircle(){
        String circumference="";
        circumference+= ((Integer.parseInt(length1))*2)+ "π";
        return circumference;
    }

    public int interiorAnglesOfPolygon(){
        int sides= Integer.parseInt(length1);
        return 180*(sides-2);
    }


}
