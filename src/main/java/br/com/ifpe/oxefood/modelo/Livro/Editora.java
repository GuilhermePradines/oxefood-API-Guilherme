package br.com.ifpe.oxefood.modelo.Livro;



import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Editora")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Editora extends EntidadeAuditavel {
    
   
    @Column
    private String nome;

    @Column
    private Integer anoFundacao;

    @Column
    private String endereco;

}
