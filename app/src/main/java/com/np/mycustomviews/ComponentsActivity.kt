package com.np.mycustomviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.np.mycustomviews.quick_action_view.QuickActionView

class ComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_components)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val quickActionView = findViewById<QuickActionView>(R.id.quickAction)
        quickActionView.label = "Niraj"

        quickActionView.setOnClickListener {
            Toast.makeText(this, "OnClick!", Toast.LENGTH_LONG).show()
        }
    }
}