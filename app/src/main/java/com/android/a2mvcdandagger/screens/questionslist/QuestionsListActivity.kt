package com.android.a2mvcdandagger.screens.questionslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.a2mvcdandagger.R
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class QuestionsListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_frame)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_content, QuestionsListFragment())
                .commit()
        }

    }
}