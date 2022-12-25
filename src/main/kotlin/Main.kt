import java.util.*
import kotlin.system.exitProcess

class Data: Utils() {
    override fun showList(lists: ArrayList<Food>, utils: Utils) {
        super.showList(lists, utils)
    }
}

fun main() {
    val input = Scanner(System.`in`)

    val lists: ArrayList<Food> = arrayListOf()
    val orderList: MutableList<Food> = mutableListOf()

    var choice: Int
    val order: String
    val total: Int
    val address: String

    val fee = (5000..10000).random()

    val utils = Utils()
    val data = Data()

    lists.addAll(FoodsData.listData)

    print("Masukkan Nama Anda : ")
    val name: String = input.next().toString()
    val greeting = Greeting()

    println(greeting.welcome(name))
    println(greeting.welcome())

    while (true) {
        println("===== MENU =====")
        println("1. Lihat Menu")
        println("2. Pesan")
        println("3. Keluar")
        print("Masukkan Pilihan Anda : ")
        choice = input.next().toInt()
        when (choice) {
            1 -> {
                data.showList(lists, utils)
            }

            2 -> {
                println("Silahkan pilih menu, pisahkan dengan tanda koma jika lebih dari satu")
                print("Masukkan Pesanan Anda : ")
                order = input.next().toString()
                val split = order.split(",").map { it.toInt() }
                println("Berikut daftar pesanan Anda :")
                for (item in split) {
                    orderList += lists.filter { data -> data.id == item }
                }
                for ((index, item) in orderList.withIndex()) {
                    println("${index + 1}. ${item.name} (${utils.convertToRupiah(item.price)}) ")
                }
                total = orderList.sumOf { it.price }
                println("Total Harga: ${utils.convertToRupiah(total)}")
                print("Masukkan alamat penerima: ")
                address = input.next().toString()
                println("Terimakasih pesanan telah kami terima. mohon di tunggu")
                println("<=====================================================>")
                println("Detail pesanan: ")
                for ((index, item) in orderList.withIndex()) {
                    println("${index + 1}. ${item.name} (${utils.convertToRupiah(item.price)}) ")
                }
                val pay = total + fee
                println("")
                println("Nama penerima: $name")
                println("Harga: ${utils.convertToRupiah(total)}")
                println("Alamat penerima: $address")
                println("Biaya pengiriman: ${utils.convertToRupiah(fee)}")
                println("Total: ${utils.convertToRupiah(pay)}")
                println("")
                println("Pesanan Anda segera kami antar.")
                println("Pembayaran bisa dibayarkan langsung ke kurir kami.")
                println("Terimakasih.")
                exitProcess(0)
            }

            3 -> {
                println("Terimakasih sudah berkunjung")
                exitProcess(0)
            }

            else -> println("Oops, Pilihan Anda tidak ada di menu. Silahkan coba lagi")
        }
    }
}
