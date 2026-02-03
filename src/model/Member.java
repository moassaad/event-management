package model;

import service.contracts.PointsRule;

public class Member implements PointsRule {
    protected int id;
    protected String name;
    protected String email;
    protected double points;

//    public static class Builder {
//        protected Member member;
//        public Builder() {
//            this.member = new Member();
//        }
//        public Builder setId(int id) throws Exception {
//            this.member.setId(id);
//            return this;
//        }
//        public Builder setName(String name) throws Exception {
//            this.member.setName(name);
//            return this;
//        }
//        public Builder setEmail(String email) {
//            this.member.setEmail(email);
//            return this;
//        }
//        public Member build() {
//            this.member.setPoints(0.0);
//            return this.member;
//        }
//    }
    public void setId(int id) throws  Exception {

        if (isPositive(id)) {
            this.id = id;
        }
        else {
            throw new Exception("Invalid ID");
        }

    }
    public void setName(String name) throws Exception {
        if (isNameNotEmpty(name)) {
            this.name = name;
        }else{
            throw  new Exception("Name is empty");
        }

    }
    public void setEmail(String email) throws Exception {
        if (!email.contains("@")) {
            throw new Exception("Invalid Email");
        }
        this.email = email;

    }
    public void setPoints(double points) {
        this.points = points;
    }

    protected boolean isPositive(int value) {
        return value >= 0;
    }
    protected boolean isPositive(double value) {
        return value >= 0;
    }
    protected boolean isNameNotEmpty(String name) {
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

    @Override
    public String toString() {
        return this.id + " | " + this.name + " | " + this.email + " | Points: " + this.points;
    }

    @Override
    public int getPointsForEvent(Event event) {
        return 0;
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
