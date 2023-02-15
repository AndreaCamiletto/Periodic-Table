import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FrameTest {
    @Test
    fun testFrame() {
        val frame: FrameDefaultImpl = FrameDefaultImpl("test","test","test")
        assertEquals("testtesttest", frame.toString())
        val f2 = FrameDefaultImpl("test", "test", "1", "2")
        val f3 = FrameDefaultImpl("test", "test", "2", "1")
        assertEquals("\ntesttest12\n",f2.atLeftOf(f3).toString())
        assertEquals(" testtest21 ",f3.onTopOf(f2).toString())
    }
}