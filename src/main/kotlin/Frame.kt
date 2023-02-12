interface Frame {
    fun atLeftOf(other: Frame): Frame

    fun onTopOf(other: Frame): Frame

    val lines: List<String>
}