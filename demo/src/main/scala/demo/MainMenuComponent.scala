//     Project: angulate2-primeng
//      Module:
// Description:
package demo

import angulate2.std._
import primeng.MenuItem

@Component(
  selector = "main-menu",
  template = """<p-menubar [model]="items"></p-menubar>"""
)
class MainMenuComponent {
  val items = @@@(
    MenuItem(label = "File")
  )
}
