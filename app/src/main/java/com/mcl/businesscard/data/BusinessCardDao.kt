package com.mcl.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BusinessCardDao {

    @Query("SELECT * FROM BusinessCardEntity")
    fun getAll(): LiveData<List<BusinessCardEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCardEntity: BusinessCardEntity)
}