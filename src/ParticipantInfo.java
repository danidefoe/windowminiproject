import javax.swing.*;

public class ParticipantInfo extends ProjectJava {
    String firstName;
    String lastName;
    String fullName;
    int hours;
    int minutes;

    public ParticipantInfo(String firstName, String lastName, int hours, int minutes) {
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
