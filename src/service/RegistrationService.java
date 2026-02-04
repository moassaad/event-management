package service;

import model.Event;
import model.Member;
import model.Registration;

public class RegistrationService {
    Registration registration;

    public RegistrationService() {
        this.registration = new Registration();
    }

    public void registerMember(Member member, Event event) throws Exception {
        this.registration.registerMemberToEvent(member, event);
    }
}
