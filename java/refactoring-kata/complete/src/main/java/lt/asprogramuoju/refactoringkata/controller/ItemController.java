package lt.asprogramuoju.refactoringkata.controller;

import lt.asprogramuoju.refactoringkata.Inventory;
import lt.asprogramuoju.refactoringkata.domain.Item;
import lt.asprogramuoju.refactoringkata.repository.ItemRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/updateAllItemQuality")
    public void updateAllItemQuality() {
        List<Item> items = itemRepository.findAll();
        Item[] array = items.toArray(new Item[items.size()]);
        Inventory inventory = new Inventory(array);
        inventory.updateQuality();
        items = Arrays.asList(array);
        itemRepository.saveAll(items);
    }

    @GetMapping("/")
    public List getItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/{name}")
    public Item getItemByName(@PathVariable("name") String name) {
        return itemRepository.findByName(name);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable("id") ObjectId id) {
        return itemRepository.findById(id);
    }

    @PostMapping("/")
    public Item createItem(@Valid @RequestBody Item item) {
        item.setId(ObjectId.get());
        itemRepository.save(item);
        return item;
    }
}
