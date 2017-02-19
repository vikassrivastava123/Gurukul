package in.co.thingsdata.gurukul.ui.ReportCardUi;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.co.thingsdata.gurukul.R;
import in.co.thingsdata.gurukul.ui.dataUi.DataOfUi;
import in.co.thingsdata.gurukul.ui.dataUi.ReportCardData;

/**
 * Created by Ritika on 2/10/2017.
 */
public class ReportCardAdapter extends RecyclerView.Adapter<ReportCardAdapter.ReportCardViewHolder> implements Filterable {

    List<DataOfUi> mListOfData = null;
    List<DataOfUi> mListOfDataOrginal = null;
    private static final String TAG = "ReportCardAdapter";
    int mScrnNumber = -1;
    public static final int SINGLE_STUDENT_REPORTCARD_DETAIL = 0;
    public static final int TEACHER_VIEW_REPORTCARD = 1;
    public static final int CREATE_REPORT_CARD = 2;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);


    }


    @Override
    public ReportCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = null;

        if(mScrnNumber == SINGLE_STUDENT_REPORTCARD_DETAIL)
        {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.reportcarddetail, parent, false);
        }
        else if(mScrnNumber == TEACHER_VIEW_REPORTCARD){
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.rc_tv_studentlist, parent, false);
        }

        return new ReportCardViewHolder(itemView);
    }
int row_index = -1;

    @Override
    public void onBindViewHolder(ReportCardViewHolder holder,final int position) {

        holder.row_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index=position;

                int absPost = 0;
                try {

                    int orgSize = mListOfDataOrginal.size();
                    int newSize = mListOfData.size();
                    if (orgSize != newSize){
                        for (DataOfUi item : mListOfDataOrginal) {
                            if (item.equals(mListOfData.get(position))) {
                                break;
                            }
                            absPost++;
                        }
                    }else{
                        absPost = position;
                    }
                }catch (Exception e){
                    absPost = position;
                    Log.d(TAG,"absPost error");
                }finally {
                    mOnItemClickListener.onItemClick(view,absPost);
                }
             //    notifyDataSetChanged();
            }
        });

        if(row_index==position){
            holder.row_view.setBackgroundColor(Color.parseColor("#567845"));
        } else
        {
            holder.row_view.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        ReportCardData data = (ReportCardData) mListOfData.get(position);
        if(mScrnNumber == SINGLE_STUDENT_REPORTCARD_DETAIL) {
            holder.subject.setText(data.getSubject());
            holder.marksObtained.setText(data.getMarksObtained());
            holder.total.setText(data.getTotal());
            holder.percentage.setText(data.getPercentage());
        }else if(mScrnNumber == TEACHER_VIEW_REPORTCARD) {
            holder.name.setText(data.getName());
            int rollNumber = data.getRollNumber();
            holder.rollnumber.setText(Integer.toString(rollNumber));
        }else if(mScrnNumber == CREATE_REPORT_CARD){
            holder.subject.setText(data.getSubject());
            holder.marksObtained.setText(data.getMarksObtained());
            holder.total.setText(data.getTotal());
        }

    }

    @Override
    public int getItemCount() {
        return mListOfData.size();
    }

    public ReportCardAdapter(List<DataOfUi> listOfData , int scrnNumber , OnItemClickListener onItemClickListener){
        mListOfData = listOfData;
        mListOfDataOrginal = listOfData;
        mScrnNumber = scrnNumber;
        mOnItemClickListener = onItemClickListener;

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                List<DataOfUi> filteredResults = null;
                if (constraint.length() == 0) {
                    filteredResults = mListOfDataOrginal;
                    }else {
                    filteredResults = getFilteredResults(constraint.toString().toLowerCase());
                }

                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mListOfData = (List<DataOfUi>) results.values;
                ReportCardAdapter.this.notifyDataSetChanged();
            }
        };

    }

    protected List<DataOfUi> getFilteredResults(String constraint) {
        List<DataOfUi> results = new ArrayList<>();
        for (DataOfUi item : mListOfDataOrginal) {
            if (item.getFilterableObject(mScrnNumber).toLowerCase().contains(constraint)) {
                results.add(item);
            }
        }
        if(results.size() <=0){
            return mListOfDataOrginal;
        }

        return results;
    }


    public class ReportCardViewHolder extends RecyclerView.ViewHolder {// implements View.OnClickListener, View.OnLongClickListener {


        public TextView subject,marksObtained , total,percentage;
        public TextView name,rollnumber;
        public View row_view;

        public ReportCardViewHolder(View view) {
            super(view);

           //view.setOnClickListener(this);
           //view.setOnLongClickListener(this);

            row_view = view;
            if(mScrnNumber == SINGLE_STUDENT_REPORTCARD_DETAIL) {
                subject = (TextView) view.findViewById(R.id.subject);
                marksObtained = (TextView) view.findViewById(R.id.marksObtained);
                total = (TextView) view.findViewById(R.id.total);
                percentage = (TextView) view.findViewById(R.id.percentage);
            }else if(mScrnNumber == TEACHER_VIEW_REPORTCARD){
                name = (TextView) view.findViewById(R.id.nameOfStudent);
                rollnumber = (TextView) view.findViewById(R.id.rollNumber);
            }else if(mScrnNumber == CREATE_REPORT_CARD){
                subject = (TextView) view.findViewById(R.id.subject);
                marksObtained = (TextView) view.findViewById(R.id.marksObtained);
                total = (TextView) view.findViewById(R.id.total);
            }

        }

        /*
        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }*/
    }

}
