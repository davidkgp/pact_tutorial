package org.example.repository.interfaces.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.controller.dto.Address;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_seq")
    @SequenceGenerator(
            name="address_seq",
            sequenceName="address_hibernate_sequence",
            allocationSize=1
    )
    @Column(name = "address_id", updatable = false, nullable = false)
    private long addressId;

    @Column(name = "addressline1", nullable = false)
    private String addressLine1;
    @Column(name = "addressline2", nullable = false)
    private String addressLine2;

    @OneToOne(mappedBy = "addressData")
    private StudentData student;

    public static Address map(AddressData addressData) {
        return new Address(addressData.addressLine1, addressData.addressLine2);
    }
}
