package com.example.journal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    private Button btnNext, btnPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = findViewById(R.id.view_fliper);
        btnNext = findViewById(R.id.next);
        btnPrevious = findViewById(R.id.dontnext);

        // Обработчик для кнопки "Next" (переключение вперёд)
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Установка анимаций для движения вправо
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_right));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_left));

                viewFlipper.showNext();
            }
        });

        // Обработчик для кнопки "Previous" (переключение назад)
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Установка анимаций для движения влево
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_left));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_right));

                viewFlipper.showPrevious();
            }
        });
    }
}
