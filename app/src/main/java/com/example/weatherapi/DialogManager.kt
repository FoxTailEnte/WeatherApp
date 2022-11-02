package com.example.weatherapi

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText

object DialogManager {
    fun locationSettingsDialog(context: Context, listener: Listener){
        val build = AlertDialog.Builder(context)
        val dialog = build.create()
        dialog.setTitle("Enable location?")
        dialog.setMessage("Location disabled! Do you want enable location?")
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Ok"){ _,_ ->
            listener.onClick(null)
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Cancel"){ _,_ ->
            dialog.dismiss()
        }
        dialog.show()
    }

    fun searchByNameDialog(context: Context, listener: Listener){
        val build = AlertDialog.Builder(context)
        val edName = EditText(context)
        build.setView(edName)
        val dialog = build.create()
        dialog.setTitle("City name:")
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Ok"){ _,_ ->
            listener.onClick(edName.text.toString())
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Cancel"){ _,_ ->
            dialog.dismiss()
        }
        dialog.show()
    }

    interface Listener{
        fun onClick(name: String?)
    }
}