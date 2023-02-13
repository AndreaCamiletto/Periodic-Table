
class FrameDefaultImpl(vararg line: String): Frame{

    override val lines: List<String>

    init {
        lines = line.toList()
    }

    override fun atLeftOf(other: Frame): Frame {
        if(Integer.parseInt(other.lines[2]) > Integer.parseInt(lines[2])){
            return FrameDefaultImpl("\n", lines[0], lines[1], lines[2], lines[3], "\n")
        }
        return this
    }

    override fun onTopOf(other: Frame): Frame {
        if(Integer.parseInt(other.lines[3]) > Integer.parseInt(lines[3])){
            return FrameDefaultImpl(" ",lines[0], lines[1], lines[2], lines[3]," ")
        }
        return this
    }

    override fun toString(): String {
        if(lines.size == 1) {
            return lines[0]
        }
        var frame = ""
        for(i in 0 until lines.size - 1) {

            frame += lines[i]
        }
        return frame
    }

}
