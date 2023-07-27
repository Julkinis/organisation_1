package org.example.application;


import org.example.domain.*;
import org.example.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository ;
    @Transactional
    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }
    @Transactional
    public boolean removeDepartment(long id){
        Department dep = departmentRepository.findById(id).get();
        if (dep != null && dep.getCountStaff()==0){
            departmentRepository.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }
    @Transactional
    public Department searchDepartment(long id){
        return departmentRepository.findById(id).get();
    }

    @Transactional
    public List<Department> findByName(String name){
        return departmentRepository.findByName(name);
    }

    public void All (){
        Iterable<Department> departments = departmentRepository.findAll();
        for (Department department : departments) {
            System.out.println(department);
        }
    }
}
