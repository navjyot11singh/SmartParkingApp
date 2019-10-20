package www.navjyotsingh.smartparkingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import www.navjyotsingh.smartparkingapp.BookedActivity;
import www.navjyotsingh.smartparkingapp.ParkingDescription;
import www.navjyotsingh.smartparkingapp.R;
import www.navjyotsingh.smartparkingapp.fragment.ParkingLot_Model;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ParkingLot_Model> list;
    //    private SharedPreferences reasonSharedPrefrences;
//    private SharedPreferences.Editor editor;

    public HistoryAdapter(Context context, ArrayList<ParkingLot_Model> mList) {
        this.context = context;
        this.list = mList;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_history, parent, false);
        HistoryAdapter.ViewHolder cardViewHolder = new HistoryAdapter.ViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HistoryAdapter.ViewHolder holder, final int position) {
        holder.historyLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, BookedActivity.class));
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout historyLay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            historyLay = itemView.findViewById(R.id.historyLay);

        }


    }


}


