package BusinessLogic.Shift;

import Persistence.PersistenceManager;
import Persistence.ResultHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Shift {
    private int id;
    private Double duration;
    private Time begin;

    public Shift() {}

    public Shift(Double duration, Time begin) {
        this.begin = begin;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }
    public Double getDuration() {
        return duration;
    }


    public void setId(int id) {
        this.id = id;
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
}
