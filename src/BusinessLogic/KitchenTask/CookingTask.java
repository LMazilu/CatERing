package BusinessLogic.KitchenTask;

import BusinessLogic.Shift.Shift;
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




    @Override
    public String toString() {
        return "cookingTask{" +
                "  turn=" + _shift +
                ", recipe=" + _recipe +
                ", estimatedTime=" + _estimatedTime +
                ", preparationQuantity=" + _preparationQuantity +
                ", numberOfPortions=" + _numberOfPortions +
                ", priority=" + _priority +
                ", difficulty=" + _difficulty +
                ", completed=" + completed +
                '}';
    }

    public static ObservableList<CookingTask> loadTaskForId(int id) {
        ObservableList<CookingTask> result = FXCollections.observableArrayList();
        String query = "SELECT * FROM cookingTask WHERE id = " + id;
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                CookingTask ct = new CookingTask();


                //kt.set_recipe(rs.getString("recipe"));
                //kt.setTurn
                ct.setId(rs.getInt("id"));
                ct.set_estimatedTime(rs.getDouble("estimatedTime"));
                ct.set_preparationQuantity(rs.getInt("quantity"));
                ct.set_numberOfPortions(rs.getInt("numberOfPortions"));
                ct.set_priority((rs.getInt("priority")));
                ct.set_priority((rs.getInt("difficulty")));
                result.add(ct);
            }
        });

        return result;
    }

    public static void insertCookingTask(CookingTask cookingTask) {
        String itemInsert = "INSERT INTO cookingtask (id_recipe,estimatedTime, preparationQuantity, numberOfPortions, priority, difficulty) VALUES (" +
                cookingTask._recipe + ", " +
                cookingTask._estimatedTime + ", " +
                cookingTask._preparationQuantity + "," +
                cookingTask._numberOfPortions + "," +
                cookingTask._priority + "," +
                cookingTask._difficulty + ");";
    }


    public static void deleteKitchenTask(CookingTask cookingTask) {
        String rem = "DELETE FROM KitchenTask WHERE id = " + kt.getId();
        PersistenceManager.executeUpdate(rem);
    }

    public static void saveKitchenTaskTime(CookingTask cookingTask) {
        String upd = "UPDATE KitchenTask SET time = '" + kt.time + "' WHERE id = " + kt.id;
        PersistenceManager.executeUpdate(upd);
    }

    public static void saveKitchenTaskQuantity(CookingTask cookingTask) {
        String upd = "UPDATE KitchenTask SET quantity = '" + PersistenceManager.escapeString(cookingTask.quantity) + "' WHERE id = " + cookingTask.id;
        PersistenceManager.executeUpdate(upd);
    }

    public static void saveKitchenTaskCook(CookingTask cookingTask) {
        String upd = "UPDATE KitchenTask SET cook = '" + cookingTask.cook.getId() + "' WHERE id = " + cookingTask.id;
        PersistenceManager.executeUpdate(upd);
    }

    public static void saveKitchenTaskShift(CookingTask cookingTask) {
        String upd = "UPDATE KitchenTask SET shift = '" + cookingTask.shift.getId() + "' WHERE id = " + cookingTask.id;
        PersistenceManager.executeUpdate(upd);
    }

    public static void saveAllKitchenTask(int id, ObservableList<CookingTask> tasks) {
        String taskInsert = "INSERT INTO catering.kitchentask (tasksheet, recipe, completed, position) VALUES (?, ?, ?, ?);";
        PersistenceManager.executeBatchUpdate(taskInsert, tasks.size(), new BatchUpdateHandler() {
            @Override
            public void handleBatchItem(PreparedStatement ps, int batchCount) throws SQLException {
                ps.setInt(1, id);
                ps.setInt(2, tasks.get(batchCount).getJob().getId());
                ps.setBoolean(3, false);
                ps.setInt(4, batchCount);
            }

            @Override
            public void handleGeneratedIds(ResultSet rs, int count) throws SQLException {
                tasks.get(count).id = rs.getInt(1);
            }
        });
    }

    public static void saveKitchenTaskCompleted(KitchenTask kt) {
        String upd = "UPDATE KitchenTask SET completed = " + kt.completed +
                " WHERE id = " + kt.id;
        PersistenceManager.executeUpdate(upd);
    }


}
