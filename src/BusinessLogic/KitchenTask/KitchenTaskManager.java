package BusinessLogic.KitchenTask;

import BusinessLogic.Turn.Turn;
import BusinessLogic.UseCaseLogicException;
import BusinessLogic.recipe.Recipe;

import java.util.ArrayList;


public class KitchenTaskManager {
    private SummarySheet _summarySheet;
    private ArrayList<KitchenTaskReceiver>  _kitchenTaskReceivers;

    public void addReceiver(KitchenTaskReceiver ktr){}
    public void deleteReceiver(KitchenTaskReceiver ktr){}

    private void notifyCookingTaskAdded(CookingTask cookingTask){
        for(KitchenTaskReceiver ktr : _kitchenTaskReceivers){
            ktr.updateCookingTaskAdded(cookingTask);
        }
    }
    private void notifyCookingTaskDeleted(CookingTask cookingTask){
        for(KitchenTaskReceiver ktr : _kitchenTaskReceivers){
            ktr.updateCookingTaskDeleted(cookingTask);
        }
    }
    private void notifyCookingTaskUpdated(CookingTask cookingTask){
        for(KitchenTaskReceiver ktr : _kitchenTaskReceivers){
            ktr.updateCookingTaskUpdated(cookingTask);
        }
    }
    private void notifyCookingTasksSorted(SummarySheet summarySheet){
        for(KitchenTaskReceiver ktr : _kitchenTaskReceivers){
            ktr.updateCookingTasksSorted(summarySheet);
        }

    }

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
