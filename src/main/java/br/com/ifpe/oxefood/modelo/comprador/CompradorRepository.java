package br.com.ifpe.oxefood.modelo.comprador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ifpe.oxefood.modelo.comprador.Comprador;

public interface CompradorRepository extends JpaRepository<Comprador, Long> {
    

    //Exemplo de uma busca exata como um atributo de relacionamento
    @Query(value = "SELECT p FROM Comprador p WHERE p.Segmento.id = :idSegmento")
    List<Comprador> consultarPorSegmento(Long idSegmento);

    //Exemplo de uma busca com mais de um atributo
    @Query(value = "SELECT p FROM Comprador p WHERE p.titulo ilike %:titulo% AND p.Segmento.id = :idSegmento")
    List<Comprador> consultarPorTituloESegmento(String nome, Long idSegmeto);
}