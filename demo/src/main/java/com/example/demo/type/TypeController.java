package com.example.demo.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="types")
@CrossOrigin("*")
public class TypeController {

    private final TypeService TypeService;
    @Autowired
    public TypeController(com.example.demo.type.TypeService typeService) {
        TypeService = typeService;
    }

    @GetMapping
    public List<Type> getType(){
        return TypeService.getType();
    }

    @GetMapping("/{id}")
    public Type getTypes(@PathVariable String id){
        return TypeService.getTypes(id);
    }

    @PostMapping
    public Type createType(@RequestBody Type type){
        return TypeService.createType(type);
    }

    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable String id) {
        TypeService.deleteType(id);
    }

    @PutMapping("/{id}")
    public void updateType(@PathVariable String id,@RequestBody Type data){

        TypeService.updateType(id,data);
    }

}
