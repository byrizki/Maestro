package maestro.cli.api

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CliVersionTest {

    @Test
    fun `parse handles simple version`() {
        val version = CliVersion.parse("1.2.3")
        assertEquals(1, version?.major)
        assertEquals(2, version?.minor)
        assertEquals(3, version?.patch)
        assertEquals(null, version?.label)
    }

    @Test
    fun `parse handles pre-release version`() {
        val version = CliVersion.parse("2.1.0-preview1")
        assertEquals(2, version?.major)
        assertEquals(1, version?.minor)
        assertEquals(0, version?.patch)
        assertEquals("preview1", version?.label)
    }

    @Test
    fun `compare versions with labels`() {
        val v1 = CliVersion.parse("2.1.0-preview1")!!
        val v2 = CliVersion.parse("2.1.0")!!
        
        // 2.1.0-preview1 < 2.1.0
        assertTrue(v1 < v2)
    }
}
