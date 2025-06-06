package br.com.ifpe.oxefood.api.comprador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.ifpe.oxefood.api.comprador.SegmentoRequest;
import br.com.ifpe.oxefood.api.comprador.CompradorRequest;
import br.com.ifpe.oxefood.modelo.comprador.Comprador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CompradorRequest {
    
    private Long idSegmento;

    private String nome;

   private String enderecoComercial;

   private String enderecoResidencial;

   private Double comissao;

   private Integer qtdComprasMediasMes;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate contratadoEm;

   public Comprador build() {

        Comprador c = Comprador.builder()
           .nome(nome)
           .enderecoComercial(enderecoComercial)
           .enderecoResidencial(enderecoResidencial)
           .comissao(comissao)
           .qtdComprasMediasMes(qtdComprasMediasMes)
           .contratadoEm(contratadoEm)
           .build();

        return c;
   }
}
