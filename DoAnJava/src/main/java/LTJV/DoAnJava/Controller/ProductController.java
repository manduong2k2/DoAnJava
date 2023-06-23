package LTJV.DoAnJava.Controller;

import LTJV.DoAnJava.Entity.Product;
import LTJV.DoAnJava.service.ProductService;
import LTJV.DoAnJava.service.ProviderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProviderService providerService;

    @GetMapping
    public String showAllBooks(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("title", "Product List");
        return "product/list";
    }
    @GetMapping("/add")
    public String addProductForm(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("providers", providerService.getAllProviders());
        return "product/add";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("providers", providerService.getAllProviders());
            return "/product/add";
        }
        productService.addProduct(file,product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable("id") Long id, Model model){
        Product editProduct = productService.getProductById(id);
        if(editProduct != null){
            model.addAttribute("product", editProduct);
            model.addAttribute("providers", providerService.getAllProviders());
            return "product/edit";
        }else{
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@ModelAttribute("product") Product updateProduct,@RequestParam("file") MultipartFile file){
        Product product = productService.getProductById(updateProduct.getId());
        product.setName(updateProduct.getName());
        product.setPrice(updateProduct.getPrice());
        product.setExpiration(updateProduct.getExpiration());
        product.setProvider(updateProduct.getProvider());
        productService.updateProduct(file,product);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
