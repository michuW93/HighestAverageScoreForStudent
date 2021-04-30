import java.util.*;

public class Main {
    static String[][] scores = {{"Bob", "85"}, {"Mark", "100"}, {"Charles", "63"}, {"Mark", "34"}};

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (String[] score : scores) {
            String name = score[0];
            int currentScore = Integer.parseInt(score[1]);

            Student student = findStudentByName(name, students);
            if (student != null) {
                student.setNumberOfScores(student.getNumberOfScores() + 1);
                student.setSumOfScores(student.getSumOfScores() + currentScore);
            } else {
                student = new Student(name, 1, currentScore);
                students.add(student);
            }
        }
        findStudentWithBestAverage(students);
    }

    private static void findStudentWithBestAverage(List<Student> students) {
        Student bestStudent = null;
        int bestAverage = 0;
        for (int i = 0; i < students.size(); i++) {
            if ((students.get(i).getSumOfScores() / students.get(i).getNumberOfScores()) > bestAverage) {
                bestStudent = students.get(i);
                bestAverage = (students.get(i).getSumOfScores() / students.get(i).getNumberOfScores());
            }
        }
        System.out.println(bestStudent + " with average: " + bestAverage);
    }

    private static Student findStudentByName(String name, List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                return students.get(i);
            }
        }
        return null;
    }

    public static class Student {
        private String name;
        private int numberOfScores;
        private int sumOfScores;

        public Student(String name, int numberOfScores, int sumOfScores) {
            this.name = name;
            this.numberOfScores = numberOfScores;
            this.sumOfScores = sumOfScores;
        }

        public String getName() {
            return name;
        }

        public int getNumberOfScores() {
            return numberOfScores;
        }

        public void setNumberOfScores(int numberOfScores) {
            this.numberOfScores = numberOfScores;
        }

        public int getSumOfScores() {
            return sumOfScores;
        }

        public void setSumOfScores(int sumOfScores) {
            this.sumOfScores = sumOfScores;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return name.equals(student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", numberOfScores=" + numberOfScores +
                    ", sumOfScores=" + sumOfScores +
                    '}';
        }
    }
}
