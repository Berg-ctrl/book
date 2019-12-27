package book.domain;

public class Admin {
    private Integer admin_id;

    private String admin_name;

    private String admin_pwd;

    private String admin_email;

    private String admin_phone;

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name == null ? null : admin_name.trim();
    }

    public String getAdmin_pwd() {
        return admin_pwd;
    }

    public void setAdmin_pwd(String admin_pwd) {
        this.admin_pwd = admin_pwd == null ? null : admin_pwd.trim();
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email == null ? null : admin_email.trim();
    }

    public String getAdmin_phone() {
        return admin_phone;
    }

    public void setAdmin_phone(String admin_phone) {
        this.admin_phone = admin_phone == null ? null : admin_phone.trim();
    }
}