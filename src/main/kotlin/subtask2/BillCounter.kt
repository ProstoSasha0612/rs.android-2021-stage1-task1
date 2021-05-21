package subtask2

class BillCounter {
    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String { //b - сумма, которую внесла Anna
        val shouldPayAnna = (bill.sum() - bill[k]) / 2 // сумма, которую должна заплатить Анна
        if (b == shouldPayAnna) return "bon appetit"  // если она заплатила нужную сумму
        return (b - shouldPayAnna).toString()  //если заплатила неверную сумму
    }
}
