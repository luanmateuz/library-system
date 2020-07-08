package model;

/**
 *
 * @author luan
 */
public class Fine {
    
    private int id;
    private int idStudent;
    private String description;
    private float value;

    public Fine(int id, int idStudent, String description, float value) {
        this.id = id;
        this.idStudent = idStudent;
        this.description = description;
        this.value = value;
    }

    public Fine() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    
}
