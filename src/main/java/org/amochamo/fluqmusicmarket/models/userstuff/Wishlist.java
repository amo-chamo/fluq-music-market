package org.amochamo.fluqmusicmarket.models.userstuff;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amochamo.fluqmusicmarket.models.mappingentities.WishlistTrack;
import org.amochamo.fluqmusicmarket.models.roles.User;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "wishlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WishlistTrack> wishlistTracks = new HashSet<>();


}
