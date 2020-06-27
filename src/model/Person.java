package model;

/**
 *
 * @author luan
 */
abstract public class Person {
    
    private int id;
    private String name;
    private String cpf;
    private String sex;
    private String birthday;
    private String address;
    private String telephone;

    public Person(int id, String name, String cpf, String sex, String birthday, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.telephone = telephone;
    }
    
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    
    }

    public int getId() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if (sex.equals("Male")) {
            this.sex = "m";
        } else if (sex.equals("Feminine")) {
            this.sex = "f";
        }
        
        if (sex.equals("m")) {
            this.sex = "Male";
        } else if (sex.equals("f"))  {
            this.sex = "Feminine";
        }
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
}
