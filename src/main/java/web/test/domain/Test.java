package web.test.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by PC on 07.09.14.
 */

public class Test {

    @Id
    private Long id;

    private String name;

    private Date date;

    public Test() {
    }

    public Test(Long id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}

