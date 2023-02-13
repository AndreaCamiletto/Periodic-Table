import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    //List of elements
    val el = ElementList()

    //Vertical and horizontal dashed lines
    val hl: Frame = FrameDefaultImpl(" -----")
    val vl: Frame = FrameDefaultImpl("|")

    val element1 = elementFrame(el.elements[0])
    val element2 = element1.atLeftOf(elementFrame((el.elements[1])))
    val element3 = element1.onTopOf(elementFrame(el.elements[2]))
    println(element1.toString() + element2.toString() + element3.toString())

    //Empty Frame
    val empty = FrameDefaultImpl("      ", "     ", "     ", "     ", "      ")

    //Element box function
    fun elementBox(el: ElementList.Element): Frame = FrameDefaultImpl(
        hl.toString(),
        "$vl${centered(el.atomicNumber)}",
        "$vl${centeredStr(el.symbol)}",
        "$vl     ",
        hl.toString()
    )

    fun elementBoxAfterParticularElements(el: ElementList.Element): Frame = FrameDefaultImpl(
        hl.toString(),
        "$vl${centered(el.atomicNumber)}\\",
        "$vl${centeredStr(el.symbol)}/",
        "$vl     \\",
        hl.toString()
    )

    fun elementBoxBeforeParticularElements(el: ElementList.Element): Frame = FrameDefaultImpl(
        hl.toString(),
        "\\${centered(el.atomicNumber)}",
        "/${centeredStr(el.symbol)}",
        "\\     ",
        hl.toString()
    )

    //Group the elements by period
    val groupByPeriod= ArrayList<ArrayList<ElementList.Element>>()
    var periodGr = ArrayList<ElementList.Element>()
    var p = 1
    for(i in 0 until el.elements.size){
        if(el.elements[i].period == p) {
            periodGr.add(el.elements[i])
        }else {
            p += 1
            groupByPeriod.add(periodGr)
            periodGr = ArrayList()
            periodGr.add(el.elements[i])
        }
    }
    //adding the element of the last period
    groupByPeriod.add(periodGr)

    //assemble the table
    var line = ""
    var boxesList: ArrayList<Frame> = ArrayList()
    var group = 1
    var period = 0
    var offset = 0
    for(z in groupByPeriod) {
        //Adding element boxes to list of boxes, elements are ordered by group
        for (elements in groupByPeriod[period]) {
            if (el.elements[offset].group == group) {
                if(offset == 103 || offset == 117){
                    boxesList.add(elementBoxAfterParticularElements(el.elements[offset]))
                    group += 1
                    offset += 1
                } else if(offset == 57 || offset == 75 ){
                    boxesList.add(elementBoxBeforeParticularElements(el.elements[offset]))
                    group += 1
                    offset += 1
                } else {
                    boxesList.add(elementBox(el.elements[offset]))
                    group += 1
                    offset += 1
                }
            } else {
                while (el.elements[offset].group != group && group < 19) {
                    boxesList.add(empty)
                    group += 1
                }
                if(offset == 56 || offset == 74 || offset == 102 || offset == 117){
                    boxesList.add(elementBoxAfterParticularElements(el.elements[offset]))
                    group += 1
                    offset += 1
                } else if(offset == 90 || offset == 104){
                    boxesList.add(elementBoxBeforeParticularElements(el.elements[offset]))
                    group += 1
                    offset += 1
                } else {
                    boxesList.add(elementBox(el.elements[offset]))
                    group += 1
                    offset += 1
                }
            }
        }
        if(period == 7) {
            line += "\n\n\n"
        }

        //printing the table
        //Handling the 4th, 5th, 6th and 8th row of the table
        if(period in 4..6 || period > 7) {
            for(i in 1..4){
                for(j in 0 until boxesList.size) {

                    if(j == 17 && i <= 3) {
                        line += boxesList[j].lines[i] + "$vl"
                    } else if(period > 7 && boxesList[j] == empty && i <= 3){
                        line += boxesList[j].lines[i] + " "
                    } else {
                        line += boxesList[j].lines[i]
                    }
                }
                line += "\n"
            }
        } else if(period in 0..2) { //handling the first two rows
            for(i in 0..3){
                for(j in 0 until boxesList.size) {
                    if(j == 0 && boxesList[j+1] == empty) {
                        if(i == 0) {
                            line += boxesList[j].lines[i]
                        }else {
                            line += boxesList[j].lines[i] + "$vl"
                        }
                    }else if(j in 1..15 && boxesList[j] != empty && boxesList[j+1] == empty){
                        if(i>= 1) {
                            line +=  boxesList[j].lines[i] + "$vl"
                        } else {
                            line += boxesList[j].lines[i]
                        }

                    }  else if(j in 1..15 && boxesList[j] == empty  && boxesList[j+1] == empty){
                        if(i == 0) {
                            line += boxesList[j].lines[i]
                        } else {
                            line += boxesList[j].lines[i] + " "
                        }
                    } else if (j == 17 && i >= 1){
                        line += boxesList[j].lines[i] + "$vl"
                    } else {
                        line += boxesList[j].lines[i]
                    }

                }
                line += "\n"
            }
        } else { //handling the the 3rd and 7th row of the table
            for (i in 0..4) {
                for (j in 0 until boxesList.size) {
                    if(j == 17 && period < 6 && i in 1..3) {
                        line += boxesList[j].lines[i] + "$vl"
                    } else if (period == 7 && boxesList[j] == empty && i in 1..3){
                        line += boxesList[j].lines[i] + " "
                    }else {
                        line += boxesList[j].lines[i]
                    }
                }
                line += "\n"
            }
        }

        period += 1
        group = 1
        boxesList.clear()
        boxesList = ArrayList()
        line += ""
    }
    print(line)
}


//Functions to center the atomic number and the name of the element
fun centered(num: Int): String {
    val t = num
    if(t < 10) {
        return "  $t  "
    } else if(t < 100) {
        return "  $t "
    }
    return " $t "
}

fun centeredStr(str:String) :String {
    if(str.length == 1) {
        return "  $str  "
    }
    return "  $str "
}

fun elementFrame(e: ElementList.Element): Frame = FrameDefaultImpl(e.symbol,
    e.atomicNumber.toString(),
    e.group.toString(),
    e.period.toString())



