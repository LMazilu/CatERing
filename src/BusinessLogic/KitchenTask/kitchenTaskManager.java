package BusinessLogic.KitchenTask;

import BusinessLogic.UseCaseLogicException;

import java.util.ArrayList;
import java.util.HashMap;

public class kitchenTaskManager {
    private summarySheet _summarySheet;

    public kitchenTaskManager() {
        _summarySheet = new summarySheet();
    }

    public void addCookingTask(ArrayList<Turn> turn,
                               Recipe recipe,
                               double estimatedTime,
                               Integer preparationQuantity,
                               Integer numberOfPortions,
                               Integer priority,
                               Integer difficulty) {

        _summarySheet.addCookingTask(turn, recipe, estimatedTime, preparationQuantity, numberOfPortions, priority, difficulty);
    }

    public void deleteCookingTask(cookingTask cookingTask) {
    }

    public void updateCookingTask(cookingTask cookingTask,
                                  ArrayList<Turn> turn,
                                  double estimatedTime,
                                  Integer preparationQuantity,
                                  Integer numberOfPortions,
                                  Integer priority,
                                  Integer difficulty) {
        _summarySheet.updateCookingTask(cookingTask, turn, estimatedTime, preparationQuantity, numberOfPortions, priority, difficulty);
    }

    public void sortSummarySheet(String criteria) throws UseCaseLogicException {
        _summarySheet.sortSummarySheet(criteria);
    }

    public void openSummarySheet() {
        //togli evento da dcd
        System.out.println(_summarySheet.getSummarySheet());
    }

    public void checkShiftsBoard() {
        //stampa turni
    }

    public void markCookingTaskAsDone(cookingTask cookingTask) {
        _summarySheet.markCookingTaskAsDone(cookingTask);
    }

}
