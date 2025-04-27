package com.example.flashlearn.`data`.local.dao

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.flashlearn.`data`.local.entity.CategoryEntity
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class CategoryDao_Impl(
  __db: RoomDatabase,
) : CategoryDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfCategoryEntity: EntityInsertAdapter<CategoryEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfCategoryEntity = object : EntityInsertAdapter<CategoryEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR ABORT INTO `category` (`id`,`name`,`cardCount`,`isReviewed`,`isQuizDone`,`createdAt`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: CategoryEntity) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.name)
        statement.bindLong(3, entity.cardCount.toLong())
        val _tmp: Int = if (entity.isReviewed) 1 else 0
        statement.bindLong(4, _tmp.toLong())
        val _tmp_1: Int = if (entity.isQuizDone) 1 else 0
        statement.bindLong(5, _tmp_1.toLong())
        statement.bindLong(6, entity.createdAt)
        statement.bindLong(7, entity.updatedAt)
      }
    }
  }

  public override suspend fun insert(category: CategoryEntity): Long = performSuspending(__db,
      false, true) { _connection ->
    val _result: Long = __insertAdapterOfCategoryEntity.insertAndReturnId(_connection, category)
    _result
  }

  public override fun getAll(): Flow<List<CategoryEntity>> {
    val _sql: String = """
        |
        |        SELECT 
        |            c.id, 
        |            c.name, 
        |            c.isReviewed, 
        |            c.isQuizDone, 
        |            c.createdAt, 
        |            c.updatedAt,
        |            COUNT(f.id) AS cardCount
        |        FROM category c
        |        LEFT JOIN flashcard f ON c.id = f.categoryId
        |        GROUP BY c.id
        |        ORDER BY c.createdAt DESC
        |    
        """.trimMargin()
    return createFlow(__db, false, arrayOf("category", "flashcard")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = 0
        val _columnIndexOfName: Int = 1
        val _columnIndexOfIsReviewed: Int = 2
        val _columnIndexOfIsQuizDone: Int = 3
        val _columnIndexOfCreatedAt: Int = 4
        val _columnIndexOfUpdatedAt: Int = 5
        val _columnIndexOfCardCount: Int = 6
        val _result: MutableList<CategoryEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: CategoryEntity
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpIsReviewed: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsReviewed).toInt()
          _tmpIsReviewed = _tmp != 0
          val _tmpIsQuizDone: Boolean
          val _tmp_1: Int
          _tmp_1 = _stmt.getLong(_columnIndexOfIsQuizDone).toInt()
          _tmpIsQuizDone = _tmp_1 != 0
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt)
          val _tmpUpdatedAt: Long
          _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt)
          val _tmpCardCount: Int
          _tmpCardCount = _stmt.getLong(_columnIndexOfCardCount).toInt()
          _item =
              CategoryEntity(_tmpId,_tmpName,_tmpCardCount,_tmpIsReviewed,_tmpIsQuizDone,_tmpCreatedAt,_tmpUpdatedAt)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getById(categoryId: Int): CategoryEntity? {
    val _sql: String = "SELECT * FROM category WHERE id = ? LIMIT 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, categoryId.toLong())
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfCardCount: Int = getColumnIndexOrThrow(_stmt, "cardCount")
        val _columnIndexOfIsReviewed: Int = getColumnIndexOrThrow(_stmt, "isReviewed")
        val _columnIndexOfIsQuizDone: Int = getColumnIndexOrThrow(_stmt, "isQuizDone")
        val _columnIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _columnIndexOfUpdatedAt: Int = getColumnIndexOrThrow(_stmt, "updatedAt")
        val _result: CategoryEntity?
        if (_stmt.step()) {
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpCardCount: Int
          _tmpCardCount = _stmt.getLong(_columnIndexOfCardCount).toInt()
          val _tmpIsReviewed: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsReviewed).toInt()
          _tmpIsReviewed = _tmp != 0
          val _tmpIsQuizDone: Boolean
          val _tmp_1: Int
          _tmp_1 = _stmt.getLong(_columnIndexOfIsQuizDone).toInt()
          _tmpIsQuizDone = _tmp_1 != 0
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt)
          val _tmpUpdatedAt: Long
          _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt)
          _result =
              CategoryEntity(_tmpId,_tmpName,_tmpCardCount,_tmpIsReviewed,_tmpIsQuizDone,_tmpCreatedAt,_tmpUpdatedAt)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getUpdatedSince(lastSyncedAt: Long): List<CategoryEntity> {
    val _sql: String = "SELECT * FROM category WHERE updatedAt > ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, lastSyncedAt)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfCardCount: Int = getColumnIndexOrThrow(_stmt, "cardCount")
        val _columnIndexOfIsReviewed: Int = getColumnIndexOrThrow(_stmt, "isReviewed")
        val _columnIndexOfIsQuizDone: Int = getColumnIndexOrThrow(_stmt, "isQuizDone")
        val _columnIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _columnIndexOfUpdatedAt: Int = getColumnIndexOrThrow(_stmt, "updatedAt")
        val _result: MutableList<CategoryEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: CategoryEntity
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpCardCount: Int
          _tmpCardCount = _stmt.getLong(_columnIndexOfCardCount).toInt()
          val _tmpIsReviewed: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsReviewed).toInt()
          _tmpIsReviewed = _tmp != 0
          val _tmpIsQuizDone: Boolean
          val _tmp_1: Int
          _tmp_1 = _stmt.getLong(_columnIndexOfIsQuizDone).toInt()
          _tmpIsQuizDone = _tmp_1 != 0
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt)
          val _tmpUpdatedAt: Long
          _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt)
          _item =
              CategoryEntity(_tmpId,_tmpName,_tmpCardCount,_tmpIsReviewed,_tmpIsQuizDone,_tmpCreatedAt,_tmpUpdatedAt)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun countCategories(): Int {
    val _sql: String = "SELECT COUNT(*) FROM category"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _result: Int
        if (_stmt.step()) {
          val _tmp: Int
          _tmp = _stmt.getLong(0).toInt()
          _result = _tmp
        } else {
          _result = 0
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun updateCategoryInfo(
    categoryId: Int,
    newName: String,
    newCardCount: Int,
  ) {
    val _sql: String = "UPDATE category SET name = ?, cardCount = ? WHERE id = ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, newName)
        _argIndex = 2
        _stmt.bindLong(_argIndex, newCardCount.toLong())
        _argIndex = 3
        _stmt.bindLong(_argIndex, categoryId.toLong())
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteById(categoryId: Int) {
    val _sql: String = "DELETE FROM category WHERE id = ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, categoryId.toLong())
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun updateCategoryName(categoryId: Int, newName: String) {
    val _sql: String = "UPDATE category SET name = ? WHERE id = ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, newName)
        _argIndex = 2
        _stmt.bindLong(_argIndex, categoryId.toLong())
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteAll() {
    val _sql: String = "DELETE FROM category"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
