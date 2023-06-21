package LTJV.DoAnJava.service;

import LTJV.DoAnJava.Entity.Role;
import LTJV.DoAnJava.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private IRoleRepository repository;
    public List<Role> getAllRoles(){return repository.findAll();}

}
