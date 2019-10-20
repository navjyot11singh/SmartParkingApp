package www.navjyotsingh.smartparkingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        holder.parkingImage.setImageResource(list.get(position).getImages());
        holder.txt_parkinglotName.setText(list.get(position).getParkingLotName());
        holder.ParkingAddress.setText(list.get(position).getAddress());
        holder.distanceTv.setText(list.get(position).getDistance());
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

        private ImageView parkingImage;
        private TextView txt_parkinglotName;
        private TextView ParkingAddress;
        private TextView distanceTv;
        private LinearLayout parking_spot_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parking_spot_item = itemView.findViewById(R.id.parking_spot_item);
            parkingImage = itemView.findViewById(R.id.parkingImage);
            txt_parkinglotName = itemView.findViewById(R.id.txt_parkinglotName);
            ParkingAddress = itemView.findViewById(R.id.ParkingAddress);
            distanceTv = itemView.findViewById(R.id.distanceTv);

        }


    }



}
