package Composer.model;

import java.security.Timestamp;

public class CreditCards {
    protected Long cardNumber;
    protected Timestamp expiration;
    protected User user;


    public CreditCards(Long cardNumber, Timestamp expiration, User user) {
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.user = user;
    }

    public CreditCards(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Timestamp getExpiration() {
        return expiration;
    }

    public void setExpiration(Timestamp expiration) {
        this.expiration = expiration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
