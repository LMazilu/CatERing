package BusinessLogic.Shift;

import java.sql.Time;

public class Shift {
    private int id;
    private Double duration;
    private Time begin;

    public Shift() {
    }

    public Shift(Time begin, Double duration) {
        this.begin = begin;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Time getBegin() {
        return begin;
    }

    public void setBegin(Time begin) {
        this.begin = begin;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "id=" + id +
                ", duration=" + duration +
                ", begin=" + begin +
                '}';
    }
}
