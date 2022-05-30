package com.example.todo.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * A basic class representing a two-column todo_database table.
 *
 * @ Entity - annotate the class as an entity and supply a table name if not class name.
 * @ PrimaryKey - identify the primary key.
 * @ ColumnInfo - supply the column name if it is different from the variable name.
 *
 * See the documentation for the full set of annotations.
 * https://developer.android.com/topic/libraries/architecture/room.html
 */

@Entity(tableName = "todo_table")
public class todo {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    public String Title;

    @ColumnInfo(name = "detail")
    public String Detail;

    @ColumnInfo(name = "date")
    public String Date;

    @ColumnInfo(name = "priority")
    public String Priority;

    @ColumnInfo(name = "status")
    public String Status;


}


