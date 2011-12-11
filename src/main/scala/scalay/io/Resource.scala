package scalay.io

/*
 * Created by IntelliJ IDEA.
 * User: Mizushima
 * Date: 11/06/25
 * Time: 7:44
 */
trait Resource[T] {
  def read(): Option[T]
  def write(): Unit
  def close(): Unit
}