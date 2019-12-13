package com.mtl.consumer.pojo;

import lombok.Data;
import java.util.Date;

/**
 * Created by MTL on 2019/12/12
 */
@Data
public class User {
    private Long id;

    private String userName;

    private String passwd;

    private String name;

    private Integer age;

    private Integer sex;

    private Date birthday;

    private Date created;

    private Date updated;

    private String note;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passwd='" + passwd + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", created=" + created +
                ", updated=" + updated +
                ", note='" + note + '\'' +
                '}';
    }
}
