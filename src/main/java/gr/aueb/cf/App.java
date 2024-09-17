package gr.aueb.cf;

import gr.aueb.cf.model.Course;
import gr.aueb.cf.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Objects;

public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school1PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        // Select all teachers
//        String sql = "SELECT t FROM Teacher t";
//        TypedQuery<Teacher> query = em.createQuery(sql, Teacher.class);
//        List<Teacher> teachers = query.getResultList();

        // Select all courses
//        String sql2 = "SELECT c FROM Course c";
//        TypedQuery<Course> query2 = em.createQuery(sql2, Course.class);
//        List<Course> courses = query2.getResultList();

        // Select courses taught by Αθανάσιος
//        String sql3 = "SELECT c FROM Course c WHERE c.teacher.firstname = :firstname";
//        TypedQuery<Course> query3 = em.createQuery(sql3, Course.class);
//        query3.setParameter("firstname", "Αθανάσιος");
//        List<Course> courses3 = query3.getResultList();

        // Select teachers & course.titles they teach
//        String sql4 = "SELECT t, c.title FROM Teacher t JOIN t.courses c";
//        TypedQuery<Object[]> query4 = em.createQuery(sql4, Object[].class);
//        List<Object[]> teachersCourseTitles = query4.getResultList();

        // Select teachers that teach Java
//        String sql5 = "SELECT t FROM Teacher t JOIN t.courses c WHERE c.title = :courseTitle";
//        TypedQuery<Teacher> query5 = em.createQuery(sql5, Teacher.class);
//        query5.setParameter("courseTitle", "Java");
//        List<Teacher> teachersJava = query5.getResultList();

        // Select teacher.firstname, lastname , count of courses they teach
//        String sql6 = "SELECT t, COUNT(c) FROM Teacher t JOIN t.courses c GROUP BY t";
//        TypedQuery<Object[]> query6 = em.createQuery(sql6, Object[].class);
//        List<Object[]> teachersCoursesCount = query6.getResultList();

        // Select teachers that teach more than one courses
//        String sql7 = "SELECT t FROM Teacher t JOIN t.courses c GROUP BY t HAVING COUNT(c) > 1";
//        TypedQuery<Teacher> query7 = em.createQuery(sql7, Teacher.class);
//        List<Teacher> teachersMoreThanOneCourses = query7.getResultList();

        // Select teachers & courses they teach ordered by lastname, title
//        String sql8 = "SELECT t, c FROM Teacher t JOIN t.courses c ORDER BY t.lastname ASC, c.title ASC";
//        TypedQuery<Object[]> query8 = em.createQuery(sql8, Object[].class);
//        List<Object[]> teachersCoursesOrdered = query8.getResultList();

        // Select teachers that do not teach a course
//        String sql9 = "SELECT t FROM Teacher t LEFT JOIN t.courses c WHERE c IS NULL";
//        TypedQuery<Teacher> query9 = em.createQuery(sql9, Teacher.class);
//        List<Teacher> teacherWithNoCourse = query9.getResultList();

        // Select the most popular courses by teachers' count
        String sql10 = "SELECT c.title, COUNT(t) FROM Course c JOIN c.teacher t GROUP BY c.title ORDER BY COUNT(t) DESC";
        TypedQuery<Object[]> query10 = em.createQuery(sql10, Object[].class);
        List<Object[]> popularCourses = query10.getResultList();

        em.getTransaction().commit();

        for (Object[] row : popularCourses) {
            for (Object item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

        //teacherWithNoCourse.forEach(System.out::println);
//        for (Object[] row : teachersCoursesOrdered) {
//            for (Object item : row) {
//                System.out.print(item + " ");
//            }
//            System.out.println();
//        }

        //teachersMoreThanOneCourses.forEach(System.out::println);

//        for (Object[] row : teachersCoursesCount) {
//            for (Object item : row) {
//                System.out.print(item + " ");
//            }
//            System.out.println();
//        }

        //teachersJava.forEach(System.out::println);

        //        for (Object[] row : teachersCourseTitles) {
//            for (Object item : row) {
//                System.out.print(item + " ");
//            }
//            System.out.println();
//        }

        //courses3.forEach(System.out::println);
        //courses.forEach(System.out::println);

        // teachers.forEach(System.out::println);








        em.close();
        emf.close();
    }
}
