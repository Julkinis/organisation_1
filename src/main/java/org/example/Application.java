package org.example;
import org.example.application.OrganisationService;
import org.example.application.StaffService;
import org.example.application.DepartmentService;
import org.example.domain.Department;
import org.example.domain.Organisation;
import org.example.domain.Staff;
import org.example.presentation.Presentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    Presentation presentation;
    @Autowired
    StaffService staffService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    OrganisationService organisationService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }
    @Override
    public void run(String... args) throws Exception {
        while (true) {
            presentation.printMenu();
            switch (presentation.inputInt()) {
                case 1:
                    departmentService.createDepartment(presentation.inputDepartment());
                    System.out.println("Отдел добавлен");
                    break;
                case 2:
                    departmentService.All();
                    System.out.println("Введите id отдела который хотите удалить");
                    if (!departmentService.removeDepartment(presentation.inputInt())){
                        System.out.println("Отдел не может быть удален");
                    } else{
                        System.out.println("Отдел удален");
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Список отделов:");
                    departmentService.All();
                    break;
                case 4:
                    System.out.println("Введите имя отдела, который хотите найти");
                    String nameDep = presentation.inputString();
                    if(departmentService.findByName(nameDep)==null){
                        System.out.println("Oтдел не найден");
                    } else {
                        Iterable<Department> departments = departmentService.findByName(nameDep);
                        for (Department department : departments) {
                            presentation.printDepartment(department);
                        }
                        break;
                    }
                case 5:
                    staffService.createStaff(presentation.inputStaff());
                    System.out.println("Сотрудник добавлен");
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Список сотрудников:");
                    staffService.All();
                    System.out.println("Введите id сотрудника которого хотите удалить");
                    Staff st = staffService.searchStaff(presentation.inputInt());
                    Department dep = st.getDepartment();
                    if (dep.getBoss() == st){
                        System.out.println("Данный сотрудник является начальником департамента");
                        System.out.println(dep.getName());
                        dep.setBoss(null);
                        dep.setCountStaff(dep.getCountStaff()-1);
                        departmentService.createDepartment(dep);
                        staffService.removeStaff(st.getId());
                        System.out.println("Сотрудник удален");
                        break;
                    }
                    staffService.removeStaff(st.getId());
                    System.out.println("Сотрудник удален");
                    break;
                case 7:
                    System.out.println();
                    System.out.println("Список сотрудников:");
                    staffService.All();
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Введите id сотрудника, которого хотите найти");
                    Integer id_st = presentation.inputInt();
                    if (staffService.searchStaff(id_st)==null){
                        System.out.println("Cотрудник не найден");
                    } else{
                        presentation.printStaff(staffService.searchStaff(id_st));
                        break;
                    }
                    break;
                case 9:
                    organisationService.createOrganisation(presentation.inputOrganisation());
                    System.out.println("Организация добавлена");
                    break;
                case 10:
                    System.out.println("Список организаций:");
                    organisationService.All();
                    System.out.println();
                    System.out.println("Введите id организации, которую хотите удалить");
                    organisationService.removeOrganisation(presentation.inputInt());
                    System.out.println("Организация удалена");
                    break;
                case 11:
                    System.out.println("Список организаций:");
                    organisationService.All();
                    System.out.println();
                    break;
                case 12:
                    System.out.println("Введите название организации, которую хотите найти");
                    String nameOrg = presentation.inputString();
                    if(organisationService.findByName(nameOrg)==null){
                        System.out.println("Орагнизация не найдена");
                    } else {
                        Iterable<Organisation> organisations = organisationService.findByName(nameOrg);
                        for (Organisation organisation : organisations) {
                            presentation.printOrganisation(organisation);
                        }
                        break;
                    }

                case 13:
                    System.out.println("Введите id отдела, которому хотите назначить начальника: ");
                    System.out.println();
                    System.out.println("Список отделов:");
                    departmentService.All();
                    System.out.println();
                    presentation.addBossDepartment(departmentService.searchDepartment(presentation.inputInt()));
                    break;
                case 14:
                    System.out.println("Введите id организации, которой хотите назначить начальника: ");
                    System.out.println();
                    System.out.println("Список организаций:");
                    organisationService.All();
                    System.out.println();
                    presentation.addBossOrganisation(organisationService.searchOrganisation(presentation.inputInt()));
                    break;
            }
        }
    }
}