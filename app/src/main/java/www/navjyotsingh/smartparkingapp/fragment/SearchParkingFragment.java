package www.navjyotsingh.smartparkingapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

import www.navjyotsingh.smartparkingapp.Adapter.ParkingLotsAdapter;
import www.navjyotsingh.smartparkingapp.R;

public class SearchParkingFragment extends Fragment {

    private RecyclerView parkingListRecyclerView;
    private ParkingLotsAdapter parkingLotsAdapter;
    private LinearLayoutManager layoutManager;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4};

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
        setCrouserView();
        fakeList();;

        setParkingRecycler();
        return view;
    }

    private void setCrouserView() {
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        });
    }

    //-------------fake list ---------------------
    private void fakeList() {

        arrayList.add(new ParkingLot_Model(R.drawable.p,"Janakpuri","Wz 4488 near metro fjdkjfkjfnkfd","2.5 km from your home"));
        arrayList.add(new ParkingLot_Model(R.drawable.p1,"Uttan","uttan nagar near metrofdfdflkdnklfdlkfmdlkfndkf","0.5 km from your home"));
        arrayList.add(new ParkingLot_Model(R.drawable.p2,"MultiFLoor","J block Paschim vihar fmdnfljkd flkdnflkd","1.23 km from your home"));
        arrayList.add(new ParkingLot_Model(R.drawable.p3,"District","Dwarka 201f lfmd flkdfkmsdlfmd","8.4 km from your home"));
        arrayList.add(new ParkingLot_Model(R.drawable.p4,"Basement","Wz 4488 near metro.kdfmlkdmflmfl;smf","12.4 km from your home"));

    }

//    ----------------initialisg views here---------------
    private void init(View view){
        parkingListRecyclerView = view.findViewById(R.id.parkingListRecyclerView);
        carouselView = view.findViewById(R.id.carouselView);

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
