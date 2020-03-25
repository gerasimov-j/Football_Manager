package by.gerasimov.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
@NamedQuery(name = "Country.getAll", query = "SELECT c from Country c")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "tag_name", length = 3)
    private String tagName;

    public Country() {
    }

    public Country(long id, String name, String tagName) {
        this.id = id;
        this.name = name;
        this.tagName = tagName;
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
        return id == country.id &&
            Objects.equals(name, country.name) &&
            Objects.equals(tagName, country.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tagName);
    }
}
