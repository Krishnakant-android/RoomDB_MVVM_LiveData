package com.josh.roomlivedataviewmodel.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.josh.roomlivedataviewmodel.model.LoginTableModel
import com.josh.roomlivedataviewmodel.model.UserModel

@Dao
interface DAOAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertData(loginTableModel: LoginTableModel)

    @Query("SELECT * FROM Login WHERE Username =:username")
    fun getLoginDetails(username: String?) : LiveData<LoginTableModel>

    @Query("SELECT * FROM Login")
    fun getAllUser() : LiveData<List<UserModel>>

}