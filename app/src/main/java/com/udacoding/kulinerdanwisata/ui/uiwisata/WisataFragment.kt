package com.udacoding.kulinerdanwisata.ui.uiwisata


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.udacoding.kulinerdanwisata.R
import com.udacoding.kulinerdanwisata.model.DataItem
import com.udacoding.kulinerdanwisata.model.ResultWisata
import com.udacoding.kulinerdanwisata.network.NetworkConfig
import com.udacoding.kulinerdanwisata.ui.uiwisata.WisataAdapter
import kotlinx.android.synthetic.main.fragment_wisata.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class WisataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wisata, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        NetworkConfig.getService()
            .getWisata()
            .enqueue(object : Callback<ResultWisata> {
                override fun onFailure(call: Call<ResultWisata>, t: Throwable) {
                    Log.d("Gagal Load Data", "Gagal Load Data")
                }

                override fun onResponse(
                    call: Call<ResultWisata>,
                    response: Response<ResultWisata>
                ) {
                    if (response.isSuccessful) {
                        showData(response.body()?.data)
                    }
                }
            })
    }

    private fun showData(data: List<DataItem?>?) {
        rvWisata.adapter = WisataAdapter(data)
    }

}
