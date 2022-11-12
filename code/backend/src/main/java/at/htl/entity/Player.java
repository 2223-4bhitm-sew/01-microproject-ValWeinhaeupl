package at.htl.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "Player.findAll",
                query = "select p from Player p"
        ),
        @NamedQuery(
                name = "Player.findByFirstNameAndLastName",
                query="select p from Player p where p.firstname like :FIRST and p.lastname like :LAST"
        )
})
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long playerId;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String position;

    @Column
    private int goals;

    public Player() {
    }

    public Player(String firstname, String lastname, String position, int goals) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.goals = goals;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }


    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", position='" + position + '\'' +
                ", goals=" + goals +
                '}';
    }
}
