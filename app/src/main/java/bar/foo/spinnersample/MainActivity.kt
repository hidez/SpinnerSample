package bar.foo.spinnersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //region ITEMS ON SCREEN

    private lateinit var spArtist: Spinner

    //endregion

    //region ITEMS ON SPINNER

    val spinnerItems = listOf<String>(
            "ジミ・ヘンドリックス",
            "エリック・クラプトン",
            "スティーヴィー・レイ・ヴォーン",
            "フランク・ザッパ",
            "ピート・タウンゼント",
            "スティーヴ・クロッパー",
    )

    //endregion

    //region LIFECYCLE METHODS OF FRAGMENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spArtist = findViewById<Spinner>(R.id.spnner_artist)

        val adapter = ArrayAdapter<String>(this, R.layout.spinner_artist, spinnerItems)
        adapter.setDropDownViewResource(R.layout.spinner_artist_dropdown)
        spArtist.adapter = adapter
        spArtist.onItemSelectedListener = spinnerItemSelectedListener()
    }

    //endregion

    //region ACTION EVENT

    /**
     * Spinnerが操作されたとき
     */
    private inner class spinnerItemSelectedListener : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(parent?.id) {
                R.id.spnner_artist -> {
                    Toast.makeText(this@MainActivity, spinnerItems[position], Toast.LENGTH_SHORT).show()
                }
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
    }

    //region ACTION EVENT
}