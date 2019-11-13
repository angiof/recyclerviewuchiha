package com.example.akaisukirecyclerview
import android.app.Activity
import android.app.Application
import android.content.Context
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ib.custom.toast.CustomToastView.build.makeDefaultToast
import com.ib.custom.toast.CustomToastView.build.makeErrorToast

class MainActivity : AppCompatActivity()  {
    lateinit var mRecyclerView : RecyclerView
    val mAdapter : ADAPTERCLASS = ADAPTERCLASS()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()
        registerForContextMenu(mRecyclerView)
    }

    fun setUpRecyclerView(){
        var gg=  mAdapter.getpersonaggi()

        mRecyclerView = findViewById(R.id.listakaisauki) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RECYCLERADAPTER(gg, this)
        mRecyclerView.adapter = mAdapter
    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
         val menuInflater=menuInflater.inflate(R.menu.menup,menu)

        return menuInflater
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {


        when(item.itemId){
            R.id.remove ->{
                try {
                    makeErrorToast(this,"rimosso ${item.itemId} ",2).show()
                    mAdapter.remove(item.itemId)
                } catch (e: Exception) {
                    makeErrorToast(this,"errore nel item ${item.itemId} ",2).show()
                }

            }
        }
        return super.onContextItemSelected(item)
    }



}