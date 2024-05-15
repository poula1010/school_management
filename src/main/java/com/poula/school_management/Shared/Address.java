package com.poula.school_management.Shared;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class Address {
    @NotNull
    @Column(name="city",nullable = false)
    protected String city;

    @NotNull
    @Column(name="street",nullable = false)
    protected String street;

    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!getCity().equals(address.getCity())) return false;
        return getStreet().equals(address.getStreet());
    }

    @Override
    public int hashCode() {
        int result = getCity().hashCode();
        result = 31 * result + getStreet().hashCode();
        return result;
    }
}
