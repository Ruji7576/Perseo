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
public class Payement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int sum;

    @Column
    private String stage;

    @Column
    private LocalDateTime dateOfPayment;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    @JsonBackReference
    private User user;

    @ManyToOne(optional = true)
    @JoinColumn(name = "course_id", nullable = true)
    @JsonBackReference
    private Course course;
}