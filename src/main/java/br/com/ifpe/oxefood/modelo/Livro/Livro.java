package br.com.ifpe.oxefood.modelo.Livro;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Livro")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro extends EntidadeAuditavel {

    @ManyToOne
    private Editora editora;

    @Column
    private String titulo;

    @Column
    private Integer qtdPaginas;

    @Column
    private String autor;

    @Column
    private Integer anoLancamento;

    @Column
    private double preco;

}
