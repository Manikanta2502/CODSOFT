import java.util.Scanner;

public class RegistrationSystem {
    public static void main(String[] args) {
        CourseDatabase courseDatabase = new CourseDatabase();
        StudentDatabase studentDatabase = new StudentDatabase();

        // Create some sample courses
        Course course1 = new Course("CS101", "Introduction to Computer Science", "Basic computer science concepts", 30, "Mon/Wed 9:00 AM - 10:30 AM");
        Course course2 = new Course("MATH202", "Calculus II", "Advanced calculus topics", 25, "Tue/Thu 11:00 AM - 12:30 PM");
        Course course3 = new Course("ENG303", "Advanced English Literature", "In-depth study of English literature", 20, "Mon/Fri 2:00 PM - 3:30 PM");

        // Add courses to the database
        courseDatabase.addCourse(course1);
        courseDatabase.addCourse(course2);
        courseDatabase.addCourse(course3);
        
        // Create some sample students
        Student student1 = new Student(1, "Vijay");
        Student student2 = new Student(2, "Adarsh");
        Student student3 = new Student(3, "Charan");
        Student student4 = new Student(4, "Manikanta");

        // Add students to the database
        studentDatabase.addStudent(student1);
        studentDatabase.addStudent(student2);
        studentDatabase.addStudent(student3);
        studentDatabase.addStudent(student4);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Course Registration System Menu:");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Display available courses
                    System.out.println("Available Courses:");
                    for (Course course : courseDatabase.getCourses()) {
                        System.out.println("Course Code: " + course.getCourseCode());
                        System.out.println("Title: " + course.getTitle());
                        System.out.println("Description: " + course.getDescription());
                        System.out.println("Capacity: " + course.getCapacity());
                        System.out.println("Available Slots: " + course.getAvailableSlots());
                        System.out.println("Schedule: " + course.getSchedule());
                        System.out.println("--------------");
                    }
                    break;

                case 2:
                    // Register for a course
                    System.out.print("Enter your student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Student student = null;
                    for (Student s : studentDatabase.getStudents()) {
                        if (s.getStudentId() == studentId) {
                            student = s;
                            break;
                        }
                    }

                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    // Display available courses
                    System.out.println("Available Courses:");
                    for (Course course : courseDatabase.getCourses()) {
                        System.out.println("Course Code: " + course.getCourseCode());
                        System.out.println("Title: " + course.getTitle());
                        System.out.println("Description: " + course.getDescription());
                        System.out.println("Capacity: " + course.getCapacity());
                        System.out.println("Available Slots: " + course.getAvailableSlots());
                        System.out.println("Schedule: " + course.getSchedule());
                        System.out.println("--------------");
                    }

                    System.out.print("Enter the course code to register: ");
                    String courseCode = scanner.nextLine();

                    Course selectedCourse = null;
                    for (Course course : courseDatabase.getCourses()) {
                        if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                            selectedCourse = course;
                            break;
                        }
                    }

                    if (selectedCourse == null) {
                        System.out.println("Course not found.");
                        break;
                    }

                    student.registerCourse(selectedCourse);
                    System.out.println("Registration successful.");
                    break;

                case 3:
                    // Drop a course
                    System.out.print("Enter your student ID: ");
                    studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    student = null;
                    for (Student s : studentDatabase.getStudents()) {
                        if (s.getStudentId() == studentId) {
                            student = s;
                            break;
                        }
                    }

                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter the course code to drop: ");
                    courseCode = scanner.nextLine();

                    selectedCourse = null;
                    for (Course course : student.getRegisteredCourses()) {
                        if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                            selectedCourse = course;
                            break;
                        }
                    }

                    if (selectedCourse == null) {
                        System.out.println("Course not found in your registrations.");
                        break;
                    }

                    student.dropCourse(selectedCourse);
                    System.out.println("Course dropped successfully.");
                    break;

                case 4:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
