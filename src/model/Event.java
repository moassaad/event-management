package model;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private  int eventId;
    private String title;
    private String type;
    private int capacity;
    private List<Member> members;

    public Event(int eventId, String title, int capacity, String type) {
        this.eventId = eventId;
        this.title = title;
        this.capacity = capacity;
        this.type = type;
        this.members = new ArrayList<>();
    }
    public int getEventId() {
        return eventId;
    }

    public String getType() {
        return type;
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
    @Override
    public String toString() {
        return eventId + " | " + title + " | " + type + " | Seats: " + members.size() + "/" + capacity;
    }
}
