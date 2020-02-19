package com.codecool.mixerduo2.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Component
public class Cart implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "cart")
    @JsonIgnore
    private Client client;

    @OneToMany(cascade = CascadeType.PERSIST)
    @Singular
    private List<Course> courses = new ArrayList<>();

    @ElementCollection
    @Column(name="quantity")
    @MapKeyColumn(name="coursename")
    private Map<String, Integer> cartMap = new HashMap<>();

    public Long getId() {
        return id;
    }

    public Map<String, Integer> getCartMap() {
        return cartMap;
    }

    public void setCart(Map<String, Integer> cart) {
        this.cartMap = cart;
    }

    public void addToCart(String name) {
        if (cartMap.containsKey(name)){
            cartMap.put(name, cartMap.get(name)+1);
        }
        cartMap.putIfAbsent(name, 1);
    }

    public void removeFromCart(String name) {
        cartMap.remove(name);
    }

    public void increaseQuantity(String name) {
        addToCart(name);
    }

    public void decreaseQuantity(String name) {
        if (cartMap.containsKey(name) && cartMap.get(name) == 1) cartMap.remove(name);
        if (cartMap.containsKey(name) && cartMap.get(name) > 1) {
            cartMap.put(name, cartMap.get(name)-1);
        }
    }

    public void addToCourses(Course course){
        courses.add(course);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", cart=" + cartMap +
                '}';
    }
}
