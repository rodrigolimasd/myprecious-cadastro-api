package com.rodtech.mypreciouscadastroapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "tb_carteira")
@SequenceGenerator(sequenceName = "seq_tb_carteira", name = "id", allocationSize = 1)
public class Carteira extends BaseEntity {

    @NotEmpty
    private String nome;

    @NotNull
    @PositiveOrZero
    private BigDecimal saldo;

}
