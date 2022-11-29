package org.hawhamburg.partslist.controller;

import org.hawhamburg.partslist.controller.dto.GetMaterialListForm;
import org.hawhamburg.partslist.controller.dto.QuantifiedMaterial;
import org.hawhamburg.partslist.model.Material;
import org.hawhamburg.partslist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/material-list")
public class MaterialListController {

    private final ProductService productService;

    public MaterialListController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showView(Model model) {
        List<String> productNames = productService.getAllNames();
        model.addAttribute("productNames", productNames);
        model.addAttribute("getMaterialListForm", new GetMaterialListForm());
        return "material-list";
    }

    @PostMapping
    public String showViewWithFetchedMaterialList(@ModelAttribute GetMaterialListForm getMaterialListForm, Model model) {
        List<QuantifiedMaterial> quantifiedMaterials = convertMaterialList(productService.getMaterialList(getMaterialListForm.getProductName()));
        model.addAttribute("quantifiedMaterials", quantifiedMaterials);
        List<String> productNames = productService.getAllNames();
        model.addAttribute("productNames", productNames);
        return "material-list";
    }

    private List<QuantifiedMaterial> convertMaterialList(List<Material> materialList) {
        Map<Material, Integer> materialQuantityMap = materialList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, m -> 1, Integer::sum)));

        return materialQuantityMap.entrySet().stream()
                .map(entry -> new QuantifiedMaterial(entry.getKey().getName(), entry.getValue())).toList();
    }
}
