package ua.com.codegroup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codegroup.dao.UserDetailedInfoDAO;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.entity.UserDetailedInfo;
import ua.com.codegroup.service.UserDetailedInfoService;

@Service
@Transactional
public class UserDetailedInfoServiceImpl implements UserDetailedInfoService {

    @Autowired
    private UserDetailedInfoDAO userDetailedInfoDAO;

    public void save(UserDetailedInfo userDetailedInfo) {
        userDetailedInfoDAO.save(userDetailedInfo);
    }

    @Override
    public UserDetailedInfo findDetailsByUserId(int id) {
        return userDetailedInfoDAO.findDetailsByUserId(id);
    }


}
