package com.jama.carouselviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jama.carouselview.CarouselScrollListener;
import com.jama.carouselview.CarouselView;
import com.jama.carouselview.CarouselViewListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

  CarouselView carouselView;
  CarouselView carouselView2;
  Button left;
  Button right;
  String[] data = {"#EF5350", "#EC407A", "#AB47BC", "#4CAF50", "#FFA726", "#78909C", "#FFA726"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    left = findViewById(R.id.button);
    right = findViewById(R.id.button2);

    carouselView = findViewById(R.id.carouselView);
    carouselView.setScaleOnScroll(true);
    carouselView.setCarouselViewListener(new CarouselViewListener() {
      @Override
      public void onBindView(View view, final int position) {
        final CardView cardView = view.findViewById(R.id.cardView);
        TextView textView = view.findViewById(R.id.textView);
        cardView.setCardBackgroundColor(Color.parseColor(data[new Random().nextInt(7)]));
        textView.setText((position + 1 + ""));
      }
    });
    left.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        carouselView2.setCurrentItem(carouselView2.getCurrentItem() - 1);
      }
    });
    right.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        carouselView2.setCurrentItem(carouselView2.getCurrentItem() + 1);
      }
    });
    carouselView.show();

    carouselView2 = findViewById(R.id.carouselView2);
    carouselView2.setSize(10);
    carouselView2.setScaleOnScroll(true);
    carouselView2.setResource(R.layout.item);
    carouselView2.setCarouselViewListener(new CarouselViewListener() {
      @Override
      public void onBindView(View view, final int position) {
        CardView cardView = view.findViewById(R.id.cardView);
        TextView textView = view.findViewById(R.id.textView);
        cardView.setCardBackgroundColor(Color.parseColor(data[new Random().nextInt(7)]));
        textView.setText((position + 1 + ""));
      }
    });
    carouselView2.show();
  }
}
