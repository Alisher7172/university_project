//package uz.java.spring_boot_application.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import uz.java.spring_bootMod_application.dto.UserDto;
//import uz.java.spring_boot_application.service.AuthService;
//   // ham Front ham Backend Thymleaf bilan
//@Controller
//@RequestMapping("/test")
//public class TestAuthController {
//
//    private final AuthService authService;
//
//    public TestAuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping("/login")
//    public String login(el model, @ModelAttribute UserDto dto) {
//        Boolean success = authService.login(dto.username(), dto.password());
//        if (!success) {
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//        model.addAttribute("username", dto.username());
//        return "dashboard";
//    }
//
//    @GetMapping
//    public String home() {
//        return "login";
//    }
//
//}
