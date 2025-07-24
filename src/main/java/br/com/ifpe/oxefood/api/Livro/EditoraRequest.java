package br.com.ifpe.oxefood.api.Livro;

import br.com.ifpe.oxefood.modelo.Livro.Editora;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditoraRequest {

    private String nome;

    private Integer anoFundacao;

    private String endereco;

    public Editora build() {
        return Editora.builder()
                .nome(nome)
                .anoFundacao(anoFundacao)
                .endereco(endereco)
                .build();
    }
}
