package lt.asprogramuoju.refactoringkata.controller;

import lt.asprogramuoju.refactoringkata.domain.Item;
import lt.asprogramuoju.refactoringkata.repository.ItemRepository;
import lt.asprogramuoju.refactoringkata.service.InventoryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/updateInventory")
    public void updateAllItemQuality() {
        inventoryService.update();
    }

    @GetMapping("/getAll")
    public List getItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/getByName/{name}")
    public Item getItemByName(@PathVariable("name") String name) {
        return itemRepository.findByName(name);
    }

    @GetMapping("/getById/{id}")
    public Item getItemById(@PathVariable("id") ObjectId id) {
        return itemRepository.findById(id);
    }

    @GetMapping("/getBySellIn/{value}")
    public Item[] getItemBySellIn(@PathVariable("value") int value) {
        return itemRepository.findBySellIn(value);
    }

    @GetMapping("/getGoodQuality/greater_than={value}")
    public Item[] getItemGoodQualityGreaterThan(@PathVariable("value") int value) {
        return itemRepository.findGoodQualityWhereQualityMoreThan(value);
    }

    @PostMapping("/create")
    public Item createItem(@Valid @RequestBody Item item) {
        item.setId(ObjectId.get());
        itemRepository.save(item);
        return item;
    }
}
