package sg.edu.rp.c346.id20025835.demotodolist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> ToDoList;

    public CustomAdapter(Context context, int resource, ArrayList<ToDoItem> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        ToDoList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textView);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);

        ToDoItem currentList = ToDoList.get(position);

        tvTitle.setText(currentList.getTitle());
        tvDate.setText(currentList.toString());

        if (currentList.getDate().get(Calendar.YEAR) == 2021) {
            tvDate.setTextColor(Color.RED);
        }

        return rowView;
    }
}

