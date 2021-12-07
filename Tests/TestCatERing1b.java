import BusinessLogic.CatERing;
import BusinessLogic.UseCaseLogicException;
import BusinessLogic.event.EventInfo;
import BusinessLogic.event.ServiceInfo;
import BusinessLogic.menu.Menu;
import BusinessLogic.menu.MenuException;
import BusinessLogic.menu.Section;
import BusinessLogic.recipe.Recipe;
import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.Map;

public class TestCatERing1b {
    public static void main(String[] args) {
        try {
            /* System.out.println("TEST DATABASE CONNECTION");
            PersistenceManager.testSQLConnection();*/
            CatERing.getInstance().getUserManager().fakeLogin("Lidia");
            System.out.println(CatERing.getInstance().getUserManager().getCurrentUser());

            Menu m = CatERing.getInstance().getMenuManager().createMenu("Menu da Cancellare");

            Section antipasti = CatERing.getInstance().getMenuManager().defineSection("Antipasti");
            Section primi = CatERing.getInstance().getMenuManager().defineSection("Primi");
            Section secondi = CatERing.getInstance().getMenuManager().defineSection("Secondi");

            ObservableList<Recipe> recipes = CatERing.getInstance().getRecipeManager().getRecipes();
            CatERing.getInstance().getMenuManager().insertItem(recipes.get(0), antipasti);
            CatERing.getInstance().getMenuManager().insertItem(recipes.get(1), antipasti);
            CatERing.getInstance().getMenuManager().insertItem(recipes.get(2), antipasti);
            CatERing.getInstance().getMenuManager().insertItem(recipes.get(6), secondi);
            CatERing.getInstance().getMenuManager().insertItem(recipes.get(7), secondi);
            CatERing.getInstance().getMenuManager().insertItem(recipes.get(3));
            CatERing.getInstance().getMenuManager().insertItem(recipes.get(4));

            CatERing.getInstance().getMenuManager().publish();
            System.out.println("\nMENU CREATO");
            System.out.println(m.testString());

            System.out.println("\nTEST DELETE");
            CatERing.getInstance().getMenuManager().deleteMenu(m);

        } catch (UseCaseLogicException | MenuException e) {
            System.out.println("Errore di logica nello use case");
        }
    }
}