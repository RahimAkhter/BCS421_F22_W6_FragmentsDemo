package edu.farmingdale.bcs421.bcs421_f22_w6_fragmentsdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import edu.farmingdale.bcs421.bcs421_f22_w6_fragmentsdemo.databinding.Fragment02Binding


class Fragment02 : Fragment(R.layout.fragment_02) {

	private lateinit var binding: Fragment02Binding

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = Fragment02Binding.inflate(layoutInflater, container, false);

		binding.fgBtn1.setOnClickListener {
			binding.fgTv1.text = "Moaath Alrajab"
		}

		return binding.root
	}
}