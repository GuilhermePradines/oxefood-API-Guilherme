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
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.Livro.Editora;
import br.com.ifpe.oxefood.modelo.Livro.EditoraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/editora")
@CrossOrigin
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @PostMapping
    public ResponseEntity<Editora> save(@RequestBody @Valid EditoraRequest request) {

        Editora editoraNovo = request.build();
        Editora editora = editoraService.save(editoraNovo);
        return new ResponseEntity<Editora>(editora, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Editora> listarTodos() {

        return editoraService.listarTodos();
    }

    @GetMapping("/{id}")
    public Editora obterPorID(@PathVariable Long id) {

        return editoraService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editora> update(@PathVariable("id") Long id, @RequestBody EditoraRequest request) {

        editoraService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        editoraService.delete(id);
        return ResponseEntity.ok().build();
    }
}
