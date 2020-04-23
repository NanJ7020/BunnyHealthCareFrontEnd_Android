package com.example.pooptest.ProfileMgmt.history;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pooptest.R;

import java.util.List;

public class HistoryRecordListAdapter extends ArrayAdapter<HistoryRecordItem> {
    private List<HistoryRecordItem> historyRecords;
    private Context context;

    public HistoryRecordListAdapter(@NonNull Context context, int resource, @NonNull List<HistoryRecordItem> objects) {
        super(context, resource, objects);
        this.historyRecords=objects;
        this.context=context;
    }

    //return back to list view
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //single item of the view
        View view = layoutInflater.inflate(R.layout.list_view_history_item, parent,false);

        TextView recordsPetName = view.findViewById(R.id.recordsPetName_textView);
        TextView recordsDate =view.findViewById(R.id.recordsDate_textView);
        TextView recordsReason = view.findViewById(R.id.recordsReason_textView);
        Button recordsDetail = view.findViewById(R.id.recordsDetail_btn);

        recordsPetName.setText(historyRecords.get(position).getPet());
        recordsDate.setText(""+ historyRecords.get(position).getVisitTime());
        recordsReason.setText(historyRecords.get(position).getReasonForHospital());

        recordsDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //link to records for Details
                Intent intent = new Intent(context, HistoryRecordDetailActivity.class);
                intent.putExtra("index", position);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
