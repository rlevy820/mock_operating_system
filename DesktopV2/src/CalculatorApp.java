import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {
    private JPanel panel;
    private GridLayout gridLayout;
    private JTextField textField;
    private JButton clear, posOrNeg, percent, div, mult, sub, add, equal, decimal, zero, one, two, three, four, five, six, seven, eight, nine;

    public CalculatorApp() {
        createFrame();
        createComponents();
        
        openFrame();

    }

    private void createFrame() {
        setSize(300, 400); // setting frame size
        setResizable(false); // setting frame to not be resizable
        setLocationRelativeTo(null); // setting frame location to center
        setLayout(gridLayout);
        setTitle("Desktop"); // setting frame title
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // setting frame close operation: do NOT terminate program on close
    }

    public void openFrame() {
        setVisible(true);
    }

    private void createComponents() {
        panel = new JPanel();
        gridLayout = new GridLayout(5, 5);
        textField = new JTextField();
        clear = new JButton("C");
        posOrNeg = new JButton("+/-");
        percent = new JButton("%");
        div = new JButton("÷");
        mult = new JButton("×");
        sub = new JButton("−");
        add = new JButton("+");
        equal = new JButton("=");
        decimal = new JButton(".");
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
