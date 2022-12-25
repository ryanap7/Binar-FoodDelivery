object FoodsData {
    private val foodId = arrayOf(
        1,
        2,
        3
    )

    private val foodName = arrayOf(
        "Nasi Goreng",
        "Gado-gado",
        "Satay"
    )

    private val foodDescription = arrayOf(
        "Nasi goreng is Indonesian fried rice with toppings.",
        "Gado-gado is Indonesian salad with peanut sauce.",
        "Grilled meat on skewers with peanut sauce."
    )

    private val foodPrice = intArrayOf(
        12000,
        10000,
        25000
    )

    val listData : ArrayList<Food>
        get() {
            val list = arrayListOf<Food>()
            for (position in foodName.indices) {
                val food = Food()
                food.id = foodId[position]
                food.name = foodName[position]
                food.description = foodDescription[position]
                food.price = foodPrice[position]
                list.add(food)
            }
            return list
        }
}