package non.shahad.today.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import non.shahad.today.data.db.converters.ImageUrlConverter
import non.shahad.today.data.db.converters.StringToListConverter
import non.shahad.today.data.db.daos.TodayNewsDao
import non.shahad.today.data.db.entities.NewsEntity

@Database(
    entities = [NewsEntity::class],
    exportSchema = false,
    version = 2
)
@TypeConverters(StringToListConverter::class)
internal abstract class TodayDatabase: RoomDatabase() {
    abstract fun todayDao(): TodayNewsDao
}