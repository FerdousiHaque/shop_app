package Model;

public class Data {

    private String tittle;
    private String note;
    private String data;
    private String id;
    private int amount;

    public Data() {

    }

    public Data(String tittle, String note, String data, String id, int amount) {
        this.tittle = tittle;
        this.note = note;
        this.data = data;
        this.id = id;
        this.amount = amount;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
