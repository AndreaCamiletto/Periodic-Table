import java.util.ArrayList


class FrameDefaultImpl(vararg line: String): Frame{

    override val lines: List<String>

    init {
        lines = line.toList()
    }

    override fun atLeftOf(other: Frame): Frame {
        if(Integer.parseInt(other.lines[2]) > Integer.parseInt(lines[2])){
            return FrameDefaultImpl("\n")
        }
        return this
        /*if(Integer.parseInt(other.lines[5]) < Integer.parseInt(lines[5])) {
            return FrameDefaultImpl(lines[0], lines[1], lines[2], lines[3], lines[4], "", "", "\n")
        }
        return FrameDefaultImpl(lines[0], lines[1], lines[2], lines[3], lines[4], " ")*/
    }

    override fun onTopOf(other: Frame): Frame {
        if(Integer.parseInt(other.lines[3]) > Integer.parseInt(lines[3])){
            return FrameDefaultImpl(" ")
        }
        return this
    }

    override fun toString(): String {
        /*var frame = "  \n" +
                "  ${lines[0]}  \n" +
                "  ${lines[1]}  \n" +
                "     \n" +
                " "*/
        if(lines.size == 1) {
            return lines[0]
        }
        var frame = ""
        for(i in 0 until lines.size - 1) {

            frame += lines[i]
        }
        return frame


    }

   /* override fun toString(): String {
        var frame = " "
        for (i in 0..4) {
            frame += lines[0]
        }
        frame += "\n"
        for(i in 0..2){
            if(lines.size == 3 && i == 0){
                frame +=lines[1] + "  " + lines[2] +  "  " + lines[1] + "\n"
            } else if(lines.size > 3){
                if(i == 0){
                    frame +=lines[1] + "  " + lines[2] +  "  " + lines[1] + "\n"
                }else if (i == 1){
                    frame +=lines[1] + "  " + lines[3] +  "  " + lines[1] + "\n"
                }else{
                    frame += lines[1] + "     " + lines[1] + "\n"
                }
            } else{
                frame += lines[1] + "     " + lines[1] + "\n"
            }
        }
        frame += " "
        for (i in 0..4) {
            frame += lines[0]
        }
        return frame
    }*/
    /*override fun toString(): String {
        var frame = ""
        for(i in 0..lines.size - 1) {
            frame += lines[i]
        }
        return frame
    }*/

}
