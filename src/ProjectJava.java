import javax.swing.*;

public class ProjectJava extends JFrame {
    private JPanel mainPanel;
    // JLabel tfFirstName; // define as field
    // JLabel timeslotMin; // minutes
    private JSpinner input_hours;
    private JTextField insertFn;
    private JTextField insertLN;
    private JSpinner input_minutes;
    private JButton clear_btn;
    private JButton addParticipantButton;
    private JLabel tfFirstName;
    private JLabel timeslot;
    private JLabel timeslotMin;
    private JLabel tfLastName;
    private JPanel colpanel1;
    private JPanel mainpanel2;
    private JPanel mainpanel3;
    private JPanel colpanel2;
    // JLabel timeslotHou; // hours

    public static void main(String[] args) {
        //ProjectJava project = new ProjectJava(); // create an instance of ProjectJava
        //project.createUI(); // call a non-static method on the instance
        ProjectJava PJ = new ProjectJava();
     //   PJ.setContentPane(new JPanel());
        PJ.setContentPane(PJ.mainPanel);
        PJ.setTitle("Welcome");
        PJ.setSize(450, 300);
        PJ.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PJ.setVisible(true);
    }

    /*
    public void createUI(){
        JButton addParticipantButton;
        JButton clearButton;
     //   JLabel tfFirstName;
        JLabel tfLastName;
        JTextField insertFn = null;  //moet dit weg
        JTextField insertLn = null;
        JPanel colPanel1;
       // JSpinner hours; // mag uit want wordt beneden gedeclareerd
      //  JSpinner minutes; // mag uit want wordt beneden gedeclareerd
        JPanel colPanel2;

        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // create spinner for hours:
        timeslotHou = new JLabel("Hours: ");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(timeslotHou, c);

        int min = 0;
        int max = 24;
        int step = 1;
        int i = 1;
        SpinnerModel value = new SpinnerNumberModel(i, min, max, step);
        JSpinner hours = new JSpinner(value);
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(hours, c);

        // create spinner for minutes
        timeslotMin = new JLabel("Minutes:  ");
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(timeslotMin, c);

        min = 0;
        max = 59;
        step = 1;
        i = 0;

        value = new SpinnerNumberModel(i, min, max, step);
       JSpinner minutes = new JSpinner(value);
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(minutes, c);

// create buttons and labels

        addParticipantButton = new JButton("Add participant");
        clearButton = new JButton("Clear");
        tfFirstName = new JLabel("First Name: ");
        tfLastName = new JLabel("Last Name: ");
        insertFn = new JTextField(20);
        insertLn = new JTextField(20);

        colPanel1 = new JPanel(new GridLayout(0, 1));
        colPanel1.add(tfFirstName);
        colPanel1.add(insertFn);
        colPanel1.add(tfLastName);
        colPanel1.add(insertLn);

        colPanel2 = new JPanel(new GridLayout(0, 1));
        colPanel2.add(addParticipantButton);
        colPanel2.add(clearButton);

        // add the columns to the main panel
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        mainPanel.add(colPanel1, c);

        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(colPanel2, c);

        JFrame frame = new JFrame("ProjectJava");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    } */
    /// hallo hallo
/*
    public static class ProjectJava2 extends JFrame {

        public ProjectJava2() {
            ProjectJava PJ = new ProjectJava();
            PJ.setContentPane(new JPanel());
            PJ.setTitle("Welcome");
            PJ.setSize(450, 300);
            PJ.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            PJ.setVisible(true);
        }


        public static void main(String[] args) {
            MainFrame myFrame = new MainFrame();
        }

    } */
}


