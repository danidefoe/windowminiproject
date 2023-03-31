import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ProjectJava extends JFrame {
    public JPanel mainPanel;
    private JSpinner input_hours;
    private JSpinner input_minutes;
    private JTextField insertFn;
    private JTextField insertLn;
    private JList List;
    private JButton clear_btn;
    private JButton addParticipantButton;
    private JLabel tfFirstName;
    private JLabel timeslot;
    private JLabel timeslotMin;
    private JLabel tfLastName;
    private JTextArea logField;
    private JTextArea participantField;

    ArrayList<ParticipantInfo> list = new ArrayList<>();

    public static void main(String[] args) { // welkom bericht in the top
        ProjectJava PJ = new ProjectJava();
        PJ.setContentPane(PJ.mainPanel);
        PJ.setTitle("Welcome");
        PJ.setSize(750, 500);
        PJ.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PJ.setVisible(true);

    }
    public ProjectJava() {
        // Add action listener to addParticipantButton
        addParticipantButton.addActionListener(e -> {

            // Read inputs
            String firstName = insertFn.getText();
            String lastName = insertLn.getText();
            String fullName = firstName + " " + lastName;
            int hours = (int) input_hours.getValue();
            int minutes = (int) input_minutes.getValue();

            logField.append("Participant added!");
            participantField.append(fullName + "reservation at" + hours + minutes);
            //ParticipantInfo P = new ParticipantInfo(firstName, lastName, hours, minutes);


            try {
                ParticipantInfo participant = new ParticipantInfo(insertFn.getText(), insertLn.getText(), (int) input_hours.getValue(), (int) input_minutes.getValue());
                list.add(participant);
                Collections.sort(list, Comparator.comparingInt(ParticipantInfo::getAppointmentTime));
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(addParticipantButton, "Name participant not valid!");
            }
        });

        clear_btn.addActionListener(e -> {
            insertFn.setText("");
            insertLn.setText("");
            input_hours.setValue(input_hours.getMinimumSize());
            input_minutes.setValue(input_minutes.getMinimumSize());
        });

        // Set the limits for the input_hours spinner
        SpinnerNumberModel hoursModel = new SpinnerNumberModel(0, 0, 23, 1);
        input_hours.setModel(hoursModel);

        // Set the limits for the input_minutes spinner
        SpinnerNumberModel minutesModel = new SpinnerNumberModel(0, 0, 59, 1);
        input_minutes.setModel(minutesModel);
    }
}