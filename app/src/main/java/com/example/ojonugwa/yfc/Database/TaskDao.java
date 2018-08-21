package com.example.ojonugwa.yfc.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM member ORDER BY updated_at")
    List<MemberEntry> loadAllTasks();

    @Insert
    void insertTask(MemberEntry memberEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(MemberEntry memberEntry);

    @Delete
    void deleteTask(MemberEntry memberEntry);
}
