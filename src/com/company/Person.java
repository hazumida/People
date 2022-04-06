package com.company;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private OptionalInt age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, OptionalInt age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age.isPresent();
    }
    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age.isPresent()) {
            return age;
        }
        throw new NoSuchElementException("Возраст неизвестен!");
    }

    public String getAddress() {
        if (address != null) {
            return address;
        }
        throw new NoSuchElementException("Адрес неизвестен!");
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    @Override
    public String toString() {
        return name + " " + surname + ": возраст = " + getAge().getAsInt() + ", адрес = " + getAddress();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }

    public PersonBuilder newChildBuilder(int age) {
        return new PersonBuilder()
                .setSurname(getSurname())
                .setAge(age)
                .setAddress(getAddress());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !object.getClass().equals(Person.class)) {
            return false;
        }
        Person person = (Person) object;

        return Objects.equals(getName(), person.getName()) && Objects.equals(getSurname(),
                person.getSurname()) && Objects.equals(getAge(),
                person.getAge()) && Objects.equals(getAddress(),
                person.getAddress());
    }
}
