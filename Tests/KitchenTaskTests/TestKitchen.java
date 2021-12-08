package KitchenTaskTests;

import BusinessLogic.CatERing;
import BusinessLogic.UseCaseLogicException;
import BusinessLogic.event.EventInfo;
import BusinessLogic.event.ServiceInfo;
import BusinessLogic.KitchenTask.*;
import BusinessLogic.menu.Menu;
import BusinessLogic.menu.Section;
import BusinessLogic.recipe.Recipe;
import BusinessLogic.Shift.Shift;
import BusinessLogic.User.User;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class TestKitchen {
    public void main(String[] args) {
        try {
            System.out.println("Test fake login");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

            System.out.println("\nTest load menu");
            ObservableList<Menu> menuList = CatERing.getInstance().getMenuManager().getAllMenus();
            System.out.println(menuList.get(0).testString());

            System.out.println("\n Test for open current summarySheet");
            System.out.println(CatERing.getInstance().getKitchenTaskManager());

            System.out.println("\n Test for create cooking task");
            ObservableList<Recipe> recipeList = CatERing.getInstance().getRecipeManager().getRecipes();
            CatERing.getInstance().getKitchenTaskManager().addCookingTask(null, null, null, null, null, null, null);
            CatERing.getInstance().getKitchenTaskManager().addCookingTask((Recipe) recipeList.get(4), null, null, null, null, null, null);
            ObservableList<Shift> turnList = CatERing.getInstance().getTurnMgr().getTurns();
            ObservableList<Shift> selectedTurn = null;
            assert false;
            selectedTurn.add(turnList.get(4));
            selectedTurn.add(turnList.get(5));
            CatERing.getInstance().getKitchenTaskManager().addCookingTask(recipeList.get(4), selectedTurn, null, null, null, null, null);
            CatERing.getInstance().getKitchenTaskManager().addCookingTask(recipeList.get(4), selectedTurn, 3.0, null, null, null, null);

            System.out.println("\n Specify quantity, portions, difficulty and importance ");
            ObservableList<CookingTask> cookingTaskList = CatERing.getInstance().getKitchenTaskManager().openSummarySheet().openSummarySheet();
            CatERing.getInstance().getKitchenTaskManager().editCookingTask(null, null,3,5,1,2,cookingTaskList.get(5));
            CatERing.getInstance().getKitchenTaskManager().editCookingTask(null, null,2,4,2,1,cookingTaskList.get(2));
            CatERing.getInstance().getKitchenTaskManager().editCookingTask(null, null,1,3,4,5,cookingTaskList.get(3));

            System.out.println("\n Test for order summarySheet by Difficulty");
            ObservableList<CookingTask> cTaskList = CatERing.getInstance().getKitchenTaskManager().openSummarySheet().openSummarySheet();
            boolean difficulty = true;
            boolean importance = false;
            CatERing.getInstance().getKitchenTaskManager().orderSummarySheet(difficulty, importance);

            System.out.println("\n Test for order summarySheet by Importance");
            difficulty = false;
            importance = true;
            CatERing.getInstance().getKitchenTaskManager().orderSummarySheet(difficulty, importance);

            System.out.println("\n Test for check cooking task completed");
            CatERing.getInstance().getKitchenTaskManager().makeCookingTaskDone(cookingTaskList.get(5));

            System.out.println("\n Test for delete cooking task");
            CatERing.getInstance().getKitchenTaskManager().deleteCookingTask(cookingTaskList.get(5));

        } catch (UseCaseLogicException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Non hai inserito o Ricetta, o preparation time oppure non hai associato il turno al compito\n");
            System.out.println("Riprova!");
        }
    }
}
