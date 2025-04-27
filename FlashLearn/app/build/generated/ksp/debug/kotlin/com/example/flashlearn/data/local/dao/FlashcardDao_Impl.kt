package com.example.flashlearn.`data`.local.dao

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.flashlearn.`data`.local.entity.FlashcardEntity
import javax.`annotation`.processing.Generated
import kotlin.Boolean
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
public class FlashcardDao_Impl(
  __db: RoomDatabase,
) : FlashcardDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfFlashcardEntity: EntityInsertAdapter<FlashcardEntity>

  private val __deleteAdapterOfFlashcardEntity: EntityDeleteOrUpdateAdapter<FlashcardEntity>

  private val __updateAdapterOfFlashcardEntity: EntityDeleteOrUpdateAdapter<FlashcardEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfFlashcardEntity = object : EntityInsertAdapter<FlashcardEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR ABORT INTO `flashcard` (`id`,`categoryId`,`term`,`definition`,`pronunciation`,`isFavorite`,`isRemembered`,`createdAt`,`updatedAt`,`lastReviewedDate`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: FlashcardEntity) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindLong(2, entity.categoryId.toLong())
        statement.bindText(3, entity.term)
        statement.bindText(4, entity.definition)
        val _tmpPronunciation: String? = entity.pronunciation
        if (_tmpPronunciation == null) {
          statement.bindNull(5)
        } else {
          statement.bindText(5, _tmpPronunciation)
        }
        val _tmp: Int = if (entity.isFavorite) 1 else 0
        statement.bindLong(6, _tmp.toLong())
        val _tmp_1: Int = if (entity.isRemembered) 1 else 0
        statement.bindLong(7, _tmp_1.toLong())
        statement.bindLong(8, entity.createdAt)
        statement.bindLong(9, entity.updatedAt)
        val _tmpLastReviewedDate: Long? = entity.lastReviewedDate
        if (_tmpLastReviewedDate == null) {
          statement.bindNull(10)
        } else {
          statement.bindLong(10, _tmpLastReviewedDate)
        }
      }
    }
    this.__deleteAdapterOfFlashcardEntity = object : EntityDeleteOrUpdateAdapter<FlashcardEntity>()
        {
      protected override fun createQuery(): String = "DELETE FROM `flashcard` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: FlashcardEntity) {
        statement.bindLong(1, entity.id.toLong())
      }
    }
    this.__updateAdapterOfFlashcardEntity = object : EntityDeleteOrUpdateAdapter<FlashcardEntity>()
        {
      protected override fun createQuery(): String =
          "UPDATE OR ABORT `flashcard` SET `id` = ?,`categoryId` = ?,`term` = ?,`definition` = ?,`pronunciation` = ?,`isFavorite` = ?,`isRemembered` = ?,`createdAt` = ?,`updatedAt` = ?,`lastReviewedDate` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: FlashcardEntity) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindLong(2, entity.categoryId.toLong())
        statement.bindText(3, entity.term)
        statement.bindText(4, entity.definition)
        val _tmpPronunciation: String? = entity.pronunciation
        if (_tmpPronunciation == null) {
          statement.bindNull(5)
        } else {
          statement.bindText(5, _tmpPronunciation)
        }
        val _tmp: Int = if (entity.isFavorite) 1 else 0
        statement.bindLong(6, _tmp.toLong())
        val _tmp_1: Int = if (entity.isRemembered) 1 else 0
        statement.bindLong(7, _tmp_1.toLong())
        statement.bindLong(8, entity.createdAt)
        statement.bindLong(9, entity.updatedAt)
        val _tmpLastReviewedDate: Long? = entity.lastReviewedDate
        if (_tmpLastReviewedDate == null) {
          statement.bindNull(10)
        } else {
          statement.bindLong(10, _tmpLastReviewedDate)
        }
        statement.bindLong(11, entity.id.toLong())
      }
    }
  }

  public override suspend fun insertAll(cards: List<FlashcardEntity>): Unit =
      performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfFlashcardEntity.insert(_connection, cards)
  }

  public override suspend fun insert(card: FlashcardEntity): Unit = performSuspending(__db, false,
      true) { _connection ->
    __insertAdapterOfFlashcardEntity.insert(_connection, card)
  }

  public override suspend fun delete(card: FlashcardEntity): Unit = performSuspending(__db, false,
      true) { _connection ->
    __deleteAdapterOfFlashcardEntity.handle(_connection, card)
  }

  public override suspend fun update(card: FlashcardEntity): Unit = performSuspending(__db, false,
      true) { _connection ->
    __updateAdapterOfFlashcardEntity.handle(_connection, card)
  }

  public override suspend fun getByCategoryId(categoryId: Int): List<FlashcardEntity> {
    val _sql: String = "SELECT * FROM flashcard WHERE categoryId = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, categoryId.toLong())
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfTerm: Int = getColumnIndexOrThrow(_stmt, "term")
        val _columnIndexOfDefinition: Int = getColumnIndexOrThrow(_stmt, "definition")
        val _columnIndexOfPronunciation: Int = getColumnIndexOrThrow(_stmt, "pronunciation")
        val _columnIndexOfIsFavorite: Int = getColumnIndexOrThrow(_stmt, "isFavorite")
        val _columnIndexOfIsRemembered: Int = getColumnIndexOrThrow(_stmt, "isRemembered")
        val _columnIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _columnIndexOfUpdatedAt: Int = getColumnIndexOrThrow(_stmt, "updatedAt")
        val _columnIndexOfLastReviewedDate: Int = getColumnIndexOrThrow(_stmt, "lastReviewedDate")
        val _result: MutableList<FlashcardEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: FlashcardEntity
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpCategoryId: Int
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId).toInt()
          val _tmpTerm: String
          _tmpTerm = _stmt.getText(_columnIndexOfTerm)
          val _tmpDefinition: String
          _tmpDefinition = _stmt.getText(_columnIndexOfDefinition)
          val _tmpPronunciation: String?
          if (_stmt.isNull(_columnIndexOfPronunciation)) {
            _tmpPronunciation = null
          } else {
            _tmpPronunciation = _stmt.getText(_columnIndexOfPronunciation)
          }
          val _tmpIsFavorite: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsFavorite).toInt()
          _tmpIsFavorite = _tmp != 0
          val _tmpIsRemembered: Boolean
          val _tmp_1: Int
          _tmp_1 = _stmt.getLong(_columnIndexOfIsRemembered).toInt()
          _tmpIsRemembered = _tmp_1 != 0
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt)
          val _tmpUpdatedAt: Long
          _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt)
          val _tmpLastReviewedDate: Long?
          if (_stmt.isNull(_columnIndexOfLastReviewedDate)) {
            _tmpLastReviewedDate = null
          } else {
            _tmpLastReviewedDate = _stmt.getLong(_columnIndexOfLastReviewedDate)
          }
          _item =
              FlashcardEntity(_tmpId,_tmpCategoryId,_tmpTerm,_tmpDefinition,_tmpPronunciation,_tmpIsFavorite,_tmpIsRemembered,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastReviewedDate)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getUpdatedSince(lastSyncedAt: Long): List<FlashcardEntity> {
    val _sql: String = "SELECT * FROM flashcard WHERE updatedAt > ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, lastSyncedAt)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfTerm: Int = getColumnIndexOrThrow(_stmt, "term")
        val _columnIndexOfDefinition: Int = getColumnIndexOrThrow(_stmt, "definition")
        val _columnIndexOfPronunciation: Int = getColumnIndexOrThrow(_stmt, "pronunciation")
        val _columnIndexOfIsFavorite: Int = getColumnIndexOrThrow(_stmt, "isFavorite")
        val _columnIndexOfIsRemembered: Int = getColumnIndexOrThrow(_stmt, "isRemembered")
        val _columnIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _columnIndexOfUpdatedAt: Int = getColumnIndexOrThrow(_stmt, "updatedAt")
        val _columnIndexOfLastReviewedDate: Int = getColumnIndexOrThrow(_stmt, "lastReviewedDate")
        val _result: MutableList<FlashcardEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: FlashcardEntity
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpCategoryId: Int
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId).toInt()
          val _tmpTerm: String
          _tmpTerm = _stmt.getText(_columnIndexOfTerm)
          val _tmpDefinition: String
          _tmpDefinition = _stmt.getText(_columnIndexOfDefinition)
          val _tmpPronunciation: String?
          if (_stmt.isNull(_columnIndexOfPronunciation)) {
            _tmpPronunciation = null
          } else {
            _tmpPronunciation = _stmt.getText(_columnIndexOfPronunciation)
          }
          val _tmpIsFavorite: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsFavorite).toInt()
          _tmpIsFavorite = _tmp != 0
          val _tmpIsRemembered: Boolean
          val _tmp_1: Int
          _tmp_1 = _stmt.getLong(_columnIndexOfIsRemembered).toInt()
          _tmpIsRemembered = _tmp_1 != 0
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt)
          val _tmpUpdatedAt: Long
          _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt)
          val _tmpLastReviewedDate: Long?
          if (_stmt.isNull(_columnIndexOfLastReviewedDate)) {
            _tmpLastReviewedDate = null
          } else {
            _tmpLastReviewedDate = _stmt.getLong(_columnIndexOfLastReviewedDate)
          }
          _item =
              FlashcardEntity(_tmpId,_tmpCategoryId,_tmpTerm,_tmpDefinition,_tmpPronunciation,_tmpIsFavorite,_tmpIsRemembered,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastReviewedDate)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteByCategoryId(categoryId: Int) {
    val _sql: String = "DELETE FROM flashcard WHERE categoryId = ?"
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

  public override suspend fun deleteAll() {
    val _sql: String = "DELETE FROM flashcard"
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
