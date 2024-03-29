package com.udacoding.kulinerdanwisata.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class DataItem(

	@field:SerializedName("lokasi")
	val lokasi: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("nama_tempat")
	val namaTempat: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null
) : Serializable