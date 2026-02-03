import model.Event;
import model.Member;
import model.OfficerMember;
import model.RegularMember;
import service.EventService;
import service.MemberService;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Member> storeMember =  new ArrayList<>();
    private List<Event> storeEvent =  new ArrayList<Event>();
    private MemberService memberService = new MemberService();
    private EventService eventService = new EventService();
    public void addMember(int choice, String name, String email) throws Exception {
        int id = (storeMember.isEmpty())?1:storeMember.size()+1;

        if (choice == 1) {
            OfficerMember officerMember = memberService.createOfficerMember(id, name, email);
            this.storeMember.add(officerMember);
        } else if (choice == 2) {
            RegularMember regularMember = memberService.createRegularMember(id, name, email);
            this.storeMember.add(regularMember);
        }
        else {
            return;
        }
    }
    public List<Member> listMembers() {
        return this.storeMember;
    }
    public Event createEvent(String title, int capacity, String type) throws Exception {
        int id = (storeEvent.isEmpty())?1:storeEvent.size()+1;
        Event event = eventService.createEvent(id, title, capacity, type);
        this.storeEvent.add(event);
        return event;
    }
    public List<Event> listEvent() {
        return this.storeEvent;
    }

    public Event findEventById(int id) {
        for(Event event : this.storeEvent) {
            if(event.getId() == id)
            {
                return event;
            }
        }
        return null;
    }
}
