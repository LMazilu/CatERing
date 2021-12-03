package BusinessLogic.KitchenTask;

import BusinessLogic.UseCaseLogicException;

import java.util.ArrayList;

public class summarySheet extends cookingTask {

    private static final String DIFFICULTY = "Difficulty";
    private static final String PRIORITY = "Priority";
    private ArrayList<cookingTask> _cookingTasks;

    public summarySheet() {
        this._cookingTasks = new ArrayList<cookingTask>();
    }

    public void addCookingTask(ArrayList<Turn> turn,
                               Recipe recipe,
                               double estimatedTime,
                               Integer preparationQuantity,
                               Integer numberOfPortions,
                               Integer priority,
                               Integer difficulty) {

        cookingTask ct = new cookingTask();
        ct.createCookingTask(turn, recipe, estimatedTime, preparationQuantity, numberOfPortions, priority, difficulty);
        _cookingTasks.add(ct);
    }

    public void deleteCookingTask(cookingTask cookingTask) {
        _cookingTasks.remove(cookingTask);
    }

    public void updateCookingTask(cookingTask cookingTask,
                                  ArrayList<Turn> turn,
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

    public void markCookingTaskAsDone(cookingTask cookingTask){
        cookingTask.setCookingTaskDone();
        deleteCookingTask(cookingTask);
    }

    public ArrayList<cookingTask> getSummarySheet(){
        return this._cookingTasks;
    }

    @Override
    public String toString() {
        return "summarySheet{" +
                "_cookingTasks=" + _cookingTasks +
                '}';
    }
}
