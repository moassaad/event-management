package model;

public class OfficerMember extends Member {

    public void updatePointsBuons(double xnew) {
        points = points + xnew;
        updatePointsEvent();
    }

    private void updatePointsEvent() {
    }
}
