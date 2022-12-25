import java.text.NumberFormat
import java.util.*

class Utils {
    fun convertToRupiah(price: Int): String {
        val localId = Locale("in", "ID")
        val formatter = NumberFormat.getCurrencyInstance(localId)
        return formatter.format(price)
    }
}