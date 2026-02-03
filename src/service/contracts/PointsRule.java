package service.contracts;

import model.Event;

public interface PointsRule {
    int getPointsForEvent(Event event);

    public void updatePointsEvent(double value);
    public void updatePointsCompetition(double value);
}
