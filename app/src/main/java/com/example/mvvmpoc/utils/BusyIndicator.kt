package com.example.mvvmpoc.utils

import android.app.Activity
import android.app.ProgressDialog

object BusyIndicator {
    private lateinit var progress: ProgressDialog
    fun showBusyLoader(activity:Activity){
        progress = ProgressDialog(activity)
        progress.setTitle("Loading")
        progress.setMessage("Wait while loading...")
        progress.setCancelable(false) // disable dismiss by tapping outside of the dialog
        progress.show()
    }

    fun hideBusyLoader(){
        if(progress.isShowing)
            progress.dismiss()
    }
}