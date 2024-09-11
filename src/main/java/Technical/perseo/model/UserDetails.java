package Technical.perseo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String country;

    @Column
    private LocalDateTime birth;

    @Column
    private int money;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    @JsonBackReference
    private User user;
}