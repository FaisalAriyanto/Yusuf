package pkp.mobile.faisal.fabianpos.FragmentMasters;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import pkp.mobile.faisal.fabianpos.Adapter.MasterFloorAdapter;
import pkp.mobile.faisal.fabianpos.Models.FloorModel;
import pkp.mobile.faisal.fabianpos.R;
import pkp.mobile.faisal.fabianpos.Sqlite.DBFloorHelper;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MasterFloorsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MasterFloorsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MasterFloorsFragment extends Fragment implements View.OnClickListener, MasterFloorAdapter.OnListItemClick {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    private RecyclerView.Adapter mAdapter;
    private ArrayList<FloorModel> taskListBase = new ArrayList<>();
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Context context;
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private FloatingActionButton mFab;
    private DBFloorHelper dbFloorHelper;

    public MasterFloorsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MasterFloorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MasterFloorsFragment newInstance(String param1, String param2) {
        MasterFloorsFragment fragment = new MasterFloorsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_master_floor, container, false);

        mFab = view.findViewById(R.id.fab);
        mFab.setOnClickListener(this);
        dbFloorHelper = new DBFloorHelper(getActivity());
        makeCardView(view);

        return view;
    }

    private void makeCardView(final View view) {
        taskListBase.addAll(dbFloorHelper.getAll());
        RecyclerView mRecyclerView = view.findViewById(R.id.rv_floor);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayout.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MasterFloorAdapter(taskListBase, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void showAlert(final FloorModel floorModel) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_master_floor, null);

        final TextView mName = view.findViewById(R.id.name);

        if (floorModel != null) {
            mName.setText(floorModel.getName());
        }

        builder.setView(view);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = mName.getText().toString();

                if (name.isEmpty()) {
                    mName.setError("Required");
                    return;
                }


                if (floorModel != null) {
                    //edit
                    floorModel.setName(name);
                    onUpdate(floorModel);
                } else {
                    //save
                    onSave(name);
                }

            }
        });

        builder.show();
    }

    private void onSave(String name) {
        dbFloorHelper.addFloor(new FloorModel(name));
        taskListBase.clear();
        taskListBase.addAll(dbFloorHelper.getAll());
        mAdapter.notifyDataSetChanged();
    }

    private void onUpdate(FloorModel floor) {
        dbFloorHelper.update(floor);
        taskListBase.clear();
        taskListBase.addAll(dbFloorHelper.getAll());
        mAdapter.notifyDataSetChanged();
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                showAlert(null);
                break;
        }
    }

    @Override
    public void onListClick(FloorModel floorModel) {
        showAlert(floorModel);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
