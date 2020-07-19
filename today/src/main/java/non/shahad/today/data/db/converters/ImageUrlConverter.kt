package non.shahad.today.data.db.converters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import non.shahad.today.data.model.ImgDataModel

@TypeConverters
internal class ImageUrlConverter {
    private val moshi = Moshi.Builder().build()
    private val type = Types.getRawType(ImgDataModel::class.java)
    private val adapter = moshi.adapter<ImgDataModel>(type)

    @TypeConverter
    fun fromJson(string: String?): ImgDataModel {
        return adapter.fromJson(string!!)!!
    }

    @TypeConverter
    fun toJson(list: ImgDataModel?): String{
        return adapter.toJson(list)
    }
}