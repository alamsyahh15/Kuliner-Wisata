package com.udacoding.kulinerdanwisata.ui.uikuliner


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.udacoding.kulinerdanwisata.R
import com.udacoding.kulinerdanwisata.ui.uikuliner.KulinerAdapter
import kotlinx.android.synthetic.main.fragment_kuliner.*

/**
 * A simple [Fragment] subclass.
 */
class KulinerFragment : Fragment() {

    private var image = arrayOf(
        R.drawable.gambar1,
        R.drawable.gambar2, R.drawable.gambar3, R.drawable.gambar4,
        R.drawable.gambar5
    )
    private var title = arrayOf(
        "Makanan1", "Makanan2", "Makanan3",
        "Makanan4", "Makanan5"
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kuliner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvKuliner.adapter = KulinerAdapter(image,title)

    }
}
