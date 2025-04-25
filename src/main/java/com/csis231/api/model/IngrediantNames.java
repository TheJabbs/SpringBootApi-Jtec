package com.csis231.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "ingrediant_names", schema = "pos_db", catalog = "")
public class IngrediantNames implements Cloneable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ingrediant_names_id", nullable = false)
    private Integer ingrediantNamesId;
    @Basic
    @Column(name = "ingrediant_name", nullable = false, length = 45)
    private String ingrediantName;
    @OneToMany(mappedBy = "ingrediantNamesByIngrediantNamesId")
    @JsonIgnore
    private Collection<Ingrediant> ingrediantsByIngrediantNamesId;


    public Integer getIngrediantNamesId() {
        return ingrediantNamesId;
    }

    public void setIngrediantNamesId(Integer ingrediantNamesId) {
        this.ingrediantNamesId = ingrediantNamesId;
    }

    public String getIngrediantName() {
        return ingrediantName;
    }

    public void setIngrediantName(String ingrediantName) {
        this.ingrediantName = ingrediantName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngrediantNames that = (IngrediantNames) o;

        if (ingrediantNamesId != null ? !ingrediantNamesId.equals(that.ingrediantNamesId) : that.ingrediantNamesId != null)
            return false;
        if (ingrediantName != null ? !ingrediantName.equals(that.ingrediantName) : that.ingrediantName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ingrediantNamesId != null ? ingrediantNamesId.hashCode() : 0;
        result = 31 * result + (ingrediantName != null ? ingrediantName.hashCode() : 0);
        return result;
    }

    public Collection<Ingrediant> getIngrediantsByIngrediantNamesId() {
        return ingrediantsByIngrediantNamesId;
    }

    public void setIngrediantsByIngrediantNamesId(Collection<Ingrediant> ingrediantsByIngrediantNamesId) {
        this.ingrediantsByIngrediantNamesId = ingrediantsByIngrediantNamesId;
    }

    @Override
    public IngrediantNames clone() {
        try {
            IngrediantNames clone = (IngrediantNames) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
