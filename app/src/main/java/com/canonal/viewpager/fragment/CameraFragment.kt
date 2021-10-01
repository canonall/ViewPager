package com.canonal.viewpager.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.canonal.viewpager.R

class CameraFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CameraFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}