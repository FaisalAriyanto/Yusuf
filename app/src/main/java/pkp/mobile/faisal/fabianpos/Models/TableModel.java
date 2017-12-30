package pkp.mobile.faisal.fabianpos.Models;

/**
 * Created by Faisal on 30/12/17.
 */

public class TableModel {
    private int id;
    private String name;
    private String isEmpty;
    private int floor_id;


    public TableModel(int id, String name, String isEmpty, int floor_id) {
        this.id = id;
        this.name = name;
        this.isEmpty = isEmpty;
        this.floor_id = floor_id;
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

    public String isEmpty() {
        return isEmpty;
    }

    public void setEmpty(String empty) {
        isEmpty = empty;
    }

    public int getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(int floor_id) {
        this.floor_id = floor_id;
    }
}


