package org.example.presentation;
 import org.example.application.OrganisationService;
 import org.example.domain.*;
import org.example.application.DepartmentService;

import org.example.application.StaffService;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 import java.util.*;

@Component
public class Presentation {

    Scanner scanner = new Scanner(System.in);
    @Autowired
    DepartmentService departmentService;
    @Autowired
    StaffService staffService;
    @Autowired
    OrganisationService organisationService;

    public Integer inputInt() {
        Integer input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public String inputString() {
        return scanner.nextLine();
    }

    public void printMenu() {
        System.out.println();
        System.out.println("1. Добавить отдел");
        System.out.println("2. Удалить отдел");
        System.out.println("3. Вывести информацию об отделах ");
        System.out.println("4. Информация об отделе по имени");
        System.out.println("5. Добавить сотрудника");
        System.out.println("6. Удалить сотрудника");
        System.out.println("7. Вывести информацию о сотрудниках");
        System.out.println("8. Информация о сотруднике по id");
        System.out.println("9. Добавить организацию");
        System.out.println("10. Удалить организацию");
        System.out.println("11. Вывести информацию об организациях ");
        System.out.println("12. Информация об организации по имени");
        System.out.println("13: Назначить начальника отдела");
        System.out.println("14: Назначить начальника организации");
        System.out.println();
    }
    public Staff inputStaff() {
        Staff staff = new Staff();
        System.out.println("Введите имя сотрудника: ");
        staff.setFirstName(inputString());
        System.out.println("Введите фамилию сотрудника: ");
        staff.setLastName(inputString());
        System.out.println("Введите отчество сотрудника: ");
        staff.setPatronymic(inputString());
        System.out.println("Введите адрес сотрудника: ");
        staff.setAddress(inputString());
        System.out.println("Введите дату рождения сотрудника: ");
        staff.setBirthDate(inputString());
        System.out.println("Введите должность сотрудника: ");
        staff.setPost(inputString());
        System.out.println("Введите id отдела сотрудника: ");
        departmentService.All();
        Department department = departmentService.searchDepartment(inputInt());
        staff.setDepartment(department);
        department.setCountStaff(department.getCountStaff() + 1);
        departmentService.createDepartment(department);
        return staff;
    }
    public Department inputDepartment() {
        Department department = new Department();
        System.out.println("Введите название отдела: ");
        department.setName(inputString());
        department.setCountStaff(0);
        System.out.println("Введите комнаты: ");
        department.setRooms(inputString());
        System.out.println("Введите id начальника отдела или 0, чтобы пропустить ");
        staffService.All();
        long i = inputInt();
        if (i == 0) {
            department.setBoss(null);
        } else {
            department.setBoss(staffService.searchStaff(i));
        }
        return department;
    }

    public void addBossDepartment(Department department) {
        System.out.println("Выберите сотрудника, введите id");
        staffService.All();
        department.setBoss(staffService.searchStaff(inputInt()));
        departmentService.createDepartment(department);
        System.out.println("Начальник добавлен");

    }
    public void addBossOrganisation(Organisation organisation) {
        System.out.println("Выберите сотрудника, введите id");
        staffService.All();
        organisation.setBoss(staffService.searchStaff(inputInt()));
        organisationService.createOrganisation(organisation);
        System.out.println("Начальник добавлен");
    }
    public Organisation inputOrganisation() {
        Organisation organisation = new Organisation();
        System.out.println("Введите название организации: ");
        organisation.setName(inputString());
        System.out.println("Введите адрес: ");
        organisation.setAddress(inputString());
        System.out.println("Список сотрудников: ");
        staffService.All();
        System.out.println("Введите id начальника организации или 0, чтобы пропустить");
        long i = inputInt();
        if (i == 0) {
            organisation.setBoss(null);
        } else {
            organisation.setBoss(staffService.searchStaff(i));
        }
        return organisation;
    }

    public void printStaff(Staff staff) {
        System.out.println();
        System.out.println("ID: " + staff.getId());
        System.out.println("Фамилия: " + staff.getLastName());
        System.out.println("Имя: " + staff.getFirstName());
        System.out.println("Отчество: " + staff.getPatronymic());
        System.out.println("Адрес: " + staff.getAddress());
        System.out.println("Дата рождения: " + staff.getBirthDate());
        System.out.println("Должность: " + staff.getPost());
        System.out.println("Отдел: " + staff.getDepartment().getName());
        System.out.println();
    }

    public void printDepartment(Department department) {
        System.out.println();
        System.out.println("ID: " + department.getId());
        System.out.println("Название: " + department.getName());
        System.out.println("Количество сотрудников: " + department.getCountStaff());
        System.out.println("Комнаты: " + department.getRooms());
        System.out.println("Начальник: " + department.getBoss());
        System.out.println();
    }

    public void printOrganisation(Organisation organisation) {
        System.out.println();
        System.out.println("ID: " + organisation.getId());
        System.out.println("Название: " + organisation.getName());
        System.out.println("Адрес: " + organisation.getAddress());
        System.out.println("Начальник: " + organisation.getBoss());
        System.out.println();
    }
}
