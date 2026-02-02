package model;

public class OfficerMember extends Member {
    public OfficerMember(int id, String name, String email) {
        super(id, name, email);
    }
    public void updatePointsBuons(double xnew) {
        points = points + xnew;
        updatePointsEvent();
    }
}
