package com.example.yourpinions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.yourpinions.ui.main.MainFragment
import com.example.yourpinions.ui.main.ViewYourpinionFragment
import com.example.yourpinions.ui.main.YourpinionClickListener

class MainActivity : AppCompatActivity(), YourpinionClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

    override fun onClick(yourpinionID: Int, opinion: String, voteCount: String) {
        val viewYourpinionFragment : Fragment = ViewYourpinionFragment.newInstance()
        val args = Bundle()
        args.putInt("uid", yourpinionID)
        args.putString("opinion", opinion)
        args.putString("voteCount", voteCount)
        viewYourpinionFragment.arguments = args
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, viewYourpinionFragment)
            .addToBackStack("")
            .commit()
    }
}