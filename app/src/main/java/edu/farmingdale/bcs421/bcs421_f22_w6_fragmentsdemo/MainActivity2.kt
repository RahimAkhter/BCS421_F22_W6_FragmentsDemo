package edu.farmingdale.bcs421.bcs421_f22_w6_fragmentsdemo

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.text.isDigitsOnly
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import edu.farmingdale.bcs421.bcs421_f22_w6_fragmentsdemo.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
	companion object {
		private const val TEXT_SIZE = "TEXT_SIZE"
		private const val TEXT_CONTENT = "SILLY"
	}

	private lateinit var binding: ActivityMain2Binding

	private val fragment1 = Fragment01()
	private val fragment2 = Fragment02()
	private val preferences
		get() = getPreferences()

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

		binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
			override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
				setSize(progress)
			}

			override fun onStartTrackingTouch(seekBar: SeekBar?) {}

			override fun onStopTrackingTouch(seekBar: SeekBar?) {}
		})

		val size = preferences.getInt(TEXT_SIZE, 12)
		binding.tv1.textSize = size.toFloat()
		binding.editText01.setText(size.toString())
		binding.seekBar.progress = size
	}

	private fun setSize(size: Int) {
		preferences.edit(true) {
			putInt(TEXT_SIZE, size)
		}
		binding.tv1.textSize = size.toFloat()
		binding.editText01.setText(size.toString())
	}

	private fun navigate(fragment: Fragment) {
		supportFragmentManager.beginTransaction().apply {
			replace(R.id.framelayout1, fragment)
			commit()
		}
	}

	private fun readFromSharedPref() {
		binding.tv1.text = preferences.getString(TEXT_CONTENT, "This value is stored in shared pref")
	}
}