package com.github.adrianobrito.projetoandroid

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import org.jetbrains.anko.*

public class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)

        verticalLayout{
            padding = dip(15)

            editText{
                hint = "Login"
                textSize = 24f
            }

            editText{
                hint = "Senha"
                textSize = 24f
            }

            button("Login")

        }


    }

}
