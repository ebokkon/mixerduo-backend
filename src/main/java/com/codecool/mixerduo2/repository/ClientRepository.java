package com.codecool.mixerduo2.repository;

import com.codecool.mixerduo2.model.Cart;
import com.codecool.mixerduo2.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {


}
