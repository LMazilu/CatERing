package BusinessLogic.KitchenTask;

import BusinessLogic.Shift.Shift;
import BusinessLogic.UseCaseLogicException;
import BusinessLogic.recipe.Recipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SummarySheet {

    private static final String DIFFICULTY = "Difficulty";
    private static final String PRIORITY = "Priority";
    private ObservableList<CookingTask> _cookingTasks;

    public SummarySheet() {
        this._cookingTasks = FXCollections.observableArrayList(CookingTask.loadAllCookingTasks());
    }

    public void addCookingTask(ObservableList<Shift> shift,
                               Recipe recipe,
                               double estimatedTime,
                               Integer preparationQuantity,
                               Integer numberOfPortions,
                               Integer priority,
                               Integer difficulty) {

        CookingTask ct = new CookingTask();
        ct.createCookingTask(shift, recipe, estimatedTime, preparationQuantity, numberOfPortions, priority, difficulty);
        _cookingTasks.add(ct);
        ct.insertCookingTask(ct);
    }

    public void deleteCookingTask(CookingTask cookingTask) {
        cookingTask.deleteCookingTask(cookingTask);
        _cookingTasks.remove(cookingTask);
    }

    public void updateCookingTask(CookingTask cookingTask,
                                  ObservableList<Shift> shift,
                                  double estimatedTime,
                                  Integer preparationQuantity,
                                  Integer numberOfPortions,
                                  Integer priority,
                                  Integer difficulty) {


        cookingTask.set_estimatedTime(estimatedTime);
        //cookingTask.set_turn(turn);
        cookingTask.set_preparationQuantity(preparationQuantity);
        cookingTask.set_numberOfPortions(numberOfPortions);
        cookingTask.set_priority(priority);
        cookingTask.set_difficulty(difficulty);

        cookingTask.editCookingTask(cookingTask);
    }

    public void sortSummarySheet(String criteria) throws UseCaseLogicException {
        if (criteria.equals(DIFFICULTY)) {
            _cookingTasks.sort((o1, o2) -> Integer.compare(o1.get_difficulty(), o2.get_difficulty()));
        } else if (criteria.equals(PRIORITY)) {
            _cookingTasks.sort((o1, o2) -> Integer.compare(o1.get_priority(), o2.get_priority()));
        } else {
            throw new UseCaseLogicException();
        }
    }

    public void markCookingTaskAsDone(CookingTask cookingTask) {
        cookingTask.setCookingTaskDone();
        //cookingTask.markCookingTaskAsDone(cookingTask);
        deleteCookingTask(cookingTask);
    }

    public ObservableList<CookingTask> get_cookingTasks() {
        return _cookingTasks;
    }

    public void set_cookingTasks(ObservableList<CookingTask> _cookingTasks) {
        this._cookingTasks = _cookingTasks;
    }

    public ObservableList<CookingTask> getSummarySheet() {
        return this._cookingTasks;
    }



}
