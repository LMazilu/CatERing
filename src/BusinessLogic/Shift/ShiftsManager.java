package BusinessLogic.Shift;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ShiftsManager {

    public ShiftsManager() {
        ShiftsBoard.loadAllShifts();
    }

    public ObservableList<Shift> getShifts() {
        return FXCollections.unmodifiableObservableList(ShiftsBoard.getAllShifts());
    }

}
