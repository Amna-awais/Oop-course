public class StudentTest {
    public static void main(String[] args) {
      // Student 1 using constructor without ID (auto-generated)
        Student student1 = new Student("Ali Khan", "Male", "19-09-2005", "Lahore");

     // Student 2 using constructor with  ID
        Student student2 = new Student("SP25-BCS-999", "Sara Malik", "Female", "01-01-2004", "Islamabad");

        // Student 3 using copy constructor
        Student student3 = new Student(student1);

        // Print  student details
        System.out.println(" Student 1 ");
          System.out.println(student1);

           System.out.println(" Student 2 ");
        System.out.println(student2);

     System.out.println("Student 3 ");
        System.out.println(student3);

        // Check for equality
        System.out.println("Student 1 is equal to Student 3? " + student1.equals(student3));
        System.out.println("Student 1 is equal to Student 2? " +student1.equals(student2));
    }
}
