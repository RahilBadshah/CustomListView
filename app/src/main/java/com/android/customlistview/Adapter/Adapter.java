package com.android.customlistview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.customlistview.Model.Model;
import com.android.customlistview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    ArrayList<Model> modelArrayList = new ArrayList<>();
    Context context;

    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_list, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.img);
        TextView textView = convertView.findViewById(R.id.tv);
        LinearLayout linearLayout = convertView.findViewById(R.id.lin);

        final Model model = modelArrayList.get(position);

        textView.setText(model.getName());
        if (!model.getImage().equals("")) {
            Picasso.with(context).load(model.getImage()).into(imageView);
        }
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, model.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
