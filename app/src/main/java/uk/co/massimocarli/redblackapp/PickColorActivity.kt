package uk.co.massimocarli.redblackapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pick.*

class PickColorActivity : AppCompatActivity() {

  companion object {
    const val PICKED_COLOR_EXTRA = "uk.co.massimocarli.redblackapp.extra.PICKED_COLOR_EXTRA"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val action = intent?.action
    if (action == Intent.ACTION_PICK) {
      setContentView(R.layout.activity_pick)
      redColorButton.setOnClickListener {
        sendBack("#FF0000")
      }
      blackColorButton.setOnClickListener {
        sendBack("#000000")
      }
    } else {
      setContentView(R.layout.activity_view)
    }
  }

  fun setResult(resultCode: Int, data: Intent)


  private fun sendBack(color: String) {
    val data = Intent().apply {
      putExtra(PICKED_COLOR_EXTRA, color)
    }
    setResult(Activity.RESULT_OK, data)
    finish()
  }
}