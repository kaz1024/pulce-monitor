package com.example.pulsemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /** Надпись "Ваш пульс" */
    private TextView info;
    /** Пульс */
    private TextView result;
    /** Кнопка */
    private Button pressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.tv_info);
        result = findViewById(R.id.tv_result);
        pressButton = findViewById(R.id.b_pulseButton);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            /** Список нажатий на кнопку */
            List<Tap> clickList = new ArrayList<>();

            @Override
            public void onClick(View view) {
                // Текущий пульс
                int currentPulse = 0;

                // Если это первое нажатие(пустой список кликов), не можем вычислить пульс и
                // показываем надпись "Первое нажатие"
                if (clickList.size() == 0) {

                    result.setText("Первое нажатие");
                    clickList.add(new Tap());

                } else {

                    clickList.add(new Tap());
                    // иначе получаем время последнего и предпоследнего нажатия, вычисляем их разницу
                    Long currentClickTime = clickList.get(clickList.size()-1).getClickTimeMills();
                    Long prevClickTime = clickList.get(clickList.size()-2).getClickTimeMills();

                    // разница между последним и предпоследним нажатием
                    float difference = (float)(currentClickTime - prevClickTime);
                    // коэффицент в придуманной формуле
                    float k = 1000/difference;
                    // вычисляем пульс по разнице между двумя последними нажатиями по придуманной формуле
                    // TODO обрабатывать больше нажатий
                    currentPulse = (int)(k * 60);

                }

                result.setText(String.valueOf(currentPulse));
            }
        };

        pressButton.setOnClickListener(onClickListener);
    }
}