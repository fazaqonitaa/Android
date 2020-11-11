package com.jek.recipetaste;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListResepAdapter extends RecyclerView.Adapter<ListResepAdapter.ListViewHolder> {
    private ArrayList<Resep> listResep;
    public ListResepAdapter(ArrayList<Resep> list) {
        this.listResep = list;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_resep, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Resep resep = listResep.get(position);
        Glide.with(holder.itemView.getContext())
                .load(resep.getPhoto())
                .apply(new RequestOptions())
                .into(holder.imgPhoto);

        holder.tvName.setText(resep.getName());
        holder.tvDetail.setText(resep.getDetail());
        holder.tvDurasi.setText(resep.getDuration());
        holder.nama=(resep.getName());
        holder.durasi=(resep.getDuration());
        holder.detail=(resep.getDetail());
        holder.images=(resep.getPhoto());
    }

    @Override
    public int getItemCount() {
        return listResep.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgPhoto;
        Context context;
        RelativeLayout relative;
        String nama,durasi,detail;
        String images;
        Button loveit;
        TextView tvName, tvDurasi, tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            context= itemView.getContext();
            loveit = itemView.findViewById(R.id.button_fav);
            tvName = itemView.findViewById(R.id.display_name);
            tvDurasi = itemView.findViewById(R.id.durasi_main);
            tvDetail= itemView.findViewById(R.id.display_detail);
            imgPhoto = itemView.findViewById(R.id.menu_photo);
            relative= itemView.findViewById(R.id.relative_id);
            relative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,DetailActivity.class);
                    intent.putExtra("nama",nama);
                    intent.putExtra("durasi",durasi);
                    intent.putExtra("gambar",images);
                    intent.putExtra("informasi",detail);
                    context.startActivity(intent);
                }
            });
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Resep data);
    }
}
