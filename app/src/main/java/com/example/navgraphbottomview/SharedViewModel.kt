package com.example.navgraphbottomview

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val screenshot = MutableLiveData<Bitmap>()
}
