package com.udacoding.kulinerdanwisata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.udacoding.kulinerdanwisata.model.DataItem
import com.udacoding.kulinerdanwisata.model.ResultWisata
import com.udacoding.kulinerdanwisata.network.NetworkConfig
import com.udacoding.kulinerdanwisata.uiwisata.WisataAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var image = arrayOf(R.drawable.gambar1,
        R.drawable.gambar2, R.drawable.gambar3, R.drawable.gambar4,
        R.drawable.gambar5)
    private var title = arrayOf("Makanan1", "Makanan2", "Makanan3",
        "Makanan4", "Makanan5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        rvKuliner.adapter = KulinerAdapter(image, title)

        with(NetworkConfig) {
            service()
                .getWisata()
                .enqueue(object  : Callback<ResultWisata>{
                    override fun onFailure(call: Call<ResultWisata>, t: Throwable) {
                        Log.d("Gagal Load Data", "Gagal Load Data")
                    }
                    override fun onResponse(
                        call: Call<ResultWisata>,
                        response: Response<ResultWisata>
                    ) {
                        if(response.isSuccessful){
                            showData(response.body()?.data)
                        }
                    }
                })
        }
    }

    private fun showData(data: List<DataItem?>?) {
        rvKuliner.adapter = WisataAdapter(data)
    }
}
