package BusinessLogic;

import BusinessLogic.KitchenTask.CookingTask;
import BusinessLogic.KitchenTask.SummarySheet;
import BusinessLogic.User.UserManager;
import BusinessLogic.event.EventManager;
import BusinessLogic.menu.*;
import BusinessLogic.recipe.*;
import Persistence.*;

import java.util.ArrayList;

public class CatERing {
    private static CatERing singleInstance;

    public static CatERing getInstance() {
        if (singleInstance == null) {
            singleInstance = new CatERing();
        }
        return singleInstance;
    }

    private MenuManager menuMgr;
    private RecipeManager recipeMgr;
    private UserManager userMgr;
    private EventManager eventMgr;

    private MenuPersistence menuPersistence;

    private CatERing() {
        menuMgr = new MenuManager();
        recipeMgr = new RecipeManager();
        userMgr = new UserManager();
        eventMgr = new EventManager();
        menuPersistence = new MenuPersistence();
        menuMgr.addEventReceiver(menuPersistence);
    }


    public MenuManager getMenuManager() {
        return menuMgr;
    }

    public RecipeManager getRecipeManager() {
        return recipeMgr;
    }

    public UserManager getUserManager() {
        return userMgr;
    }

    public EventManager getEventManager() { return eventMgr; }

    public static void main(String[] args) {


        SummarySheet ss = new SummarySheet();

        ss.addCookingTask(null, null, 2, 500, null, null, 15);
        ss.addCookingTask(null, null, 2, 500, null, null, 15);
        System.out.println("Prima: " + ss.toString());

        ArrayList<CookingTask> a = ss.getSummarySheet();
        ss.markCookingTaskAsDone(a.get(0));
        System.out.println("\nDopo: " + ss.toString());
        System.out.println("Ciao");
    }
}
