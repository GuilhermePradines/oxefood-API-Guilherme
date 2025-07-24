package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT C FROM Cliente c WHERE c.cpf =:cpf ORDER BY c.id")
    List<Cliente> consultarPorCpf(String cpf);

    @Query(value = "SELECT C FROM Cliente c WHERE c.nome ilike %:nome% ORDER BY c.nome")
    List<Cliente> consultarPorNome(String nome);

    @Query(value = "SELECT c FROM Cliente c WHERE c.nome ilike %:nome% AND c.cpf = :cpf")
    List<Cliente> consultarPorNomeCpf(String nome, String cpf);
}