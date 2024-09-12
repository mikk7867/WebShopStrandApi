package dk.tec.todolistapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    ItemRepository repository;
    ItemController(ItemRepository repository){
        this.repository = repository;
    }

    @PostMapping
    void create(@RequestBody Item item){
        repository.save(item);
    }

    @GetMapping("/{id}")
    Item read(@PathVariable int id){
        return repository.findById(id).get();
    }

    @GetMapping()
    List<Item> readAll(){
        return repository.findAll();
    }

    @PutMapping
    void update(@RequestBody Item item){
        repository.save(item);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        repository.deleteById(id);
    }


}
