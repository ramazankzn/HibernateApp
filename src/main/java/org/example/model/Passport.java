package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "Passport")
public class Passport {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn (name = "person_id", referencedColumnName = "id")
    private Person person;
    @Column (name = "passport_number")
    private int passportNumber;

    public Passport() {}

    public Passport(int passportNumber) {
        this.person = person;
        this.passportNumber = passportNumber;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "Владелец: " + person +
                ", Номер паспорта: " + passportNumber +
                ';';
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
