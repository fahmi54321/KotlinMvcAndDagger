package com.android.a2mvcdandagger.screens.viewmodel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.a2mvcdandagger.R
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

class ViewModelActivity : BaseActivity() {

    @Inject lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

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