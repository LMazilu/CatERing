package BusinessLogic.Turn;

public class TurnManager {
    ShiftsBoard board;

    public TurnManager(ShiftsBoard board){
        this.board = board;
    }

    public ShiftsBoard getShiftsBoard(){
        return this.board;
    }

}
