package com.android.a2mvcdandagger.screens.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.android.a2mvcdandagger.R
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ViewModelActivity : BaseActivity() {

    private lateinit var myViewModel: MyViewModel
    private lateinit var myViewModel2: MyViewModel2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        myViewModel2 = ViewModelProvider(this)[MyViewModel2::class.java]

        myViewModel.question.observe(this) {
            Toast.makeText(this, "fetched ${it.size} questions", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ViewModelActivity::class.java)
            context.startActivity(intent)
        }
    }
}