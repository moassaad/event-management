package service;

import model.Event;

public class EventService {
    public Event createEvent(int id, String title, int capacity, String type) throws Exception {
        Event event = new Event();
        event.setId(id);
        event.setTitle(title);
        event.setCapacity(capacity);
        event.setType(type);
        return event;
    }
}
