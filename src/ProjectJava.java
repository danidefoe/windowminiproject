import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

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

        clear_btn.addActionListener(e -> {
            insertFn.setText("");
            insertLN.setText("");
            input_hours.setValue(input_hours.getMinimumSize());
            input_minutes.setValue(input_minutes.getMinimumSize());
        });

        ((AbstractDocument) insertFn.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final String regex = "^[a-zA-Z\\s\\-ëäöïü]{0,50}$";

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String beforeText = currentText.substring(0, offset);
                String afterText = currentText.substring(offset + length, currentText.length());
                String proposedText = beforeText + text + afterText;
                if (proposedText.matches(regex)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        ((AbstractDocument) insertLN.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final String regex = "^[a-zA-Z\\s\\-ëäöïü]{0,50}$";

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String beforeText = currentText.substring(0, offset);
                String afterText = currentText.substring(offset + length, currentText.length());
                String proposedText = beforeText + text + afterText;
                if (proposedText.matches(regex)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        // Add action listener to addParticipantButton
        addParticipantButton.addActionListener(e -> {
            saveParticipantInfo();
        });
    }

    private void saveParticipantInfo() {
        String firstName = insertFn.getText();
        String lastName = insertLN.getText();
        int hours = (int) input_hours.getValue();
        int minutes = (int) input_minutes.getValue();

        String participantName = firstName + " " + lastName;  // define the participantsName

        // Check if all fields are filled in
        if (!firstName.isEmpty() && !lastName.isEmpty() && hours >= 0 && minutes >= 0) {
            // Add participant's name to colpanel1
            JLabel nameLabel = new JLabel(participantName);
            colpanel1.add(nameLabel);

            // Save the participant info
            String message = "Thank you! You were added as a participant.";
            // Display the participant name and message on colpanel1
            JLabel participantLabel = new JLabel(participantName + " - " + message);
            colpanel1.add(participantLabel);

            // Display a message that the participant was added
            JLabel messageLabel = new JLabel("Participant added: " + participantName);
            colpanel1.add(messageLabel);

            // Clear the input fields
            insertFn.setText("");
            insertLN.setText("");
            input_hours.setValue(0);
            input_minutes.setValue(0);

            // Refresh the panel to show the new participant and message
            colpanel1.revalidate();
            colpanel1.repaint();
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Please fill in all fields.");
            return;
        }
    }

}
