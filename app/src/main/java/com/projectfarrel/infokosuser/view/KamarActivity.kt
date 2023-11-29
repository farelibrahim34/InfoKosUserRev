package com.projectfarrel.infokosuser.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.projectfarrel.infokosuser.R
import com.projectfarrel.infokosuser.adapter.AdapterNotif
import com.projectfarrel.infokosuser.databinding.ActivityKamarBinding
import com.projectfarrel.infokosuser.databinding.ActivityNotifBinding
import com.projectfarrel.infokosuser.viewmodel.ViewModelPesan

private const val TAG = "KamarActivity"
class KamarActivity : AppCompatActivity() {
    lateinit var binding : ActivityKamarBinding
    var kamar : String = "0"
    var idKos : String = "0"
    var isKamar1 = false
    var isKamar2 = false
    var isKamar3 = false
    var isKamar4 = false
    var isKamar5 = false
    var isKamar6 = false
    var isKamar7 = false
    var isKamar8 = false
    var isKamar9 = false
    var isKamar10 = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKamarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val namaKos = intent.getStringExtra("nama")

        getArgs()
        binding.ivKamar1.setOnClickListener {
            if (isKamar1){
                binding.ivKamar1.setImageResource(R.drawable.available_img)
                isKamar1 = false

            }else{
                isKamar1 = true
                kamar = "1"
                binding.ivKamar1.setImageResource(R.drawable.booked_img)
            }

        }
        binding.ivKamar2.setOnClickListener {
            if (isKamar2){
                binding.ivKamar2.setImageResource(R.drawable.available_img)
                isKamar2 = false
            }else{
                isKamar2 = true
                kamar = "2"
                binding.ivKamar2.setImageResource(R.drawable.booked_img)
            }
        }
        binding.ivkamar3.setOnClickListener {
            if (isKamar3){
                binding.ivkamar3.setImageResource(R.drawable.available_img)
                isKamar3 = false
            }else{
                isKamar3 = true
                kamar = "3"
                binding.ivkamar3.setImageResource(R.drawable.booked_img)
            }
        }
        binding.ivKamar4.setOnClickListener {
            if (isKamar4){
                binding.ivKamar4.setImageResource(R.drawable.available_img)
                isKamar4 = false
            }else{
                isKamar4 = true
                kamar = "4"
                binding.ivKamar4.setImageResource(R.drawable.booked_img)
            }
        }
        binding.ivKamar5.setOnClickListener {
            if (isKamar5){
                binding.ivKamar5.setImageResource(R.drawable.available_img)
                isKamar5 = false
            }else{
                isKamar5 = true
                kamar = "5"
                binding.ivKamar5.setImageResource(R.drawable.booked_img)
            }
        }
        binding.ivKamar6.setOnClickListener {
            if (isKamar6){
                binding.ivKamar6.setImageResource(R.drawable.available_img)
                isKamar6 = false
            }else{
                isKamar6 = true
                kamar = "6"
                binding.ivKamar6.setImageResource(R.drawable.booked_img)
            }
        }
        binding.ivKamar7.setOnClickListener {
            if (isKamar7){
                binding.ivKamar7.setImageResource(R.drawable.available_img)
                isKamar7 = false
            }else{
                isKamar7 = true
                kamar = "7"
                binding.ivKamar7.setImageResource(R.drawable.booked_img)
            }
        }
        binding.ivKamar8.setOnClickListener {
            if (isKamar8){
                binding.ivKamar8.setImageResource(R.drawable.available_img)
                isKamar8 = false
            }else{
                isKamar8 = true
                kamar = "8"
                binding.ivKamar8.setImageResource(R.drawable.booked_img)
            }
        }
        binding.ivKamar9.setOnClickListener {
            if (isKamar9){
                binding.ivKamar9.setImageResource(R.drawable.available_img)
                isKamar9 = false
            }else{
                isKamar9 = true
                kamar = "9"
                binding.ivKamar9.setImageResource(R.drawable.booked_img)
            }
        }
        binding.ivKamar10.setOnClickListener {
            if (isKamar10){
                binding.ivKamar10.setImageResource(R.drawable.available_img)
                isKamar10 = false
            }else{
                isKamar10 = true
                kamar = "10"
                binding.ivKamar10.setImageResource(R.drawable.booked_img)
            }
        }

        binding.btnPesan3.setOnClickListener {
            val intent = Intent(this, PesanActivity::class.java)
            intent.putExtra("idKos",idKos)
            intent.putExtra("noKamar",kamar)
            intent.putExtra("nama",namaKos)
            startActivity(intent)
        }
    }

    private fun getArgs() {
        Log.d(TAG, "getArgs: idKos ${intent.getStringExtra("idKos")} ")
        if(intent.getStringExtra("idKos") != ""){
            val viewModel = ViewModelProvider(this).get(ViewModelPesan::class.java)
            viewModel.callApiPesanKos()
            idKos = intent.getStringExtra("idKos").toString()
            viewModel.getPesanKos().observe(this) { it ->
                if (it != null) {
                    for (pesanKosItem in it) {
                        if (pesanKosItem.idKos == idKos) {
                            Log.d(TAG, "onCreate: idKos ${pesanKosItem.idKos} kamar ${pesanKosItem.noKamar}")
                            if (pesanKosItem.noKamar == "1") binding.ivKamar1.setImageResource(R.drawable.your_seat_img)
                            if (pesanKosItem.noKamar == "2") binding.ivKamar2.setImageResource(R.drawable.your_seat_img)
                            if (pesanKosItem.noKamar == "3") binding.ivkamar3.setImageResource(R.drawable.your_seat_img)
                            if (pesanKosItem.noKamar == "4") binding.ivKamar4.setImageResource(R.drawable.your_seat_img)
                            if (pesanKosItem.noKamar == "5") binding.ivKamar5.setImageResource(R.drawable.your_seat_img)
                            if (pesanKosItem.noKamar == "6") binding.ivKamar6.setImageResource(R.drawable.your_seat_img)
                            if (pesanKosItem.noKamar == "7") binding.ivKamar7.setImageResource(R.drawable.your_seat_img)
                            if (pesanKosItem.noKamar == "8") binding.ivKamar8.setImageResource(R.drawable.your_seat_img)
                            if (pesanKosItem.noKamar == "9") binding.ivKamar9.setImageResource(R.drawable.your_seat_img)
                            if (pesanKosItem.noKamar == "10") binding.ivKamar10.setImageResource(R.drawable.your_seat_img)
                        }
                    }
                }
            }
        }
    }


}