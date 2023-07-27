package org.example.application;

import org.example.domain.Organisation;
import org.example.domain.Staff;
import org.example.domain.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;
    @Transactional
    public Staff createStaff(Staff staff){
       return staffRepository.save(staff);
    }
    @Transactional
    public void removeStaff(long id){
        staffRepository.deleteById(id);
    }
    @Transactional
    public Staff searchStaff(long id){
        return staffRepository.findById(id).get();
    }

    public void All (){
        Iterable<Staff> staffs = staffRepository.findAll();
        for (Staff staff : staffs) {
            System.out.println(staff);
        }
    }
}
