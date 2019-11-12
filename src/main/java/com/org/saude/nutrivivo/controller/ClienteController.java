package com.org.saude.nutrivivo.controller;


import com.org.saude.nutrivivo.ResourceNotFoundException;
import com.org.saude.nutrivivo.model.Cliente;
import com.org.saude.nutrivivo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {



    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/cliente")
    public List<Cliente> getAllCliente(){

        return clienteRepository.findAll();
    }

    @PostMapping("/cliente")
    public Cliente createCliente(@Valid @RequestBody Cliente cliente){

        return clienteRepository.save(cliente);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") Long clienteId)
        throws ResourceNotFoundException {
      Cliente cliente = clienteRepository.findById(clienteId)
       .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado neste ID : :" + clienteId));
      return ResponseEntity.ok().body(cliente);

}

    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id")Long clienteId,
      @Valid @RequestBody Cliente clienteDetails) throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(()-> new ResourceNotFoundException("Cliente não encontrado neste ID : :"+ clienteId));

       //  Não se coloca ID no metodo put! ERRO 500!
        cliente.setNomeCliente(clienteDetails.getNomeCliente());

        final Cliente updatedCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/cliente/{id}") //Sempre verificar O TIPO DE id LONG OU INT
    public Map<String, Boolean> deleteCliente(@PathVariable(value = "id")Long clienteId)
        throws ResourceNotFoundException{
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente not found for this id ::"+ clienteId));

        clienteRepository.delete(cliente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;

    }

}
