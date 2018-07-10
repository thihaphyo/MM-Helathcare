package com.padc.mmhelathcare.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.padc.mmhelathcare.R
import com.padc.mmhelathcare.adapters.HealthCareInfoAdapter
import com.padc.mmhelathcare.data.models.MMHealthModel
import com.padc.mmhelathcare.events.ApiErrorEvent
import com.padc.mmhelathcare.events.SuccessGetHealthCareEvent

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    private var adapter: HealthCareInfoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        rv_health_list.layoutManager = LinearLayoutManager(applicationContext
                , LinearLayoutManager.VERTICAL
                , false)
        adapter = HealthCareInfoAdapter()
        rv_health_list.adapter = adapter

        MMHealthModel.getObjectReference()!!.loadHealthCareInfo()

    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)

    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSuccessGetHealthList(successEvent: SuccessGetHealthCareEvent) {

        adapter!!.setHealthCareInfoList(successEvent.healthCareList)

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onApiError(errorEvent: ApiErrorEvent) {

        Snackbar.make(rv_health_list, errorEvent.errorMessage, Snackbar.LENGTH_INDEFINITE).show()
    }
}
