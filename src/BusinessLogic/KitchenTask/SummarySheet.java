package BusinessLogic.KitchenTask;

import BusinessLogic.UseCaseLogicException;

import java.util.ArrayList;

public class SummarySheet extends CookingTask {

    private static final String DIFFICULTY = "Difficulty";
    private static final String PRIORITY = "Priority";
    private ArrayList<CookingTask> _cookingTasks;

    public SummarySheet() {
        this._cookingTasks = new ArrayList<CookingTask>();
    }

    public void addCookingTask(ArrayList<Turn> turn,
                               Recipe recipe,
                               double estimatedTime,
                               Integer preparationQuantity,
                               Integer numberOfPortions,
                               Integer priority,
                               Integer difficulty) {

        CookingTask ct = new CookingTask();
        ct.createCookingTask(turn, recipe, estimatedTime, preparationQuantity, numberOfPortions, priority, difficulty);
        _cookingTasks.add(ct);
    }

    public void deleteCookingTask(CookingTask cookingTask) {
        _cookingTasks.remove(cookingTask);
    }

    public void updateCookingTask(CookingTask cookingTask,
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

    public void markCookingTaskAsDone(CookingTask cookingTask){
        cookingTask.setCookingTaskDone();
        deleteCookingTask(cookingTask);
    }

    public ArrayList<CookingTask> getSummarySheet(){
        return this._cookingTasks;
    }

    @Override
    public String toString() {
        return "summarySheet{" +
                "_cookingTasks=" + _cookingTasks +
                '}';
    }
}
