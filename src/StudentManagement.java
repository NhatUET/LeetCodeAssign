import java.util.List;

class Student {
    private String hoTen;
    private double diem;
    private String hocLuc;

    // constructor
    public Student(String hoTen, double diem, String hocLuc) {
        this.hoTen = hoTen;
        this.diem = diem;
        this.hocLuc = hocLuc;
    }

    //getter, setter
    public double getDiem() {
        return diem;
    }

    public String getHocLuc() {
        return hocLuc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public void setHocLuc(String hocLuc) {
        this.hocLuc = hocLuc;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String toString() {
        return getHoTen() + " " + getDiem() + " " + getHocLuc();
    }
}

public class StudentManagement {
    private Student[] studentList;

    public StudentManagement(Student[] list) {
        studentList = list;
    }

    public void sort() {
        for (int i = 0; i < studentList.length; i++) {
            for (int j = 0; j < i; j++) {
                if (studentList[i].getDiem() > studentList[j].getDiem()) {
                    Student tmp = studentList[i];
                    studentList[i] = studentList[j];
                    studentList[j] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Student s2 = new Student("Nam PD", 10, "gioi");
        Student s1 = new Student("vmn", 7, "kha");
        Student s3 = new Student("ttt", 2, "yeu");
        Student[] students = new Student[3];
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        StudentManagement studentManagement = new StudentManagement(students);

        studentManagement.sort();
        for (int i = 0; i < studentManagement.studentList.length; i++) {
            if (studentManagement.studentList[i] == null) continue;
            System.out.println(studentManagement.studentList[i].toString());
        }
    }
}
