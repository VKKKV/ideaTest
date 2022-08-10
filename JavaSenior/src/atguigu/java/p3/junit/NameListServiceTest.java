package atguigu.java.p3.junit;

import atguigu.java.p3.service.NameListService;
import atguigu.java.p3.service.TeamException;
import atguigu.java.p3.domain.Employee;
import org.junit.jupiter.api.Test;

public class NameListServiceTest {
    @Test
    public void testGetAllEmployees() {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee() {
        NameListService service = new NameListService();
        int id = 1;
        id=10;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

}
