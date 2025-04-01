package ProCat.ProCat.Controller;

import ProCat.ProCat.Entity.Product;
import ProCat.ProCat.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add_product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        service.saveProduct(product);
        return "redirect:/products/all";
    }

    @GetMapping("/all")
    public String showAllProduct(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "product_list";
    }
}
