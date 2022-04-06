package com.company;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) throws IllegalArgumentException{
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Не корректно введен возраст");
        }
        this.age = OptionalInt.of(age);
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Не все поля заполнены");
        }
        if (age.isPresent() || address != null)  {
            if (!age.isPresent()) {
                return new Person(name, surname, address);
            }
            if (address == null) {
                return new Person(name, surname , age);
            }
            return new Person(name, surname, age, address);
        }
        return new Person(name, surname);
    }
}
