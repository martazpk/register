package pl.kopp.marta.student.domain.model;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {
    private String email;
    private String phoneNumber;

    public Contact(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    private Contact() {
    }

}
