package com.org.saude.nutrivivo.repository;

import com.org.saude.nutrivivo.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
}
