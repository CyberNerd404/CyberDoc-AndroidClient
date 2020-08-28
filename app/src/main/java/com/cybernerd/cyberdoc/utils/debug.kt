package com.cybernerd.cyberdoc.utils

import android.util.Log
import android.view.View
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar


// logs for degub
fun debug(message : String){
    Log.d("debug", message)
}


// *************** view **********************
fun View.gone(){
    visibility = View.GONE
}

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.invisible(){
    visibility = View.INVISIBLE
}

// *************** snackbar ***************
fun View.snack(text : String){
    Snackbar.make(this, text, Snackbar.LENGTH_SHORT).show()
}

fun View.snackWithAction(
    @StringRes messageRes: Int,
    length : Int = Snackbar.LENGTH_SHORT,
    f: Snackbar.() -> Unit){

    snackWithAction(resources.getString(messageRes), length, f)
}

fun View.snackWithAction(
    message: String,
    length: Int = Snackbar.LENGTH_LONG,
    f: Snackbar.() -> Unit
) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    snack.show()
}

fun Snackbar.action(@StringRes actionRes: Int, color: Int? = null, listener: (View) -> Unit) {
    action(view.resources.getString(actionRes), color, listener)
}

fun Snackbar.action(action: String, color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let { setActionTextColor(ContextCompat.getColor(context, color)) }
}




