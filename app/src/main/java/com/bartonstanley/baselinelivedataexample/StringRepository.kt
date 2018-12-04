package com.bartonstanley.baselinelivedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Repository for holding the "official" copy of the string in memory.
 *
 * String is not persisted.  When the app is killed the string will be lost.
 */
object StringRepository {

    // Keep the mutable LiveData item private and provide accessors.
    private var mutableLiveDataString: MutableLiveData<String> = MutableLiveData()

    // Accessor to allow a LiveData Observer to observe changes to the string.
    var observableString: LiveData<String> = mutableLiveDataString

    // Convenience property for the string itself.
    val string: String?
        get() {
            return mutableLiveDataString.value
        }

    /**
     * Accessor to allow string value to be changed.
     *
     * @param string the new value of the string.
     */
    fun setString(string: String) {
        mutableLiveDataString.value = string
    }
}