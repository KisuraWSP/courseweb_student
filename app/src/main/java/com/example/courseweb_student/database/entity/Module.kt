package com.example.courseweb_student.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "modules")
data class Module(
    @ColumnInfo(name = "mcode")
    var moduleCode : String,
    @ColumnInfo(name = "mname")
    var moduleName : String
){
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}
