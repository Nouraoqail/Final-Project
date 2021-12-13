package com.example.demo.type;

import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private final TypeRepository TypeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        TypeRepository = typeRepository;
    }

    public List<Type> getType() {
        return TypeRepository.findAll();
    }

    public Type getTypes(String id) {
        Long type_id = Long.parseLong(id);
        return TypeRepository.findById(type_id).orElse(null);
    }

    public Type createType(Type type) {
        return TypeRepository.save(type);
    }

    public void updateType(String id, Type data) {
        Long type_id = Long.parseLong(id);
        Type type = TypeRepository.findById(type_id).orElse(null);

        if (type != null) {
            type.setType(data.getType());
        }
    }
}
