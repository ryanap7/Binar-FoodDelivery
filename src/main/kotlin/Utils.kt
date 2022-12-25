import java.text.NumberFormat
import java.util.*

open class Utils {
    fun convertToRupiah(price: Int): String {
        val localId = Locale("in", "ID")
        val formatter = NumberFormat.getCurrencyInstance(localId)
        return formatter.format(price)
    }

    open fun showList(lists: ArrayList<Food>, utils: Utils) {
        for ((index, list) in lists.withIndex()) {
            println("${index + 1}. ${list.name} (${utils.convertToRupiah(list.price)})\n${list.description}")
            println("")
        }
    }
}