package com.example.lab4_20200241;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4_20200241.dto.Geolocalizacion;

import java.util.ArrayList;
import java.util.List;

public class GeoAdapter extends RecyclerView.Adapter<GeoAdapter.GeolocalizacionViewHolder>{

    /** Se crean las variables **/
    private List<Geolocalizacion> geolocalizacions;
    private Context context;



    public GeoAdapter(Context context) {
        this.context = context;
        this.geolocalizacions = new ArrayList<>();
    }

    public void setCities(List<Geolocalizacion> geolocalizacions) {
        this.geolocalizacions = geolocalizacions;
        notifyDataSetChanged();
    }


    /** SE CREARON LOS SIGUIENTES METODOS APARTIR DEL EXTENDS **/
    @NonNull
    @Override
    public GeolocalizacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /** Se debe inflarel layout y crear la instancia **/
        View view = LayoutInflater.from(context).inflate(R.layout.item_geo, parent,false);
        return new GeolocalizacionViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull GeolocalizacionViewHolder holder, int position) {
        /** Indica como se va llenar la informacion **/

        Geolocalizacion geo = geolocalizacions.get(position);
        holder.geolocalizacion = geo;


        /** FALTA ANALIZAR AQUÍ :D **/

    }

    @Override
    public int getItemCount() {
        if (geolocalizacions == null) {
            return 0;
        } else {
            return geolocalizacions.size();
        }
    }


    /** Se crea el ViewHolder **/
    public class GeolocalizacionViewHolder extends RecyclerView.ViewHolder{
        Geolocalizacion geolocalizacion;
        public GeolocalizacionViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
