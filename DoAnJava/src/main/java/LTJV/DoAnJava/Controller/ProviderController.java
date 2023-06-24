package LTJV.DoAnJava.Controller;

import LTJV.DoAnJava.Entity.Provider;
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
@RequestMapping("/providers")
public class ProviderController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProviderService providerService;

    @GetMapping
    public String showAllProviders(Model model) {
        model.addAttribute("providers", providerService.getAllProviders());
        model.addAttribute("title", "Provider list");
        return "provider/list";
    }
    @GetMapping("/add")
    public String addProviderForm(Model model){
        model.addAttribute("provider", new Provider());
        return "provider/add";
    }
    @PostMapping("/add")
    public String addProvider(@Valid @ModelAttribute("product") Provider provider, @RequestParam("file") MultipartFile file, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("provider",provider);
            return "/provider/add";
        }
        providerService.addProvider(file,provider);
        return "redirect:/providers";
    }
}
