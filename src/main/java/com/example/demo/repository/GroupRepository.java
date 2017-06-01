package com.example.demo.repository;

import com.example.demo.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cvter on 2017/6/1.
 */
public interface GroupRepository extends JpaRepository<Group, Integer>{
    public Group findById(int id);
}
