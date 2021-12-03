package BusinessLogic.KitchenTask;

import BusinessLogic.UseCaseLogicException;

import java.util.ArrayList;


public class KitchenTaskManager {
    private SummarySheet _summarySheet;

    public void addReceiver(KitchenTaskReceiver ktr){}
    public void deleteReceiver(KitchenTaskReceiver ktr){}
    private void notifyCookingTaskAdded(CookingTask cookingTask){}
    private void notifyCookingTaskDeleted(CookingTask cookingTask){}
    private void notifyCookingTaskUpdated(CookingTask cookingTask){}
    private void notifyCookingTasksOrdered(SummarySheet cookingTask){}

    public KitchenTaskManager() {
        _summarySheet = new SummarySheet();
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

    public void deleteCookingTask(CookingTask cookingTask) {
    }

    public void updateCookingTask(CookingTask cookingTask,
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

    public void markCookingTaskAsDone(CookingTask cookingTask) {
        _summarySheet.markCookingTaskAsDone(cookingTask);
    }

}
