package com.colinting.springbootrediscache.domian;



import java.io.Serializable;


public class User implements Serializable {

    private Long id;

    private String name;

    private String sex;

    public User() {
    }

    public User(Long id,
                String name,
                String sex) {
        if (id == null) {
            throw new NullPointerException("Null id");
        }
        this.id = id;
        if (name == null) {
            throw new NullPointerException("Null name");
        }
        this.name = name;
        if (sex == null) {
            throw new NullPointerException("Null sex");
        }
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id + ", "
                + "name=" + name + ", "
                + "sex=" + sex
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof User) {
            User that = (User) o;
            return this.id.equals(that.getId())
                    && this.name.equals(that.getName())
                    && this.sex.equals(that.getSex());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h$ = 1;
        h$ *= 1000003;
        h$ ^= id.hashCode();
        h$ *= 1000003;
        h$ ^= name.hashCode();
        h$ *= 1000003;
        h$ ^= sex.hashCode();
        return h$;
    }


}
