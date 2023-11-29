package com.projectfarrel.infokosuser.view.wrapper
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projectfarrel.infokosuser.databinding.FragmentVpHomeOneBinding

class FragmentVpHomeOne : Fragment() {

    lateinit var binding : FragmentVpHomeOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVpHomeOneBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}