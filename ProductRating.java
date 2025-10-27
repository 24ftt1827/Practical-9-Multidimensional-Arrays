
    import java.util.Scanner;

public class ProductRating {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int[][] feedback = new int[4][3];
        
        String[] criteria = {"Product", "Packaging", "Delivery"};
        int numCustomers = feedback.length;
        int numCriteria = feedback[0].length;
        
        
        System.out.println("Enter customer feedback ratings (1-5):");
        System.out.println("======================================");
        
        for (int i = 0; i < numCustomers; i++) {
            System.out.println("\nCustomer " + (i + 1) + ":");
            for (int j = 0; j < numCriteria; j++) {
                System.out.print("  " + criteria[j] + " rating: ");
                feedback[i][j] = input.nextInt();
            }
        }
        
  
        System.out.println("\n\nRating\t\tProduct\t\tPackaging\tDelivery\tAverage");
        System.out.println("================================================================");
        
  
        for (int i = 0; i < numCustomers; i++) {
            System.out.print("Customer " + (i + 1) + "\t");
            
            int sum = 0;
            for (int j = 0; j < numCriteria; j++) {
                System.out.print(feedback[i][j] + "\t\t");
                sum += feedback[i][j];
            }
            
  
            double customerAvg = (double) sum / numCriteria;
            System.out.printf("%.2f\n", customerAvg);
        }
        
  
        System.out.println("================================================================");
        
  
        System.out.print("Average\t\t");
        for (int j = 0; j < numCriteria; j++) {
            int sum = 0;
            for (int i = 0; i < numCustomers; i++) {
                sum += feedback[i][j];
            }
            double criterionAvg = (double) sum / numCustomers;
            System.out.printf("%.2f\t\t", criterionAvg);
        }
        
  
        int totalSum = 0;
        for (int i = 0; i < numCustomers; i++) {
            for (int j = 0; j < numCriteria; j++) {
                totalSum += feedback[i][j];
            }
        }
        double overallAvg = (double) totalSum / (numCustomers * numCriteria);
        System.out.printf("%.2f\n", overallAvg);
        
        input.close();
    }
}
