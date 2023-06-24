package LTJV.DoAnJava.Controller;

import LTJV.DoAnJava.Entity.Acc;
import LTJV.DoAnJava.Entity.CustomUserDetail;
import LTJV.DoAnJava.Entity.Item;
import LTJV.DoAnJava.Entity.Order;
import LTJV.DoAnJava.service.CustomUserDetailService;
import LTJV.DoAnJava.service.OrderService;
import LTJV.DoAnJava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    CustomUserDetailService userDetailService;

    @GetMapping
    public String showAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("title", "Order List");
        return "order/list";
    }
    @GetMapping("/add")
    public String addOrder(Model model, @ModelAttribute("items") String items, @AuthenticationPrincipal Acc acc){
        model.addAttribute("itemList",items);
        try{
            Order order=new Order();
            order.setAcc(acc);
            List<Item> itemList=Item.fromJsonList(items);
            double total=0;
            for(Item i:itemList){
                i.setProduct(productService.getProductById(i.getProduct_id()));
                total+=i.getProduct().getPrice()*i.getNumber();
            }
            order.setItems(itemList);
            order.setTotal(total);
            model.addAttribute("items",itemList);
            model.addAttribute("order",order);
            return "order/add";
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            return "error/404";
        }
    }
    @PostMapping("/add")
    public String addOrder(Model model,@ModelAttribute("order")Order order,
                           @AuthenticationPrincipal CustomUserDetail acc,
                           @ModelAttribute("listItem") String items){
        order.setDate(Date.valueOf(LocalDate.now()));
        if(acc==null){
            System.out.println("Acc null");
            return "error/404";
        }
        try{
            double total=0;
            List<Item> itemList=Item.fromJsonList(items);
            order.setItems(itemList);
            for(Item i: itemList){
                i.setProduct(productService.getProductById(i.getProduct_id()));
                i.setProduct_order(order);
                total+=i.getProduct().getPrice()*i.getNumber();
            }
            order.setAcc(userDetailService.getUser(acc.getUsername()));
            order.setTotal(total);
            orderService.addOrder(order);
            return "order/success";
        }
        catch (Exception e){
            System.out.println(e);
            return "error/404";
        }
    }
}
