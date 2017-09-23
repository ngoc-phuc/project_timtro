package example.com.timtro;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14/09/2017.
 */

public class CustomListItemAdapter extends ArrayAdapter<PhongTro> {
    private Activity activity;
    private  int idLayout;
    private ArrayList<PhongTro> list;
    public CustomListItemAdapter(Activity activity, int idLayout , ArrayList<PhongTro> list){
        super(activity,idLayout,list);
        this.activity=activity;
        this.idLayout=idLayout;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(idLayout,null);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.i1) ;
        TextView textViewdc =(TextView) convertView.findViewById(R.id.dc);
        TextView textViewdt =(TextView) convertView.findViewById(R.id.dt);
        TextView textViewgt =(TextView) convertView.findViewById(R.id.gt);
        TextView textView1 =(TextView) convertView.findViewById(R.id.tv1);
        textView1.setText(list.get(position).getGiatien());
        TextView textView2 =(TextView) convertView.findViewById(R.id.tv2);
        textView2.setText(list.get(position).getDiachi());
        TextView textView3 =(TextView) convertView.findViewById(R.id.tv3);
        textView3.setText(list.get(position).getSdt());

        return convertView;
    }
}
