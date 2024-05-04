package com.example.lab4_20200241;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4_20200241.dto.Geolocalizacion;

public class GeoAdapter extends RecyclerView.Adapter<GeoAdapter.GeolocalizacionViewHolder>{

    /** Se crean las variables **/
    private String name;
    private Context context;

    /** SE CREARON LOS SIGUIENTES METODOS APARTIR DEL EXTENDS **/
    @NonNull
    @Override
    public GeolocalizacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /** Se debe inflarel layout y crear la instancia **/
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv, parent,false);
        return new GeolocalizacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GeolocalizacionViewHolder holder, int position) {
        /** Indica como se va llenar la informacion **/

        Geolocalizacion e = holder.geolocalizacion;

        TextView textViewFirstName = holder.itemView.findViewById(R.id. latEncontrada2);
        textViewFirstName.setText(e.getLat()) ;

        TextView textViewLastName = holder.itemView.findViewById(R.id. lonEncontrada2);
        textViewLastName.setText(e.getLon()) ;

    }

    @Override
    public int getItemCount() {
        return 1;
    }


    /** Se crea el ViewHolder **/
    public class GeolocalizacionViewHolder extends RecyclerView.ViewHolder{
        Geolocalizacion geolocalizacion;
        public GeolocalizacionViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
