package kz.bitlab.group30.db;

public class Countries {

    private Long id;
    private String name;
    private String code;

    public Countries(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Countries() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
