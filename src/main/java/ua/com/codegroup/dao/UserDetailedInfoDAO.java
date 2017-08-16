package ua.com.codegroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.codegroup.entity.UserDetailedInfo;

public interface UserDetailedInfoDAO extends JpaRepository<UserDetailedInfo, Integer> {

    @Query("select d from UserDetailedInfo d join fetch d.user where d.user.id=:id")
    UserDetailedInfo findDetailsByUserId(@Param("id") int id);


}
