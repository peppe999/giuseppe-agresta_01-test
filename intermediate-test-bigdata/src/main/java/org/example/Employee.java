package org.example;

import java.util.List;

public class Employee {
    private String name;
    private String surname;
    private Integer age;
    private Place place;
    private List<ProgrammingSkill> programmingSkills;

    public Employee() {
    }

    public Employee(String name, String surname, Integer age, Place place, List<ProgrammingSkill> programmingSkills) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.place = place;
        this.programmingSkills = programmingSkills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public List<ProgrammingSkill> getProgrammingSkills() {
        return programmingSkills;
    }

    public void setProgrammingSkills(List<ProgrammingSkill> programmingSkills) {
        this.programmingSkills = programmingSkills;
    }
}
