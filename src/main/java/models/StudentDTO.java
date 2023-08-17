package models;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@ToString

public class StudentDTO {

    String firstName;
    String lastName;
    String email;
    //    String gender;
    Gender gender;
    String phone;
    String birthday;
    String subjects;
    //    String hobbies;
    List<Hobby> hobbies;
    String address;
    String state;
    String city;

}