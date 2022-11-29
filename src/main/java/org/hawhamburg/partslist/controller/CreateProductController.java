package org.hawhamburg.partslist.controller;

import org.hawhamburg.partslist.controller.dto.ProductForm;
import org.hawhamburg.partslist.service.ComponentService;
import org.hawhamburg.partslist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("create-product")
public class CreateProductController {

    private final ProductService productService;
    private final ComponentService componentService;

    public CreateProductController(ProductService productService, ComponentService componentService) {
        this.productService = productService;
        this.componentService = componentService;
    }

    @GetMapping
    public String showView(Model model) {
        model.addAttribute("componentNames", componentService.getAllComponentNames());
        var productForm = new ProductForm();
        productForm.setQuantifiedComponents(new ArrayList<>());
        model.addAttribute("productForm", productForm);
        return "create-product";
    }

    @PostMapping
    public String createProduct(@RequestBody ProductForm productForm) {
        List<String> componentNames = new ArrayList<>();
        List<Integer> componentAmounts = new ArrayList<>();
        productForm.getQuantifiedComponents().forEach(q -> {
            componentNames.add(q.getName());
            componentAmounts.add(q.getAmount());
        });
        productService.createProduct(productForm.getName(), productForm.getPrice(), componentNames, componentAmounts);
        return "redirect:/create-product";
    }
}
