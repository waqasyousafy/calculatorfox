package com.code4rox.calculatorfox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Book_Detail_Activity extends AppCompatActivity {

    private TextView tvtitle,tvcategory,tvdescription;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book__detail_);
        tvtitle=(TextView) findViewById(R.id.texttitle  );
        tvcategory=(TextView) findViewById(R.id.textcategory);
        tvdescription=(TextView) findViewById(R.id.textdescription);
        img=(ImageView) findViewById(R.id.bookthumbnail);

        //receiving data
        Intent intent=getIntent();
        String Title=intent.getExtras().getString("Title");
        String Category=intent.getExtras().getString("Category");
        String Description=intent.getExtras().getString("Description");
        int image=intent.getExtras().getInt("Thumbnail");
        tvtitle.setText(Title);
        tvcategory.setText(Category);
        tvdescription.setText(Description);
        img.setImageResource(image);

    }
}
