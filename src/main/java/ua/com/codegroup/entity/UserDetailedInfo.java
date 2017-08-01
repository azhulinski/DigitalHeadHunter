package ua.com.codegroup.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class UserDetailedInfo {

    @Id
    private int id;
    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private Date dateOfBirth;
    private String gender;
    private boolean married;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
