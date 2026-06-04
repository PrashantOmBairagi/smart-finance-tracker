package com.prashant.smartfinancetracker.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prashant.smartfinancetracker.expense.Expense;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Username is required.")
    @Size(min = 4, max = 30,
            message = "Username must be between 4 and 30 characters.")
    @Pattern(
            regexp = "^[a-zA-Z0-9_]+$",
            message = "Username can contain only letters, numbers and underscore."
    )
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "Password is required.")
    @Size(min = 6, max = 50,
            message = "Password must be between 6 and 50 characters.")
    private String password;

    @Column(nullable = false)
    @NotBlank(message = "First name is required.")
    @Size(min = 3, max = 20,
            message = "First name must be between 3 and 20 characters.")
    private String firstName;

    @Size(max = 20,
            message = "Last name cannot exceed 20 characters.")
    private String lastName;

    @Column(unique = true)
    @NotBlank(message = "Phone number is required.")
    @Pattern(
            regexp = "^[6-9][0-9]{9}$",
            message = "Enter a valid 10-digit Indian mobile number."
    )
    private String phone;

    @NotNull(message = "Budget is required.")
    @PositiveOrZero(message = "Budget cannot be negative.")
    private Long budget;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Expense> expenses = new ArrayList<>();
}