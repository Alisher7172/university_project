package uz.java.spring_boot_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.java.spring_boot_application.dto.user.TeacherRequest;
import uz.java.spring_boot_application.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(teacherService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> addTeacher(@RequestBody TeacherRequest teacherRequest) {
        return ResponseEntity.ok(teacherService.create(teacherRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest) {
        return ResponseEntity.ok(teacherService.update(teacherRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.delete(id));
    }
}
