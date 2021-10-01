package uz.lazycoder.playmarketclone.utils

import java.lang.Exception
import android.widget.Toast
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Callback
import androidx.fragment.app.Fragment

fun Fragment.showToast(msg: String) {
    Toast.makeText(this.requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImage(url: String) {
    Picasso.get().load(url).into(this, object : Callback{
        override fun onSuccess() {
        }
        override fun onError(e: Exception?) {
            this@loadImage.loadImage(url)
        }
    })
}