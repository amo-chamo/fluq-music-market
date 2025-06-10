package org.amochamo.fluqmusicmarket.models.artiststuff;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amochamo.fluqmusicmarket.models.enums.RequestStatus;
import org.amochamo.fluqmusicmarket.models.roles.Artist;

import java.time.LocalDateTime;

@Entity
@Table(name = "registration_request")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "artist_id", nullable = false, unique = true)
    private Artist artist;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status = RequestStatus.PENDING;

    @Column(name = "submitted_at", nullable = false)
    private LocalDateTime submittedAt = LocalDateTime.now();


}
