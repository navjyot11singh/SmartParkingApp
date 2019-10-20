package www.navjyotsingh.smartparkingapp.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import www.navjyotsingh.smartparkingapp.Adapter.HistoryAdapter;
import www.navjyotsingh.smartparkingapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {
LinearLayoutManager linearLayoutManager;
RecyclerView recyclerView;
HistoryAdapter adapter;
ArrayList<ParkingLot_Model> arrayList = new ArrayList<>();


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = view.findViewById(R.id.rec_history);
        recHistory();
        return view;
    }

    public  void recHistory(){

        ParkingLot_Model p = new ParkingLot_Model(R.drawable.ic_launcher_foreground,"",
                "","");

        arrayList.add(p);
        arrayList.add(p);
        arrayList.add(p);
        arrayList.add(p);
        arrayList.add(p);
        arrayList.add(p);

        HistoryAdapter historyAdapter = new HistoryAdapter(getContext(),arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(historyAdapter);





    }


}
