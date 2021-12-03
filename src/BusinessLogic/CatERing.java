package BusinessLogic;

import BusinessLogic.KitchenTask.CookingTask;
import BusinessLogic.KitchenTask.SummarySheet;

import java.util.ArrayList;

public class CatERing {
    public static void main(String[] args) {

        SummarySheet ss = new SummarySheet();

        ss.addCookingTask(null, null, 2, 500, null, null, 15);
        ss.addCookingTask(null, null, 2, 500, null, null, 15);
        System.out.println("Prima: " + ss.toString());

        ArrayList<CookingTask> a = ss.getSummarySheet();
        ss.markCookingTaskAsDone(a.get(0));
        System.out.println("\nDopo: " + ss.toString());
    }
}
