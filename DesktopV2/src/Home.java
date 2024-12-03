import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Home extends JFrame implements ActionListener {
    // JFrame components
    private JPanel homePanel;
    private JMenuBar homeMenuBar;
    private JMenu homeFile, homeApps;
    private JMenu homeFileNew, homeFileOpen;
    private JMenuItem homeFileNewFolder, homeOpenLoad, homeAppsDocuments, homeAppsDraw;
    JMenu folderMenuItem; // variable to add new folders to the file -> open tab
    JMenuItem documentMenuItem; // variable to add new documents to the file -> open tab


    // other variables
    private int width = 400; // frame width
    private int height = 300; // frame height
    ArrayList<String> folders = new ArrayList<String>(); // folders listed by name

    // apps
    DocumentsApp documentsApp;
    DrawApp drawApp;
    CalculatorApp calculatorApp;

    public Home() {
        createFrame(width, height); // creating frame
        createHomeComponents();

        documentsApp = new DocumentsApp(folders);
        drawApp = new DrawApp();
        calculatorApp = new CalculatorApp();


        openFrame(); // must be last after all components are added or it wont show the components
    }

    private void createFrame(int w, int h) {
        setSize(w, h); // setting frame size
        setResizable(false); // setting frame to not be resizable
        setLocationRelativeTo(null); // setting frame location to center
        setTitle("Desktop"); // setting frame title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setting frame close operation: terminate program on close
    }

    private void openFrame() {
        setVisible(true); // set frame visible
    }

    private void createHomeComponents() {
        // initializing components
        homePanel = new JPanel();
        homeMenuBar = new JMenuBar();
        homeFile = new JMenu("File");
        homeApps = new JMenu("Apps");
        homeFileNew = new JMenu("New");
        homeFileOpen = new JMenu("Open");
        homeFileNewFolder = new JMenuItem("Folder");
        homeOpenLoad = new JMenuItem("Load");
        homeAppsDocuments = new JMenuItem("Documents");
        homeAppsDraw = new JMenuItem("Draw");

        // creating menu structure: narrow -> broad
        homeFileNew.add(homeFileNewFolder);
        homeFileOpen.add(homeOpenLoad);
        homeFile.add(homeFileNew);
        homeFile.add(homeFileOpen);
        homeApps.add(homeAppsDocuments);
        homeApps.add(homeAppsDraw);
        homeMenuBar.add(homeFile);
        homeMenuBar.add(homeApps);
        homePanel.add(homeMenuBar);

        add(homePanel); // adding panel to frame

        // adding action listeners to menu items
        homeFileNewFolder.addActionListener(this);
        homeOpenLoad.addActionListener(this);
        homeAppsDocuments.addActionListener(this);
        homeAppsDraw.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if(s.equals("Folder")) {
            String folderName = JOptionPane.showInputDialog("Folder Name"); // opens input dialogue to get folder name
            folders.add(folderName); // adding folder name to folders array list

        }
        if(s.equals("Load")) {
            homeFileOpen.removeAll(); // clear desktop items to not have duplicates
            homeFileOpen.add((homeOpenLoad)); // add load menu item
            for(String folderTitle : folders) { // for each folder title in folders array list
                folderMenuItem = new JMenu(folderTitle); // create new menu item
                folderMenuItem.addActionListener(this); // add action listener to menu item
                homeFileOpen.add(folderMenuItem); // add menu item to file -> open
            }
            for(String docTitle : documentsApp.getDocTitleList()) { // for each doc title
                documentMenuItem = new JMenuItem(docTitle); // create new menu item
                documentMenuItem.addActionListener(this); // add action listener to menu item
                homeFileOpen.add(documentMenuItem); // add menu item to file -> open
            }
        }
        for(String title : documentsApp.getDocTitleList()) { // checking if opened a document
            if(s.equals(title)) { // if s equals a title in the doc titles list
                int count = documentsApp.getDocTitleList().indexOf(title); // finding index of variables associated with doc
                documentsApp.setTextField(documentsApp.getDocTitleList().get(count)); // setting doc title
                documentsApp.setTextArea(documentsApp.getDocBodyList().get(count)); // setting doc body
                documentsApp.setDocumentEditable(false);
                documentsApp.openFrame();
            }
        }
        if(s.equals("Documents")) {
            // clear doc
            documentsApp.setTextField("");
            documentsApp.setTextArea("");
            documentsApp.setDocumentEditable(true);
            documentsApp.openFrame();
        }
        if(s.equals("Draw")) {
            drawApp.runDrawApp();
        }
    }
}











