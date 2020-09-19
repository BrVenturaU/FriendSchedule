package com.example.friendschedule.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.friendschedule.Entities.Amigo;
import com.example.friendschedule.Interfaces.IAmigoService;
import com.example.friendschedule.R;

import java.util.ArrayList;

public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private ArrayList<Amigo> amigos;
    private IAmigoService amigoService;
    private View.OnClickListener listener;

    public AmigosAdapter() {
    }

    public void setData(ArrayList<Amigo> list, IAmigoService service){
        amigos = list;
        amigoService = amigoService;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreCompleto, tvTelefono;
        ImageButton btnFavorito;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreCompleto = itemView.findViewById(R.id.tvNombreCompleto);
            tvTelefono = itemView.findViewById(R.id.tvTelefono);
            btnFavorito = itemView.findViewById(R.id.btnEditar);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_amigo, parent, false);
        view.setOnClickListener(this);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Amigo amigo = amigos.get(position);
        setAmigoData(amigo, holder);
    }

    @Override
    public int getItemCount() {
        return amigos.size();
    }

    public void setOnclicListener(View.OnClickListener listener){this.listener = listener;}

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

    private void setAmigoData(final Amigo amigo, ViewHolder holder){
        holder.tvNombreCompleto.setText(amigo.getPrimerNombre() + " " + amigo.getPrimerApellido());
        holder.tvTelefono.setText(amigo.getTelefono());
    }
}
