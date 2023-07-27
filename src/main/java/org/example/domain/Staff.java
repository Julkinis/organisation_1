package org.example.domain;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String address;
    private String post;
    private String birthDate;

    @ManyToOne
    @JoinColumn(name="department_id")
    Department department;

    public Staff() {
    }

    @Override
    public String toString() {
        return String.format(
                "Сотрудник id %d: %s %s должность: %s, департамент: %s", id, firstName, lastName, post, department.getName());
    }
}
