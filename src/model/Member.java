package model;

import service.PointsRule;

public class Member implements PointsRule {
    protected int id;
    protected String name;
    protected String email;
    protected double points;

//    public Member(int id, String name, String email) {
//        this.id = id;
//
//        this.email = email;
//        this.points = 0;
//    }

    public void setId(int id) {
        this.id++;
    }
    public void setName(String name) {
        if (isNameNotEmpty(name)) {
            this.name = name;
        }else{
            this.name = "Unknown";
        }

    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPoints(double points) {
        this.points = points;
    }

    private boolean isPositive(int value) {
        return value >= 0;
    }
    private boolean isPositive(double value) {
        return value >= 0;
    }
    private boolean isNameNotEmpty(String name) {
        return name != null && !name.isEmpty();
    }

    public String getName() {
        return this.name;
    }

    public double getPoints() {
        return this.points;
    }

    // Controlled points update (encapsulation)
    public void updatePoints(double value) {
        if (isPositive(value)) {
            this.points += value;
        }
    }

    // Polymorphic behavior
//    public abstract int applyBonus(int basePoints);

    @Override
    public String toString() {
        return this.id + " | " + this.name + " | " + this.email + " | Points: " + this.points;
    }

    @Override
    public void updatePointsEvent(double value) {
        if (isPositive(value)) {
            this.points += value * 1.5;
        }
    }

    @Override
    public void updatePointsCompetition(double value) {
        if (isPositive(value)) {
            this.points += value * 2;
        }
    }
}
