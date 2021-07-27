package hello.login.domain.member;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //DB 저장 Id

    @NotBlank
    private String loginId; // 로그인 Id

    @NotBlank
    private String name;

    @NotBlank
    private String password;


    @Builder
    public Member(String loginId, String password, String name) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }

    public static Member of(String loginId, String password, String name) {
        return new Member().builder()
                .loginId(loginId)
                .name(name)
                .password(password)
                .build();
    }

}
