
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
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

            try {
                // Validate input
                ParticipantInfo.main(firstName, lastName);

                // Create participant
                ParticipantInfo participant = new ParticipantInfo(firstName, lastName, hours, minutes);

                // Add participant to list
                list.add(participant);
                Collections.sort(list, Comparator.comparingInt(ParticipantInfo::getAppointmentTime));

                // Update UI
                logField.append("Thank you, you were added." + "\n");
                participantField.append(participant.getFullName() + " reservation at " + hours + ":" + minutes + "\n");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(addParticipantButton, "ERROR: this is not a valid name.");
            }
        });

        clear_btn.addActionListener(e -> {
            insertFn.setText("");
            insertLn.setText("");
            input_hours.setValue(0);
            input_minutes.setValue(0);
        });

        // Set the limits for the input_hours spinner
        SpinnerNumberModel hoursModel = new SpinnerNumberModel(0, 0, 23, 1);
        input_hours.setModel(hoursModel);
        input_hours.setPreferredSize(new Dimension(250, 20));
        input_hours.setMinimumSize(new Dimension(250, 20));

        // Set the limits for the input_minutes spinner
        SpinnerNumberModel minutesModel = new SpinnerNumberModel(0, 0, 59, 1);
        input_minutes.setModel(minutesModel);
        input_minutes.setPreferredSize(new Dimension(300, 20));
        input_minutes.setMinimumSize(new Dimension(300, 20));

        addParticipantButton.setPreferredSize(new Dimension (250, 30));
        addParticipantButton.setMinimumSize(new Dimension (250, 30));



    }

}