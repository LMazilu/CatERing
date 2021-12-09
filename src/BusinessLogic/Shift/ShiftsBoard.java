package BusinessLogic.Shift;

import Persistence.PersistenceManager;
import Persistence.ResultHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ShiftsBoard {

    private static Map<Integer, Shift> all = new HashMap<>();

    public static ObservableList<Shift> loadAllShifts() {
        String query = "SELECT * FROM shift";
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                int id = rs.getInt("id");
                if (all.containsKey(id)) {
                    Shift sh = all.get(id);
                    sh.setBegin(rs.getTime("begin"));
                    sh.setDuration(rs.getDouble("duration"));
                } else {
                    Shift sh = new Shift(rs.getTime("begin"), rs.getDouble("duration"));
                    sh.setId(id);
                    all.put(sh.getId(), sh);
                }
            }
        });
        ObservableList<Shift> shList = FXCollections.observableArrayList(all.values());
        Collections.sort(shList, Comparator.comparing(Shift::getDuration).thenComparing(Shift::getDuration));
        return shList;
    }

    // STATIC METHODS FOR PERSISTENCE
    public static ObservableList<Shift> getAllShifts() {
        return FXCollections.observableArrayList(all.values());
    }

    public static Shift loadShiftById(int id) {
        if (all.containsKey(id)) return all.get(id);
        Shift sh = new Shift();

        String query = "SELECT * FROM shift WHERE id = " + id;
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                sh.setBegin(rs.getTime("begin"));
                sh.setDuration(rs.getDouble("duration"));
                sh.setId(id);
                all.put(sh.getId(), sh);
            }
        });

        return sh;
    }
}
