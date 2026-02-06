package service.storage;

import model.Event;
import service.storage.contract.IStorageService;

import java.util.ArrayList;
import java.util.List;

public class EventStorage implements IStorageService<Event> {
    private final List<Event> store;
    public EventStorage() {
        this.store =  new ArrayList<>();
    }
    @Override
    public List<Event> get() {
        return this.store;
    }

    @Override
    public void store(Event event) {
        this.store.add(event);
    }

    @Override
    public Event find(int id) throws Exception{
        if (this.isEmpty())
        {
            throw new Exception("Not found event");
        }
        for(Event event : this.store) {
            if(event.getId() == id)
            {
                return event;
            }
        }
        return null;
    }

    @Override
    public Event update(int id, Event event) throws Exception {
        if (this.isEmpty())
        {
            throw new Exception("Not found event");
        }
        for(int iterator = 0 ; iterator < this.count(); iterator++) {

            if(this.store.get(iterator).getId() == id)
            {
                return this.store.set(iterator, event);
            }
        }
        return null;
    }

    @Override
    public Event delete(int id) throws Exception{
        if (this.isEmpty())
        {
            throw new Exception("Not found event");
        }
        for(int iterator = 0 ; iterator < this.count(); iterator++) {

            if(this.store.get(iterator).getId() == id)
            {
                return this.store.remove(iterator);
            }
        }
        return null;
    }

    @Override
    public int count() {
        return this.store.size();
    }

    @Override
    public boolean isEmpty() {
        return this.count() <= 0;
    }
}
