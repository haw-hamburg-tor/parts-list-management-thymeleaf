package org.hawhamburg.partslist.controller;

import org.hawhamburg.partslist.model.Component;
import org.hawhamburg.partslist.service.ComponentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("component-overview")
public class ComponentOverviewController {

    private final ComponentService componentService;

    public ComponentOverviewController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @GetMapping
    public String showView(Model model) {
        List<Component> components = componentService.getAll();
        model.addAttribute("components", components);
        return "component-overview";
    }

}
