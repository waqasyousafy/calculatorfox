package com.code4rox.calculatorfox.ui.dashboard;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.code4rox.calculatorfox.R;

import java.text.DateFormat;
import java.util.Calendar;

public class DashboardFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    public TextView textView;
    private DashboardViewModel dashboardViewModel;
int messageCount;
    public Dialog onCreateDialog() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int Day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, Day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Log.i("MSG", "inside ondateset");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentdatestring = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        Log.i("value", currentdatestring);
        textView = getActivity().findViewById(R.id.textdate);
        textView.setText(currentdatestring);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Button button = root.findViewById(R.id.btn_datepicker);

        if (container != null) {
            container.removeAllViews();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog().show();
            }
        });
        Button btn_notification = root.findViewById(R.id.btn_notification);
        btn_notification.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(root.getContext(), "title")
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle("Dumy Notification")
                        .setContentText("This is dumy notification for testing")
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setColorized(true);
                NotificationManager nm = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel mChannel = new NotificationChannel("title", "chanel_1", nm.IMPORTANCE_DEFAULT);
                    mChannel.setShowBadge(true);
                    nm.createNotificationChannel(mChannel);
                }
                nm.notify(1, builder.build());
            }
        });
        return root;
    }
}
