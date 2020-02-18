package com.codecool.mixerduo2.repository;

import com.codecool.mixerduo2.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
