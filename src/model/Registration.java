package model;

import java.util.List;

public class Registration {
    protected List<Event> eventList;

    public Event registerMemberToEvent(Member member, Event event) throws Exception {
        event.registerMember(member);
        return event;
    }
}
