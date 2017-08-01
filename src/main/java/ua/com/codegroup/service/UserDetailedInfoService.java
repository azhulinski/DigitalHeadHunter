package ua.com.codegroup.service;

import org.springframework.stereotype.Service;
import ua.com.codegroup.entity.UserDetailedInfo;

@Service
public interface UserDetailedInfoService {

    void save(UserDetailedInfo userDetailedInfo);



}
