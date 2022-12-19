package at.htl.entity;

import javax.persistence.*;
import java.time.LocalDate;

@NamedQueries(
        {
                @NamedQuery(
                        name = "TrainingSession.findAll",
                        query = "select t from TrainingSession t"
                )
        }
)
@Entity
public class TrainingSession {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trainingSessionId;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "FK_AGELEVEL")
    private AgeLevel ageLevel;

    @ManyToOne
    @JoinColumn(name = "FK_Trainer")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "FK_Field")
    private Field field;

    public TrainingSession() {
    }

    public long getTrainingSessionId() {
        return trainingSessionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
