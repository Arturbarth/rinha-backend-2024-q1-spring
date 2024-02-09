package br.com.arturbarth.rinhabackend.repository;

import br.com.arturbarth.rinhabackend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{


}
