package uk.co.massimocarli.redblackapp

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  companion object {
    const val CHANGE_COLOR_REQUEST_ID = 1
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    changeColorButton.setOnClickListener {
      val intent = Intent(
        this,
        PickColorActivity::class.java
      ).apply {
        action = Intent.ACTION_PICK
      }
      startActivityForResult(intent, CHANGE_COLOR_REQUEST_ID)
    }
    viewButton.setOnClickListener {
      val intent = Intent(
        this,
        PickColorActivity::class.java
      ).apply {
        action = Intent.ACTION_VIEW
      }
      startActivity(intent)
    }
  }

  override fun onActivityResult(
    requestCode: Int,
    resultCode: Int,
    data: Intent?
  ) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == CHANGE_COLOR_REQUEST_ID) {
      if (resultCode == Activity.RESULT_OK) {
        data?.getStringExtra(
          PickColorActivity.PICKED_COLOR_EXTRA
        )?.let {
          val color = Color.parseColor(it)
          containerLayout.setBackgroundColor(color)
        }
      }
    }
  }
}
