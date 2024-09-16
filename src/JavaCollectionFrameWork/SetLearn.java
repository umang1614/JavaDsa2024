package JavaCollectionFrameWork;
import java.util.*;

class Student{
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
public class SetLearn {
    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>();   UNORDERED SET
//        Set<Integer> set = new LinkedHashSet<>();   ORDERED SET
//        Set<Integer> set = new TreeSet<>();    //SORTED ORDER SET
//        set.add(60);
//        set.add(10);
//        set.add(70);
//        set.add(20);
//        System.out.println(set);
//        System.out.println(set.remove(10));
//        System.out.println(set);

        Set<Student> st = new HashSet<>();
        st.add(new Student(1,"Umang"));
        st.add(new Student(1,"Umang"));
        st.add(new Student(1,"Umang"));

        System.out.println(st);

    }
}
