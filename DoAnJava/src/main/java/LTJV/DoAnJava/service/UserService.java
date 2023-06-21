package LTJV.DoAnJava.service;

import LTJV.DoAnJava.Entity.Acc;
import LTJV.DoAnJava.repository.IRoleRepository;
import LTJV.DoAnJava.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    public void save(Acc user){
        userRepository.save(user);
        String userName = user.getUsername();
        Long roleId = roleRepository.getRoleIdByName("USER");
        if (roleId != 0 && userName !=null){
            userRepository.addRoleToUser(userName,roleId);
        }
    }
}
