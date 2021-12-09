package KitchenTaskTests;

import BusinessLogic.CatERing;
import BusinessLogic.KitchenTask.CookingTask;
import BusinessLogic.KitchenTask.SummarySheet;
import BusinessLogic.Shift.Shift;
import BusinessLogic.UseCaseLogicException;
import BusinessLogic.menu.Menu;
import BusinessLogic.recipe.Recipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TestKitchen {
    public static void main(String[] args) {
        try {
            System.out.println("Test fake login");
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

            System.out.println("\nTest load menu");
            ObservableList<Menu> menuList = CatERing.getInstance().getMenuManager().getAllMenus();
            System.out.println(menuList.get(0).testString());

            System.out.println("\n Test for open current summarySheet");
            SummarySheet sheet = new SummarySheet();
            System.out.println(sheet.getSummarySheet());

            System.out.println("\n Test for create cooking task");
            ObservableList<Recipe> recipeList = CatERing.getInstance().getRecipeManager().getRecipes();
            ObservableList<Shift> shifts = CatERing.getInstance().getShiftsManager().getShifts();
            ObservableList<Shift> selectedShift = FXCollections.observableArrayList();
            selectedShift.add(shifts.get(4));
            selectedShift.add(shifts.get(5));
            sheet.addCookingTask(selectedShift, recipeList.get(4), 2.0, 1, 1, 1, 1);
            sheet.addCookingTask(selectedShift, recipeList.get(2), 3.0, null, null, null, null);
            sheet.addCookingTask(selectedShift, recipeList.get(3), 4.0, null, null, null, null);
            sheet.addCookingTask(selectedShift, recipeList.get(4), 1.0, null, null, null, null);

            System.out.println(sheet.getSummarySheet());

            System.out.println("\n Specify quantity, portions, difficulty and priority ");
            ObservableList<CookingTask> cookingTaskList = sheet.getSummarySheet();
            sheet.updateCookingTask(cookingTaskList.get(1), null, 2, 3, 5, 1, 2);
            sheet.updateCookingTask(cookingTaskList.get(2), null, 3, 2, 4, 2, 1);
            sheet.updateCookingTask(cookingTaskList.get(3), null, 4, 1, 3, 4, 5);

            System.out.println("\n Test for order summarySheet by Difficulty");
            sheet.sortSummarySheet("Difficulty");

            System.out.println("\n Test for order summarySheet by Priority");
            sheet.sortSummarySheet("Priority");

            System.out.println("\n Test for check cooking task completed");
            sheet.markCookingTaskAsDone(cookingTaskList.get(2));

            System.out.println("\n Test for delete cooking task");
            sheet.deleteCookingTask(cookingTaskList.get(2));

            System.out.println(sheet.toString());

        } catch (UseCaseLogicException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Non hai inserito o Ricetta, o preparation time oppure non hai associato il turno al compito\n");
            System.out.println("Riprova!");
        }
    }
}
