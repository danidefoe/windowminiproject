import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProjectJava extends JFrame {
    private JPanel mainPanel;
    private JSpinner input_hours;
    private JTextField insertFn;
    private JTextField insertLn;
    private JSpinner input_minutes;
    private JList ListP;
    private JButton clear_btn;
    private JButton addParticipantButton;
    private JLabel tfFirstName;
    private JLabel timeslot;
    private JLabel timeslotMin;
    private JLabel tfLastName;
    private JTextArea logField;
    private JTextArea participantField;

    public static void main(String[] args) { // welkom bericht in the top
        ProjectJava PJ = new ProjectJava();
        PJ.setContentPane(PJ.mainPanel);
        PJ.setTitle("Welcome");
        PJ.setSize(750, 500);
        PJ.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PJ.setVisible(true);
    }

    public ProjectJava() {
        // new array
        ArrayList<ParticipantInfo> list = new ArrayList<>();

        /*((AbstractDocument) insertFn.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final String regex = "^[a-zA-Z\\s\\-ëäöïü]{0,50}$";

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (proposedText.matches(regex)) {
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }

        });

        ((AbstractDocument) insertLN.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final String regex = "^[a-zA-Z\\s\\-ëäöïü]{0,50}$";

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (proposedText.matches(regex)) {
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });*/

        // Add action listener to addParticipantButton
        addParticipantButton.addActionListener(e -> {

            // Read inputs
            String firstName = insertFn.getText();
            String lastName = insertLn.getText();
            int hours = (int) input_hours.getValue();
            int minutes = (int) input_minutes.getValue();

            logField.append("Hoi");

            /*if (firstName.isEmpty() || lastName.isEmpty() || hours < 0 || minutes < 0) {
                JOptionPane.showMessageDialog(mainPanel, "Please fill in all fields with valid values.");
                return;
            }*/

            ParticipantInfo P = new ParticipantInfo(firstName, lastName, hours, minutes);
            System.out.println(P);

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

