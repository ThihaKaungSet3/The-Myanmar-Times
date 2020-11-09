package non.shahad.today.domain.model

data class NewsDomainModel(
    val id: String,
    val title: String,
    val imgUrl: String,
    val description: String?,
    val dateTime: String?,
    val categoryName: String,
    val lastUpdated: Long = 0L
){
    fun isUpdated(): Boolean {
        return System.currentTimeMillis() - lastUpdated < 5 * 1000
    }
}


