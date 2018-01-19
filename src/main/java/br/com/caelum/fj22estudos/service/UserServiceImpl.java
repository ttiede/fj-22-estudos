package br.com.caelum.fj22estudos.service;

import java.util.Arrays;
import java.util.HashSet;

import br.com.caelum.fj22estudos.model.Role;
import br.com.caelum.fj22estudos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repository.IRoleRepository;
import repository.IUserRepository;

@Service("userService")
public class UserServiceImpl implements IUserService{

    public IUserRepository userRepository;
    public IRoleRepository roleRepository;
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void UserServiceImpl(IUserRepository userRepository, IRoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}