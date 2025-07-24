package br.com.ifpe.oxefood.api.Livro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.Livro.Editora;
import br.com.ifpe.oxefood.modelo.Livro.EditoraService;
import br.com.ifpe.oxefood.modelo.Livro.Livro;
import br.com.ifpe.oxefood.modelo.Livro.LivroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/livro")
@CrossOrigin
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private EditoraService editoraService;

    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody @Valid LivroRequest request) {

        Livro livroNovo = request.build();
        Editora cp = editoraService.obterPorID(request.getIdEditora());
        livroNovo.setEditora(cp);
        Livro livro = livroService.save(livroNovo);

        return new ResponseEntity<Livro>(livro, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Livro> listarTodos() {

        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Livro obterPorID(@PathVariable Long id) {

        return livroService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable("id") Long id, @RequestBody LivroRequest request) {

        Livro livro = request.build();
        livro.setEditora(editoraService.obterPorID(request.getIdEditora()));
        livroService.update(id, livro);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        livroService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/filtrar")
    public List<Livro> filtrar(
            @RequestParam(value = "preco", required = false) Double preco,
            @RequestParam(value = "titulo", required = false) String titulo,
            @RequestParam(value = "idEditora", required = false) Long idEditora) {

        return livroService.filtrar(preco, titulo, idEditora);
    }
}
