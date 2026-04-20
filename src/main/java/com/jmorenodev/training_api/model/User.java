package com.jmorenodev.training_api.model;

import com.jmorenodev.training_api.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size (min = 2, max = 100)
    private String name;

    @NotBlank
    @NotNull
    @Size (min = 2, max = 100)
    private String surname;

    @Column (unique = true)
    @Email
    @NotBlank
    @NotNull
    private String email;

    @Size (min = 8, max = 100)
    @NotBlank
    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private User trainer;
}
