package mq.mqandroidworld.customviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import mq.mqandroidworld.customviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this,binding.custom1.getTitle(),Toast.LENGTH_SHORT).show()
        binding.custom2.setTitle("안녕 바뀜요 수고")
    }
}