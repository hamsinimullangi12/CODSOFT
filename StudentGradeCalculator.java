import java.util.Scanner;

class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of Subjects:");
        int n = sc.nextInt();
        int[] marks = new int[n];

        System.out.println("Enter marks obtained in each subject (out of 100):");
        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

       
        int totalMarks = 0;
        for (int i = 0; i < n; i++) {
            totalMarks += marks[i];
        }

        
        double averagePercentage = (double) totalMarks / n;

      
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");


        if (averagePercentage >= 90) {
            System.out.println("Grade: A");
        } else if (averagePercentage >= 80) {
            System.out.println("Grade: B");
        } else if (averagePercentage >= 70) {
            System.out.println("Grade: C");
        } else if (averagePercentage >= 60) {
            System.out.println("Grade: D");
        } else if (averagePercentage >= 50) {
            System.out.println("Grade: E");
        } else {
            System.out.println("Grade: Fail");
        }
    }
}
