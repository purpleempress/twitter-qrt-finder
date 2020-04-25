package ch.flourish.qrtfind

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class ShareHandler : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when {
            intent?.action == Intent.ACTION_SEND -> {
                var text = intent.getStringExtra("android.intent.extra.TEXT")
                if ("text/plain" == intent.type) {
                    if (text.startsWith("https://twitter.com/")) {
                        val openURL = Intent(android.content.Intent.ACTION_VIEW)
                        openURL.data = Uri.parse(
                            "twitter://search?query=url:" + text.toString().split(
                                "?"
                            )[0]
                        )
                        startActivity(openURL)
                        finish()
                    } else {
                        Toast.makeText(this, "Unsupported URL!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            }

        }
    }
}

//Log.i("TAG", "hi")