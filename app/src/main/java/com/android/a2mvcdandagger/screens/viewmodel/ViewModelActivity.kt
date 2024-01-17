package com.android.a2mvcdandagger.screens.viewmodel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.a2mvcdandagger.R
import com.android.a2mvcdandagger.common.viewmodel.ViewModelFactory
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity
import com.android.a2mvcdandagger.screens.questionslist.FetchQuestionsUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider

//todo 9
@AndroidEntryPoint
class ViewModelActivity : BaseActivity() {

    private lateinit var myViewModel: MyViewModel
    private lateinit var myViewModel2: MyViewModel2
    @Inject lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) { //todo 10 hapus inject(next QuestionsListFragment)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        myViewModel = ViewModelProvider(this,factory)[MyViewModel::class.java]
        myViewModel2 = ViewModelProvider(this,factory)[MyViewModel2::class.java]

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