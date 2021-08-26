package com.mcl.businesscard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository(private val dao: BusinessCardDao) {

    fun insert(businessCardEntity: BusinessCardEntity) = runBlocking {
        launch(Dispatchers.IO){
            dao.insert(businessCardEntity)
        }
    }

    fun getAll() = dao.getAll()
}