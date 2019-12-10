package models;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import play.data.format.Formats;
import tables.T_User;

@Getter
@NoArgsConstructor
public class UserItem {

    Long id;

    String name;

    String title;

    String message;

    @Formats.DateTime(pattern = "yyyy/MM/dd HH:mm:SS")
    Date createdAt;

    @Formats.DateTime(pattern = "yyyy/MM/dd HH:mm:SS")
    Date updatedAt;

    public UserItem(T_User user) {
        this.id = user.id;
        this.name = user.name;
        this.title = user.title;
        this.message = user.message;
        this.createdAt = user.createdAt;
        this.updatedAt = user.updatedAt;
    }
}