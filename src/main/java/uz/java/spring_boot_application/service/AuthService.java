package uz.java.spring_boot_application.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.java.spring_boot_application.dto.UserRegisterRequest;
import uz.java.spring_boot_application.entities.Role;
import uz.java.spring_boot_application.entities.User;
import uz.java.spring_boot_application.exception.ValidationException;
import uz.java.spring_boot_application.repository.RoleRepository;
import uz.java.spring_boot_application.repository.UserRepository;

import java.util.Set;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final CustomUserDetailService customUserDetailService;

    public AuthService(PasswordEncoder passwordEncoder, RoleRepository roleRepository, UserRepository userRepository, CustomUserDetailService customUserDetailService, CustomUserDetailService customUserDetailService1) {
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.customUserDetailService = customUserDetailService1;
    }

    public Boolean login(String username, String password) {
        UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, userDetails.getPassword()))
            throw new ValidationException("Invalid password or username");

        return true;
    }

    public Boolean register(UserRegisterRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Role role = roleRepository.findByCode("ROLE_USER");
        if (role == null) {
            role = new Role();
            role.setName("User");
            role.setCode("ROLE_USER");
            roleRepository.save(role);
        }
        user.setRoles(Set.of(role));
        userRepository.save(user);
        return true;
    }
}
