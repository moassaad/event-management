package model;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private  int id;
    private String title;
    private String type;
    private int capacity;
    private List<Member> members;

    public Event() {
        this.members = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public boolean registerMember(Member member) {
        if (members.contains(member)) {
            return false;
        }
        if (members.size() >= capacity) {
            return false;
        }
        members.add(member);
        return true;
    }
    public void addMember(Member member) throws Exception {
        if (members.contains(member)) {
            throw new Exception("Member already exists");
        }
        members.add(member);
    }
    public boolean isCapacityFull() {
        return members.size() == this.capacity;
    }
    public List<Member> listMembers() {
        return this.members;
    }

    @Override
    public String toString() {
        return this.id + " | " + this.title + " | " + this.type + " | Seats: " + this.members.size() + "/" + this.capacity;
    }
}
