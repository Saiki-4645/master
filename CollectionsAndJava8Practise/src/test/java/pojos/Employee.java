package pojos;

public class Employee {
    private int id;
    private String name;
    private String stream;

    public Employee(int id, String name, String stream) {
        this.id = id;
        this.name = name;
        this.stream = stream;
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

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stream='" + stream + '\'' +
                '}';
    }
}
