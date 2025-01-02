package com.najwa.laundryapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.najwa.laundryapps.ModelLayanan;

import java.util.List;

public class AdapterLayanan extends RecyclerView.Adapter<AdapterLayanan.ViewHolder> {
    private static final String TAG = AdapterLayanan.class.getSimpleName();
    private Context context;
    private List<ModelLayanan> list;
    private View.OnClickListener onItemClicked;
    public void setOnItemClickListener(View.OnClickListener
                                               itemClickListener){
        onItemClicked = itemClickListener;
    }
    public AdapterLayanan(Context context, List<ModelLayanan> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype){
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layanan,
                        parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        ModelLayanan item =  list.get(position);
        holder.tvTipe.setText(item.getTipe());
        holder.tvHarga.setText(item.getHarga());
    }
    @Override
    public int getItemCount(){
        return  list.size();
    }
    public void clear(){
        int size = this.list.size();
        this.list.clear();
        notifyItemRangeRemoved(0, size);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTipe, tvHarga;

        public ViewHolder(View itemview){
            super(itemview);
            tvTipe = (TextView) itemview.findViewById(R.id.tvLayanan);
            tvHarga = (TextView) itemview.findViewById(R.id.tvHarga);
            itemview.setTag(this);
            itemview.setOnClickListener(onItemClicked);
        }
    }
}
