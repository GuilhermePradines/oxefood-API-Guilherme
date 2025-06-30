package br.com.ifpe.oxefood.modelo.Livro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface LivroRepository extends JpaRepository<Livro, Long> {

        //Exemplo de uma busca exata
    @Query(value = "SELECT p FROM Livro p WHERE p.preco = :preco ORDER BY p.id")
    List<Livro> consultarPorPreco(Double preco);

    //Exemplo de uma busca aproximada com ordenação:
    // @Query(value = "SELECT p FROM Produto p WHERE p.titulo ilike %:titulo% ORDER BY p.titulo")
    // List<Produto> consultarPorTitulo(String titulo);
    List<Livro> findByTituloContainingIgnoreCaseOrderByTituloAsc(String titulo);

    //Exemplo de uma busca exata como um atributo de relacionamento
    @Query(value = "SELECT p FROM Livro p WHERE p.editora.id = :idEditora")
    List<Livro> consultarPorEditora(Long idEditora);

    //Exemplo de uma busca com mais de um atributo
    @Query(value = "SELECT p FROM Livro p WHERE p.titulo ilike %:titulo% AND p.editora.id = :idEditora")
    List<Livro> consultarPorTituloEEditora(String titulo, Long idCategoria);
}
