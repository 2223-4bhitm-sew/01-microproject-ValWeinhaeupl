package at.htl.entity;

import javax.persistence.*;
@NamedQueries({
        @NamedQuery(
                name = "AgeLevel.findAll",
                query = "select a from AgeLevel a"
        ),
        @NamedQuery(
                name = "AgeLevel.findByName",
                query = "select a from AgeLevel a where a.ageLevelName like :NAME"
        )
})
@Entity
public class AgeLevel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ageLevelId;

    @Column
    private String ageLevelName;

    public AgeLevel() {
    }

    public long getAgeLevelId() {
        return ageLevelId;
    }

    public String getAgeLevelName() {
        return ageLevelName;
    }

    public void setAgeLevelName(String ageLevelName) {
        this.ageLevelName = ageLevelName;
    }
}
