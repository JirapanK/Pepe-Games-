package com.example.prototypr_2_final.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.prototypr_2_final.R
import com.example.prototypr_2_final.databinding.FragmentNotificationsBinding
import com.example.prototypr_2_final.ui.home.AndroidAudioRecordActivity

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root



        var btn_choice1 = root.findViewById<Button>(R.id.btn_storymode)
        btn_choice1.setOnClickListener {
            activity?.let {
                val intent = Intent(it, game_storyScreen::class.java)
                it.startActivity(intent)
            }
        }

        var btn_choice2 = root.findViewById<Button>(R.id.btn_record)
        btn_choice2.setOnClickListener{
            activity?.let {
                var intent = Intent(it, AndroidAudioRecordActivity::class.java)
                it.startActivity(intent)
            }
        }
        /*
        var btn_choice2 = root.findViewById<Button>(R.id.btn_plane)
        btn_choice2.setOnClickListener {
            activity?.let {
                val intent = Intent(it, kat2::class.java)
                it.startActivity(intent)
            }
        }
*/


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}