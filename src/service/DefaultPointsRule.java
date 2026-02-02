package service;

import model.Event;

public class DefaultPointsRule implements PointsRule{
    @Override
    public int getPointsForEvent(Event event) {
        if (event.getType().equalsIgnoreCase("Competition")) {
            return 20;
        }
        return 10; // workshop or others
    }

    @Override
    public void updatePointsEvent(double value) {

    }

    @Override
    public void updatePointsCompetition(double value) {

    }
}
