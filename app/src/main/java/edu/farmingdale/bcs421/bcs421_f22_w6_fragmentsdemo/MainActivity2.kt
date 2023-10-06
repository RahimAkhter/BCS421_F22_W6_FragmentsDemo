package edu.farmingdale.bcs421.bcs421_f22_w6_fragmentsdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import edu.farmingdale.bcs421.bcs421_f22_w6_fragmentsdemo.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

	private lateinit var binding: ActivityMain2Binding

	private val fragment1 = Fragment01()
	private val fragment2 = Fragment02()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMain2Binding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.btn1.setOnClickListener {
			navigate(fragment1)
		}

		binding.btn2.setOnClickListener {
			navigate(fragment2)
			readFromSharedPref()
		}
	}

	private fun navigate(fragment: Fragment) {
		supportFragmentManager.beginTransaction().apply {
			replace(R.id.framelayout1, fragment)
			commit()
		}
	}

	private fun readFromSharedPref() {
		val sharedPref = getPreferences()
		binding.tv1.text = sharedPref.getString("KEY", "NOT_FOUND")
	}
}