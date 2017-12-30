package pkp.mobile.faisal.fabianpos;

/**
 * Created by Faisal on 30/12/17.
 */

public class TableModel {
    private int id;
    private String name;
    private boolean isEmpty;
    private int floor_id;

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

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(int floor_id) {
        this.floor_id = floor_id;
    }
}


