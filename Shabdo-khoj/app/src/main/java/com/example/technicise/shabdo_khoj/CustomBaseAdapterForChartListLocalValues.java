package com.example.technicise.shabdo_khoj;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.File;
import java.util.ArrayList;

/**
 * Created by Amit Paul on 19/2/15.
 * It gets all the values of local db of chart details
 */
public class CustomBaseAdapterForChartListLocalValues extends BaseAdapter
{

    private Context activity;
    private ArrayList<String> dataArray;
    public String gender, UserChartIdForProfilePicture,chart_dob;



    public CustomBaseAdapterForChartListLocalValues(Context activity, ArrayList<String> dataList) {
        this.activity = activity;
        dataArray = dataList;

    }


    public void notifyData() {
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataArray.size();
    }

    @Override
    public Object getItem(int position) {
        return dataArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
//        ViewHolder holder;
//        if (convertView == null) {
//            holder = new ViewHolder();
//            convertView = LayoutInflater.from(activity).inflate(R.layout.list_item_chart_holder, null);
//            holder.id = (TextView) convertView.findViewById(R.id.tvChartListID);
//            holder.btnBadgeNotification = (TextView) convertView.findViewById(R.id.btnBadgeNotification);
//            holder.tvChartNotificationTotalCount = (TextView) convertView.findViewById(R.id.tvChartNotificationTotalCount);
//            holder.name = (TextView) convertView.findViewById(R.id.tvChart_Username);
//            holder.relation_name = (TextView) convertView.findViewById(R.id.tvChart_Relation);
//            holder.chart_gender_dob = (TextView) convertView.findViewById(R.id.tvChartGenderDOB);
//            holder.thumb = (ImageView) convertView.findViewById(R.id.mem_photo_img_id);
//            holder.chart_profile_imageView = (ImageView) convertView.findViewById(R.id.picReminders);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//
////        String text_relation_name = dataArray.get(position).chart_relation_name;
////        String text_relation = text_relation_name.substring(0, 1).toUpperCase() + text_relation_name.substring(1).toLowerCase();
//
//
//        //holder.name.setText("("+" "+(dataArray.get(position).getRelationWithOwner())+" "+")"+" "+dataArray.get(position).getFirstName()+" " +(dataArray.get(position).getLastName()));
//        holder.name.setText((dataArray.get(position).chart_user_name));
//
////        if (text_relation.equals("Myself")) {
////            chart_description = "Your Chart";
////        } else {
////            chart_description = "Created by You";
////        }
////
////        if (text_relation_name.equals("MOTHER") || text_relation_name.equals("GRANDMOTHER") || text_relation_name.equals("SISTER")) {
////            gender = "Female";
////        } else {
////            gender = "Male";
////        }
//
////        holder.relation_name.setText(chart_description);
//        holder.id.setText(dataArray.get(position).chart_list_id);
//
//        sharedPrefClassObj = new SharedPreferenceClass(activity);
////        String chart_id = String.valueOf(dataArray.get(position).chart_list_id);
//
//        UserChartIdForProfilePicture =  dataArray.get(position).UserChartIdForProfilePicture;
//        chart_dob = dataArray.get(position).chart_dob;
//        gender = dataArray.get(position).chart_user_gender;
//
//        if (chart_dob != null && !chart_dob.matches("Unknown"))
//        {
//            String[] dobSegments = chart_dob.split("/");
//
//            //================Divided  MM-DD-YYYY Format ==================//
//
//            String YearDOB = dobSegments[0];
//            String MonthDOB = dobSegments[1];
//            String DayDOB = dobSegments[2];
//
//            String ChartUserDOB = MonthDOB + "/" + DayDOB + "/" + YearDOB;
//
//            //================Set User DOB =======================//
//
//            String first = gender + " " + ChartUserDOB;
//            holder.chart_gender_dob.setText(first);
//        }
//        else
//        {
//            String first = gender + " 11/01/1989";
//            holder.chart_gender_dob.setText(first);
//        }
//
//        File f = new File(Environment.getExternalStorageDirectory(), "/myCuratio/usermychartprofilepic" + UserChartIdForProfilePicture + ".png");
//        Bitmap bmp = ScaleBitmap.decodeFile(f, 200, 200);
//
//        //======================= User Chart Image Set, Checking Male-Female for User Chart Image Functionality ==========================//
//
//        if (bmp != null)
//        {
//            holder.chart_profile_imageView.setImageBitmap(bmp);
//        }
//
//        else if (gender != null)
//        {
//            if(gender.matches("Female"))
//            {
//                holder.chart_profile_imageView.setImageResource(R.drawable.femaleavatar);
//            }
//            else
//            {
//                holder.chart_profile_imageView.setImageResource(R.drawable.maleavatar);
//            }
//        }
//        else
//        {
//            holder.chart_profile_imageView.setImageResource(R.drawable.ic_launcher);
//        }
//
        return convertView;
    }


    public static class ViewHolder {
        /**
         * Put the variable at here.
         */
        TextView id;
        TextView tvChartNotificationTotalCount, btnBadgeNotification;
        TextView name;
        TextView relation_name;
        TextView chart_gender_dob;
        ImageView thumb;
        ImageView chart_profile_imageView;

    }
}
