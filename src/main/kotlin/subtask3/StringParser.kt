package subtask3

import java.lang.StringBuilder

/*
идем по строке пока не найдем открывающую скобку
если нашли открывающую -> добавляем элементы пока не найдем закрывающую
возращаемся к месту, где нашли открывающую скобку
 */
class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val open = listOf('<', '[', '(')
        val close = listOf('>', ']', ')')
        val resSet = mutableSetOf<String>()

        var tmp: Char
        var str = StringBuilder()
        var index = 0
        var returnInd = -1
        var repeats = 0

        while (index < inputString.length) {
            if (inputString[index] in open) {//если нашли открывающую, то формируем строку,
                // до тех пор, пока не найдем закрывающую скобку, а затем возвращаемся в место, с которого начали формировать строку
                tmp = inputString[index] //сохраняем открывающую скобочку, чтобы искать соответсвующую ей закрывающую скобку
                returnInd = index + 1 //индекс, на который вернемся, когда найдем закрывающую скобку
                index++
                while (inputString[index] != closeAnalog(tmp) || repeats !=0) {
                    str.append(inputString[index])
                    if(inputString[index] == tmp) repeats++ //если нашли открывающую скобку такого же типа
                    if(inputString[index] == closeAnalog(tmp)) repeats-- //если нашли закрывающий аналог
                    index++
                }
                resSet.add(str.toString())
                str.clear()
                index = returnInd  //возвращаемся к месту, откуда начали формировать строку
            }
            else index++
        }

        return resSet.toTypedArray()
    }

    fun closeAnalog(ch: Char): Char = when (ch) { // находит соответсвующую закрывающую скобочку для открывающей
        '[' -> ']'
        '<' -> '>'
        '(' -> ')'
        else -> ' '
    }
}
