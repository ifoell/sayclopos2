package com.sayclo.pos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sayclo.pos.ui.login.LoginActivity
import com.sayclo.pos.ui.transaction.TransactionActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            // User sudah login → langsung ke transaksi screen
            val intent = Intent(this, TransactionActivity::class.java)
            startActivity(intent)
            finish() // tutup MainActivity
        } else {
            // Belum login → masuk ke login screen
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}