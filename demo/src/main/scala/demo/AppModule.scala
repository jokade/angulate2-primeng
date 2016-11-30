//     Project: angulate2-primeng-demo
package demo

import angulate2.platformBrowser.BrowserModule
import angulate2.router.{Route, RouterModule}
import angulate2.std._
import primeng.{MenubarModule, PanelModule}

@NgModule(
  imports = @@[BrowserModule]
            ++ AppConfig.primeng
            :+ AppConfig.routes,
  declarations = @@[AppComponent,MainMenuComponent,WelcomeComponent],
  bootstrap = @@[AppComponent]
)
class AppModule {

}

object AppConfig {
  def primeng = @@[MenubarModule,PanelModule]

  def routes = RouterModule.forRoot( @@@(
    Route(path = ""        , redirectTo = "/welcome", pathMatch = "full"),
    Route(path = "welcome", component = %%[WelcomeComponent], pathMatch = "full")
  ))
}
