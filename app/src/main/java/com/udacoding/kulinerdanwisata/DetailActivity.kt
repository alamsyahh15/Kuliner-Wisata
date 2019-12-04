package com.udacoding.kulinerdanwisata

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableResource
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.udacoding.kulinerdanwisata.model.DataItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //Terima data image dari kuliner
        val dataImage1 = intent.getIntExtra("dataImage1",0)
        val dataTitle1 = intent.getStringExtra("dataTitle")

        //Terima data image wisata secara manual
//        val dataImage2 = intent.getStringExtra("dataImage2")
//        val dataTitle = intent.getStringExtra("dataTitle")

        // Pasangkan data ke xml atau view kita
        if(dataImage1 == 0 && dataTitle1.isNullOrEmpty()){
            //Terima data wisata seluruhnya
            val data = intent.getSerializableExtra("dataWisata") as DataItem
            Glide.with(this)
                .load(data.gambar)
                .into(imgDetail)
            titleDetail.text = data.namaTempat
            descriptionDetail.text = "Description Location"
            theDescription.text = data.deskripsi

        } else {
            descriptionDetail.text = "Description Food"
            imgDetail.setImageResource(dataImage1)
            titleDetail.text  = dataTitle1
        }

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.myMaps) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val res = this.resources
        val marker1 = BitmapFactory.decodeResource(res,R.drawable.ic_marker)
        val smallmarker = Bitmap.createScaledBitmap(marker1,80,80,false)


        // Add a marker in Sydney and move the camera
        val sydney = LatLng(2.6114159,98.5557591)
        mMap.addMarker(MarkerOptions().position(sydney).title("Danau Toba")
            .icon(BitmapDescriptorFactory.fromBitmap(smallmarker)))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,10f))


    }
}
