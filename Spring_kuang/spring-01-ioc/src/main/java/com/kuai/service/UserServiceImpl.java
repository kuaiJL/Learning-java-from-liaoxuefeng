package com.kuai.service;

import com.kuai.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    //利用set进行实现值的注入！
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
