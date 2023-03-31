import javax.swing.*;

public class ParticipantInfo extends ProjectJava {
    String firstName;
    String lastName;
    String fullName;
    int hours;
    int minutes;



    public ParticipantInfo(String firstName, String lastName, int hours, int minutes) {
          if (firstName.isEmpty() || lastName.isEmpty() || hours < 0 || minutes < 0) {
              JOptionPane.showMessageDialog(mainPanel, "Please fill in all fields with valid values.");
              return;
          }  else if(!firstName.matches("[a-zA-Z\\\\s\\\\-ëäöïü]+") || !lastName.matches("[a-zA-Z\\\\s\\\\-ëäöïü]+")) {
              throw new IllegalArgumentException("Participant name not valid!");

          }
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getAppointmentTime() {
        return this.hours * 60 + this.minutes;
    }

    @Override
    public String toString() {
        return this.fullName + " at " + this.hours + ":" + this.minutes;
    }

}
