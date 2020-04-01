package by.gerasimov.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player {

    @OneToOne(mappedBy = "player")
    public Manager manager;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "short_name", nullable = false, length = 50)
    private String shortName;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
