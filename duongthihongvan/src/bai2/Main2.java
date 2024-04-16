package bai2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import duongthihongvan.Classroom;
import duongthihongvan.Student;

public class Main2 {
	public static void main(String[] args) {
		
		
        ArrayList<Classroom> classrooms = readClassroomsFromFile("classroom.txt");
        System.out.println("Total classrooms: " + classrooms.size());
        System.out.println("Classrooms:");
        for (Classroom classroom : classrooms) {
            System.out.println(classroom);
        }

        ArrayList<Student> students = readStudentsFromFile("student.txt");
        System.out.println("\nTotal students: " + students.size());
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort students by name
        Collections.sort(students, Comparator.comparing(Student::getName));
        System.out.println("\nStudents sorted by name:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static ArrayList<Classroom> readClassroomsFromFile(String fileName) {
        ArrayList<Classroom> classrooms = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String code = parts[1];
                classrooms.add(new Classroom(id, code));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classrooms;
    }

    private static ArrayList<Student> readStudentsFromFile(String fileName) {
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                int classId = Integer.parseInt(parts[3]);
                students.add(new Student(id, name, age, new Classroom(classId)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

}
