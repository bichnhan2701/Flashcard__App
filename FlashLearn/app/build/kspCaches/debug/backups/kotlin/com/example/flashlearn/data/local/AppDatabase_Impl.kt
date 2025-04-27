package com.example.flashlearn.`data`.local

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import com.example.flashlearn.`data`.local.dao.CategoryDao
import com.example.flashlearn.`data`.local.dao.CategoryDao_Impl
import com.example.flashlearn.`data`.local.dao.FlashcardDao
import com.example.flashlearn.`data`.local.dao.FlashcardDao_Impl
import com.example.flashlearn.`data`.local.dao.MiniQuizResultDao
import com.example.flashlearn.`data`.local.dao.MiniQuizResultDao_Impl
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class AppDatabase_Impl : AppDatabase() {
  private val _categoryDao: Lazy<CategoryDao> = lazy {
    CategoryDao_Impl(this)
  }

  private val _flashcardDao: Lazy<FlashcardDao> = lazy {
    FlashcardDao_Impl(this)
  }

  private val _miniQuizResultDao: Lazy<MiniQuizResultDao> = lazy {
    MiniQuizResultDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(9,
        "122d4fd5cddbeb68916f6d3cf0e3ef79", "e924f1eb99f6c8fa093a731634d5d5d6") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `flashcard` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `categoryId` INTEGER NOT NULL, `term` TEXT NOT NULL, `definition` TEXT NOT NULL, `pronunciation` TEXT, `isFavorite` INTEGER NOT NULL, `isRemembered` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `lastReviewedDate` INTEGER)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `category` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `cardCount` INTEGER NOT NULL, `isReviewed` INTEGER NOT NULL, `isQuizDone` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `quiz_results` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `categoryId` INTEGER NOT NULL, `totalQuestions` INTEGER NOT NULL, `correctAnswers` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `wrongFlashcardIds` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '122d4fd5cddbeb68916f6d3cf0e3ef79')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `flashcard`")
        connection.execSQL("DROP TABLE IF EXISTS `category`")
        connection.execSQL("DROP TABLE IF EXISTS `quiz_results`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection):
          RoomOpenDelegate.ValidationResult {
        val _columnsFlashcard: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsFlashcard.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsFlashcard.put("categoryId", TableInfo.Column("categoryId", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsFlashcard.put("term", TableInfo.Column("term", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsFlashcard.put("definition", TableInfo.Column("definition", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsFlashcard.put("pronunciation", TableInfo.Column("pronunciation", "TEXT", false, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsFlashcard.put("isFavorite", TableInfo.Column("isFavorite", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsFlashcard.put("isRemembered", TableInfo.Column("isRemembered", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsFlashcard.put("createdAt", TableInfo.Column("createdAt", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsFlashcard.put("updatedAt", TableInfo.Column("updatedAt", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsFlashcard.put("lastReviewedDate", TableInfo.Column("lastReviewedDate", "INTEGER",
            false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysFlashcard: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesFlashcard: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoFlashcard: TableInfo = TableInfo("flashcard", _columnsFlashcard,
            _foreignKeysFlashcard, _indicesFlashcard)
        val _existingFlashcard: TableInfo = read(connection, "flashcard")
        if (!_infoFlashcard.equals(_existingFlashcard)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |flashcard(com.example.flashlearn.data.local.entity.FlashcardEntity).
              | Expected:
              |""".trimMargin() + _infoFlashcard + """
              |
              | Found:
              |""".trimMargin() + _existingFlashcard)
        }
        val _columnsCategory: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsCategory.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsCategory.put("name", TableInfo.Column("name", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsCategory.put("cardCount", TableInfo.Column("cardCount", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsCategory.put("isReviewed", TableInfo.Column("isReviewed", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsCategory.put("isQuizDone", TableInfo.Column("isQuizDone", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsCategory.put("createdAt", TableInfo.Column("createdAt", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsCategory.put("updatedAt", TableInfo.Column("updatedAt", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysCategory: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesCategory: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoCategory: TableInfo = TableInfo("category", _columnsCategory, _foreignKeysCategory,
            _indicesCategory)
        val _existingCategory: TableInfo = read(connection, "category")
        if (!_infoCategory.equals(_existingCategory)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |category(com.example.flashlearn.data.local.entity.CategoryEntity).
              | Expected:
              |""".trimMargin() + _infoCategory + """
              |
              | Found:
              |""".trimMargin() + _existingCategory)
        }
        val _columnsQuizResults: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsQuizResults.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsQuizResults.put("categoryId", TableInfo.Column("categoryId", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsQuizResults.put("totalQuestions", TableInfo.Column("totalQuestions", "INTEGER",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsQuizResults.put("correctAnswers", TableInfo.Column("correctAnswers", "INTEGER",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsQuizResults.put("timestamp", TableInfo.Column("timestamp", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsQuizResults.put("wrongFlashcardIds", TableInfo.Column("wrongFlashcardIds", "TEXT",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsQuizResults.put("updatedAt", TableInfo.Column("updatedAt", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysQuizResults: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesQuizResults: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoQuizResults: TableInfo = TableInfo("quiz_results", _columnsQuizResults,
            _foreignKeysQuizResults, _indicesQuizResults)
        val _existingQuizResults: TableInfo = read(connection, "quiz_results")
        if (!_infoQuizResults.equals(_existingQuizResults)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |quiz_results(com.example.flashlearn.data.local.entity.MiniQuizResultEntity).
              | Expected:
              |""".trimMargin() + _infoQuizResults + """
              |
              | Found:
              |""".trimMargin() + _existingQuizResults)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "flashcard", "category",
        "quiz_results")
  }

  public override fun clearAllTables() {
    super.performClear(false, "flashcard", "category", "quiz_results")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(CategoryDao::class, CategoryDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(FlashcardDao::class, FlashcardDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(MiniQuizResultDao::class, MiniQuizResultDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override
      fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun categoryDao(): CategoryDao = _categoryDao.value

  public override fun flashcardDao(): FlashcardDao = _flashcardDao.value

  public override fun miniQuizResultDao(): MiniQuizResultDao = _miniQuizResultDao.value
}
