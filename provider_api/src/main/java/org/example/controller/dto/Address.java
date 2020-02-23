package org.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.repository.interfaces.dto.AddressData;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Address {

    private String addressLine1;
    private String addressLine2;

    public static AddressData map(Address addressData) {
        return new AddressData(addressData.addressLine1,addressData.addressLine2);
    }

}
