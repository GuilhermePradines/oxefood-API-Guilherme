package br.com.ifpe.oxefood.modelo.comprador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



import jakarta.transaction.Transactional;

public class SegmentoService {
    
    @Autowired
    private SegmentoRepository repository;

    @Transactional
    public Segmento save(Segmento segmento) {

        segmento.setHabilitado(Boolean.TRUE);
        return repository.save(segmento);
    }

    public List<Segmento> listarTodos() {
  
        return repository.findAll();
    }
 
    public Segmento obterPorID(Long id) {
 
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Segmento segmentoAlterado) {

        Segmento segmento = repository.findById(id).get();
        segmento.setDescricao(segmentoAlterado.getDescricao());

        repository.save(segmento);
    }

    @Transactional
    public void delete(Long id) {

        Segmento segmento = repository.findById(id).get();
        segmento.setHabilitado(Boolean.FALSE);

        repository.save(segmento);
    }
}
