import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class GeometryDisplay extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4;
    String operation= "";
    JButton btnResult, btnLength;
    JTextField txtField1, txtField2, txtField3,  txtField4;
    public GeometryDisplay(String operation){
        this.operation= operation;
        setLayout(new GridLayout(10,10));
        setTitle("Geometry calculator");
        if (operation.equals("  Circle")){
            label1 = new JLabel("   Area of Circle:πr^2, Circumference of circle: 2πr");
            label2 = new JLabel("   radius: :", JLabel.LEFT);
            label3 = new JLabel("   Result :", JLabel.LEFT);
            btnResult = new JButton("Area");
            btnLength= new JButton("Circumference");
            btnResult.addActionListener(this);
            btnLength.addActionListener(this);
            txtField1 = new JTextField();
            txtField2 = new JTextField();
            add(label1);
            add(label2);
            add(txtField1);
            add(label3);
            add(txtField2);
            add(btnResult);
            add(btnLength);

        }
        if (operation.equals("rectangle")){
            label1 = new JLabel("Area of rectangle: b*h ");
            label2 = new JLabel("base:", JLabel.LEFT);
            label4 = new JLabel("height:", JLabel.LEFT);
            label3 = new JLabel("Result :", JLabel.LEFT);
            btnResult = new JButton("Area");
            btnResult.addActionListener(this);
            txtField1 = new JTextField();
            txtField2 = new JTextField();
            txtField3 = new JTextField();
            add(label1);
            add(label2);
            add(txtField1);
            add(label4);
            add(txtField3);
            add(btnResult);
            add(label3);
            add(txtField2);
        }
        if (operation.equals("triangle")){
            label1 = new JLabel("Area of triangle: (b*h)/2 ");
            label2 = new JLabel("base:", JLabel.LEFT);
            label4 = new JLabel("height:", JLabel.LEFT);
            label3 = new JLabel("Result :", JLabel.LEFT);
            btnResult = new JButton("Area");
            btnResult.addActionListener(this);
            txtField1 = new JTextField();
            txtField2 = new JTextField();
            txtField3 = new JTextField();
            add(label1);
            add(label2);
            add(txtField1);
            add(label4);
            add(txtField3);
            add(btnResult);
            add(label3);
            add(txtField2);
        }

        if (operation.equals("square")){
            label1 = new JLabel("Area of square: s^2 ");
            label2 = new JLabel("side :", JLabel.LEFT);
            label3 = new JLabel("Result :", JLabel.LEFT);
            btnResult = new JButton("Area");
            btnResult.addActionListener(this);
            txtField1 = new JTextField();
            txtField2 = new JTextField();
            add(label1);
            add(label2);
            add(txtField1);
            add(label3);
            add(txtField2);
            add(btnResult);
        }
        if (operation.equals("Pythagorean Theorem")){
            label1 = new JLabel("Pythagorean Theorem: a^2+ b^2= hypotense ");
            label2 = new JLabel("length1 :", JLabel.LEFT);
            label4 = new JLabel("length2 :", JLabel.LEFT);
            label3 = new JLabel("Result :", JLabel.LEFT);
            btnResult = new JButton("Find hypotense");
            btnLength= new JButton("Find length");
            btnResult.addActionListener(this);
            btnLength.addActionListener(this);
            txtField1 = new JTextField();
            txtField2 = new JTextField();
            txtField3 = new JTextField();
            add(label1);
            add(label2);
            add(txtField1);
            add(label4);
            add(txtField3);
            add(label3);
            add(txtField2);
            add(btnResult);
            add(btnLength);

        }
        if (operation.equals("interior angles")){
            label1 = new JLabel("interior angles 180(side-2): ");
            label2 = new JLabel("Polygon Sides:", JLabel.LEFT);
            label3 = new JLabel("Result :", JLabel.LEFT);
            btnResult = new JButton("Total Angle");
            btnResult.addActionListener(this);
            txtField1 = new JTextField();
            txtField2 = new JTextField();
            add(label1);
            add(label2);
            add(txtField1);
            add(label3);
            add(txtField2);
            add(btnResult);
        }

    }
    public void actionPerformed(ActionEvent e) {
        String result = "";
        if (operation.equals("  Circle")) {
            if (e.getActionCommand().equals("Area")) {
                GeometryCalc gc = new GeometryCalc(txtField1.getText(), txtField1.getText());
                result = gc.areaCircle();
            }
            if (e.getActionCommand().equals("Circumference")) {
                GeometryCalc gc = new GeometryCalc(txtField1.getText(), "0");
                result = gc.circumferenceCircle();
            }
        }
        if (operation.equals("rectangle")){
            if (e.getActionCommand().equals("Area")) {
                GeometryCalc gc = new GeometryCalc(txtField1.getText(), txtField3.getText());
                result = gc.areaRectangle();
            }
    }
        if (operation.equals("square")){
            if (e.getActionCommand().equals("Area")) {
                GeometryCalc gc = new GeometryCalc(txtField1.getText(), txtField1.getText());
                result = gc.areaRectangle();
            }
        }
        if (operation.equals("interior angles")){
            if (e.getActionCommand().equals("Total Angle")) {
                GeometryCalc gc = new GeometryCalc(txtField1.getText(), "0");
                result = ""+gc.interiorAnglesOfPolygon()+ " degrees";
            }
        }
        if (operation.equals("triangle")){
            if (e.getActionCommand().equals("Area")) {
                GeometryCalc gc = new GeometryCalc(txtField1.getText(), txtField3.getText());
                result = gc.areaTriangle();
            }
        }
        if (operation.equals("Pythagorean Theorem")){
            if (e.getActionCommand().equals("Find hypotense")) {
                GeometryCalc gc = new GeometryCalc(txtField1.getText(), txtField3.getText());
                result = gc.missingLength(true);
            }
            if (e.getActionCommand().equals("Find length")) {
                GeometryCalc gc = new GeometryCalc(txtField1.getText(), txtField3.getText());
                result = gc.missingLength(false);
            }

        }
        txtField2.setText(result);

    }
}
