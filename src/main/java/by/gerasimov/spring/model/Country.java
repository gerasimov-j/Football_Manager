package by.gerasimov.spring.model;

import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "countries")
@NamedQuery(name = "Country.getAll", query = "SELECT c from Country c")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "tag_name", nullable = false, length = 3)
    private String tagName;

    private String flagFileName;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Stadium> stadiums;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Player> players;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Country() {
    }

    public Country(String name, String tagName) {
        this.name = name;
        this.tagName = tagName;
    }

    public Country(String name, String tagName, User user) {
        this.name = name;
        this.tagName = tagName;
        this.author = user;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "-";
    }

    @Override
    public String toString() {
        return name + " (" + tagName + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Country)) {
            return false;
        }
        Country country = (Country) o;
        return name.equals(country.name) &&
            tagName.equals(country.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tagName);
    }
}
