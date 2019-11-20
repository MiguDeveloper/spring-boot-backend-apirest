package pe.tuna.springbootbackendapirest.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.tuna.springbootbackendapirest.models.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
