package com.org.saude.nutrivivo.controller;

import com.org.saude.nutrivivo.ResourceNotFoundException;
import com.org.saude.nutrivivo.model.Funcionario;
import com.org.saude.nutrivivo.repository.FuncionarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {


    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/employee")
    public List<Funcionario> getAllDescricao(){

        return funcionarioRepository.findAll();
    }

    @PostMapping("/employee")
    public Funcionario createFuncionario(@Valid @RequestBody Funcionario funcionario){

        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable(value = "id") Long funcionarioId)
        throws ResourceNotFoundException {
      Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
       .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado neste ID : :" + funcionarioId));
      return ResponseEntity.ok().body(funcionario);

}

    @PutMapping("/employee/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable(value = "id")Long funcionarioId,
      @Valid @RequestBody Funcionario funcionarioDetails) throws ResourceNotFoundException {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(()-> new ResourceNotFoundException("Descricao not found for this id : :"+ funcionarioId));

       // funcionario.setId(funcionarioDetails.getId()); Não se coloca ID no metodo put! ERRO 500!
        funcionario.setNomeFuncionario(funcionarioDetails.getNomeFuncionario());
        funcionario.setFuncaoFuncionario(funcionarioDetails.getFuncaoFuncionario());
        funcionario.setEmailFuncionario(funcionarioDetails.getEmailFuncionario());
        funcionario.setTelefoneFuncionario(funcionarioDetails.getTelefoneFuncionario());
        final Funcionario updatedFuncionario = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @DeleteMapping("/employee/{id}")
    public Map<String, Boolean> deleteFuncionario(@PathVariable(value = "id")Long funcionarioId)
        throws ResourceNotFoundException{
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario not found for this id ::"+ funcionarioId));

        funcionarioRepository.delete(funcionario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;

    }


}
