package pe.tuna.springbootbackendapirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.tuna.springbootbackendapirest.models.entity.Cliente;
import pe.tuna.springbootbackendapirest.models.repository.IClienteRepository;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return iClienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return iClienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return iClienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iClienteRepository.deleteById(id);
    }
}
