package BusinessLogic.KitchenTask;

import BusinessLogic.Shift.Shift;
import BusinessLogic.UseCaseLogicException;
import BusinessLogic.recipe.Recipe;
import javafx.collections.ObservableList;

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

    public KitchenTaskManager() {}

    public void addCookingTask(ObservableList<Shift> shift,
                               Recipe recipe,
                               double estimatedTime,
                               Integer preparationQuantity,
                               Integer numberOfPortions,
                               Integer priority,
                               Integer difficulty) {

        _currentSummarySheet.addCookingTask(shift, recipe, estimatedTime, preparationQuantity, numberOfPortions, priority, difficulty);
    }

    public void deleteCookingTask(CookingTask cookingTask) {
    }

    public void updateCookingTask(CookingTask cookingTask,
                                  ObservableList<Shift> shift,
                                  double estimatedTime,
                                  Integer preparationQuantity,
                                  Integer numberOfPortions,
                                  Integer priority,
                                  Integer difficulty) {
        _currentSummarySheet.updateCookingTask(cookingTask, shift, estimatedTime, preparationQuantity, numberOfPortions, priority, difficulty);
    }

    public void sortSummarySheet(String criteria) throws UseCaseLogicException {
        _currentSummarySheet.sortSummarySheet(criteria);
    }

    public ObservableList<CookingTask> openSummarySheet() {
        return _currentSummarySheet.getSummarySheet();
    }


    public void markCookingTaskAsDone(CookingTask cookingTask) {
        _currentSummarySheet.markCookingTaskAsDone(cookingTask);
    }

}
