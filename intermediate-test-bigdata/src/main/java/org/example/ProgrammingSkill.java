package org.example;

public class ProgrammingSkill {
    private String name;
    private String description;
    private Integer confidenceLevel;

    public ProgrammingSkill() {
    }

    public ProgrammingSkill(String name, String description, Integer confidenceLevel) {
        this.name = name;
        this.description = description;
        this.confidenceLevel = confidenceLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getConfidenceLevel() {
        return confidenceLevel;
    }

    public void setConfidenceLevel(Integer confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }
}
