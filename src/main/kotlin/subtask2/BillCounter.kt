package subtask2

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val sum = bill.filter { it != bill[k] }.sum() / 2
        return if (sum == b) {
            "bon appetit"
        } else {
            (b - sum).toString()
        }

    }
}
