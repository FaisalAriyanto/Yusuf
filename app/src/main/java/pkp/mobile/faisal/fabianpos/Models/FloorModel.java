package pkp.mobile.faisal.fabianpos.Models;

/**
 * Created by Faisal on 30/12/17.
 */

public class FloorModel {
    private int floor_id;
    private String name;

    public FloorModel(int floor_id, String name) {
        this.floor_id = floor_id;
        this.name = name;
    }

    public int getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(int floor_id) {
        this.floor_id = floor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


