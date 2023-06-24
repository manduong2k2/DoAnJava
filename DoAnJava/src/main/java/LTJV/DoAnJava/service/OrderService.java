package LTJV.DoAnJava.service;

import LTJV.DoAnJava.Entity.Order;
import LTJV.DoAnJava.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    IOrderRepository orderRepository;

    public List<Order> getAllOrders(){return orderRepository.findAll();}

    public Order getOrderById(Long id){
        Optional<Order> optional = orderRepository.findById(id);
        return optional.orElse(null);
    }
    public void addOrder(Order order){orderRepository.save(order);}
    public void updateOrder(Order order){orderRepository.save(order);}
    public void deleteOrder(Long id){orderRepository.deleteById(id);}
}
