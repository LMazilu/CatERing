package BusinessLogic.KitchenTask;

import java.util.ArrayList;

public class CookingTask {
    private ArrayList<Turn> _turn;
    private Recipe _recipe;
    private double _estimatedTime;
    private int _preparationQuantity;
    private int _numberOfPortions;
    private int _priority;
    private int _difficulty;

    private boolean completed = false;

    public CookingTask() {
    }


    //region Regions for getter and setter

    public double get_estimatedTime() {
        return _estimatedTime;
    }

    public void set_estimatedTime(double estimatedTime) {
        this._estimatedTime = estimatedTime;
    }

    public int get_preparationQuantity() {
        return _preparationQuantity;
    }

    public void set_preparationQuantity(Integer preparationQuantity) {
        if (preparationQuantity != null && preparationQuantity >= 1) this._preparationQuantity = preparationQuantity;
    }

    public int get_numberOfPortions() {
        return _numberOfPortions;
    }

    public void set_numberOfPortions(Integer numberOfPortions) {
        if (numberOfPortions != null && numberOfPortions >= 1) this._numberOfPortions = numberOfPortions;

    }

    public int get_priority() {
        return _priority;
    }

    public void set_priority(Integer priority) {
        if (priority != null && priority >= 1 && priority < 5) this._priority = priority;
    }

    public int get_difficulty() {
        return _difficulty;
    }

    public void set_difficulty(Integer difficulty) {
        if (difficulty != null && difficulty >= 1 && difficulty < 5) this._difficulty = difficulty;
    }
    //endregion

    public CookingTask createCookingTask(ArrayList<Turn> turn,
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
        if (priority == null || priority < 1 || priority > 5) this._priority = -1;
        else this._priority = priority;
        if (difficulty == null || difficulty < 1 || difficulty > 5) this._difficulty = -1;
        else this._difficulty = difficulty;

        return this;
    }

    public void setCookingTaskDone() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "cookingTask{" +
                "  turn=" + _turn +
                ", recipe=" + _recipe +
                ", estimatedTime=" + _estimatedTime +
                ", preparationQuantity=" + _preparationQuantity +
                ", numberOfPortions=" + _numberOfPortions +
                ", priority=" + _priority +
                ", difficulty=" + _difficulty +
                ", completed=" + completed +
                '}';
    }
}
