package com.example.akaisukirecyclerview
import android.view.ContextMenu
import android.view.MenuInflater
import android.content.Context
import android.view.*
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
 class ADAPTERCLASS  :RecyclerView.Adapter<ADAPTERCLASS.ViewHolder>() {
     var personaggi: MutableList<Modello>  = ArrayList()
    lateinit var context: Context
    fun  RECYCLERADAPTER(personaggi: MutableList<Modello>, context: Context)  {
        this.personaggi = personaggi
        this.context = context
    }
     fun getpersonaggi():MutableList<Modello>{ //var da mutable a d array
         var persoanggi:ArrayList<Modello> = ArrayList()
         persoanggi.add(Modello("SASORI "       , "sands"         , "https://static.zerochan.net/Sasori.full.1496734.jpg"))
         persoanggi.add(Modello("kisame"        , "water village" , "https://i.pinimg.com/originals/d2/47/a6/d247a62289b22afa68e8152bcc7d15ab.jpg"))
         persoanggi.add(Modello("IATCHI uchiha" , "konoha"        , "https://i.pinimg.com/564x/6f/46/75/6f4675199bf7802b9a9f531a15dbce2b.jpg"))
         persoanggi.add(Modello("pain"          , "RAIN village"  , "https://i.pinimg.com/564x/44/73/b6/4473b64e729795566f1bcf500b6cb677.jpg"))
         persoanggi.add(Modello("obito uchiha"  , "konoha"        , "https://static.zerochan.net/Tobi.full.1217207.jpg"))
         return persoanggi
     }
     fun remove (position: Int){
         getpersonaggi().removeAt(position)
         notifyItemRemoved(position)
         notifyDataSetChanged()
     }
    //classe viewhold
    class ViewHolder(view:View):RecyclerView.ViewHolder(view)  {
        //casting +istanze dei items
        val personaggionome=view.findViewById(R.id.tvpersonaggio)as TextView
        val nomevillagio = view.findViewById(R.id.persoanggiovillaggio) as TextView
        val stagione = view.findViewById(R.id.stagione) as TextView
        val avatar = view.findViewById(R.id.ivAvatar) as ImageView
        fun bin(setpersoanggi:Modello,context: Context){
            personaggionome.text = setpersoanggi.nome
            nomevillagio.text = setpersoanggi.villagio
            avatar.loadUrl(setpersoanggi.prifilo)
             var click=itemView
            click.setOnLongClickListener {
                Toast.makeText(context, setpersoanggi.nome, Toast.LENGTH_SHORT).show()
                click.showContextMenu()
            }
        }
        fun ImageView.loadUrl(url:String){
            Picasso.with(context).load(url).into(this)
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val item=personaggi.get(position)
        holder.bin(item,context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.itemlist,parent,false))
    }
    override fun getItemCount(): Int {
        return personaggi.size
    }
 }