package non.shahad.today.data.db.converters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@TypeConverters
open class StringToListConverter {
    private val moshi = Moshi.Builder().build()
    private val type =  Types.newParameterizedType(List::class.java,String::class.java)
    private val adapter = moshi.adapter<List<String>>(type)

    @TypeConverter
    fun fromJson(string: String): List<String> {
        return adapter.fromJson(string)!!
    }

    @TypeConverter
    fun toJson(list: List<String>): String{
        return adapter.toJson(list)
    }
}