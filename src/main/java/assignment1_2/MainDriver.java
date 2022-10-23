package assignment1_2;

/**
 * @author Megan Ryan
 * b)
 * A second Gradle project adds the project release in part a) as a dependency using Jitpack,
 * i.e. pulling it from the GitHub repository on demand and providing you with the artefacts on
 * demand (see also Additional Guidelines).
 * Part b) acts as a driver project, creating a handful of fictional students with mock data,
 * adding the students to a number of modules and adding a number of modules to a course.
 * Further on, the program should print out a list of all the courses, their respective modules,
 * and all students, their usernames, assigned modules and the course(s) they are registered
 * for to the console. Again, use Git and GitHub to set up a local / global repository
 */

import org.joda.time.DateTime;

import java.util.ArrayList;

public class MainDriver {

    public static void main(String[] args) {
        //students B, D and E to be added to course programme 1 with its associated modules
        //students A and C to be added to cp2

        ArrayList<CourseProgramme> courses = new ArrayList<CourseProgramme>();
        ArrayList<Student> students1 = new ArrayList<Student>();
        ArrayList<Student> students2 = new ArrayList<Student>();
        ArrayList<Module> modulesCP1 = new ArrayList<Module>();
        ArrayList<Module> modulesCP2 = new ArrayList<Module>();
        ArrayList<Module> modulesL1 = new ArrayList<Module>();
        ArrayList<Module> modulesL2 = new ArrayList<Module>();
        ArrayList<Module> modulesL3 = new ArrayList<Module>();
        ArrayList<Module> modulesL4 = new ArrayList<Module>();

        //start and end date for both courses
        DateTime startDate = new DateTime(2019, 9, 2, 0, 0);
        DateTime endDate = new DateTime(2022, 8, 25, 0, 0);

        CourseProgramme cp1 = new Course("Electronic and Computer Engineering", modulesCP2, students1, startDate, endDate);
        CourseProgramme cp2 = new Course("Computer Science & IT", modulesCP2, students2, startDate, endDate);

        // DOBs of students
        DateTime dateA = new DateTime(2000,9,28,0,0);
        DateTime dateB = new DateTime(2001,4,5,0,0);
        DateTime dateC = new DateTime(1994,3,13,0,0);
        DateTime dateD = new DateTime(1999,02,14,0,0);
        DateTime dateE = new DateTime(2000,02,11,0,0);

        Student studentA = new Student("Merrin", 19666999, dateA);
        Student studentB = new Student("Cal", 19420543, dateB);
        Student studentC = new Student("Greez", 13526742, dateC);
        Student studentD = new Student("Cere", 18321561, dateD);
        Student studentE = new Student("Trilla", 19350756, dateE);

        students1.add(studentB);
        students1.add(studentD);
        students1.add(studentE);

        students2.add(studentA);
        students2.add(studentC);

        Module module1 = new Module("Software Engineering III", "CT417", students1, courses);
        Module module2 = new Module("Mobile Networks Architectures and Systems", "EE4101", students1, courses);
        Module module3 = new Module("Embedded Systems Applications Programming", "EE347", students1, courses);
        Module module4 = new Module("Digital Signal Processing", "EE445", students1, courses);
        Module module5 = new Module("Computer Science III", "CT666", students2, courses);

        //all students in module1
        module1.addStudents(students2);

        // adding to array that holds all modules in course 1
        modulesCP1.add(module1);
        modulesCP1.add(module2);
        modulesCP1.add(module3);
        modulesCP1.add(module4);

        // adding to array that holds all modules in course 1
        modulesCP1.add(module1);
        modulesCP1.add(module5);

        modulesL1.add(module1);
        modulesL2.add(module2);
        modulesL3.add(module3);
        modulesL3.add(module4);
        modulesL4.add(module5);

        //DOBs of lecturers
        DateTime dateLA = new DateTime(1968,6,28,0,0);
        DateTime dateLB = new DateTime(1984,2,16,0,0);
        DateTime dateLC = new DateTime(1991,11,10,0,0);
        DateTime dateLD = new DateTime(1982,12,3,0,0);

        Lecturer lecturer1 = new Lecturer("Yoda", 44, 992103, modulesL1);
        Lecturer lecturer2 = new Lecturer("Mace", 38, 975632, modulesL2);
        Lecturer lecturer3 = new Lecturer("Obi-Wan", 31, 903845, modulesL3);
        Lecturer lecturer4 = new Lecturer("Dooku", 40, 910568, modulesL4);

        // add lecturers to modules
        module1.addLecturer(lecturer1);
        module2.addLecturer(lecturer2);
        module3.addLecturer(lecturer3);
        module4.addLecturer(lecturer3);
        module5.addLecturer(lecturer4);

        // add modules to students according to the course they're in
        studentA.addModules(modulesCP2);
        studentB.addModules(modulesCP1);
        studentC.addModules(modulesCP2);
        studentD.addModules(modulesCP1);
        studentE.addModules(modulesCP1);

        // add modules to courseprogrammes
        cp1.addModules(modulesCP1);
        cp2.addModules(modulesCP2);

        // add students to courseprogrammes
        cp1.addStudents(students1);
        cp2.addStudents(students2);

        System.out.print("List of courses, and their respective modules:\n");
        System.out.print(cp1.getCourseName() +" modules: " +cp1.getModules() +"\n");
        System.out.print(cp1.getCourseName() +" modules: " +cp1.getModules() +"\n\n");

        System.out.print("List of students, and their respective usernames, assigned modules and their course:\n");
        System.out.print(studentA.getName() +":\n");
        System.out.print("Username: " +studentA.getUserName() +"\n");
        System.out.print("Modules: " +studentA.getModules() +"\n");
        System.out.print("Course name: " +studentA.getCourses() +"\n\n");

        System.out.print(studentB.getName() +":\n");
        System.out.print("Username: " +studentB.getUsername() +"\n");
        System.out.print("Modules: " +studentB.getModules() +"\n");
        System.out.print("Course name: " +studentB.getCourses() +"\n\n");

        System.out.print(studentC.getName() +":\n");
        System.out.print("Username: " +studentC.getUsername() +"\n");
        System.out.print("Modules: " +studentC.getModules() +"\n");
        System.out.print("Course name: " +studentC.getCourses() +"\n\n");

        System.out.print(studentD.getName() +":\n");
        System.out.print("Username: " +studentD.getUsername() +"\n");
        System.out.print("Modules: " +studentD.getModules() +"\n");
        System.out.print("Course name: " +studentD.getCourses() +"\n\n");

        System.out.print(studentE.getName() +":\n");
        System.out.print("Username: " +studentE.getUsername() +"\n");
        System.out.print("Modules: " +studentE.getModules() +"\n");
        System.out.print("Course name: " +studentE.getCourses() +"\n\n");


    }
}
