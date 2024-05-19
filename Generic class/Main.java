//liran trahter 206606782 

package Q1;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		Student s1 = new Student("Liran", "Trahter", "206606782", "1998");
		Student s2 = new Student("Marina", "Trahter", "314267519", "1970");
		Student s3 = new Student("Boris", "Trahter", "314267493", "1962");
		Student[] students = {s1, s2, s3};
		Integer[] GPA = new Integer[]{100, 90, 80};
        AssociationTable<Student, Integer> assoTable;
        try {
            assoTable = new AssociationTable<>(students,GPA);
            Student s4 = new Student("May","Trahter","314267600","1942");
            assoTable.add(s4, 20);
            assoTable.remove(s2);
            assoTable.add(s1, 20);
            Iterator<Entry<Student, Integer>> iter = assoTable.keyIterator();
            while(iter.hasNext()) {
                Map.Entry<Student,Integer> next = iter.next();
                System.out.println("key - student: " + next.getKey());
                System.out.println("value - GPA: " + next.getValue() + "\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // arrays not the same size
        }
		
	}

}
