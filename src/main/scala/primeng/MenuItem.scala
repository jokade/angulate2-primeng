//     Project: angulate2-primeng
package primeng

import angulate2.ext.Data
import de.surfice.smacrotools.JSOptionsObject

import scala.scalajs.js

// TODO: replace with @Data?
@JSOptionsObject
case class MenuItem(label: js.UndefOr[String] = js.undefined,
                    icon: js.UndefOr[String] = js.undefined,
                    command: js.UndefOr[js.Function] = js.undefined,
                    url: js.UndefOr[String] = js.undefined,
                    routerLink: js.UndefOr[js.Array[js.Any]] = js.undefined,
                    items: js.UndefOr[js.Array[MenuItem]] = js.undefined,
                    expanded: js.UndefOr[Boolean] = js.undefined,
                    disabled: js.UndefOr[Boolean] = js.undefined)
