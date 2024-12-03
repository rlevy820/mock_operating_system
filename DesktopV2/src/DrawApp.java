import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawApp extends JFrame implements ActionListener {
    private ArrayList<DrawAppPolyLine> lines = new ArrayList<DrawAppPolyLine>();
    private DrawAppPolyLine currentLine;
    private JPanel panel;
    private JMenuBar menuBar;
    private JMenu file, size, color;
    private JMenuItem saveAndQuit, s1, s2, s3, red, blue, black;
    private DrawCanvas canvas;
    private Color lineColor;
    private int lineSize;




    public DrawApp() {
        panel = new JPanel();
        menuBar = new JMenuBar();
        file = new JMenu("File");
        size = new JMenu("Size");
        color = new JMenu("Color");
        saveAndQuit = new JMenuItem("Save & Quit");
        s1 = new JMenuItem("Small");
        s2 = new JMenuItem("Medium");
        s3 = new JMenuItem("Large");
        red = new JMenuItem("Red");
        blue = new JMenuItem("Blue");
        black = new JMenuItem("Black");

        saveAndQuit.addActionListener(this);
        s1.addActionListener(this);
        s2.addActionListener(this);
        s3.addActionListener(this);
        red.addActionListener(this);
        blue.addActionListener(this);
        black.addActionListener(this);

        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(400, 300));

        lineColor = Color.BLACK;
        lineSize = 3;


        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // begin new line
                currentLine = new DrawAppPolyLine();
                lines.add(currentLine);
                currentLine.addPoint(e.getX(), e.getY());
            }
        });
        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentLine.addPoint(e.getX(), e.getY());
                repaint(); // invoke paintComponent
            }
        });

        menuBar.add(file);
        menuBar.add(size);
        menuBar.add(color);
        file.add(saveAndQuit);
        size.add(s1);
        size.add(s2);
        size.add(s3);
        color.add(red);
        color.add(blue);
        color.add(black);

        panel.add(menuBar);
        panel.add(canvas);
    }

    private void createFrame() {
        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Drawing App");
        setSize(400, 300); // setting frame size
        setResizable(false); // setting frame to not be resizable
        setLocationRelativeTo(null); // setting frame location to center
        setVisible(true);
    }

    public void runDrawApp() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createFrame();
                new DrawApp();
            }
        });
    }

    private class DrawCanvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(lineColor);
            for(DrawAppPolyLine line : lines) {
                line.draw(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if(s.equals("Save & Quit")) {
            dispose();
        }


        if(s.equals("Red")) {
            lineColor = Color.RED;
        }
        if(s.equals("Blue")) {
            lineColor = Color.BLUE;
        }
        if(s.equals("Black")) {
            lineColor = Color.BLACK;
        }

        if(s.equals("Small")) {
            lineSize = 1;
        }
        if(s.equals("Medium")) {
            lineSize = 3;
        }
        if(s.equals("Large")) {
            lineSize = 6;
        }
    }

    // GETTERS AND SETTERS
    public ArrayList<DrawAppPolyLine> getLines() {
        return lines;
    }
}































