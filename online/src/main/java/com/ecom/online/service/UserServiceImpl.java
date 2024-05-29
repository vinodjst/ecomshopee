package com.ecom.online.service;

import com.ecom.online.mapper.UserMapper;
import com.ecom.online.entity.AddressEntity;
import com.ecom.online.entity.UserEntity;
import com.ecom.online.model.UserRequest;
import com.ecom.online.model.UserResponse;
import com.ecom.online.repository.AddressRepository;
import com.ecom.online.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String registerUser(UserRequest userRequest) {

        UserEntity byUserName = userRepository.findByUserName(userRequest.getUsername());
        UserEntity byEmail = userRepository.findByEmail(userRequest.getEmail());
        if(byUserName !=null || byEmail !=null){

            return "UserName or Email already exits..Please provide another";
        }
        try {
            //Prepare entity to save into db
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(userRequest.getUsername());
            userEntity.setEmail(userRequest.getEmail());
            userEntity.setPassword(userRequest.getPassword());


           AddressEntity addressEntity = userMapper.addressRequestToAddressEntity(userRequest.getAddress());

           /* //address  entity mapping
            AddressEntity addressEntity = new AddressEntity();
            AddressRequest addressRequest = userRequest.getAddress();
            addressEntity.setArea(addressRequest.getArea());
            addressEntity.setStreet(addressRequest.getStreet());
            addressEntity.setPinCode(addressRequest.getPinCode());
            addressEntity.setDist(addressRequest.getDist());
            addressEntity.setState(addressRequest.getState());
            addressEntity.setCountry(addressRequest.getCountry());*/

            //save the address before user
            AddressEntity addressEntitySave = addressRepository.save(addressEntity);

            //set this adddress entity to user entity\
            userEntity.setAddress(addressEntitySave);

            //use repo.save predefined func to save data
            UserEntity save = userRepository.save(userEntity);
        }catch (InvalidDataAccessApiUsageException exception){
            throw new RuntimeException("Error while user registration process ::: " + exception.getMessage());
        }

        return "Registered Successfully.....!";
    }

    @Override
    public String loginUser(String userName, String password) {

        UserEntity userEntity = userRepository.findByUserNameAndPassword(userName, password);
        if(userEntity!=null){
            return "Login Success..";
        }

        return "Invalid credentails please provide valid username/password.";
    }

    @Override
    public UserResponse getProfile(Long id) {

        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(userEntity.isPresent()){

            UserResponse userResponse = userMapper.userEntiyToUserResponse(userEntity.get());
            //map entity class to response class
            //avoid below technique and use mapper
            /*UserResponse userResponse = new UserResponse();
            userResponse.setUserName(userEntity.get().getUserName());
*/


            return userResponse;

        }
        return null;
    }
}
