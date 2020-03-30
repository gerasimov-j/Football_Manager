package by.gerasimov.hibernate.model;

import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Stadium> stadiums;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Player> players;

    public Country() {
    }

    public Country(long id, String name, String tagName) {
        this.id = id;
        this.name = name;
        this.tagName = tagName;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(Set<Stadium> stadiums) {
        this.stadiums = stadiums;
    }
}
