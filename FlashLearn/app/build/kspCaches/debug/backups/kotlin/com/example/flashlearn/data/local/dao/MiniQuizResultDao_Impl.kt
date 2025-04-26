package com.example.flashlearn.`data`.local.dao

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.flashlearn.`data`.local.Converters
import com.example.flashlearn.`data`.local.entity.MiniQuizResultEntity
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class MiniQuizResultDao_Impl(
  __db: RoomDatabase,
) : MiniQuizResultDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfMiniQuizResultEntity: EntityInsertAdapter<MiniQuizResultEntity>

  private val __converters: Converters = Converters()
  init {
    this.__db = __db
    this.__insertAdapterOfMiniQuizResultEntity = object :
        EntityInsertAdapter<MiniQuizResultEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `quiz_results` (`id`,`categoryId`,`totalQuestions`,`correctAnswers`,`timestamp`,`wrongFlashcardIds`) VALUES (nullif(?, 0),?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: MiniQuizResultEntity) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindLong(2, entity.categoryId.toLong())
        statement.bindLong(3, entity.totalQuestions.toLong())
        statement.bindLong(4, entity.correctAnswers.toLong())
        statement.bindLong(5, entity.timestamp)
        val _tmp: String = __converters.fromIntList(entity.wrongFlashcardIds)
        statement.bindText(6, _tmp)
      }
    }
  }

  public override suspend fun insert(result: MiniQuizResultEntity): Unit = performSuspending(__db,
      false, true) { _connection ->
    __insertAdapterOfMiniQuizResultEntity.insert(_connection, result)
  }

  public override suspend fun getResultsByCategory(categoryId: Int): List<MiniQuizResultEntity> {
    val _sql: String = "SELECT * FROM quiz_results WHERE categoryId = ? ORDER BY timestamp DESC"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, categoryId.toLong())
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfTotalQuestions: Int = getColumnIndexOrThrow(_stmt, "totalQuestions")
        val _columnIndexOfCorrectAnswers: Int = getColumnIndexOrThrow(_stmt, "correctAnswers")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _columnIndexOfWrongFlashcardIds: Int = getColumnIndexOrThrow(_stmt, "wrongFlashcardIds")
        val _result: MutableList<MiniQuizResultEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: MiniQuizResultEntity
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpCategoryId: Int
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId).toInt()
          val _tmpTotalQuestions: Int
          _tmpTotalQuestions = _stmt.getLong(_columnIndexOfTotalQuestions).toInt()
          val _tmpCorrectAnswers: Int
          _tmpCorrectAnswers = _stmt.getLong(_columnIndexOfCorrectAnswers).toInt()
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          val _tmpWrongFlashcardIds: List<Int>
          val _tmp: String
          _tmp = _stmt.getText(_columnIndexOfWrongFlashcardIds)
          _tmpWrongFlashcardIds = __converters.toIntList(_tmp)
          _item =
              MiniQuizResultEntity(_tmpId,_tmpCategoryId,_tmpTotalQuestions,_tmpCorrectAnswers,_tmpTimestamp,_tmpWrongFlashcardIds)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getAllResults(): List<MiniQuizResultEntity> {
    val _sql: String = "SELECT * FROM quiz_results ORDER BY timestamp DESC"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfTotalQuestions: Int = getColumnIndexOrThrow(_stmt, "totalQuestions")
        val _columnIndexOfCorrectAnswers: Int = getColumnIndexOrThrow(_stmt, "correctAnswers")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _columnIndexOfWrongFlashcardIds: Int = getColumnIndexOrThrow(_stmt, "wrongFlashcardIds")
        val _result: MutableList<MiniQuizResultEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: MiniQuizResultEntity
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpCategoryId: Int
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId).toInt()
          val _tmpTotalQuestions: Int
          _tmpTotalQuestions = _stmt.getLong(_columnIndexOfTotalQuestions).toInt()
          val _tmpCorrectAnswers: Int
          _tmpCorrectAnswers = _stmt.getLong(_columnIndexOfCorrectAnswers).toInt()
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          val _tmpWrongFlashcardIds: List<Int>
          val _tmp: String
          _tmp = _stmt.getText(_columnIndexOfWrongFlashcardIds)
          _tmpWrongFlashcardIds = __converters.toIntList(_tmp)
          _item =
              MiniQuizResultEntity(_tmpId,_tmpCategoryId,_tmpTotalQuestions,_tmpCorrectAnswers,_tmpTimestamp,_tmpWrongFlashcardIds)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getResultsBetween(start: Long, end: Long):
      List<MiniQuizResultEntity> {
    val _sql: String = "SELECT * FROM quiz_results WHERE timestamp BETWEEN ? AND ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, start)
        _argIndex = 2
        _stmt.bindLong(_argIndex, end)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfTotalQuestions: Int = getColumnIndexOrThrow(_stmt, "totalQuestions")
        val _columnIndexOfCorrectAnswers: Int = getColumnIndexOrThrow(_stmt, "correctAnswers")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _columnIndexOfWrongFlashcardIds: Int = getColumnIndexOrThrow(_stmt, "wrongFlashcardIds")
        val _result: MutableList<MiniQuizResultEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: MiniQuizResultEntity
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpCategoryId: Int
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId).toInt()
          val _tmpTotalQuestions: Int
          _tmpTotalQuestions = _stmt.getLong(_columnIndexOfTotalQuestions).toInt()
          val _tmpCorrectAnswers: Int
          _tmpCorrectAnswers = _stmt.getLong(_columnIndexOfCorrectAnswers).toInt()
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          val _tmpWrongFlashcardIds: List<Int>
          val _tmp: String
          _tmp = _stmt.getText(_columnIndexOfWrongFlashcardIds)
          _tmpWrongFlashcardIds = __converters.toIntList(_tmp)
          _item =
              MiniQuizResultEntity(_tmpId,_tmpCategoryId,_tmpTotalQuestions,_tmpCorrectAnswers,_tmpTimestamp,_tmpWrongFlashcardIds)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getLatestResultByCategory(categoryId: Int): MiniQuizResultEntity? {
    val _sql: String =
        "SELECT * FROM quiz_results WHERE categoryId = ? ORDER BY timestamp DESC LIMIT 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, categoryId.toLong())
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfTotalQuestions: Int = getColumnIndexOrThrow(_stmt, "totalQuestions")
        val _columnIndexOfCorrectAnswers: Int = getColumnIndexOrThrow(_stmt, "correctAnswers")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _columnIndexOfWrongFlashcardIds: Int = getColumnIndexOrThrow(_stmt, "wrongFlashcardIds")
        val _result: MiniQuizResultEntity?
        if (_stmt.step()) {
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpCategoryId: Int
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId).toInt()
          val _tmpTotalQuestions: Int
          _tmpTotalQuestions = _stmt.getLong(_columnIndexOfTotalQuestions).toInt()
          val _tmpCorrectAnswers: Int
          _tmpCorrectAnswers = _stmt.getLong(_columnIndexOfCorrectAnswers).toInt()
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          val _tmpWrongFlashcardIds: List<Int>
          val _tmp: String
          _tmp = _stmt.getText(_columnIndexOfWrongFlashcardIds)
          _tmpWrongFlashcardIds = __converters.toIntList(_tmp)
          _result =
              MiniQuizResultEntity(_tmpId,_tmpCategoryId,_tmpTotalQuestions,_tmpCorrectAnswers,_tmpTimestamp,_tmpWrongFlashcardIds)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
