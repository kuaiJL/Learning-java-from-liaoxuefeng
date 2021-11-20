package Z_jdbc.one;

public class User {
    private int id;
    private String name;
    private String mail;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return String.format("{Student: id=%d, name=%s, mail=%s}", this.id, this.name, this.mail);
    }
}
