package com.ecom.online.mapper;

import com.ecom.online.entity.AddressEntity;
import com.ecom.online.entity.UserEntity;
import com.ecom.online.model.AddressRequest;
import com.ecom.online.model.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    AddressEntity addressRequestToAddressEntity(AddressRequest addressRequest);

    UserResponse userEntiyToUserResponse(UserEntity userEntity);


}
