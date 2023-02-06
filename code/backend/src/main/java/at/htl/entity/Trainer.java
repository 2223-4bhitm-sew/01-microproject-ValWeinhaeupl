package at.htl.entity;

import javax.persistence.*;


@Entity
public class Trainer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trainerId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    public Trainer() {
    }

    public long getTrainerId() {
        return trainerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }
}
