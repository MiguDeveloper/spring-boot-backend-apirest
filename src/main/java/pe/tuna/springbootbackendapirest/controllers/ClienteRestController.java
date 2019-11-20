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

    @GetMapping("/cliente/{id}")
    public Cliente showCliente(@PathVariable(name = "id") Long id){
        return clienteService.findById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }
}
