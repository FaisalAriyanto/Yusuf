package pkp.mobile.faisal.fabianpos.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pkp.mobile.faisal.fabianpos.Models.FloorModel;
import pkp.mobile.faisal.fabianpos.R;

public class MasterFloorAdapter extends RecyclerView.Adapter<MasterFloorAdapter.DataObjectHolder> {
    private ArrayList<FloorModel> mDataSet;

    public MasterFloorAdapter(ArrayList<FloorModel> myDataSet) {
        mDataSet = myDataSet;
    }

    public MasterFloorAdapter() {

    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_master_floor, parent, false);
        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        FloorModel penugasan = mDataSet.get(position);
        holder.mNama.setText(penugasan.getName());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    public static class DataObjectHolder extends RecyclerView.ViewHolder {

        private ArrayList<FloorModel> mItemSet;
        private TextView mNama;


        public DataObjectHolder(final View view) {
            super(view);
            mNama = (TextView) view.findViewById(R.id.name);
        }
    }

}
