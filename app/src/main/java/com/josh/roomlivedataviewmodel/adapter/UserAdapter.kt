package com.josh.roomlivedataviewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.josh.roomlivedataviewmodel.R
import com.josh.roomlivedataviewmodel.model.UserModel

internal class UserAdapter(private var userList: List<UserModel>) :
RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
   internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      var txtUsername: TextView = view.findViewById(R.id.txtUsername)
      var txtPassword: TextView = view.findViewById(R.id.txtPassword)
   }
   @NonNull
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val itemView = LayoutInflater.from(parent.context)
      .inflate(R.layout.item_view, parent, false)
      return MyViewHolder(itemView)
   }
   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val userModel = userList.get(position)
      holder.txtUsername.text = "Name : " + userModel.username
      holder.txtPassword.text = "Password: " + userModel.password
   }
   override fun getItemCount(): Int {
      return userList.size
   }
}