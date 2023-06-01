package com.example.globalsolutionmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.globalsolutionmobile.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.LatLngBounds

class MapsActivity : AppCompatActivity() {

    private val places = arrayListOf(
        Place("Cidade do Cabo", LatLng(-33.9248685, 18.4240553), "Cidade do Cabo, África do Sul", 80),
        Place("Casablanca", LatLng(33.5731104, -7.5898434), "Casablanca, Marrocos", 80),
    Place("Nairobi", LatLng(-1.286389, 36.817223), "Nairobi, Quênia", 80),
    Place("Luanda", LatLng(-8.8399883, 13.2894377), "Luanda, Angola", 80),
    Place("Tóquio", LatLng(35.6894875, 139.6917064), "Tóquio, Japão", 80),
    Place("Delhi", LatLng(28.6139391, 77.2090212), "Delhi, Índia", 80),
    Place("Istambul", LatLng(41.0082376, 28.9783589), "Istambul, Turquia", 80),
    Place("Singapura", LatLng(1.352083, 103.819836), "Singapura", 80),
    Place("Nova York", LatLng(40.7127753, -74.0059728), "Nova York, EUA", 80),
    Place("Cidade do México", LatLng(19.4326077, -99.133208), "Cidade do México, México", 80),
    Place("Buenos Aires", LatLng(-34.6036844, -58.3815591), "Buenos Aires, Argentina", 80),
    Place("Vancouver", LatLng(49.2827291, -123.1207375), "Vancouver, Canadá", 80),
    Place("Sydney", LatLng(-33.865143, 151.209900), "Sydney, Austrália", 80),
    Place("Auckland", LatLng(-36.8484609, 174.7633315), "Auckland, Nova Zelândia", 80),
    Place("Honolulu", LatLng(21.3069444, -157.8583333), "Honolulu, Havaí, EUA", 80),
    Place("Brisbane", LatLng(-27.4697707, 153.0251235), "Brisbane, Austrália", 80),
    Place("Londres", LatLng(51.5073509, -0.1277583), "Londres, Reino Unido", 80),
    Place("Paris", LatLng(48.856614, 2.3522219), "Paris, França", 80),
    Place("Roma", LatLng(41.9027835, 12.4963655), "Roma, Itália", 80),
    Place("Amsterdã", LatLng(52.3702157, 4.8951679), "Amsterdã, Holanda", 80),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_maps)

        val btnVerDados = findViewById<Button>(R.id.button5)

        btnVerDados.setOnClickListener{
            val i = Intent (this, MainActivity3::class.java)
            startActivity(i)

        }

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync { googleMap -> addMarkers(googleMap)
            googleMap.setOnMapLoadedCallback {
                val bounds = LatLngBounds.builder()

                places.forEach {
                    bounds.include(it.latLng)
                }

                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 100))
            }
        }
    }

    private fun addMarkers(googleMap: GoogleMap) {
        places.forEach { place ->
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .title(place.name)
                    .snippet(place.address)
                    .position(place.latLng)
                    .icon(
                        BitmapHelper.vectorToBitmap(this, R.drawable.iconalert_foreground, ContextCompat.getColor(this, R.color.green))
                    )
            )
        }
    }
}

data class Place(
    val name: String,
    val latLng: LatLng,
    val address: String,
    val level: Int,
)
