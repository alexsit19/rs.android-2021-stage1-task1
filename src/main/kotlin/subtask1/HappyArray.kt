package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        var happyFlag = false
        val tempList = sadArray.toMutableList()
        var sadCount = 0

        if(sadArray.size in 0..2) {
            happyFlag = true
        }

        while(!happyFlag) {
            sadCount = 0
            for ((iterCount, i) in (1 until tempList.size - 1).withIndex()) {
                if (i > tempList.size - 2) {

                } else {
                    if (tempList[i - 1] + tempList[i + 1] < tempList[i]) {
                        tempList.removeAt(i)
                        sadCount++
                    }
                }
            }
            if (sadCount == 0) {
                happyFlag = true
            }
        }

        return tempList.toIntArray()
    }
}
