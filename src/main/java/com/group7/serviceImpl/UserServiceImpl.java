package com.group7.serviceImpl;

import com.group7.dao.UserDao;
import com.group7.entity.User;
import com.group7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Description:
 * Author:严浩天
 * CreateTime:2018-11-24 10:10
 */
@Service
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int register(User user) {
        int i = userDao.register(user);
        System.out.println("插入后返回的主键:"+user.getId());
        userDao.addPhone(user.getUserPhone(),user.getId());
        return i;
//        return userDao.addPhone(user.getUserPhone(),user.getId());

    }

    @Override
    public String checkRepeat(String userName) {
        return userDao.checkRepeat(userName);
    }

    @Override
    public String checkRepeatPhone(String userPhone) {
        return null;
    }

}
