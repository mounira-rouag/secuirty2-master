package com.example.Project.Controller;

import com.example.Project.Services.DevServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/devs")
public class DevController {

private final DevServiceImpl devServiceImpl;

    public DevController(DevServiceImpl devServiceImpl) {
        this.devServiceImpl = devServiceImpl;
    }


    @GetMapping("/all-dll")
    public List<String> getAllMarqueNames() {
        return devServiceImpl.getAllDev().stream()
                .map(DLL -> DLL.getDll())
                .collect(Collectors.toList());
    }
}


