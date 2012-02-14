package scalay

package object io {
  import java.io._

  object FileIO {
    abstract sealed class AccessMode
    case class READ() extends AccessMode
    case class WRITE() extends AccessMode
    case class READ_WRITE() extends AccessMode
    abstract sealed class StreamType
    case class BYTES() extends StreamType
    case class CHARS() extends StreamType

    trait FileOpener[M, T, R] {
      def open(path: File): R
    }

    implicit def pathNameToFile(pathName: String) = new File(pathName)

    object FileOpener {
      implicit object InputStreamOpener extends FileOpener[READ, BYTES, InputStream] {
        def open(path: File) = new FileInputStream(path)
      }
      implicit object OutputStreamOpener extends FileOpener[WRITE, BYTES, PrintStream] {
        def open(path: File) = new PrintStream(new FileOutputStream(path))
      }
      implicit object RandomAccessFileOpener extends FileOpener[READ_WRITE, BYTES, RandomAccessFile] {
        def open(path: File) = new RandomAccessFile(path, "rw")
      }
      implicit object ReaderOpener extends FileOpener[READ, CHARS, BufferedReader] {
        def open(path: File) = new BufferedReader(new FileReader(path))
      }
      implicit object WriterOpener extends FileOpener[WRITE, CHARS, PrintWriter] {
        def open(path: File) = new PrintWriter(new FileWriter(path))
      }
    }

    def open[M <: AccessMode, T <: StreamType, R](
      path: File, mode: M = READ(), streamType: T = CHARS())(implicit opener: FileOpener[M, T, R]): R = opener.open(path)

    def using[R <: { def close(): Unit }, M](r: R)(f: R => M): M = try {
      f(r)
    } finally { r.close() }
  }
}