package com.bartonstanley.baselinelivedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel for the string that the user enters based on guidance from "Guide to app architecture"
 * (https://developer.android.com/jetpack/docs/guide).
 *
 * Allows the Repository string value to be updated and supplies a read-only LiveData item for the string.
 */
class StringViewModel: ViewModel() {

    // Keep it simple and skip the Dagger stuff and init() method shown in "Guide to app architecture".  This accomplishes
    // the same thing, namely preventing the View from directly modifying the MutableLiveData item.
    val string: LiveData<String>
        get() {
            return StringRepository.observableString
        }

    /**
     * Update the value of the string in the Repository.
     *
     * @param string new value of string to be placed in the Repository.
     */
    fun setStringValue(string: String) {
        StringRepository.observableString.value = string
    }
}