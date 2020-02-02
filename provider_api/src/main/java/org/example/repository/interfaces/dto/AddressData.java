package org.example.repository.interfaces.dto;

import lombok.*;
import org.example.controller.dto.Address;

import javax.persistence.*;

@Entity(name = "addresses")
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public final class AddressData {


    public AddressData(String addressLine1, String addressLine2) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id", updatable = false, nullable = false)
    private String addressId;

    @Column(name = "addressline1", nullable = false)
    private String addressLine1;
    @Column(name = "addressline2", nullable = false)
    private String addressLine2;

    @OneToOne(mappedBy = "addressData")
    private StudentData student;

    public static Address map(AddressData addressData) {
        return new Address(addressData.addressLine1,addressData.addressLine2);
    }
}
