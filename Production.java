/**
 * @Author Vladimir Hardy
 * @TODO Create a database Table for Production, display available products to record
 */
package sample;

import java.util.Scanner;
import java.time.LocalDate;

public class Production {

    public void produce(Scanner input) {

        String[] sampleItems = {"Apple, iPod, AU", "Windows, Macbook, VI"};
        for (int i = 0; i<sampleItems.length; i++) {
            System.out.println(i + 1 + ". " + sampleItems[i]);
        }
        System.out.println("Select an item to produce: ");
        int itemChoice = input.nextInt();
        //Produce that item x number of times and save to a Database
        System.out.println("Enter the amount of items that have been produced: ");
        int numItemsToProduce = input.nextInt();

        LocalDate date = LocalDate.now();
        String manufacturedOn = date.toString();
        System.out.println(manufacturedOn);
        String productionRun;
        for(int i = 1; i<=numItemsToProduce; i++) {
            productionRun = i + ". " + sampleItems[itemChoice-1];
            System.out.println(productionRun);
        }


    }
}
