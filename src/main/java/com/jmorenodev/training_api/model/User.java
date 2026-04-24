package com.jmorenodev.training_api.model;

import com.jmorenodev.training_api.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @Size (min = 2, max = 100)
    private String name;

    @NotBlank
    @Size (min = 2, max = 100)
    private String surname;

    @Column (unique = true)
    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size (max = 100)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, and one number")
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private User trainer;
}
