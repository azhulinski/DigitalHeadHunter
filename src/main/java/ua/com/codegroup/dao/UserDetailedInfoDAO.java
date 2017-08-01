package ua.com.codegroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.codegroup.entity.UserDetailedInfo;

public interface UserDetailedInfoDAO extends JpaRepository<UserDetailedInfo, Integer> {



}
