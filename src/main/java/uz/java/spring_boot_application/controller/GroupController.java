package uz.java.spring_boot_application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.java.spring_boot_application.dto.group.GroupResponse;
import uz.java.spring_boot_application.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GroupResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

}
