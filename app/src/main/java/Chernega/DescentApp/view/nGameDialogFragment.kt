package Chernega.DescentApp.view

import android.os.Bundle
import android.view.View
import Chernega.DescentApp.R
import Chernega.DescentApp.model.DataModel
import Chernega.DescentApp.model.players

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels

class nGameDialogFragment : DialogFragment() {




    @SuppressLint("MissingInflatedId")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val customView: View = layoutInflater.inflate(R.layout.fragment_n_game_dialog, null)
        val editText: EditText = customView.findViewById(R.id.editText)

        val myContex = requireActivity()
        val dataModel: DataModel by activityViewModels()

        return AlertDialog.Builder(myContex)
            .setView(customView)
            .setCancelable(true)
            .setMessage("Enter the number of players")
            .setIcon(R.drawable.alert)

            .setPositiveButton("Enter") {_, _ ->
                dataModel.players.value = editText.text.toString()

                goToNGame()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(myContex, "Cancel", Toast.LENGTH_SHORT).show()
            }
            .create()
    }

    private fun goToNGame() {

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.placeholder, NewGameFragment::class.java.newInstance())
            .apply { players() }
            ?.addToBackStack(null)
            ?.commit()
    }

}