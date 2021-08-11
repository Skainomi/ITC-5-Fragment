package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttons: ArrayList<Button>
    private val mFragmentManager = supportFragmentManager
    private val mFragmentSatu = FragmentSatu()
    private val mFragmentDua = FragmentDua()
    private var status = 1

    companion object {
        final val EXTRA_NAME = "EXTRA_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttons = arrayListOf(
            findViewById(R.id.btn_fragmentSatu),
            findViewById(R.id.btn_fragmentDua)
        )

        buttons.forEach {
            it.setOnClickListener(this)
        }

        val fragmentSatu = mFragmentManager.findFragmentByTag(FragmentSatu::class.java.simpleName);
        mFragmentSatu.text = "Data Fragment Satu"
        mFragmentDua.text = "Data Fragment Dua"
        if (fragmentSatu !is FragmentSatu) {
            mFragmentManager
                .beginTransaction()
                .add(R.id.fl_frame, mFragmentSatu, FragmentSatu::class.java.simpleName)
                .commit()
        }


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_fragmentSatu -> {
                mFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_frame, mFragmentSatu, FragmentSatu::class.java.simpleName)
                    .commit()
                this.status = 2
            }
            R.id.btn_fragmentDua -> {
                mFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_frame, mFragmentDua, FragmentDua::class.java.simpleName)
                    .commit()
                this.status = 1
            }
        }
    }
}