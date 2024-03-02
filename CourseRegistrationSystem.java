import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    String studentID;
    String name;
    ArrayList<Course> registeredCourses = new ArrayList<>();

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }
}

public class CourseRegistrationSystem {
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        courses.add(new Course("CS101", "Introduction to Computer Science", "Fundamental concepts of programming", 30, "MWF 10:00 AM - 11:30 AM"));
        courses.add(new Course("JAVA201", "Java", "Class and objects", 25, "TTH 1:00 PM - 2:30 PM"));
courses.add(new Course("PYTHON301", "Python", "Attritubtes", 20, "TTH 4:00 PM - 5:30 PM"));
courses.add(new Course("DBMS401", "Data Base Management System", "MultiThreading ", 21, "TTH 12:00 PM - 1:30 PM"));

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Course Listing");
            System.out.println("2. Student Registration");
            System.out.println("3. Course Removal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayCourseListing();
                    break;
                case 2:
                    performStudentRegistration();
                    break;
                case 3:
                    performCourseRemoval();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
    }

    private static void displayCourseListing() {
        System.out.println("Course Listing:");
        for (Course course : courses) {
            System.out.println(course.code + " - " + course.title + " | Capacity: " + course.capacity + " | Schedule: " + course.schedule);
        }
        System.out.println();
    }

    private static void performStudentRegistration() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        String studentID = scanner.next();
        System.out.print("Enter student name: ");
        String studentName = scanner.next();

        Student student = new Student(studentID, studentName);

        System.out.println("Available Courses:");
        displayCourseListing();

        System.out.print("Enter the course code to register: ");
        String courseCode = scanner.next();

        Course selectedCourse = findCourse(courseCode);
        if (selectedCourse != null && selectedCourse.capacity > 0) {
            student.registeredCourses.add(selectedCourse);
            selectedCourse.capacity--;
            students.add(student);
            System.out.println("Registration successful!");
        } else {
            System.out.println("Course not found or no available slots.");
        }
    }

    private static void performCourseRemoval() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        String studentID = scanner.next();

        Student student = findStudent(studentID);

        if (student != null && !student.registeredCourses.isEmpty()) {
            System.out.println("Registered Courses:");
            for (Course course : student.registeredCourses) {
                System.out.println(course.code + " - " + course.title);
            }

            System.out.print("Enter the course code to remove: ");
            String courseCode = scanner.next();

            Course selectedCourse = findCourse(courseCode);
            if (selectedCourse != null && student.registeredCourses.contains(selectedCourse)) {
                student.registeredCourses.remove(selectedCourse);
                selectedCourse.capacity++;
                System.out.println("Course removal successful!");
            } else {
                System.out.println("Course not found in the student's registration.");
            }
        } else {
            System.out.println("Student not found or no registered courses.");
        }
    }

    private static Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.code.equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private static Student findStudent(String studentID) {
        for (Student student : students) {
            if (student.studentID.equals(studentID)) {
                return student;
            }
        }
        return null;
    }
}
