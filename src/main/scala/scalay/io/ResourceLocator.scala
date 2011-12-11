package scalay.io

/*
 * Created by IntelliJ IDEA.
 * User: Mizushima
 * Date: 11/07/09
 * Time: 17:08
 *
 * This trait represents "resource locator".  The word means that it references the point at which a resource
 * is located.
 */
trait ResourceLocator[T] {
  def open: Resource[T]
}