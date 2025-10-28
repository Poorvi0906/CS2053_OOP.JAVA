import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<String>();

        int choice;

        do {
            System.out.println(" Student List Menu ");
            System.out.println("1. Add Student");
            System.out.println("2. Insert Student at Index");
            System.out.println("3. Update Student Name");
            System.out.println("4. Remove Student");
            System.out.println("5. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    // Add student
                    System.out.print("Enter student name: ");
                    String name = input.nextLine();
                    students.add(name);
                    System.out.println(name + " has been added.");
                    displayList(students);
                    break;

                case 2:
                    // Insert student at index
                    System.out.print("Enter index to insert at: ");
                    int index = input.nextInt();
                    input.nextLine();
                    if (index >= 0 && index <= students.size()) {
                        System.out.print("Enter student name: ");
                        String newName = input.nextLine();
                        students.add(index, newName);
                        System.out.println(newName + " added at index " + index);
                    } else {
                        System.out.println("Invalid index!");
                    }
                    displayList(students);
                    break;

                case 3:
                    // Update student name
                    System.out.print("Enter the name to update: ");
                    String oldName = input.nextLine();
                    if (students.contains(oldName)) {
                        System.out.print("Enter new name: ");
                        String updatedName = input.nextLine();
                        int position = students.indexOf(oldName);
                        students.set(position, updatedName);
                        System.out.println("Name updated successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    displayList(students);
                    break;

                case 4:
                    // Remove student
                    System.out.println("Remove by: 1) Name  2) Index");
                    int removeOption = input.nextInt();
                    input.nextLine();

                    if (removeOption == 1) {
                        System.out.print("Enter student name to remove: ");
                        String removeName = input.nextLine();
                        if (students.remove(removeName)) {
                            System.out.println(removeName + " removed.");
                        } else {
                            System.out.println("Student not found!");
                        }
                    } else if (removeOption == 2) {
                        System.out.print("Enter index to remove: ");
                        int removeIndex = input.nextInt();
                        if (removeIndex >= 0 && removeIndex < students.size()) {
                            String removedStudent = students.remove(removeIndex);
                            System.out.println(removedStudent + " removed from index " + removeIndex);
                        } else {
                            System.out.println("Invalid index!");
                        }
                    } else {
                        System.out.println("Invalid option!");
                    }
                    displayList(students);
                    break;

                case 5:
                    // Display all students
                    displayList(students);
                    break;

                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        input.close();
    }

    // Method to display the list
    public static void displayList(ArrayList<String> list) {
        System.out.println("\n--- Student List ---");
        if (list.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + ": " + list.get(i));
            }
        }
    }
}

