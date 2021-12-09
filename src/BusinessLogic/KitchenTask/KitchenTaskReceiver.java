package BusinessLogic.KitchenTask;

public interface KitchenTaskReceiver {

    public void updateCookingTaskAdded(CookingTask cookingTask);

    public void updateCookingTaskDeleted(CookingTask cookingTask);

    public void updateCookingTaskUpdated(CookingTask cookingTask);

    public void updateSummarySheetSorted(SummarySheet summarySheet);

}
