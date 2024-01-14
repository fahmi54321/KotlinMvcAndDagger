package com.android.a2mvcdandagger.screens.viewmodel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.a2mvcdandagger.R
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity
import com.android.a2mvcdandagger.screens.questionslist.FetchQuestionsUseCase
import javax.inject.Inject
import javax.inject.Provider

class ViewModelActivity : BaseActivity() {

    private lateinit var myViewModel: MyViewModel
    @Inject lateinit var factory: MyViewModel.MyViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        myViewModel = ViewModelProvider(this,factory)[MyViewModel::class.java]

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