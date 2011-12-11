package scalay.io

import collection.{GenTraversableLike, GenTraversable, TraversableLike}
import collection.generic.{GenericCompanion, GenericTraversableTemplate}


/*
 * Created by IntelliJ IDEA.
 * User: Mizushima
 * Date: 11/07/10
 * Time: 0:11
 */
trait Cursor[A] extends AnyRef with CursorLike[A, Cursor[A]] {
  def moveNext(): Boolean
  def current: A
  def foreach[U](f: (A) => U) {
    while(moveNext()) {
      f(current)
    }
  }
}