package BusinessLogic.Turn;

import java.util.ArrayList;

public class ShiftsBoard {
    ArrayList<Turn> shifts = new ArrayList<>();

    public ShiftsBoard(){
    }

    public ArrayList<Turn> getShifts(){
        return this.shifts;
    }

    public void setShifts(ArrayList<Turn> shifts){
        this.shifts = shifts;
    }
}
