package dto;

import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 22.07.2021
 * 27. SimpleProgram
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UserDto {
    private String email;
    private int id;

    public UserDto(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public static UserDto from(User user) {
        return new UserDto(user.getId(), user.getEmail());
    }

    public static List<UserDto> from(List<User> users) {
        List<UserDto> result = new ArrayList<>();

        for (User user : users) {
            UserDto userDto = from(user);
            result.add(userDto);
        }

        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDto.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("email='" + email + "'")
                .toString();
    }
}
