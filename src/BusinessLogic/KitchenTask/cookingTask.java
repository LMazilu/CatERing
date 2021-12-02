package BusinessLogic.KitchenTask;

import java.util.ArrayList;

public class cookingTask {
    private ArrayList<Turn> _turn;
    private Recipe _recipe;
    private double _estimatedTime;
    private int _preparationQuantity;
    private int _numberOfPortions;
    private int _priority;
    private int _difficulty;

    private boolean completed = false;

    public cookingTask() {
    }


    //region Regions for getter and setter

    public double get_estimatedTime() {
        return _estimatedTime;
    }

    public void set_estimatedTime(double _estimatedTime) {
        this._estimatedTime = _estimatedTime;
    }

    public int get_preparationQuantity() {
        return _preparationQuantity;
    }

    public void set_preparationQuantity(int _preparationQuantity) {
        this._preparationQuantity = _preparationQuantity;
    }

    public int get_numberOfPortions() {
        return _numberOfPortions;
    }

    public void set_numberOfPortions(int _numberOfPortions) {
        this._numberOfPortions = _numberOfPortions;
    }

    public int get_priority() {
        return _priority;
    }

    public void set_priority(int _priority) {
        this._priority = _priority;
    }

    public int get_difficulty() {
        return _difficulty;
    }

    public void set_difficulty(int _difficulty) {
        this._difficulty = _difficulty;
    }
    //endregion

    public cookingTask createCookingTask(ArrayList<Turn> turn,
                                         Recipe recipe,
                                         double estimatedTime,
                                         Integer preparationQuantity,
                                         Integer numberOfPortions,
                                         Integer priority,
                                         Integer difficulty) {

        this._turn = turn; //Anche se null.
        this._recipe = recipe;
        this._estimatedTime = estimatedTime;

        if (preparationQuantity == null || preparationQuantity < 1) this._preparationQuantity = -1;
        else this._preparationQuantity = preparationQuantity;
        if (numberOfPortions == null || numberOfPortions < 1) this._numberOfPortions = -1;
        else this._numberOfPortions = numberOfPortions;
        if (priority == null || priority < 1 || priority > 5 )this._priority = -1;
        else this._priority = priority;
        if (difficulty == null || difficulty < 1 || difficulty > 5) this._difficulty = -1;
        else this._difficulty = difficulty;

        return this;
    }

    @Override
    public String toString() {
        return "cookingTask{" +
                "turn=" + _turn +
                ", recipe=" + _recipe +
                ", estimatedTime=" + _estimatedTime +
                ", preparationQuantity=" + _preparationQuantity +
                ", numberOfPortions=" + _numberOfPortions +
                ", priority=" + _priority +
                ", difficulty=" + _difficulty +
                '}';
    }
}
