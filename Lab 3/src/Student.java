public class Student {
    // Static counter for auto ID generation
    private static int counter = 1;

    // Declare attributes
    private String studentId;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String address;

    // ======== Constructors ========

    // 1. Default Constructor
    public Student() {
        this.studentId = generateId();
        this.name = "";
        this.gender = "";
        this.dateOfBirth = "";
        this.address = "";
    }

    // 2. Parameterized Constructor with ID
    public Student(String studentId, String name, String gender, String dateOfBirth, String address) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    // 3. Parameterized Constructor without ID (auto-generated)
    public Student(String name, String gender, String dateOfBirth, String address) {
        this.studentId = generateId();
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    // 4. Copy Constructor
    public Student(Student other) {
        this.studentId = other.studentId;
        this.name = other.name;
        this.gender = other.gender;
        this.dateOfBirth = other.dateOfBirth;
        this.address = other.address;
    }

    // ======== ID Generator ========
    private String generateId() {
        return String.format("SP25-BCS-%03d", counter++);
    }

    // ======== Getters ========
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    // ======== Setters ========
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // ======== equals() method ========
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;

        Student s = (Student) obj;

        return this.name.equals(s.name) &&
               this.gender.equals(s.gender) &&
               this.dateOfBirth.equals(s.dateOfBirth) &&
               this.address.equals(s.address);
    }

    // ======== toString() method ========
    @Override
    public String toString() {
        return String.format(
            "ID: %s\nName: %s\nGender: %s\nDate of Birth: %s\nAddress: %s\n",
            studentId, name, gender, dateOfBirth, address
        );
    }
}
