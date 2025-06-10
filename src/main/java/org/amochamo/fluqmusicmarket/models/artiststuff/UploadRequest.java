package org.amochamo.fluqmusicmarket.models.artiststuff;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amochamo.fluqmusicmarket.models.enums.RequestStatus;
import org.amochamo.fluqmusicmarket.models.roles.Artist;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "upload_request")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "duration_seconds", nullable = false)
    private Integer durationSeconds;

    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;

    @Column(name = "music_file", nullable = false)
    private byte[] musicFile;

    @Column(name = "preview_file", nullable = false)
    private byte[] previewFile;

    @Column(name = "cover_image", nullable = false)
    private byte[] coverImage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status = RequestStatus.PENDING;

    @Column(name = "submitted_at", nullable = false)
    private LocalDateTime submittedAt = LocalDateTime.now();



}
