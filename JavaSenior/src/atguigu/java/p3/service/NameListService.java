package atguigu.java.p3.service;

import atguigu.java.p3.domain.*;

/**
 * v1.0
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {

            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch (type) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;

                case Data.PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;

                case Data.DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;

                case Data.ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }
    }

    //获得指定员工设备
    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        String model = Data.EQUIPMENTS[index][1];
        String display = Data.EQUIPMENTS[index][2];

        switch (type) {
            case Data.PC://21
                return new PC(model, display);
            case Data.NOTEBOOK://22
                double prise = Double.parseDouble(Data.EQUIPMENTS[index][2]);
                return new NoteBook(model, prise);
            case Data.PRINTER://23
                return new Printer(model, display);//name type
        }
        return null;
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId()==id){
                return employees[i];
            }
        }
        throw new TeamException("找不到指定的员工");
    }
}
