package com.vm.springstarter.http.controller;

import com.vm.springstarter.database.entity.Role;
import com.vm.springstarter.database.repo.CompanyRepo;
import com.vm.springstarter.dto.UserReadDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes({"user"})
@RequestMapping("api/v1")
public class CreatingController {

    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }

    @GetMapping("/hello/{id}")
    public String hello(Model model,
                        @RequestParam Integer age,
                        @RequestHeader String accept,
                        @CookieValue("JSESSIONID") String jsessionId,
                        @PathVariable("id") Integer id,
                        UserReadDto userReadDto) {
        model.addAttribute("user", userReadDto);
        return "greating/hello";
    }

    @GetMapping("/bye")
    public String bye(@SessionAttribute("user") UserReadDto user) {
        return "greating/bye";
    }
@GetMapping("/hello")
    public String hello(Model model,
                        UserReadDto userReadDto) {
        model.addAttribute("user", userReadDto);
        return "greating/hello";
    }
}
