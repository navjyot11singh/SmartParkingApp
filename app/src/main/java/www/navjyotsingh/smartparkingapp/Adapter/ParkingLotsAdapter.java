package www.navjyotsingh.smartparkingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import www.navjyotsingh.smartparkingapp.ParkingDescription;
import www.navjyotsingh.smartparkingapp.ParkingMapsActivity;
import www.navjyotsingh.smartparkingapp.R;
import www.navjyotsingh.smartparkingapp.fragment.ParkingLot_Model;


public class ParkingLotsAdapter extends RecyclerView.Adapter<ParkingLotsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ParkingLot_Model> list;
    //    private SharedPreferences reasonSharedPrefrences;
//    private SharedPreferences.Editor editor;

    public ParkingLotsAdapter(Context context, ArrayList<ParkingLot_Model> mList) {
        this.context = context;
        this.list = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parking_spots_item_layout, parent, false);
        ViewHolder cardViewHolder = new ViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.parking_spot_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ParkingDescription.class));
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        private LinearLayout parking_spot_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parking_spot_item = itemView.findViewById(R.id.parking_spot_item);

        }


    }



}
