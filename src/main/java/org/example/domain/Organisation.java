package org.example.domain;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name="organisation")
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    @OneToOne
    @JoinColumn(name="boss_id")
    private Staff boss;
    public Organisation(){}

    @Override
    public String toString() {
        return String.format(
                "Органицация id %d: название: %s, адрес: %s, начальник: %s", id, name, address, boss);
    }
}
