package FSD_Basic;

class Course {
    static int maxCapacity = 100;
    String courseName;
    int enrollments;

    String[] enrolledStudents;

    Course(String courseName) {
        this.courseName = courseName;
        this.enrollments = 0;
        this.enrolledStudents = new String[maxCapacity];
    }

    static void setMaxCapacity(int maxCapacity) {
        Course.maxCapacity = maxCapacity;
    }

    void enrollStudent(String studentName) {
        enrolledStudents[enrollments] = studentName;
        enrollments++;
    }

    void unenrollStudent(String studentName) {
        if(enrollments == 0)
            System.out.println("nothing to delete");
        String[] enrolledStudentsNew = new String[maxCapacity-1];
        for (int i = 0, k = 0; i < enrolledStudents.length; i++) {

            // if the index is
            // the removal element index
            if (enrolledStudents[i].equals( studentName)) {
                continue;
            }

            // if the index is not
            // the removal element index
            enrolledStudentsNew[k++] = enrolledStudents[i];
        }
        System.out.println("Student removed");
        enrollments--;
        for (String s : enrolledStudentsNew) {
            System.out.println(s);
        }
    }

}
