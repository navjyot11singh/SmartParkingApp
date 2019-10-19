package www.navjyotsingh.smartparkingapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import www.navjyotsingh.smartparkingapp.Adapter.ParkingLotsAdapter;
import www.navjyotsingh.smartparkingapp.R;

public class SearchParkingFragment extends Fragment {

    private RecyclerView parkingListRecyclerView;
    private ParkingLotsAdapter parkingLotsAdapter;
    private LinearLayoutManager layoutManager;

    private ArrayList<ParkingLot_Model> arrayList= new ArrayList<>();
    public SearchParkingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_search_parking, container, false);
        init(view);
        fakeList();
        setParkingRecycler();
        return view;
    }
//-------------fake list ---------------------
    private void fakeList() {
        ParkingLot_Model parkingLot_model = new ParkingLot_Model(R.drawable.ic_launcher_foreground,"","","");

        arrayList.add(parkingLot_model);
        arrayList.add(parkingLot_model);
        arrayList.add(parkingLot_model);
        arrayList.add(parkingLot_model);
        arrayList.add(parkingLot_model);
        arrayList.add(parkingLot_model);

    }

//    ----------------initialisg views here---------------
    private void init(View view){
        parkingListRecyclerView = view.findViewById(R.id.parkingListRecyclerView);
    }

//    ------------------setting up list here----------------
    private void setParkingRecycler(){
        parkingLotsAdapter = new ParkingLotsAdapter(getContext(),arrayList);
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        parkingListRecyclerView.setLayoutManager(layoutManager);
        parkingListRecyclerView.setHasFixedSize(true);
        parkingListRecyclerView.setAdapter(parkingLotsAdapter);
    }

}
