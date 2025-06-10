package org.amochamo.fluqmusicmarket.models.mappingentities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amochamo.fluqmusicmarket.models.artiststuff.Track;
import org.amochamo.fluqmusicmarket.models.compositekeys.CartTrackId;
import org.amochamo.fluqmusicmarket.models.compositekeys.UserCreditCardId;
import org.amochamo.fluqmusicmarket.models.roles.User;
import org.amochamo.fluqmusicmarket.models.userstuff.Cart;
import org.amochamo.fluqmusicmarket.models.userstuff.CreditCard;

@Entity
@Table(name = "user_credit_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreditCard {

    @EmbeddedId
    private UserCreditCardId id = new UserCreditCardId();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("cardId")
    @JoinColumn(name = "card_id")
    private CreditCard creditCard;

    public UserCreditCard(User user, CreditCard creditCard) {
        this.user = user;
        this.creditCard = creditCard;
        this.id = new UserCreditCardId(user.getId(), creditCard.getId());
    }


}
