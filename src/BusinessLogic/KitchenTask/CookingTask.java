package BusinessLogic.KitchenTask;

import BusinessLogic.Shift.Shift;
import BusinessLogic.Shift.ShiftsBoard;
import BusinessLogic.recipe.Recipe;
import Persistence.BatchUpdateHandler;
import Persistence.PersistenceManager;
import Persistence.ResultHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CookingTask {
    private ObservableList<Shift> _shift;
    private int id;
    private Recipe _recipe;
    private double _estimatedTime;
    private int _preparationQuantity;
    private int _numberOfPortions;
    private int _priority;
    private int _difficulty;

    private boolean completed = false;

    public CookingTask() {
    }

    public CookingTask(Recipe recipe, ObservableList<Shift> shift) {
        this._recipe = recipe;
        this._shift = shift;
    }


    //region Regions for getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public CookingTask createCookingTask(ObservableList<Shift> shift,
                                         Recipe recipe,
                                         double estimatedTime,
                                         Integer preparationQuantity,
                                         Integer numberOfPortions,
                                         Integer priority,
                                         Integer difficulty) {

        this._shift = shift; //Anche se null.
        this._recipe = recipe;
        this._estimatedTime = estimatedTime;

        if (preparationQuantity == null || preparationQuantity < 1) this._preparationQuantity = 0;
        else this._preparationQuantity = preparationQuantity;
        if (numberOfPortions == null || numberOfPortions < 1) this._numberOfPortions = 0;
        else this._numberOfPortions = numberOfPortions;
        if (priority == null || priority < 1 || priority > 5) this._priority = 0;
        else this._priority = priority;
        if (difficulty == null || difficulty < 1 || difficulty > 5) this._difficulty = 0;
        else this._difficulty = difficulty;

        return this;
    }

    public void setCookingTaskDone() {
        this.completed = true;
    }

    public static ObservableList<CookingTask> loadTaskForId(int id) {
        ObservableList<CookingTask> result = FXCollections.observableArrayList();
        String query = "SELECT * FROM cookingTask WHERE id = " + id;
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                CookingTask ct = new CookingTask(Recipe.loadRecipeById(rs.getInt("recipe")), ShiftsBoard.loadShiftOfCoookingTaskById(id));
                ct.setId(rs.getInt("id"));
                ct.set_estimatedTime(rs.getDouble("estimatedTime"));
                ct.set_preparationQuantity(rs.getInt("quantity"));
                ct.set_numberOfPortions(rs.getInt("numberOfPortions"));
                ct.set_priority((rs.getInt("priority")));
                ct.set_difficulty((rs.getInt("difficulty")));
                result.add(ct);
            }
        });

        return result;
    }

    public static void insertCookingTask(CookingTask cookingTask) {
        String itemInsert = "INSERT INTO cookingtask (id_recipe,estimatedTime, preparationQuantity, numberOfPortions, priority, difficulty) VALUES (" +
                cookingTask._recipe.getId() + ", " +
                cookingTask._estimatedTime + ", " +
                cookingTask._preparationQuantity + "," +
                cookingTask._numberOfPortions + "," +
                cookingTask._priority + "," +
                cookingTask._difficulty + ");";
        PersistenceManager.executeUpdate(itemInsert);
        cookingTask.id = PersistenceManager.getLastId();
        for(Shift s : cookingTask._shift){
            String itemTurnInsert = "INSERT INTO shift_cookingtask_association (id_shift, id_cookingtask) VALUES (" + cookingTask._shift + "," + cookingTask.id + ");";
            PersistenceManager.executeUpdate(itemTurnInsert);
        }

    }

    public void markCookingTaskAsDone(CookingTask cookingTask){
        deleteCookingTask(cookingTask);
    }


    public static void deleteCookingTask(CookingTask cookingTask){
        String remove = "DELETE * FROM cookingtask WHERE id =" +cookingTask.getId();
        PersistenceManager.executeUpdate(remove);
    }

    public static void editNewCookingTask(CookingTask cookingTask) {
        String itemEdit = "UPDATE  cookingtask SET estimatedTime="+cookingTask._estimatedTime+
                ",preparationQuantity="+cookingTask._preparationQuantity+
                ",numberOfPortions="+cookingTask._numberOfPortions+
                ",priority="+cookingTask._priority+
                ",difficulty="+cookingTask._difficulty+
                " WHERE id="+cookingTask.id+";";

        PersistenceManager.executeUpdate(itemEdit);
        for (Shift shift : cookingTask._shift) {
            String itemTurnEdit = "UPDATE cookingtask_has_turn SET id_shift WHERE id_cookingtask="+cookingTask.id+ ";";
            PersistenceManager.executeUpdate(itemTurnEdit);
        }

    }

    @Override
    public String toString() {
        return "CookingTask{" +
                "_shift=" + _shift +
                ", id=" + id +
                ", _recipe=" + _recipe +
                ", _estimatedTime=" + _estimatedTime +
                ", _preparationQuantity=" + _preparationQuantity +
                ", _numberOfPortions=" + _numberOfPortions +
                ", _priority=" + _priority +
                ", _difficulty=" + _difficulty +
                ", completed=" + completed +
                '}';
    }
}
