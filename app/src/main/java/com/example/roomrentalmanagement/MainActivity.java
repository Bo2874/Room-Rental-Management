package com.example.roomrentalmanagement;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.roomrentalmanagement.controller.RoomController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
                setSupportActionBar(toolbar)
        supportActionBar?.title = "Quản lý phòng trọ"

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = RoomAdapter(
                RoomController.getRooms(),
                onEdit = { position -> openEditForm(position) },
                onDelete = { position -> confirmDelete(position) }
        )
        recyclerView.adapter = adapter

        findViewById<FloatingActionButton>(R.id.fabAddRoom).setOnClickListener {
            val intent = Intent(this, RoomFormActivity::class.java)
            startActivityForResult(intent, REQUEST_ADD)
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

        });
    }
}