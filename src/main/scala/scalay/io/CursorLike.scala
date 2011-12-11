package scalay.io

import collection.{GenTraversableLike, TraversableLike}


/**
 * Created by IntelliJ IDEA.
 * User: Mizushima
 * Date: 11/12/11
 * Time: 21:32
 * To change this template use File | Settings | File Templates.
 */
trait CursorLike[+A, +Repr] extends Equals with TraversableLike[A, Repr]
