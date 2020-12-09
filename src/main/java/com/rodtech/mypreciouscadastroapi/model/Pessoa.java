package com.rodtech.mypreciouscadastroapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "tb_pessoa")
@SequenceGenerator(sequenceName = "seq_tb_pessoa", name = "id", allocationSize = 1)
public class Pessoa extends BaseEntity {

    @NotEmpty
    private String nome;

    private String documento;

    private String telefone;
}
