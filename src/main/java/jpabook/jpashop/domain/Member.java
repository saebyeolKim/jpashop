package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter //보통 Setter 생성X, 비즈니스 메서드를 별도로 제공
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    @Embedded
    private Address address;

    @JsonIgnore // json 형식에서 제거 해주는 것 (api 에서), 잘못된 것!
    @OneToMany(mappedBy = "member") //order table 에 있는 필드 이름
    private List<Order> orders = new ArrayList<>();
}
