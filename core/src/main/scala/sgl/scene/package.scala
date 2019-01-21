package sgl

package object scene {

  /** Provide a hierarchical scene of renderable objects
    *
    * This builds on top of the core GraphicsProvider to provide
    * a scene graph with a structured hierarchy to render 
    * and organize objects on the screen.
    *
    * This handles translation from global to local coordinates, as well
    * as input routing (maybe only clicks?) to the correct children (and properly firing 
    * inputs only if no overlapping elements has intercepted it).
    *
    * The main use case is to build game UIs, such as menus and HUD.
    *
    * In theory, you could build the whole game with the API, as it provides a
    * similar interface to the core GameScreen abstraction, while adding some
    * higher level concept such as a graph organization of the scene.
    *
    * It comes with built-in widgets in the sgl.scene.ui package, for common
    * UI elements such as buttons and textfield.
    */

  // TODO: Offer a ScrollPane kind of container, which would provide
  //       a default scrollable background (by touch and mouse scroll).
  //       This would be great for building level menus. More details on
  //       the design are within the Fish Escape source code (in the level menu).
  //       This might in particular be a good point to expose a touch scroll API,
  //       instead of within the core input handling system. Mostly because it's
  //       not clear what is a scroll action versus a click/touch action.
}
