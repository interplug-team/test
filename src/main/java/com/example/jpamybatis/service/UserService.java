package com.example.jpamybatis.service;

import com.example.jpamybatis.dao.UserDao;
import com.example.jpamybatis.dto.UserRecord;
import com.example.jpamybatis.entity.UserEntity;
import com.example.jpamybatis.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    public List<UserRecord> getUsers() {
        return userRepository.findAll().stream()
                .map(userEntity -> new UserRecord(userEntity.getName(), userEntity.getAge()))
                .toList();
    }


    public void addUser(UserRecord userRecord) {
        userRepository.save(new UserEntity(userRecord.name(), userRecord.age()));
    }

    public UserRecord getUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow();
        return new UserRecord(userEntity.getName(), userEntity.getAge());
    }

    public UserRecord getUserMybatis(Long id) {
        return userDao.findByIdMybatis(id);
    }

    public void addUserMybatis(UserRecord userRecord) throws Exception {
        UserEntity userEntity = new UserEntity(userRecord.name(), userRecord.age());

        userRepository.save(userEntity);
        userDao.insertMybatis(userEntity);



    }
}
