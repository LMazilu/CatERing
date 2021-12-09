package BusinessLogic;

import BusinessLogic.KitchenTask.KitchenTaskManager;
import BusinessLogic.Shift.ShiftsManager;
import BusinessLogic.User.UserManager;
import BusinessLogic.event.EventManager;
import BusinessLogic.menu.MenuManager;
import BusinessLogic.recipe.RecipeManager;
import Persistence.MenuPersistence;

public class CatERing {
    private static CatERing singleInstance;
    private MenuManager menuManager;
    private RecipeManager recipeManager;
    private UserManager userManager;
    private EventManager eventManager;
    private ShiftsManager shiftsManager;
    private KitchenTaskManager kitchenTaskManager;
    private MenuPersistence menuPersistence;

    private CatERing() {
        menuManager = new MenuManager();
        recipeManager = new RecipeManager();
        userManager = new UserManager();
        eventManager = new EventManager();
        menuPersistence = new MenuPersistence();
        menuManager.addEventReceiver(menuPersistence);
        kitchenTaskManager = new KitchenTaskManager();
        shiftsManager = new ShiftsManager();
    }

    public static CatERing getInstance() {
        if (singleInstance == null) {
            singleInstance = new CatERing();
        }
        return singleInstance;
    }

    public ShiftsManager getShiftsManager() {
        return shiftsManager;
    }

    public void setShiftsManager(ShiftsManager shiftsManager) {
        this.shiftsManager = shiftsManager;
    }

    public KitchenTaskManager getKitchenTaskManager() {
        return kitchenTaskManager;
    }

    public void setKitchenTaskManager(KitchenTaskManager kitchenTaskManager) {
        this.kitchenTaskManager = kitchenTaskManager;
    }

    public MenuManager getMenuManager() {
        return menuManager;
    }

    public RecipeManager getRecipeManager() {
        return recipeManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public EventManager getEventManager() {
        return eventManager;
    }
/*
    public static void main(String[] args) {


        SummarySheet ss = new SummarySheet();

        ss.addCookingTask(null, null, 2, 500, null, null, 15);
        ss.addCookingTask(null, null, 2, 500, null, null, 15);
        System.out.println("Prima: " + ss.toString());

        ObservableList<CookingTask> a = ss.getSummarySheet();
        ss.markCookingTaskAsDone(a.get(0));
        System.out.println("\nDopo: " + ss.toString());
        System.out.println("Ciao");
    }
    */
}
