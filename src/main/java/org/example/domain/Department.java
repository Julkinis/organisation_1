package org.example.domain;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Integer countStaff;
    private String rooms;

    @OneToOne
    @JoinColumn(name="boss_id")
    private Staff boss;
    public Department(){}

    @Override
    public String toString() {
        return String.format(
                "Отдел id %d:  название = %s, количество сотрудников = %d, комнаты = %s, начальник = %s", id, name, countStaff, rooms, boss);
    }
}
