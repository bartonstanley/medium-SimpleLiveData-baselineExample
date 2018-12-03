package com.bartonstanley.baselinelivedataexample

import androidx.lifecycle.MutableLiveData

/**
 * Repository for holding the "official" copy of the string in memory.
 *
 * String is not persisted.  When the app is killed the string will be lost.
 */
object StringRepository {

    // Allow a LiveData Observer to observe changes to the string.
    var observableString: MutableLiveData<String> = MutableLiveData()

    // Convenience property for the string itself.
    val string: String?
        get() {
            return observableString.value
        }
}