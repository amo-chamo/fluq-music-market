package org.amochamo.fluqmusicmarket.models.userstuff;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amochamo.fluqmusicmarket.models.mappingentities.UserCreditCard;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "credit_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "card_number", nullable = false, length = 19)
    private String cardNumber;

    @Column(name = "holder_name", nullable = false)
    private String holderName;

    @Column(name = "expiry_date", nullable = false, length = 5)
    private String expiryDate;

    @Column(name = "cvc_hash", nullable = false)
    private String cvcHash;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserCreditCard> userCreditCards = new HashSet<>();

    @OneToMany(mappedBy = "creditCard")
    private Set<Transaction> transactions = new HashSet<>();


}
