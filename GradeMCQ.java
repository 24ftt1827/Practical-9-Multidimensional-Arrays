
    import java.util.Scanner;

public class GradeMCQ {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        char[][] studentAnswers = {
            {'A', 'B', 'A', 'C', 'C', 'D'},  
            {'D', 'B', 'A', 'B', 'C', 'A'},  
            {'E', 'D', 'D', 'A', 'C', 'B'},  
            {'A', 'B', 'D', 'C', 'C', 'D'}   
        };
        
    
        char[] answerKey = new char[6];
        
        
        System.out.println("Enter the answer key (6 questions no space):");
        System.out.print("Answer key: ");
        String keyInput = input.nextLine().toUpperCase();
        
        
        for (int i = 0; i < 6; i++) {
            answerKey[i] = keyInput.charAt(i);
        }
        
        System.out.println("\n=== MCQ Test Results ===\n");
        
        int numStudents = studentAnswers.length;
        int numQuestions = studentAnswers[0].length;
        int passingScore = 4; 
        
        for (int i = 0; i < numStudents; i++) {
            int counter = 0; 
            
            System.out.println("Student " + (i + 1) + ":");
            System.out.print("Answers: ");
            
            
            for (int j = 0; j < numQuestions; j++) {
                System.out.print(studentAnswers[i][j] + " ");
            }
            System.out.println();
            
            
            for (int j = 0; j < numQuestions; j++) {
            
                for (int k = 0; k < 1; k++) {
                    if (studentAnswers[i][j] == answerKey[j]) {
                        counter++;
                    }
                }
            }
            
            
            System.out.println("Correct answers: " + counter + " out of " + numQuestions);
            
            
            if (counter >= passingScore) {
                System.out.println("Result: PASS");
            } else {
                System.out.println("Result: FAIL");
            }
            System.out.println();
        }
        
        
        System.out.println("Answer Key: ");
        for (int i = 0; i < numQuestions; i++) {
            System.out.print(answerKey[i] + " ");
        }
        System.out.println();
        
        input.close();
    }
}

