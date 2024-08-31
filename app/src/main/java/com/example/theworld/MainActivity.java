package com.example.theworld;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CellAdapter cellAdapter;
    private List<Cell> cells = new ArrayList<>();
    private Button buttonAddCell;

    private int liveCount = 0;
    private int deadCount = 0;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewCells);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cellAdapter = new CellAdapter(cells);
        recyclerView.setAdapter(cellAdapter);

        buttonAddCell = findViewById(R.id.buttonCreateCell); // Инициализация кнопки

        buttonAddCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isAlive = random.nextBoolean();

                if (isAlive) {
                    liveCount++;
                    deadCount = 0;
                    cells.add(new Cell("Живая", "и шевелится!", "🌟")); // Используем эмодзи для живой клетки
                } else {
                    liveCount = 0;
                    deadCount++;
                    cells.add(new Cell("Мертвая", "или прикидывается", "💀")); // Используем эмодзи для мертвой клетки
                }

                // Проверяем условия зарождения или уничтожения жизни
                if (liveCount == 3) {
                    cells.add(new Cell("Жизнь", "Ку-ку!", "💥")); // Используем эмодзи 💥 для отображения жизни
                    liveCount = 0;
                } else if (deadCount == 3) {
                    cells.clear();
                    cells.add(new Cell("Мертвая", "Жизнь уничтожена!", "💀"));
                    deadCount = 0;
                }

                cellAdapter.notifyDataSetChanged();
            }
        });
    }
}
