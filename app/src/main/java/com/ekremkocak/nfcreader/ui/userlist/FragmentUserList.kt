package com.ekremkocak.nfcreader.ui.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ekremkocak.nfcreader.adapter.UsersAdapter
import com.ekremkocak.nfcreader.databinding.FragmentUserListBinding
import com.ekremkocak.nfcreader.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentUserList : Fragment() {

    private lateinit var binding : FragmentUserListBinding
    private lateinit var rcUsers: RecyclerView

    @Inject
    lateinit var userAdapter : UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        rcUsers = binding.rcUsers
        rcUsers.adapter = userAdapter

        //val layoutManager = GridLayoutManager(activity, 2)


        rcUsers.layoutManager = (LinearLayoutManager(activity))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(UsersViewModel::class.java)

        viewModel.liveData.observe(viewLifecycleOwner
        ) { value ->
            if (value != null) {
                rcUsers.recycledViewPool.clear()
                userAdapter.setList(value)
            }
        }
        viewModel.getData()
    }
}