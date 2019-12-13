package com.mtl.user.service;

import com.mtl.user.mapper.UserMapper;
import com.mtl.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MTL on 2019/12/12
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> getAll() {
        return userMapper.selectAll();
    }
}
