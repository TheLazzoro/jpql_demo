package facades;

import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Facade implements IFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    @Override
    public List<Employee> getAllEmployees() {
        //return null;
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Employee> tq = em.createQuery("Select e from Employee e", Employee.class);
            return tq.getResultList();
        }finally {
            em.close();
        }
    }

    @Override
    public Employee getHighestPaid() {
        EntityManager em = emf.createEntityManager();

        try {
            // desc means descending, as in descending order
            TypedQuery<Employee> tq = em.createQuery("select e from Employee e order by e.salery desc", Employee.class);
            return tq.getResultList().get(0);
        }finally {
            em.close();
        }
    }

    @Override
    public Double getAverageSalery() {
        return null;
    }

    @Override
    public List<Employee> getAllBelowAverage() {
        return null;
    }

    @Override
    public Department getWithMostEmployees() {
        return null;
    }

    @Override
    public Department getMostExpensiveSalarySum() {
        return null;
    }

    @Override
    public List<Department> getDepartmentsWithEmpNamed(String name) {
        return null;
    }

    public Employee update(Employee e) {
        EntityManager em = emf.createEntityManager();

        // It's important to not merge null values in case Employee 'e' is and incomplete class
        // So what we do is get the employee from the database and re-insert those same values again.
        Employee found = em.find(Employee.class, e.getId());
        String name = e.getName();
        if(name != null)
            found.setName(name);

        try {
            em.getTransaction().begin();
            em.merge(found);
            em.getTransaction().commit();
        }finally {
            em.close();
        }

        return found;
    }
}
