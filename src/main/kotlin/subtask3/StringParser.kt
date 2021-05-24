package subtask3

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        var bracketsList = mutableListOf<Pair<Char, Int>>()
        val bracketCollection = listOf('>', '<', '[', ']', '(', ')')
        var open: Pair<Char, Int>?
        var close: Pair<Char, Int>?

        val resultArray = mutableListOf<String>()

        for ((index, char) in inputString.withIndex()) {
            when (char) {
                in bracketCollection -> bracketsList.add(Pair(char, index))
            }
        }

        bracketsList = sortBracketList(bracketsList) as MutableList<Pair<Char, Int>>

        while(bracketsList.isNotEmpty()) {
            resultArray.add(inputString.substring(bracketsList[0].second + 1, bracketsList[1].second))
            bracketsList.removeAt(0)
            bracketsList.removeAt(0)

        }


        return resultArray.toTypedArray()
    }

    fun sortBracketList(bracketsList: List<Pair<Char, Int>>): List<Pair<Char, Int>> {
        var sortedBracketList = mutableListOf<Pair<Char, Int>>()
        var parenthesisOpen = 0
        var angleOpen = 0
        var squareOpen = 0
        var parenthesisClose = 0
        var angleClose = 0
        var squareClose = 0

        loop@ for ((index, pair) in bracketsList.withIndex()) {
            parenthesisOpen = 0
            parenthesisClose = 0
            squareOpen = 0
            squareClose = 0
            angleOpen = 0
            angleClose = 0

            when(pair.first) {
                '(' -> parenthesisOpen++
                '<' -> angleOpen++
                '[' -> squareOpen++
                ')' -> continue@loop
                '>' -> continue@loop
                ']' -> continue@loop
            }

            if (parenthesisOpen == 1 || angleOpen == 1 || squareOpen == 1) {
                sortedBracketList.add(pair)
            }
            for (i in index + 1 until bracketsList.size) {
                when (bracketsList[i].first) {
                    '(' -> parenthesisOpen++
                    '<' -> angleOpen++
                    '[' -> squareOpen++
                    ']' -> squareClose++
                    '>' -> angleClose++
                    ')' -> parenthesisClose++
                }

                if (parenthesisOpen == parenthesisClose && (pair.first == '(' && parenthesisOpen > 0)) {
                    sortedBracketList.add(bracketsList[i])
                    break

                } else if (angleOpen == angleClose && (pair.first == '<' && angleOpen > 0)) {
                    sortedBracketList.add(bracketsList[i])
                    break

                } else if (squareOpen == squareClose && (pair.first == '[' && squareOpen > 0)) {
                    sortedBracketList.add(bracketsList[i])
                    break
                }

            }
        }
        return sortedBracketList
    }



}
