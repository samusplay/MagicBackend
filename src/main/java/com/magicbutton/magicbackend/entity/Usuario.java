package com.magicbutton.magicbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min =2 ,max=120)
    @Column(nullable = false,unique = true,length = 120)
    private String name;

    @NotBlank
    @Email
    @Size(max=190)
    @Column(nullable = false,unique = true, length = 190)
    private String correo;

    @NotBlank
    @Size(min = 6, max = 255)
    @Column(nullable = false, length = 255)
    private String password;

    @NotBlank
    @Size(max = 30)
    @Column(nullable = false,length = 30)
    private String rol="profesor";

    @CreationTimestamp
    @Column(name = "creado_en", nullable = false, updatable = false) // ojo: SIN insertable=false
    private LocalDateTime creadoEn;

}
