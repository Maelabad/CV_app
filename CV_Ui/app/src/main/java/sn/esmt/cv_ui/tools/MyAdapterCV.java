package sn.esmt.cv_ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import sn.esmt.cv_ui.R;
import sn.esmt.cv_ui.httpconfig.CVResponse;


import java.util.ArrayList;


public class MyAdapterCV extends BaseAdapter {

    private ArrayList<CVResponse> usersCV;
    private LayoutInflater myInflater;

    public MyAdapterCV(Context context, ArrayList<CVResponse> usersCV)
    {
        this.myInflater = LayoutInflater.from(context);
        this.usersCV = usersCV;
    }

    @Override
    public int getCount() {
        return this.usersCV.size();
    }

    @Override
    public Object getItem(int arg0) {
        return this.usersCV.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        TextView textnom;
        TextView textprenom;
        TextView textage;
        TextView textadresse;
        TextView textemail;
        TextView texttelephone;
        TextView textexperienceProfessionnelle;
        TextView textniveauEtude;
        TextView textspecialite;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null)
        {
            convertView = myInflater.inflate(R.layout.listitem_cv, null);
            holder = new ViewHolder();
            holder.textnom = (TextView) convertView.findViewById(R.id.txtnom);
            holder.textprenom = (TextView) convertView.findViewById(R.id.txtprenom);
            holder.textage = (TextView) convertView.findViewById(R.id.txtage);
            holder.textemail = (TextView) convertView.findViewById(R.id.txtemail);
            holder.textadresse = (TextView) convertView.findViewById(R.id.txtadresse);
            holder.texttelephone = (TextView) convertView.findViewById(R.id.txttelephone);
            holder.textspecialite = (TextView) convertView.findViewById(R.id.txtspecialite);
            holder.textniveauEtude = (TextView) convertView.findViewById(R.id.txtniveauEtude);
            holder.textexperienceProfessionnelle = (TextView) convertView.findViewById(R.id.txtexperienceProfessionnelle);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textnom.setText(usersCV.get(position).getNom()+"");
        holder.textprenom.setText(usersCV.get(position).getPrenom()+"");
        holder.textage.setText(usersCV.get(position).getAge()+"");
        holder.textemail.setText(usersCV.get(position).getEmail());
        holder.textadresse.setText(usersCV.get(position).getAddresse());
        holder.texttelephone.setText(usersCV.get(position).getTelephone());
        holder.textspecialite.setText(usersCV.get(position).getSpecialite());
        holder.textniveauEtude.setText(usersCV.get(position).getNiveauEtude());
        holder.textexperienceProfessionnelle.setText(usersCV.get(position).getExperienceProfessionnelle());

        return convertView;

    }

}



