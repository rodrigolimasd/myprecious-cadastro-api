package com.rodtech.mypreciouscadastroapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "tb_categoria")
@SequenceGenerator(sequenceName = "seq_tb_categoria", name = "id", allocationSize = 1)
public class Categoria extends BaseEntity {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String codigo;
}
