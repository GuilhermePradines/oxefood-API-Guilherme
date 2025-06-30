package br.com.ifpe.oxefood.modelo.Livro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;

@Service
public class EditoraService {
        @Autowired
    private EditoraRepository repository;

    @Transactional
    public Editora save(Editora editora) {

        editora.setHabilitado(Boolean.TRUE);
        return repository.save(editora);
    }

    public List<Editora> listarTodos() {
  
        return repository.findAll();
    }
 
    public Editora obterPorID(Long id) {
 
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Editora editoraAlterado) {

        Editora editora = repository.findById(id).get();
        editora.setNome(editoraAlterado.getNome());
        editora.setAnoFundacao(editoraAlterado.getAnoFundacao());
        editora.setEndereco(editoraAlterado.getEndereco());

        repository.save(editora);
    }

    @Transactional
    public void delete(Long id) {

        Editora editora = repository.findById(id).get();
        editora.setHabilitado(Boolean.FALSE);

        repository.save(editora);
    }
}
