package at.htl.entity;

import javax.persistence.*;
@NamedQueries({
        @NamedQuery(
                name = "Field.findAll",
                query = "select f from Field f"
        ),
        @NamedQuery(
                name = "Field.findByLocation",
                query="select f from Field f where f.location like :LOCATION"
        )
})
@Entity
public class Field {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fieldId;

    @Column
    private String location;

    public Field() {
    }

    public long getFieldId() {
        return fieldId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
