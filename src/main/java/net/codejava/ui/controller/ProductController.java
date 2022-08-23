package net.codejava.ui.controller;

import net.codejava.io.entity.ProductEntity;
import net.codejava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String viewHomePage(){

        return "index";
    }

    @GetMapping("/products")
    public String viewProducts(Model model){

        List<ProductEntity> listProducts = productService.listAll();
        model.addAttribute("listProducts", listProducts);

        return "products";
    }

    @GetMapping("/products/new")
    public String viewNewProductForm(Model model){

        ProductEntity productEntity = new ProductEntity();
        model.addAttribute("product", productEntity);

        return "product_form";
    }

    @PostMapping("/products/save")
    public String AddNewProduct(ProductEntity productEntity, RedirectAttributes redirectAttributes){

        productService.AddNewProduct(productEntity);
        redirectAttributes.addFlashAttribute("message", "Product added successfully");
        return "redirect:/products";
    }

    @GetMapping("/product/edit/{productId}")
    public String editProduct(@PathVariable(name = "productId") String productId,
                                   Model model) {

        ProductEntity productEntity = productService.getProduct(productId);
        model.addAttribute("product", productEntity);
        model.addAttribute("pageTitle", "Edit Product with ID: " + productId + "");
        return "product_form";
    }
    @GetMapping("/product/delete/{productId}")
    public String deleteProduct(@PathVariable(name = "productId") String productId, Model model) {

        productService.deleteProduct(productId);
        model.addAttribute("message", "Product with ID: " + productId + "deleted");
        return "redirect:/products";
    }
}
