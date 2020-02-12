package com.example.dragapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

import static com.example.dragapp.R.id.bg;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener,View.OnDragListener{

    TextView t1, t2, t3, t4, t5;
    ConstraintLayout bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        bg = findViewById(R.id.bg);

        t1.setOnLongClickListener(this);
        t2.setOnLongClickListener(this);
        t3.setOnLongClickListener(this);
        t4.setOnLongClickListener(this);
        t5.setOnDragListener(this);


    }
    @Override
    public boolean onLongClick(View v)
    {

        v.setVisibility(View.INVISIBLE);
        ClipData clipData = ClipData.newPlainText("ok","Hello");
        View.DragShadowBuilder dragShadow = new View.DragShadowBuilder(v);
        v.startDrag(clipData, dragShadow, v, 0);
        return true;
    }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    if (view.getId() == R.id.t1) {
                        t5.setText(t1.getText());

                        break;
                    } else if (view.getId() == R.id.t2) {
                        t5.setText(t2.getText());


                        break;
                    } else if (view.getId() == R.id.t3) {
                        t5.setText(t3.getText());
                        break;
                    } else if (view.getId() == R.id.t4) {
                        t5.setText(t4.getText());
                        break;
                    }
                case DragEvent.ACTION_DRAG_ENDED:
                    if (view.getId() == R.id.t1) {
                        t5.setText(t1.getText());
                        t2.setVisibility(View.VISIBLE);
                        t3.setVisibility(View.VISIBLE);
                        t4.setVisibility(View.VISIBLE);
                        break;
                    } else if (view.getId() == R.id.t2) {
                        t5.setText(t2.getText());
                        t3.setVisibility(View.VISIBLE);
                        t1.setVisibility(View.VISIBLE);
                        t4.setVisibility(View.VISIBLE);
                        bg.setBackgroundColor(Color.RED);



                        break;
                    } else if (view.getId() == R.id.t3) {
                        t5.setText(t3.getText());
                        t1.setVisibility(View.VISIBLE);
                        t2.setVisibility(View.VISIBLE);
                        t4.setVisibility(View.VISIBLE);
                        bg.setBackgroundColor(Color.YELLOW);

                        break;
                    } else if (view.getId() == R.id.t4) {
                        t5.setText(t4.getText());
                        t1.setVisibility(View.VISIBLE);
                        t2.setVisibility(View.VISIBLE);
                        t3.setVisibility(View.VISIBLE);
                        bg.setBackgroundColor(Color.BLUE);

                        break;
                    }


            }
            return true;
        }

}
