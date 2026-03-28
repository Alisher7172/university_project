package uz.java.spring_boot_application.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "session_users")
@Builder
public class SessionUser extends Auditable {

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "access_token", nullable = false)
    private String accessToken;

    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
