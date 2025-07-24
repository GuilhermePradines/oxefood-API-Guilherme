package br.com.ifpe.oxefood.modelo.Livro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Transactional
    public Livro save(Livro livro) {
        livro.setHabilitado(Boolean.TRUE);
        return repository.save(livro);
    }

    public List<Livro> listarTodos() {

        return repository.findAll(); // select * from Cliente
    }

    public Livro obterPorID(Long id) {

        return repository.findById(id).get(); // select * from Cliente where id = ?
    }

    @Transactional
    public void update(Long id, Livro livroAlterado) {

        Livro livro = repository.findById(id).get();
        livro.setEditora(livroAlterado.getEditora());
        livro.setTitulo(livroAlterado.getTitulo());
        livro.setQtdPaginas(livroAlterado.getQtdPaginas());
        livro.setAutor(livroAlterado.getAutor());
        livro.setAnoLancamento(livroAlterado.getAnoLancamento());
        livro.setPreco(livroAlterado.getPreco());

        repository.save(livro);
    }

    @Transactional
    public void delete(Long id) {

        Livro livro = repository.findById(id).get();
        livro.setHabilitado(Boolean.FALSE);

        repository.save(livro);
    }

    @SuppressWarnings("unlikely-arg-type")
    public List<Livro> filtrar(Double preco, String titulo, Long idEditora) {

        List<Livro> listaLivro = repository.findAll();

        if ((preco != null && !"".equals(preco)) &&
                (titulo == null || "".equals(titulo)) &&
                (idEditora == null)) {

            listaLivro = repository.consultarPorPreco(preco);

        } else if ((preco == null || "".equals(preco)) &&
                (titulo != null && !"".equals(titulo)) &&
                (idEditora == null)) {

            listaLivro = repository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);

        } else if ((preco == null || "".equals(preco)) &&
                (titulo == null || "".equals(titulo)) &&
                (idEditora != null)) {

            listaLivro = repository.consultarPorEditora(idEditora);

        } else if ((preco == null || "".equals(preco)) &&
                (titulo != null && !"".equals(titulo)) &&
                (idEditora != null)) {

            listaLivro = repository.consultarPorTituloEEditora(titulo, idEditora);
        }

        return listaLivro;
    }
}
