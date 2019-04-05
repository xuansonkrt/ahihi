package application.model.dto;

public class AhihiDTO {
    private String n;
    private String k;
    private String arr;

    public AhihiDTO(String n, String k, String arr) {
        this.n = n;
        this.k = k;
        this.arr = arr;
    }

    public AhihiDTO() {
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getArr() {
        return arr;
    }

    public void setArr(String arr) {
        this.arr = arr;
    }
}
