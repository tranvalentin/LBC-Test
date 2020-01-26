package com.tran.valentin.lbctest.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.tran.valentin.lbctest.R
import com.tran.valentin.lbctest.service.manager.ManagerLocator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SplashActivity : AppCompatActivity() {

    private val loader by lazy { findViewById<View>(R.id.loader) }
    private val rootView by lazy { findViewById<View>(R.id.rootView) }
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        compositeDisposable.add(
            ManagerLocator.findLBCManager().getAlbums().subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()
            ).subscribe({ launchMainActivity() }, {
                loader.visibility = View.GONE
                Snackbar.make(rootView, getString(R.string.error_splash), Snackbar.LENGTH_LONG)
                    .show()
            })
        )
    }

    private fun launchMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
