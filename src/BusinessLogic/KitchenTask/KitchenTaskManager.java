package BusinessLogic.KitchenTask;

import BusinessLogic.Turn.Turn;
import BusinessLogic.UseCaseLogicException;
import BusinessLogic.recipe.Recipe;

import java.util.ArrayList;


public class KitchenTaskManager {
    private SummarySheet _currentSummarySheet = new SummarySheet();
    private ArrayList<KitchenTaskReceiver>  _kitchenTaskReceivers;

    public void addReceiver(KitchenTaskReceiver ktr){
        this._kitchenTaskReceivers.add(ktr);
    }
    public void deleteReceiver(KitchenTaskReceiver ktr){
        this._kitchenTaskReceivers.remove(ktr);
    }

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
        _kitchenTaskReceivers = new ArrayList<KitchenTaskReceiver>();
    }

    public void addCookingTask(ArrayList<Turn> turn,
                               Recipe recipe,
                               double estimatedTime,
                               Integer preparationQuantity,
                               Integer numberOfPortions,
                               Integer priority,
                               Integer difficulty) {

        _currentSummarySheet.addCookingTask(turn, recipe, estimatedTime, preparationQuantity, numberOfPortions, priority, difficulty);
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
        _currentSummarySheet.updateCookingTask(cookingTask, turn, estimatedTime, preparationQuantity, numberOfPortions, priority, difficulty);
    }

    public void sortSummarySheet(String criteria) throws UseCaseLogicException {
        _currentSummarySheet.sortSummarySheet(criteria);
    }

    public void openSummarySheet() {
        System.out.println(_currentSummarySheet.getSummarySheet());
    }

    public void checkShiftsBoard() {

    }

    public void markCookingTaskAsDone(CookingTask cookingTask) {
        _currentSummarySheet.markCookingTaskAsDone(cookingTask);
    }

}
