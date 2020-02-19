package com.codecool.mixerduo2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Component
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String password;

    @OneToOne(mappedBy = "client", cascade = CascadeType.PERSIST)
    private Cart cart;
}
