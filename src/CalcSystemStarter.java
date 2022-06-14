import javax.swing.JFrame;

public class CalcSystemStarter {
    public static void main(String[] args) {
        CalcOptionsDisplay de= new CalcOptionsDisplay();
        de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        de.setVisible(true);
        de.setSize(1600,800);


    }
}
