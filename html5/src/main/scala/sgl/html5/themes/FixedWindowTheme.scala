package sgl.html5
package themes

import org.scalajs.dom
import dom.html

/** The window has a fixed size in pixels.
  *
  * The window is not adapted to the client browser, but just sits centered if
  * there is enough space, otherwise it will overflow and require scrolling
  */
trait FixedWindowTheme extends Theme {

  /** Override the background color behind the canvas game. */
  val backgroundColor: String = "rgb(42,42,42)"

  /** The canvas always use these (width,height) (in CSS pixels). */
  val frameSize: (Int, Int)

  override def init(canvas: html.Canvas): Unit = {
    dom.document.body.style.backgroundColor = backgroundColor
    dom.document.body.style.margin = "0"
    dom.document.body.style.padding = "0"

    // prevent highlight on click on canvas.
    dom.document.onselectstart = (e: dom.Event) => false

    canvas.style.margin = "0"
    canvas.style.padding = "0"
    canvas.style.display = "block"
    canvas.style.position = "absolute"

    canvas.width = frameSize._1
    canvas.height = frameSize._2
    setPosition(canvas)
  }

  override def onResize(canvas: html.Canvas): Unit = {
    // It's not great, but some other parts of the backend might change the width/height,
    // so we need to reset them here. Would be good to have something cleaner, but
    // not sure how.
    canvas.width = frameSize._1
    canvas.height = frameSize._2
    setPosition(canvas)
  }

  /* Automatically center dynamically. */
  private def setPosition(canvas: html.Canvas): Unit = {
    /*
     * We use body.clientWidth/clientHeight to take into account the potential
     * space used by scroll bars.
     */
    val windowWidth = dom.document.body.clientWidth.toInt
    val windowHeight = dom.document.body.clientHeight.toInt

    if(windowWidth < frameSize._1)
      canvas.style.left = "0"
    else {
      val left: Int = (windowWidth - canvas.width)/2
      canvas.style.left = left + "px"
    }

    if(windowHeight < frameSize._2)
      canvas.style.top = "0"
    else {
      val top: Int = (windowHeight - canvas.height)/2
      canvas.style.top = top + "px"
    }
  }
}
