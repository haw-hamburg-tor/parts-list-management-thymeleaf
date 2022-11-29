package org.hawhamburg.partslist.controller;

import org.hawhamburg.partslist.controller.dto.MaterialForm;
import org.hawhamburg.partslist.service.MaterialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create-material")
public class CreateMaterialController {

    private final MaterialService materialService;

    public CreateMaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public String showView(Model model) {
        model.addAttribute("materialForm", new MaterialForm());
        return "create-material";
    }

    @PostMapping
    public String createMaterial(@ModelAttribute MaterialForm materialForm) {
        materialService.createMaterial(materialForm.getName(), materialForm.getPrice());
        return "redirect:/create-material";
    }
}
