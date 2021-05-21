package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        var resList = mutableListOf<Int>()
        resList.addAll(sadArray.toList()) //resList содержит весь sadArray

        while (arrayIsBad(resList)) { //цикл поаторяется, пока наш массив полностью не очистится от bad элементов
            val tmpList = resList //tmpList содержит sadArray
            resList = mutableListOf() // сюда будет записываться очистка от bad лементов

            resList.add(tmpList[0]) //первый элемент всегда happy
            for (i in 1 until tmpList.size - 1) { // проверка и добавка всех остальных элементов
                if (tmpList[i] > tmpList[i - 1] + tmpList[i + 1]) {
                    tmpList[i] = tmpList[i - 1] //на место bad элемента ставим предыдущий хороший элемент
                    continue
                }
                resList.add(tmpList[i])
            }
            resList.add(tmpList[tmpList.size - 1]) // последний элемент всегда happy
        }

        return resList.toIntArray()
    }

    private fun arrayIsBad(array: List<Int>): Boolean { //проверят наличие bad элементов
        for (i in 1 until array.size - 1) {
            if (array[i] > array[i - 1] + array[i + 1]) {
                return true
            }
        }
        return false
    }
}

