package BusinessLogic;

import BusinessLogic.KitchenTask.cookingTask;

public class CatERing {
    public static void main(String[] args) {
        cookingTask ct = new cookingTask();
        ct = ct.createCookingTask(null, null, 2, 5, null, null, 15 );
        System.out.println(ct.toString());
        //System.out.println("Hello World");
    }
}
