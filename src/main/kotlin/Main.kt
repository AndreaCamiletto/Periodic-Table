import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    //List of elements
    var el:ElementList = ElementList()

    //Vertical and horizontal dashed lines
    val hl: Frame = FrameDefaultImpl(" ----- ")
    val vl: Frame = FrameDefaultImpl("|")



    //Empty Frame
    val empty = FrameDefaultImpl("       ", "       ", "       ", "       ", "       ")

    //Element box function
    fun elementBox(el: ElementList.Element): Frame = FrameDefaultImpl(
            hl.toString(),
            "$vl${centered(el.atomicNumber)}$vl",
            "$vl${centeredStr(el.symbol)}$vl",
            "$vl     $vl",
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
        "\\${centered(el.atomicNumber)}$vl",
        "/${centeredStr(el.symbol)}$vl",
        "\\     $vl",
        hl.toString()
    )

    //Group the elements by period
    var groupByPeriod= ArrayList<ArrayList<ElementList.Element>>()
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
    var j = 1
    var period = 0
    var offset = 0
    for(z in groupByPeriod) {
        for (elements in groupByPeriod[period]) {
            if (el.elements[offset].group == j) {
                if(offset == 56 || offset == 74 || offset == 103 || offset == 117){
                    boxesList.add(elementBoxAfterParticularElements(el.elements[offset]))
                    j += 1
                    offset += 1
                } else {
                    boxesList.add(elementBox(el.elements[offset]))
                    j += 1
                    offset += 1
                }
            } else {
                while (el.elements[offset].group != j && j < 19) {
                    boxesList.add(empty)
                    j += 1
                }
                if(offset == 56 || offset == 74 || offset == 102 || offset == 117){
                    boxesList.add(elementBoxAfterParticularElements(el.elements[offset]))
                    j += 1
                    offset += 1
                } else if(offset == 90 || offset == 104){
                    boxesList.add(elementBoxBeforeParticularElements(el.elements[offset]))
                    j += 1
                    offset += 1
                } else {
                    boxesList.add(elementBox(el.elements[offset]))
                    j += 1
                    offset += 1
                }
            }
        }
        if(period == 7) {
            line += "\n\n\n\n"
        }
        if(period in 4..6 || period > 7) {
            for(i in 1..4){
                for(j in 0 until boxesList.size) {
                    line += boxesList[j].lines[i]
                }
                line += "\n"
            }
        } else if(period in 0..2) {
            for(i in 0..3){
                for(j in 0 until boxesList.size) {
                    line += boxesList[j].lines[i]
                }
                line += "\n"
            }
        } else {

            for (i in 0..4) {
                for (j in 0 until boxesList.size) {
                    line += boxesList[j].lines[i]
                }
                line += "\n"
            }
        }

        period += 1
        j = 1
        boxesList.clear()
        boxesList = ArrayList()
        line += ""
    }
    print(line)
}

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



