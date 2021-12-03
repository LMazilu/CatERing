package BusinessLogic;

import BusinessLogic.KitchenTask.cookingTask;
import BusinessLogic.KitchenTask.summarySheet;

import java.util.ArrayList;

public class CatERing {
    public static void main(String[] args) {

        summarySheet ss = new summarySheet();

        ss.addCookingTask(null, null, 2, 500, null, null, 15);
        ss.addCookingTask(null, null, 2, 500, null, null, 15);
        System.out.println("Prima: " + ss.toString());

        ArrayList<cookingTask> a = ss.getSummarySheet();
        ss.markCookingTaskAsDone(a.get(0));
        System.out.println("\nDopo: " + ss.toString());
    }
}
