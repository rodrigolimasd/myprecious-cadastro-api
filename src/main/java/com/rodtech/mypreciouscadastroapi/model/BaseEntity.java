package com.rodtech.mypreciouscadastroapi.model;


import com.rodtech.mypreciouscadastroapi.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    private Long id;

    @Column
    private LocalDateTime alteracao;

    @Column(nullable = false, updatable = false)
    private LocalDateTime inclusao;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @PrePersist
    public void prePersist() {
        inclusao = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        alteracao = LocalDateTime.now();
    }

}
