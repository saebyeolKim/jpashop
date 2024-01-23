package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter //값타입은 변경 불가능한 클래스로 만들자
public class Address {

    private String city;
    private String street;
    private String zipcode;

    //기본생성자를 만들어서 Address 를 new 로 함부로 생성하지 않게 한다.
    protected Address() {}

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
