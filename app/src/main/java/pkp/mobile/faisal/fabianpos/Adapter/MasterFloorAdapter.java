package pkp.mobile.faisal.fabianpos.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import pkp.mobile.faisal.fabianpos.Models.FloorModel;
import pkp.mobile.faisal.fabianpos.R;

public class MasterFloorAdapter extends RecyclerView.Adapter<MasterFloorAdapter.DataObjectHolder> {
    private ArrayList<FloorModel> mDataSet;
    private OnListItemClick onListClick;

    public MasterFloorAdapter(ArrayList<FloorModel> myDataSet, OnListItemClick onListClick) {
        mDataSet = myDataSet;
        this.onListClick = onListClick;

    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_master_floor, parent, false);
        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        final FloorModel penugasan = mDataSet.get(position);
        holder.mNama.setText(penugasan.getName());
        holder.mRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListClick.onListClick(penugasan);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    public static class DataObjectHolder extends RecyclerView.ViewHolder {

        private ArrayList<FloorModel> mItemSet;
        private TextView mNama;
        private LinearLayout mRoot;


        public DataObjectHolder(final View view) {
            super(view);
            mNama = view.findViewById(R.id.name);
            mRoot = view.findViewById(R.id.root);
        }
    }


    public interface OnListItemClick {
        void onListClick(FloorModel floorModel);
    }
}
