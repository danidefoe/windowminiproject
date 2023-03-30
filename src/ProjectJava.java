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
        ProjectJava PJ = new ProjectJava();
        PJ.setContentPane(PJ.mainPanel);
        PJ.setTitle("Welcome");
        PJ.setSize(450, 300);
        PJ.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PJ.setVisible(true);
    }

    public ProjectJava() {
        // Set the limits for the input_hours spinner
        SpinnerNumberModel hoursModel = new SpinnerNumberModel(0, 0, 23, 1);
        input_hours.setModel(hoursModel);

        // Set the limits for the input_minutes spinner
        SpinnerNumberModel minutesModel = new SpinnerNumberModel(0, 0, 59, 1);
        input_minutes.setModel(minutesModel);

        // Add the rest of your code here
        // ...
    }
}


