package com.codecool.mixerduo2.repository;

import com.codecool.mixerduo2.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
