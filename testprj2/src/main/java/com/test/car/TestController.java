package com.test.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public String getTestList(Model model) {
        model.addAttribute("testList", testService.getTestList());
        return "test";
    }

    @PostMapping("/test/insert")
    public String insertTestData(Test test) {
        testService.insertTestData(test);
        return "redirect:/test";
    }

    @PostMapping("/test/updateDate")
    public String updateTestDate(String test_id) {
        testService.updateTestDate(test_id);
        return "redirect:/test";
    }
}