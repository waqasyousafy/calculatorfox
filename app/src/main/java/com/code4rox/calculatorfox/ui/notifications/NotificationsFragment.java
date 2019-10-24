package com.code4rox.calculatorfox.ui.notifications;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.code4rox.calculatorfox.R;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment implements DialogInterface {

    TextView txfragment;
    Button btn_to_gallery,btn_multi_select;
    AlertDialog.Builder builder,builder1;
    String[] country_names = {"pak", "India", "Srilanka"};

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ArrayList<Integer> selecteditemindexlist = new ArrayList();
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        txfragment = (TextView) root.findViewById(R.id.activity_data);
        builder = new AlertDialog.Builder(root.getContext());
        builder1 = new AlertDialog.Builder(root.getContext());
        btn_to_gallery = (Button) root.findViewById(R.id.btn_to_gallery);
        boolean[] isSelectedArray = {true, false, true};
        btn_multi_select=(Button) root.findViewById(R.id.btn_multi_select);
        btn_multi_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder1.setTitle("Select Country")
                        .setMultiChoiceItems(country_names, isSelectedArray, new OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    selecteditemindexlist.add(which);
                                } else if (selecteditemindexlist.contains(which)) {
                                    selecteditemindexlist.remove(Integer.valueOf(which));
                                }
                            }
                        })
                        .setPositiveButton("OK", new OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder1.create();
                alert.show();

            }

        });


        btn_to_gallery.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                builder.setTitle("Alert");
                builder.setMessage("Do you want to navigate to Gallery Screen")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("No", new OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();

                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        String title = null;
        if (this.getArguments() != null) {
            title = this.getArguments().getString("title");
            txfragment.setText(title);
        }

        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        if (container != null) {
            container.removeAllViews();
        }
        return root;
    }
    @Override
    public void cancel() {

    }

    @Override
    public void dismiss() {

    }
}