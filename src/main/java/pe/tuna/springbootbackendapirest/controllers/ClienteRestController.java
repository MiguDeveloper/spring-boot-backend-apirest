package pe.tuna.springbootbackendapirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.tuna.springbootbackendapirest.models.entity.Cliente;
import pe.tuna.springbootbackendapirest.models.services.IClienteService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Cliente showCliente(@PathVariable(name = "id") Long id){
        return clienteService.findById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente clienteCurrent = clienteService.findById(id);
        clienteCurrent.setNombre(cliente.getNombre());
        clienteCurrent.setApellido(cliente.getApellido());
        clienteCurrent.setEmail(cliente.getEmail());

        return clienteService.save(clienteCurrent);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }
}
