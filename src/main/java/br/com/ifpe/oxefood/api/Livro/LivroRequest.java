package br.com.ifpe.oxefood.api.Livro;

import br.com.ifpe.oxefood.modelo.Livro.Livro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LivroRequest {

    private long idEditora;

    private String titulo;

    private Integer qtdPaginas;

        
    private String autor;

   
    private Integer anoLancamento;

    
    private double preco;

    public Livro build(){
        return Livro.builder()
                .titulo(titulo)
                .qtdPaginas(qtdPaginas)
                .autor(autor)
                .anoLancamento(anoLancamento)
                .preco(preco)
                .build();
    }
}
