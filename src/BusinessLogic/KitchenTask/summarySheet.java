package BusinessLogic.KitchenTask;

import BusinessLogic.UseCaseLogicException;

import java.util.ArrayList;

public class summarySheet extends cookingTask {

    private ArrayList<cookingTask> _cookingTasks;

    public void addCookingTask(ArrayList<Turn> turn,
                               Recipe recipe,
                               double estimatedTime,
                               int preparationQuantity,
                               int numberOfPortions,
                               int priority,
                               int difficulty) {

    }

    public void deleteCookingTask(cookingTask cookingTask) {
        _cookingTasks.remove(cookingTask);
    }

    public void updateCookingTask(cookingTask cookingTask,
                                  ArrayList<Turn> turn,
                                  double estimatedTime,
                                  int preparationQuantity,
                                  int numberOfPortions,
                                  int priority,
                                  int difficulty) {


        cookingTask.set_estimatedTime(estimatedTime);
        //cookingTask.set_recipe(recipe);
        //cookingTask.set_turn(turn);
        cookingTask.set_preparationQuantity(preparationQuantity);
        cookingTask.set_numberOfPortions(numberOfPortions);
        cookingTask.set_priority(priority);
        cookingTask.set_difficulty(difficulty);

    }

    public void sortSummarySheet(String criteria) throws UseCaseLogicException {
        if (criteria.equals(Criteria.DIFFICULTY)) {
            _cookingTasks.sort((o1, o2) -> Integer.compare(o1.get_difficulty(), o2.get_difficulty()));
        } else if (criteria.equals(Criteria.PRIORITY)) {
            _cookingTasks.sort((o1, o2) -> Integer.compare(o1.get_priority(), o2.get_priority()));
        } else {
            throw new UseCaseLogicException();
        }
    }


}
