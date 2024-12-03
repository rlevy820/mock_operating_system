import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DocumentsApp extends JFrame implements ActionListener {
    // JFrame component variables
    private JPanel panel;
    private JTextArea textArea;
    private JTextField textField;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private JMenu file, edit;
    private JMenuItem saveAndQuit;

    // other variables
    private int width = 300;
    private int height = 400;
    private ArrayList<String> docTitleList, docBodyList, docLocationList;
    private int counter; // counter is used to find which title/body correspond to which document
    private ArrayList<String> foldersFromDesktop;

    public DocumentsApp(ArrayList<String> foldersList) {
        counter = 0;
        foldersFromDesktop = new ArrayList<String>();
        foldersFromDesktop.addAll(foldersList); // getting access from the folders created in the desktop
        createFrame(width, height);
        addComponents();
    }

    private void createFrame(int w, int h) {
        setSize(w, h); // setting frame size
        setResizable(false); // setting frame to not be resizable
        setLocationRelativeTo(null); // setting frame location to center
        setTitle("Desktop"); // setting frame title
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // setting frame close operation: do NOT terminate program on close, just close document app frame
    }

    public void openFrame() {
        setVisible(true);
    }

    private void addComponents() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // panel layout
        createDocComponents(); // creating doc components
        // adding components to panel
        panel.add(menuBar);
        panel.add(textField);
        panel.add(scrollPane);

        add(panel); // adding panel to frame
    }

    private void createDocComponents() {
        // components
        textField = new JTextField(10); // setting title to 10 columns
        textArea = new JTextArea(19, 20); // setting text area size
        scrollPane = new JScrollPane(textArea); // adding the text area to scroll pane

        // arrays
        docTitleList = new ArrayList<String>();
        docBodyList = new ArrayList<String>();
        docLocationList = new ArrayList<String>();

        // text area settings
        textArea.setMargin(new Insets(10, 10, 10, 10)); // setting the text area margin
        textArea.setLineWrap(true); // automatically goes to the next line when reach the edge
        textArea.setWrapStyleWord(true); // if reach the end, it moves the whole word to the new line

        // menu bar
        menuBar = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        saveAndQuit = new JMenuItem("Save & Quit");

        // adding action listeners
        saveAndQuit.addActionListener(this);

        // creating menu structure: narrow -> broad
        file.add(saveAndQuit);
        menuBar.add(file);
        menuBar.add(edit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if(s.equals("Save & Quit")) {
            String title = textField.getText(); // get title
            String body = textArea.getText(); // get body

            docTitleList.add(title); // add title to array list
            docBodyList.add(body); // add body to array list
            counter++; // increase counter

            dispose(); // close frame (document)
        }
    }

    // GETTERS AND SETTERS
    public ArrayList<String> getDocTitleList() {
        return docTitleList;
    }
    public ArrayList<String> getDocBodyList() {
        return docBodyList;
    }
    public int getCounter() {
        return counter;
    }
    public void setTextField(String t) {
        textField.setText(t);
    }
    public void setTextArea(String b) {
        textArea.setText(b);
    }
    public void setDocumentEditable(boolean b) {
        textField.setEditable(b);
        textArea.setEditable(b);
    }
}
