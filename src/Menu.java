import model.Event;
import model.Member;
import model.OfficerMember;
import model.RegularMember;
import service.EventService;
import service.MemberService;
import service.storage.EventStorage;
import service.storage.MemberStorage;
import service.storage.contract.IStorageService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {
    private final IStorageService<Member> storeMember =  new MemberStorage();
    private final IStorageService<Event> storeEvent = new EventStorage();
    private final MemberService memberService = new MemberService();
    private final EventService eventService = new EventService();

    public void addMember(int choice, String name, String email) throws Exception {
        int id = (storeMember.isEmpty())?1:storeMember.count()+1;

        if (choice == 1) {
            OfficerMember officerMember = memberService.createOfficerMember(id, name, email);
            this.storeMember.store(officerMember);
        } else if (choice == 2) {
            RegularMember regularMember = memberService.createRegularMember(id, name, email);
            this.storeMember.store(regularMember);
        }
        else {
            return;
        }
    }
    public List<Member> listMember() {
        return this.storeMember.get();
    }
    public List<Member> listMemberOrderByPointsDesc() {
        List<Member> storeMembers = new ArrayList<>(this.storeMember.get());
        Collections.sort(storeMembers);

        return storeMembers;
    }
    public Member findMemberById(int id) {
        for(Member member : this.storeMember.get()) {
            if(member.getId() == id)
            {
                return member;
            }
        }
        return null;
    }

    public void createEvent(String title, int capacity, String type) throws Exception {
        int id = (storeEvent.isEmpty())?1:storeEvent.count()+1;
        Event event = eventService.createEvent(id, title, capacity, type);
        this.storeEvent.store(event);
    }
    public List<Event> listEvent() {
        return this.storeEvent.get();
    }
    public Event findEventById(int id) {
        for(Event event : this.storeEvent.get()) {
            if(event.getId() == id)
            {
                return event;
            }
        }
        return null;
    }
}
