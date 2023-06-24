package LTJV.DoAnJava.service;

import LTJV.DoAnJava.Entity.Item;
import LTJV.DoAnJava.repository.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private IItemRepository itemRepository;
    public List<Item> getAllItems(){return itemRepository.findAll();}

    public Item getItemById(Long id){
        Optional<Item> optional = itemRepository.findById(id);
        return optional.orElse(null);
    }
    public void addItem(Item item){itemRepository.save(item);}
    public void updateItem(Item item){itemRepository.save(item);}
    public void deleteItem(Long id){itemRepository.deleteById(id);}
}
