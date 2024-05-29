package com.ecom.online.mapper;

import com.ecom.online.entity.AddressEntity;
import com.ecom.online.entity.UserEntity;
import com.ecom.online.model.AddressRequest;
import com.ecom.online.model.UserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-27T08:17:44+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public AddressEntity addressRequestToAddressEntity(AddressRequest addressRequest) {
        if ( addressRequest == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setStreet( addressRequest.getStreet() );
        addressEntity.setArea( addressRequest.getArea() );
        addressEntity.setPinCode( addressRequest.getPinCode() );
        addressEntity.setDist( addressRequest.getDist() );
        addressEntity.setState( addressRequest.getState() );
        addressEntity.setCountry( addressRequest.getCountry() );

        return addressEntity;
    }

    @Override
    public UserResponse userEntiyToUserResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setUserName( userEntity.getUserName() );
        userResponse.setEmail( userEntity.getEmail() );
        userResponse.setPassword( userEntity.getPassword() );
        userResponse.setAddress( addressEntityToAddressRequest( userEntity.getAddress() ) );

        return userResponse;
    }

    protected AddressRequest addressEntityToAddressRequest(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        String street = null;
        String area = null;
        String pinCode = null;
        String dist = null;
        String state = null;
        String country = null;

        street = addressEntity.getStreet();
        area = addressEntity.getArea();
        pinCode = addressEntity.getPinCode();
        dist = addressEntity.getDist();
        state = addressEntity.getState();
        country = addressEntity.getCountry();

        AddressRequest addressRequest = new AddressRequest( street, area, pinCode, dist, state, country );

        return addressRequest;
    }
}
