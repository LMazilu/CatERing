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
                                         int preparationQuantity,
                                         int numberOfPortions,
                                         int priority,
                                         int difficulty) {

        this._turn = turn;
        this._recipe = recipe;
        this._estimatedTime = estimatedTime;

        if (preparationQuantity < 1 || preparationQuantity > 5) this._preparationQuantity = -1;
        else this._preparationQuantity = preparationQuantity;

        this._numberOfPortions = numberOfPortions;
        this._priority = priority;
        this._difficulty = difficulty;

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
