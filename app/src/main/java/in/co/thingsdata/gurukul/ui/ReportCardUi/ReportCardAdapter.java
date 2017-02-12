package in.co.thingsdata.gurukul.ui.ReportCardUi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.co.thingsdata.gurukul.R;
import in.co.thingsdata.gurukul.ui.dataUi.DataOfUi;
import in.co.thingsdata.gurukul.ui.dataUi.ReportCardData;

/**
 * Created by Ritika on 2/10/2017.
 */
public class ReportCardAdapter extends RecyclerView.Adapter<ReportCardAdapter.ReportCardViewHolder>{

    List<DataOfUi> mListOfData = null;

    @Override
    public ReportCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reportcarddetail , parent, false);

        return new ReportCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ReportCardViewHolder holder, int position) {
        ReportCardData data = (ReportCardData)mListOfData.get(position);
        holder.subject.setText(data.getSubject());
        holder.subject.setText(data.getMarksObtained());
        holder.subject.setText(data.getTotal());
        holder.subject.setText(data.getPercentage());
    }

    @Override
    public int getItemCount() {
        return mListOfData.size();
    }

    public ReportCardAdapter(List<DataOfUi> listOfData){
        mListOfData = listOfData;

    }


    public class ReportCardViewHolder extends RecyclerView.ViewHolder {

        public TextView subject,marksObtained , total,percentage;

        public ReportCardViewHolder(View view) {
            super(view);

            subject = (TextView) view.findViewById(R.id.subject);
            marksObtained = (TextView) view.findViewById(R.id.marksObtained);
            total = (TextView) view.findViewById(R.id.total);
            percentage = (TextView) view.findViewById(R.id.percentage);

        }
    }
}
